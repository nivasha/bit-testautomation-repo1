package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyDevicesPage extends BasePage{
    public MyDevicesPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id="btn_1599662557_0")
    WebElement btnViewIssues;

    @FindBy(id="btn_1608304995_0")
    WebElement btnRename;

    @FindBy(xpath = "//input[@id='input_1650953571']")
    WebElement txtDeviceName;

    @FindBy(id="btnSave")
    WebElement btnSave;
}
