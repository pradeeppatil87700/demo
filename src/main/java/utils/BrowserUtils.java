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

public class BrowserUtils {
	
	
	public static void maximizWindow(WebDriver driver) {
		driver.manage().window().maximize();
	}
	
	// Explicit Wait: Wait for an element to be visible
    public static WebElement waitForVisibility(WebDriver driver, WebElement element, int timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
        return wait.until(ExpectedConditions.visibilityOf(element));
    }
	
    
	// Take ScreenShot 
	public static void takeScreenshot(WebDriver driver, String testName, String status) {
        String timestamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        String basePath = "screenshots\\qa\\authentication\\" + testName + "\\" + status + "\\";
        File destinationFile = new File(basePath + testName + "_" + timestamp + ".png");
        try {
            destinationFile.getParentFile().mkdirs();
            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileHandler.copy(screenshot, destinationFile);
            System.out.println("Screenshot saved at: " + destinationFile.getAbsolutePath());
        } catch (IOException e) {
            System.err.println("Failed to save screenshot: " + e.getMessage());
        }
    }

	












}
