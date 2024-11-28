package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BasePage {

    protected static WebDriver driver;
    // Constructor to initialize the driver
    public BasePage(WebDriver driver) {
        this.driver = driver;
    }
    
    
    // Method to initialize WebDriver based on browser type
    public static WebDriver getDriver(String browser) {
        if (driver == null) {
            if (browser.equalsIgnoreCase("chrome")) {
                System.setProperty("webdriver.chrome.driver", "C:\\Users\\Asus\\Downloads\\chromedriver.exe");
                driver = new ChromeDriver();
            } else if (browser.equalsIgnoreCase("firefox")) {
                System.setProperty("webdriver.gecko.driver", "C:\\Users\\Asus\\Downloads\\geckodriver.exe");
                driver = new FirefoxDriver();
            } else {
                throw new IllegalArgumentException("Unsupported browser: " + browser);
            }
        }
        return driver;
    }

    // Overloaded method to get ChromeDriver by default
    public static WebDriver getDriver() {
        return getDriver("chrome"); // Default browser is Chrome
    }

    // Method to close and quit WebDriver
    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }


}
