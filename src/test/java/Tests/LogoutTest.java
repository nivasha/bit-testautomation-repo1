package Tests;

import Functions.DashboardPageMethods;
import Functions.Login;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class LogoutTest extends TestBase {

    @Test(priority = 3, dependsOnMethods = "Tests.LoginTest.login")
    public void userLogout() {
        try {
            DashboardPageMethods dashboardPageMethods = new DashboardPageMethods(driver);
            Login login = new Login(driver);
            dashboardPageMethods.userLogout();
            SoftAssert softAssert = new SoftAssert();
            softAssert.assertTrue(login.isUserLogout());
            softAssert.assertAll();
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
