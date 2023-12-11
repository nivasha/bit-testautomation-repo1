package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PasswordManagerPage extends BasePage{
    public PasswordManagerPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@class='col-12 col-md-4 mb-3 ng-star-inserted'][1]//h4")
    WebElement lblTitle1;

    @FindBy(xpath = "//div[@class='col-12 col-md-4 mb-3 ng-star-inserted'][1]//div")
    WebElement description1;

    @FindBy(xpath = "//div[@class='col-12 col-md-4 mb-3 ng-star-inserted'][2]//h4")
    WebElement lblTitle2;

   @FindBy(xpath = "//div[@class='col-12 col-md-4 mb-3 ng-star-inserted'][2]//div")
   WebElement description2;

    @FindBy(xpath = "//div[@class='col-12 col-md-4 mb-3 ng-star-inserted'][3]//h4")
    WebElement lblTitle3;

    @FindBy(xpath = "//div[@class='col-12 col-md-4 mb-3 ng-star-inserted'][3]//div")
    WebElement description3;
}
