package utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

/**
 * Utility class for common browser-related actions.
 * Contains reusable methods to maximize windows, handle waits, and capture screenshots.
 */
public class BrowserUtils {

    /**
     * Maximizes the browser window.
     *
     * @param driver WebDriver instance
     */
    public static void maximizeWindow(WebDriver driver) {
        driver.manage().window().maximize();
    }

    /**
     * Waits explicitly for an element to be visible.
     *
     * @param driver WebDriver instance
     * @param element WebElement to wait for
     * @param timeoutInSeconds Timeout in seconds
     * @return WebElement after it becomes visible
     */
    public static WebElement waitForVisibility(WebDriver driver, WebElement element, int timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    /**
     * Captures a screenshot and saves it with a timestamp.
     *
     * @param driver WebDriver instance
     * @param testName Name of the test case
     * @param status Test status (e.g., "Passed", "Failed")
     */
    public static void takeScreenshot(WebDriver driver, String testName, String status) {
        String timestamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        String basePath = "screenshots/qa/authentication/" + testName + "/" + status + "/";
        File destinationFile = new File(basePath + testName + "_" + timestamp + ".png");

        try {
            // Create directories if they don't exist
            destinationFile.getParentFile().mkdirs();

            // Take screenshot and save it
            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileHandler.copy(screenshot, destinationFile);

            System.out.println("Screenshot saved at: " + destinationFile.getAbsolutePath());
        } catch (IOException e) {
            System.err.println("Failed to save screenshot: " + e.getMessage());
        }
    }

    /**
     * Waits explicitly for an element to be clickable.
     *
     * @param driver WebDriver instance
     * @param element WebElement to wait for
     * @param timeoutInSeconds Timeout in seconds
     * @return WebElement after it becomes clickable
     */
    public static WebElement waitForClickability(WebDriver driver, WebElement element, int timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    /**
     * Sends keys to a WebElement after waiting for its visibility.
     *
     * @param driver WebDriver instance
     * @param element WebElement to send keys to
     * @param text Text to be sent
     */
    public static void sendKeys(WebDriver driver, WebElement element, String text) {
        waitForVisibility(driver, element, 10).sendKeys(text);
    }

    /**
     * Clicks on a WebElement after waiting for its clickability.
     *
     * @param driver WebDriver instance
     * @param element WebElement to click
     */
    public static void click(WebDriver driver, WebElement element) {
        waitForClickability(driver, element, 10).click();
    }
}
