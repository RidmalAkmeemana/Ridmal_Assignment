package Tests;

import Infra.BasePage;
import Pages.LogInPage;
import Validations.LogInPageValidations;
import org.testng.annotations.Test;

public class LogInPageTest extends BasePage
{
    public static String emailOrLoginID,password;

    @Test(priority = 1)
    public void LogInWithValidData() throws InterruptedException {
        logger.info(" +++++++++++++++++++++++ Create Account +++++++++++++++++++++++ ");

        LogInPage logInPage = new LogInPage(driver);
        LogInPageValidations logInPageValidations = new LogInPageValidations(driver);

        logInPage.openLogInPage(logInPage.setUrl());
        Thread.sleep(2000);
        logger.info("Redirect to: " +logInPage.setUrl());

        //Test Data

        emailOrLoginID = "rajeewaakmeemana@gmail.com";
        password = "Ridmal1234";

        //Enter User Details

        logInPage.fillData(emailOrLoginID, password);
        logInPage.clickOnLogIn();
        Thread.sleep(2000);

        //Validate Login Page

        logInPageValidations.LoginSuccess();
        Thread.sleep(2000);

        logger.info(" +++++++++++++++++++++++ Create Account Processed +++++++++++++++++++++++ \n");
    }
}
