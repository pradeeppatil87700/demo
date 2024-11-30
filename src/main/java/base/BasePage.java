package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import utils.ConfigReader;

public class BasePage {

    protected static WebDriver driver;

    // Constructor Constructor
    public BasePage(WebDriver driver) {
        BasePage.driver = driver;
    }

    // Method to initialize WebDriver based on browser type
    public static WebDriver getDriver(String browser) {
        if (driver == null) {
        	System.out.println("Initializing WebDriver for browser: " + browser); // Debugging log
            if (browser.equalsIgnoreCase("chrome")) {
                System.setProperty("webdriver.chrome.driver", ConfigReader.getProperty("chromedriverPath"));
                driver = new ChromeDriver();
            } else if (browser.equalsIgnoreCase("firefox")) {
                System.setProperty("webdriver.gecko.driver", ConfigReader.getProperty("geckodriverPath"));
                driver = new FirefoxDriver();
            } else {
                throw new IllegalArgumentException("Unsupported browser: " + browser);
            }
        }
        return driver;
    }

    // Overloaded method to initialize WebDriver with browser from config file
    public static WebDriver getDriver() {
        String browser = ConfigReader.getProperty("browser");
        return getDriver(browser); // Use the browser from config file
    }

    // Method to close and quit WebDriver
    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}