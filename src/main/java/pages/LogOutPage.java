package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import base.BasePage;

public class LogOutPage extends BasePage {
	
	
	public LogOutPage (WebDriver driver) {
		super(driver);
	}
	
	
	protected By usernameField = By.id("username");
	protected By passwordField = By.id("password");
	protected By buttonLogin = By.id("submit");
	
	
	public void navigateTo(String url) {
		driver.get(url);
	}
	
	public void enterUsername(String username) {
		driver.findElement(usernameField).sendKeys(username);	
		}
	
	public void enterPassword(String password) {
		driver.findElement(passwordField).sendKeys(password);	
		}
	
	public void buttonClick() {
		driver.findElement(buttonLogin).click();
	}
	

}
