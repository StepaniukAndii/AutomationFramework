package Tests;

import Helper.TestInit;
import Pages.RegisterPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestSingUp extends TestInit {

    @Test
    public void testSingUp() {
        RegisterPage registerPage = new RegisterPage(driver);
        openUrl("http://demowebshop.tricentis.com/register");
//        registerPage.getGenderMale().click();
        registerPage.getFirstNameField().sendKeys(createRandomNumber() + "TestUser");
        registerPage.getLastNameField().sendKeys(createRandomNumber() + "TestLastName");
        registerPage.getEmailField().sendKeys(createRandomNumber() + "test@gmail.com");
        registerPage.getPasswordField().sendKeys("12345!QWd");
        registerPage.getConfirmPasswordField().sendKeys("12345!QWd");
        registerPage.getRegisterBtn().click();

        Assert.assertTrue(getUrl().contains("http://demowebshop.tricentis.com/registerresult"));
    }
}