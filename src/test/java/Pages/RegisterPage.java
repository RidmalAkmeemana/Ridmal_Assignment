package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage
{
    private WebDriver driver;

    @FindBy(name = "ctl00$CPHContainer$txtFname")
    WebElement Name;

    @FindBy(name = "ctl00$CPHContainer$txtEmail")
    WebElement Email;

    @FindBy(name = "ctl00$CPHContainer$txtUserLogin1")
    WebElement LoginID;

    @FindBy(name = "ctl00$CPHContainer$txtpassword")
    WebElement Password;

    @FindBy(name = "ctl00$CPHContainer$txtReType")
    WebElement ConfirmPassword;

    @FindBy(name = "ctl00$CPHContainer$txtVarificationCode")
    WebElement VerificationCode;

    @FindBy(id = "ctl00_CPHContainer_btnRegistration")
    WebElement CreateAccount;

    @FindBy(id = "ctl00_CPHContainer_lblOutput")
    WebElement RegistrationSuccessMsg;

    public RegisterPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void fillField(WebElement field, String value)
    {
        field.sendKeys(value);
    }

    public String setUrl() {
        String Url = "https://www.testyou.in/SignUp.aspx";
        return Url;
    }

    public void openRegisterPage(String url) {
        driver.get(url);
    }

    public void fillData(String name, String email, String loginId, String password, String confirmPassword, String verificationCode) throws InterruptedException {
        this.fillField(Name,name);
        Thread.sleep(2000);

        this.fillField(Email,email);
        Thread.sleep(2000);

        this.fillField(LoginID,loginId);
        Thread.sleep(2000);

        this.fillField(Password,password);
        Thread.sleep(2000);

        this.fillField(ConfirmPassword,confirmPassword);
        Thread.sleep(2000);

        this.fillField(VerificationCode,verificationCode);
        Thread.sleep(2000);
    }

    public void clickOnSignIn() throws InterruptedException {
        CreateAccount.click();
        Thread.sleep(2000);
    }

    public boolean getAccountCreateSuccess()
    {
        boolean SuccessMsg = RegistrationSuccessMsg.isDisplayed();
        return SuccessMsg;
    }
}
