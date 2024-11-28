package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

// Pages
import pages.LoginPage;
import base.BasePage;
import utils.BrowserUtils;

public class LoginTest {

    public WebDriver driver;
    @Test
    public void loginWithValidCredentials() {
        try {
       	
        	 System.setProperty("webdriver.chrome.driver", "C:\\Users\\Asus\\Downloads\\chromedriver.exe");
		     WebDriver driver = new ChromeDriver();
		     BrowserUtils.maximizWindow(driver); 
             
		      
	
            LoginPage object = new LoginPage(driver);
            driver.get("https://practicetestautomation.com/practice-test-login/");
    		
            
            // Enter valid credentials and click login
            object.enterUsername("student");
            object.enterPassword("Password123");
            object.buttonClick();

            // Validate the success message
            String actual = driver.findElement(By.cssSelector("div[class='post-header'] h1[class='post-title']"))
                    .getText();
            String expected = "Logged In Successfully";
            Assert.assertEquals(actual, expected, "Login was not successfully");

            // Log the result and take a screenshot
            System.out.println("Login Test Passed: User successfully logged in.");
          
            //BrowserUtils.takeScreenshot(driver, "LoginTest", "Pass");

        } catch (Exception e) {
            System.out.println("Error during login test: " + e.getMessage());
            Assert.fail("Test failed due to exception.");
        }
        driver.close();
    }


}
