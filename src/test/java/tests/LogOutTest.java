package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

// Base and Utility Classes
import pages.LogOutPage;
import utils.BrowserUtils;

public class LogOutTest {

    private WebDriver driver;

    @BeforeMethod
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Asus\\Downloads\\chromedriver.exe");
        driver = new ChromeDriver();
      //  BrowserUtils.maximizeWindow(driver); // Corrected method call
        driver.get("https://practicetestautomation.com/practice-test-login/");
    }

    @AfterMethod
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void testInvalidUsername() {
        try {
            // Initialize LogOutPage
            LogOutPage logOutPage = new LogOutPage(driver);

            // Enter incorrect username and password
            logOutPage.enterUsername("student1"); // Incorrect username
            logOutPage.enterPassword("Password123");
            logOutPage.clickLoginButton();

            // Validate error message for invalid username
            String actualErrorMessage = driver.findElement(By.cssSelector("div[id='error']")).getText();
            String expectedErrorMessage = "Your username is invalid!";
            Assert.assertEquals(actualErrorMessage, expectedErrorMessage, "Invalid Username Error Message Mismatch");

            System.out.println("LogOut Test Passed: Invalid username error validated.");

        } catch (Exception e) {
            System.err.println("Error during logout test: " + e.getMessage());
            BrowserUtils.takeScreenshot(driver, "LogOutTest", "Fail");
            Assert.fail("Test failed due to exception: " + e.getMessage());
        }
    }
}
