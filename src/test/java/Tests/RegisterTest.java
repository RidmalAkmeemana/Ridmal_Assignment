package Tests;

import Infra.BasePage;
import Infra.CaptchaListener;
import Pages.RegisterPage;
import Validations.RegisterPageValidations;
import net.sourceforge.tess4j.TesseractException;
import org.testng.annotations.Test;
import java.io.IOException;

public class RegisterTest extends BasePage
{
    public static String name,email,loginId,password,confirm, verification;

    //Test for Account Creation
    @Test(priority = 1, description = "Create Account")
    public void CreateAccount() throws InterruptedException, IOException, TesseractException {

        logger.info("-------------------------------------------------------");
        logger.info("CREATE ACCOUNT");
        logger.info("-------------------------------------------------------\n");
        Thread.sleep(2000);

        RegisterPage registerPage = new RegisterPage(driver);
        CaptchaListener captchaListener = new CaptchaListener(driver);
        RegisterPageValidations registerPageValidations = new RegisterPageValidations(driver);

        registerPage.openRegisterPage(registerPage.setUrl());
        Thread.sleep(2000);

        logger.info("Redirect to: " +registerPage.setUrl()+ "\n");
        Thread.sleep(2000);

        //Test Data

        name = "Ridmal Akmeemana";
        email = "rajeewaakmeemana@gmail.com";
        loginId = "Ridmal";
        password = "Ridmal1234";
        confirm = "Ridmal1234";
        verification = "abc123";

        //Enter User Details

        logger.info("ENTER NAME - "+name);
        logger.info("ENTER EMAIL - "+email);
        logger.info("ENTER LOGIN ID - "+loginId);
        logger.info("ENTER PASSWORD - "+password);
        logger.info("ENTER FORM CONFIRM PASSWORD - "+confirm);
        logger.info("ENTER VERIFICATION CODE - "+verification);

//        String captchaText = captchaListener.getCaptchaImg();
//        verification = captchaText;

        registerPage.fillData(name, email, loginId, password, confirm, verification);
        Thread.sleep(2000);

        logger.info("CLICK ON SIGN IN BUTTON \n");
        registerPage.clickOnSignIn();
        Thread.sleep(2000);

        //Validate User Registration Success

        registerPageValidations.AccountCreated();
        Thread.sleep(2000);

        logger.info("-------------------------------------------------------");
        logger.info("CREATE ACCOUNT PROCESSED");
        logger.info("-------------------------------------------------------\n");
        Thread.sleep(2000);
    }
}
