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

        logger.info(" +++++++++++++++++++++++ Create Account +++++++++++++++++++++++ ");

        RegisterPage registerPage = new RegisterPage(driver);
        CaptchaListener captchaListener = new CaptchaListener(driver);
        RegisterPageValidations registerPageValidations = new RegisterPageValidations(driver);

        registerPage.openRegisterPage(registerPage.setUrl());
        Thread.sleep(2000);
        logger.info("Redirect to: " +registerPage.setUrl());

        String captchaText = captchaListener.getCaptchaImg();

        //Test Data

        name = "Ridmal Akmeemana";
        email = "rajeewaakmeemana@gmail.com";
        loginId = "Ridmal";
        password = "Ridmal1234";
        confirm = "Ridmal1234";
        verification = captchaText;

        //Enter User Details

        registerPage.fillData(name, email, loginId, password, confirm, verification);
        registerPage.clickOnSignIn();
        Thread.sleep(2000);

        //Validate User Registration Success

        registerPageValidations.AccountCreated();
        Thread.sleep(2000);

        logger.info(" +++++++++++++++++++++++ Create Account Processed +++++++++++++++++++++++ \n");
    }
}
