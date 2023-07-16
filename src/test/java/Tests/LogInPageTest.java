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

        logger.info("-------------------------------------------------------");
        logger.info("LOG IN");
        logger.info("-------------------------------------------------------\n");
        Thread.sleep(2000);

        LogInPage logInPage = new LogInPage(driver);
        LogInPageValidations logInPageValidations = new LogInPageValidations(driver);

        logInPage.openLogInPage(logInPage.setUrl());
        Thread.sleep(2000);
        logger.info("Redirect to: " +logInPage.setUrl()+ "\n");

        //Test Data

        emailOrLoginID = "rajeewaakmeemana@gmail.com";
        password = "Ridmal1234";

        //Enter User Details

        logger.info("ENTER EMAIL OR LOGIN ID - "+emailOrLoginID);
        logger.info("ENTER PASSWORD - "+password);

        logInPage.fillData(emailOrLoginID, password);
        Thread.sleep(2000);

        logger.info("CLICK ON LOG IN BUTTON \n");
        logInPage.clickOnLogIn();
        Thread.sleep(2000);

        //Validate Login Page

        logInPageValidations.LoginSuccess();
        Thread.sleep(2000);

        logger.info("-------------------------------------------------------");
        logger.info("LOG IN PROCESSED");
        logger.info("-------------------------------------------------------\n");
        Thread.sleep(2000);
    }
}
