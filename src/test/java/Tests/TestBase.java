package Tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.ResourceBundle;

public class TestBase {

    public static WebDriver driver;
    public ResourceBundle resource;

    static JavascriptExecutor js;


    @BeforeClass
    public void setUp() {
        resource = ResourceBundle.getBundle("config");

        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(resource.getString("appURL"));
        driver.manage().window().maximize();
    }

    public static void sendKeys(WebElement element, String text) {
        try {
            element.clear();
            element.sendKeys(text);
        } catch (ElementNotInteractableException e) {
            element.clear();
            executeJSType(element, text);
        }

    }


    public static void clickOnElement(WebElement element) {

        try {
            element.click();
        } catch (ElementClickInterceptedException e) {
            executeJSClick(element);
        }


    }


    private static void executeJSClick(WebElement element) {
        js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element);
    }

    private static void executeJSType(WebElement element, String text) {
        js.executeScript("arguments[0].value = arguments[1];", element, text);
    }

    public static String getTextValue(WebElement element) {
        return element.getText();
    }

    public static boolean isElementDisplayed(WebElement element) {
        return element.isDisplayed();
    }


    public static void clearValue(WebElement element) {
        element.clear();
    }

}
