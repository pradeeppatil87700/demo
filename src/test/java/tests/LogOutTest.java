package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

// Base and Utility Classes
import base.BasePage;
import pages.LogOutPage;
import utils.BrowserUtils;

public class LogOutTest {

    public WebDriver driver; 
 
    @Test
    public void testInvalidUsername() {
        try {
        	
           
        	 System.setProperty("webdriver.chrome.driver", "C:\\Users\\Asus\\Downloads\\chromedriver.exe");
			 WebDriver driver = new ChromeDriver();
			 BrowserUtils.maximizWindow(driver); 
            LogOutPage object = new LogOutPage(driver);
           // object.navigateTo("https://practicetestautomation.com/practice-test-login/");
            driver.get("https://practicetestautomation.com/practice-test-login/");
			
            
            // Enter incorrect username
            object.enterUsername("student1"); // Incorrect username
            object.enterPassword("Password123");
            object.buttonClick();
            
           
           // Validate error message for invalid username
             String actual = driver.findElement(By.cssSelector("div[id='error']")).getText();
             String expected = "Your username is invalid!";
             Assert.assertEquals(actual, expected, "Invalid Username :::");
            
            System.out.println("done logiv");

            // Take screenshot on failure
            BrowserUtils.takeScreenshot(driver, "LogOutTest", "Fail");

        } catch (Exception e) {
            System.out.println("Error during logout test: " + e.getMessage());
            Assert.fail("Test failed due to exception.");
        }
        driver.close();
    }

   
}
