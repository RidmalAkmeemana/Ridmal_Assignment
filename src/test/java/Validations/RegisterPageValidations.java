package Validations;

import Infra.BasePage;
import Pages.RegisterPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class RegisterPageValidations extends BasePage
{
    private WebDriver driver;

    public RegisterPageValidations(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void AccountCreated() throws InterruptedException {

        RegisterPage registerPage = new RegisterPage(driver);

        boolean isSuccessMsgVisible = registerPage.getAccountCreateSuccess();

        if(isSuccessMsgVisible)
        {
            logger.info("USER REGISTRATION - PASSED\n");
            Thread.sleep(2000);
        }
        else
        {
            logger.error("USER REGISTRATION - FAILED\n");
            Thread.sleep(2000);
        }
        Assert.assertTrue(isSuccessMsgVisible, "USER REGISTRATION - FAILED\n");
    }

}
