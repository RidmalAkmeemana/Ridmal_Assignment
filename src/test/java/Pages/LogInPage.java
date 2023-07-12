package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogInPage
{
    private WebDriver driver;

    @FindBy (name = "ctl00$CPHContainer$txtUserLogin")
    WebElement EmailOrLoginID;

    @FindBy (name = "ctl00$CPHContainer$txtPassword")
    WebElement Password;

    @FindBy (name = "ctl00$CPHContainer$btnLoginn")
    WebElement Login;

    @FindBy (id = "ctl00_CPHContainer_lblOutput")
    WebElement AccountActivationError;

    public LogInPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void fillField(WebElement field, String value)
    {
        field.sendKeys(value);
    }

    public String setUrl() {
        String Url = "https://www.testyou.in/Login.aspx?";
        return Url;
    }

    public void openLogInPage(String url) {
        driver.get(url);
    }

    public void fillData(String emailOrLoginId, String password) throws InterruptedException {

        this.fillField(EmailOrLoginID,emailOrLoginId);
        Thread.sleep(2000);

        this.fillField(Password,password);
        Thread.sleep(2000);

    }

    public void clickOnLogIn() throws InterruptedException {
        Login.click();
        Thread.sleep(2000);
    }

    public boolean getActivateError()
    {
        boolean ErrorMsg = AccountActivationError.isDisplayed();
        return ErrorMsg;
    }

    public String getErrorMsg()
    {
        String Msg = AccountActivationError.getText();
        return  Msg;
    }
}
