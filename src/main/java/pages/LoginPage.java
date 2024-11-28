package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import base.BasePage;
import utils.BrowserUtils;



public class LoginPage extends BasePage  {
	
	// Constructor that initializes the driver using the superclass constructor
    public LoginPage(WebDriver driver) {
        super(driver);  // Call the constructor of BasePage
    }
	
	private By usernameField = By.id("username");
	private By passwordField = By.id("password");
	private By buttonLogin = By.id("submit");
	
	
    
	
	
	public void navigateTo(String url) {
		driver.get(url);
	}
	
	public void enterUsername(String username) {
     driver.findElement(usernameField).sendKeys(username);	
	}
	
	
	/*
	 * // Methods for interacting with the page public void enterUsername(String
	 * username) { WebElement usernameElement =
	 * BrowserUtils.waitForVisibility(driver, driver.findElement(usernameField),
	 * 10); usernameElement.sendKeys(username); }
	 */
    
    
	
	public void enterPassword(String password) {
	driver.findElement(passwordField).sendKeys(password);
	}
	
	public void buttonClick() {
		driver.findElement(buttonLogin).click();
	}

	
	
}
