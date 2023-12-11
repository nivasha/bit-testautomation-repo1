package Functions;


import Pages.LoginPage;
import Tests.TestBase;
import org.openqa.selenium.WebDriver;


public class Login extends LoginPage {


    public Login(WebDriver driver) {
        super(driver);
    }



    public void invalidNValidLogin(String username, String password){
        TestBase.sendKeys(txtUsername, username);
        TestBase.clickOnElement(btnLoginNext);
        TestBase.sendKeys(txtPassword,password);
        TestBase.clickOnElement(btnSignIn);
    }



    public void inValidEmail(String username){
        TestBase.sendKeys(txtUsername,username);
        TestBase.clickOnElement(btnLoginNext);

    }

    public void goBack() {
        TestBase.clickOnElement(btnBacktoSignin);
    }

    public boolean isInvalidErrorDisplayed() {
        return TestBase.isElementDisplayed(lblInvalidEmail);
    }

    public boolean isNoUserDisplayed() {
        return TestBase.isElementDisplayed(lblNoUser);
    }

    public boolean isPasswordErrorDisplayed() {
        return TestBase.isElementDisplayed(lblErrorPw);
    }

}
