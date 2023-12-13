package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LandingPage extends BasePage{
    public LandingPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//li[@class = 'sub-menu'][2]//a[@onclick=\"s_objectID='Main Menu|Utility|Login';\"]")
    protected WebElement btnLogin;

    @FindBy(linkText = "Bitdefender Central")
    protected WebElement btnWebCentral;
    @FindBy(id = "onetrust-accept-btn-handler")
    protected WebElement btnAcceptCookies;
}
