package Infra;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.File;
import java.io.IOException;

public class CaptchaListener extends BasePage
{
    private WebDriver driver;

    @FindBy(id = "ctl00_CPHContainer_dxCaptcha_IMG")
    WebElement CaptchaImg;

    public CaptchaListener(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    //Get Captcha Value & Set to String

    public String getCaptchaImg() throws IOException, InterruptedException, TesseractException {

        File screenshotFile = CaptchaImg.getScreenshotAs(OutputType.FILE);
        String path = "../Ridmal_Assignment/src/test/resources/captcha.png";

        FileHandler.copy(screenshotFile, new File(path));
        Thread.sleep(2000);

        ITesseract image = new Tesseract();

        String Captcha = image.doOCR(new File(path));
        Thread.sleep(2000);
        logger.info(Captcha);

        return Captcha;
    }
}
