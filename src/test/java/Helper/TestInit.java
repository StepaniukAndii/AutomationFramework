package Helper;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestInit {

    public WebDriver driver;

    ChromeOptions options = new ChromeOptions();

    boolean headless = true;

    @BeforeMethod
    public void setUp() {

        if (isOSMac()){
            setProperty("src/test/drivers/chromedriver_91_mac");
        }else if (isOSWindows()){
            setProperty("src/test/drivers/chromedriver_91_windows.exe");
        }else {
            setProperty("src/test/drivers/chromedriver_linux_91");
        }

        driver = new ChromeDriver(options);

        if(headless) {
            driver.manage().window().setSize(new Dimension(1920, 1200));
        } else {
            driver.manage().window().maximize();
        }
    }

    private void setProperty(String path) {
        System.setProperty("webdriver.chrome.driver", path);
        if (headless){
            options.addArguments("--headless");
            options.addArguments("start-maximized");
            options.addArguments("disable-infobars");
            options.addArguments("--disable-extensions");
            options.addArguments("--disable-gpu");
            options.addArguments("--disable-dev-shm-usage");
            options.addArguments("--no-sandbox");
        }
    }

    private boolean isOSWindows() {
        return getOSName().contains("win");
    }

    private boolean isOSMac() {
        return getOSName().contains("mac");
    }

    private String getOSName() {
        return System.getProperty("os.name").toLowerCase();
    }

    @AfterMethod
    public void afterTest() {
        driver.quit();
    }

    public void openUrl(String site) {
        driver.get(site);
    }

    protected long createRandomNumber() {
        return System.currentTimeMillis();
    }

    protected String getUrl() {
        return driver.getCurrentUrl();
    }
}
