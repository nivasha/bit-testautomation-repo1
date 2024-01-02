package Tests;

import Functions.DashboardPageMethods;
import Functions.LandingPageMethods;
import Functions.Login;
import Utils.DataManager;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class LoginTest extends TestBase {

    @Test(priority = 1)
    public void selectWebCentral() {
        try {
            LandingPageMethods landingPageMethods = new LandingPageMethods(driver);
            landingPageMethods.goToWebsiteCentral();
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Test(dataProvider = "loginCredentials", dataProviderClass = DataManager.class, dependsOnMethods = "selectWebCentral",priority = 2)
    public void login(String username, String password, String status) {
        try {
            Login loginFunction = new Login(driver);
            DashboardPageMethods dashboardPageMethods = new DashboardPageMethods(driver);
            SoftAssert softAssert = new SoftAssert();
            switch (status) {
                case "valid":
                    loginFunction.invalidNValidLogin(username, password);
                    softAssert.assertTrue(dashboardPageMethods.isUsernameDisplayed());
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
        } catch (Exception e) {
            Assert.fail();
        }
    }
}
