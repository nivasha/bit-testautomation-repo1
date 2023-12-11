package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*//div//h1")
    protected WebElement lblSignin;

    @FindBy(id = "username")
    protected WebElement txtUsername;

    @FindBy(id = "login-next")
    protected WebElement btnLoginNext;

    @FindBy(id="password_input")
    protected WebElement txtPassword;

    @FindBy(id = "two-fa-code-input")
    protected WebElement txtOTP;

    @FindBy(id = "password-sign-in")
    protected WebElement btnSignIn;

    @FindBy(id = "go_to_signin")
    protected WebElement btnBacktoSignin;

    @FindBy(xpath = "//div[@class='email-input-error input-error ng-active']//span")
    protected WebElement lblInvalidEmail;

    @FindBy(xpath = "//div[@class='error-display request-error input-error text-wrap ng-isolate-scope show']")
    protected WebElement lblNoUser;

    @FindBy(css = ".error-display.request-error.input-error.text-wrap.ng-isolate-scope.show")
    protected WebElement lblErrorPw;

}
