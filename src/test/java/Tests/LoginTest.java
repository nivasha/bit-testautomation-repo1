package Tests;

import Functions.DashboardPageMethods;
import Functions.LandingPageMethods;
import Functions.Login;
import Utils.DataManager;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class LoginTest extends TestBase {

    @Test(priority = 1)
    public void selectWebCentral() {
        LandingPageMethods landingPageMethods = new LandingPageMethods(driver);
        landingPageMethods.goToWebsiteCentral();
    }

    @Test(dataProvider = "loginCredentials",dependsOnMethods = "selectWebCentral")
    public void login(String username, String password, String status) {

        Login loginFunction = new Login(driver);


        SoftAssert softAssert = new SoftAssert();
        switch (status) {
            case "valid":
                loginFunction.invalidNValidLogin(username, password);
                DashboardPageMethods dashboardPageMethods = new DashboardPageMethods(driver);
                softAssert.assertTrue(dashboardPageMethods.isUsernameDisplayed(), "Login was not successful");
                break;
            case "invalid":
                loginFunction.invalidNValidLogin(username, password);
                softAssert.assertTrue(loginFunction.isPasswordErrorDisplayed());
                loginFunction.goBack();
                break;
            case "invalid email":
                loginFunction.inValidEmail(username);
                softAssert.assertTrue(loginFunction.isInvalidErrorDisplayed());
                break;
            case "no such user":
                loginFunction.inValidEmail(username);
                softAssert.assertTrue(loginFunction.isNoUserDisplayed());
                break;
            default:
                loginFunction.goBack();
                throw new IllegalArgumentException("Unknown status provided in test data: " + status);
        }

        softAssert.assertAll();

    }

    @DataProvider(name = "loginCredentials")
    public Object[][] readCredentials() {
        return DataManager.getCredentials("Login");
    }

}
