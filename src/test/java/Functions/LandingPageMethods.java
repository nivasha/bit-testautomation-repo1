package Functions;

import Pages.LandingPage;
import Tests.TestBase;
import org.openqa.selenium.WebDriver;

public class LandingPageMethods extends LandingPage {
    public LandingPageMethods(WebDriver driver) {
        super(driver);
    }


    public void goToWebsiteCentral(){
        if(btnAcceptCookies.isDisplayed()){
            TestBase.clickOnElement(btnAcceptCookies);
        }

        TestBase.clickOnElement(btnLogin);
        TestBase.clickOnElement(btnWebCentral);

    }


}
