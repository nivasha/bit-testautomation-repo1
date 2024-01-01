package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Dashboard extends BasePage {
    public Dashboard(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@id='btn_1602656141']/div/div/span")
    protected WebElement lblUsername;

    @FindBy(id = "btn_1602656141")
    protected WebElement btnProfileIcon;

    @FindBy(xpath = "//*[@id='a_1602657015_3']/span[2]")
    protected WebElement btnLogout;


}

