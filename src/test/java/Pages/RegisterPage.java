package Pages;

import Helper.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegisterPage extends BasePage {

    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getGenderMale() {
        return getElementByXpath("//input[@id='gender-male']");
    }

    public WebElement getEmailField() {
        return getElementByXpath("//input[@id='Email']");
    }

    public WebElement getFirstNameField() {
        return getElementByXpath("//input[@id='FirstName']");
    }

    public WebElement getLastNameField() {
        return getElementByXpath("//input[@id='LastName']");
    }

    public WebElement getPasswordField() {
        return getElementByXpath("//input[@id='Password']");
    }

    public WebElement getConfirmPasswordField() {
        return getElementByXpath("//input[@id='ConfirmPassword']");
    }

    public WebElement getRegisterBtn() {
        return getElementByXpath("//input[@id='register-button']");
    }
}