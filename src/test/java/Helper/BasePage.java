package Helper;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;

public class BasePage implements Expectations{

    int BASIC_TIME = 15;

    @Override
    public List<WebElement> waitVisibilityOfAllElementsLocatedBy(String locator) {
        WebDriverWait wait = new WebDriverWait(driver, BASIC_TIME);
        return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(locator)));
    }

    @Override
    public WebElement waitElementToBeClickable(String locator) {
        WebDriverWait wait = new WebDriverWait(driver, BASIC_TIME);
        return wait.until(ExpectedConditions.elementToBeClickable(By.xpath(locator)));
    }

    protected WebDriver driver;

    public  BasePage(WebDriver driver) {
        this.driver = driver;
    }

    protected WebElement getElementByXpath(String locator) {
        return waitElementToBeClickable(locator);
    }

    protected List<WebElement> getElementsByXpath(String locator) {
        return waitVisibilityOfAllElementsLocatedBy(locator);
    }
}
