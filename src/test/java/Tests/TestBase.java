package Tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.ResourceBundle;

public class TestBase {

    public static WebDriver driver;
    public static ResourceBundle resource= ResourceBundle.getBundle("config");

    static JavascriptExecutor js;


    @BeforeSuite
    public void setUp() {
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

    public String captureScreenshot(String testname) {
        String timestamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
        String outputPath = "./"+ resource.getString("screenshots") + testname + "_" + timestamp + ".png";
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        try {
            File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(source, new File(outputPath));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return outputPath;
    }

}
