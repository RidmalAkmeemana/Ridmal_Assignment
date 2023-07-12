package Validations;

import Infra.BasePage;
import Pages.LogInPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class LogInPageValidations extends BasePage {
    private WebDriver driver;

    public LogInPageValidations(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void LoginSuccess() throws InterruptedException {

        LogInPage logInPage = new LogInPage(driver);

        boolean isErrorMsgVisible = logInPage.getActivateError();
        String ErrorMsg = logInPage.getErrorMsg();

        if(isErrorMsgVisible)
        {
            logger.info("User Login Failed");
            Thread.sleep(2000);
        }
        else
        {
            logger.error("User Login Success");
            Thread.sleep(2000);
        }
        Assert.assertFalse(isErrorMsgVisible, "User Login Failed | " +ErrorMsg);
    }
}
