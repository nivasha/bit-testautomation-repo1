package Functions;

import Pages.Dashboard;
import Tests.TestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DashboardPageMethods extends Dashboard {
    public DashboardPageMethods(WebDriver driver) {
        super(driver);
    }

    public boolean isUsernameDisplayed(){
        return TestBase.isElementDisplayed(lblUsername);
    }
}
