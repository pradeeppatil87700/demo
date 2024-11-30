package tests;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;
import utils.BrowserUtils;


public class LoginTest {

    private WebDriver driver;

    @BeforeMethod
    public void setup() {
        // Initialize WebDriver using the BasePage and configuration
        driver = BasePage.getDriver(); // Browser is read from config.properties

        // Navigate to the login page
        driver.get("https://practicetestautomation.com/practice-test-login/");
    }
    
    

    @AfterMethod
    public void teardown() {
        BasePage.quitDriver();
    }

    @Test
    public void loginWithValidCredentials() {
        try {
            // Initialize LoginPage
            LoginPage loginPage = new LoginPage(driver);

            // Perform login
            loginPage.enterUsername("student");
            loginPage.enterPassword("Password123");
            loginPage.clickLoginButton();

            // Validate the success message
            String actual = driver.findElement(By.cssSelector("div[class='post-header'] h1[class='post-title']")).getText();
            String expected = "Logged In Successfully";
            Assert.assertEquals(actual, expected, "Login was not successful");

            // Log the result and take a screenshot
            System.out.println("Login Test Passed: User successfully logged in.");
            BrowserUtils.takeScreenshot(driver, "LoginTest", "Pass");

        } catch (Exception e) {
            System.err.println("Error during login test: " + e.getMessage());
            BrowserUtils.takeScreenshot(driver, "LoginTest", "Fail");
            Assert.fail("Test failed due to exception: " + e.getMessage());
        }
    }
}
