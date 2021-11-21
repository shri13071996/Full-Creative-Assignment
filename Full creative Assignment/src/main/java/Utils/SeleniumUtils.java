package Utils;

import com.browser.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Set;

public class SeleniumUtils {

 public static WebDriverWait wait = new WebDriverWait(DriverFactory.driver, 40);
 public static String parentWindow = null;

    public  static void waitAndClick(By by){
        waitForElementPresence(by);
        DriverFactory.driver.findElement(by).click();
    }
    public  static void enterText(By by,String text){
        waitForElementPresence(by);
        DriverFactory.driver.findElement(by).sendKeys();
    }

    public static void waitForElementPresence(By by){
        wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public  static void clear(By by){
        DriverFactory.driver.findElement(by).clear();
    }

    public static String switchToNewWindow(WebDriver driver) {
        try {
            Set<String> windowHandles = driver.getWindowHandles();
            parentWindow = driver.getWindowHandle(); // get the current window handle
            System.out.println("No of Windows opened:" + windowHandles.size());

            for (String winHandle : driver.getWindowHandles()) {
                if (!winHandle.equals(parentWindow)) {
                    driver.switchTo().window(winHandle);
                }
            }
        } catch (Exception ex) {
            parentWindow = "Failure: Errorr while switching to new window" + ex.toString();
            System.out.println(parentWindow);
        }
        return parentWindow;
    }

    public static void switchToParentWindow(WebDriver driver, String parent) {
        try {
            driver.switchTo().window(parent);
            parentWindow = "Switched back to Parent window Successfully";
        } catch (Exception ex) {
            parentWindow = "Failure:Error in Switching back to parent window" + ex.toString();
            System.out.println(parentWindow);
        }
    }

    /*Using WebDriver's IsDisplayed to return boolean value
     * To be used in if condition to check for an element presence*/
    public static boolean isElementPresent(WebDriver driver, By by){
        try {
            return driver.findElement(by).isDisplayed();
        } catch (Exception ex) {
            return false;
        }
    }

}
