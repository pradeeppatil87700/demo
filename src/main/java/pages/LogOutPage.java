package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import base.BasePage;
import utils.BrowserUtils;

import java.time.Duration;

/**
 * Page class representing the Logout Page.
 * Handles actions related to logging out of the application.
 */
public class LogOutPage extends BasePage {

    // Locators for elements related to login/logout functionality
    private static final By USERNAME_FIELD = By.id("username");
    private static final By PASSWORD_FIELD = By.id("password");
    private static final By LOGIN_BUTTON = By.id("submit");

    // Explicit wait for handling dynamic elements
    private WebDriverWait wait;

    /**
     * Constructor to initialize the WebDriver and WebDriverWait.
     *
     * @param driver WebDriver instance
     */
    public LogOutPage(WebDriver driver) {
        super(driver); // Call the BasePage constructor
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    /**
     * Navigates to the specified URL.
     *
     * @param url The URL to navigate to
     */
    public void navigateTo(String url) {
        driver.get(url);
    }

    /**
     * Enters the username into the username field.
     *
     * @param username The username to be entered
     */
    public void enterUsername(String username) {
        WebElement usernameElement = wait.until(ExpectedConditions.visibilityOfElementLocated(USERNAME_FIELD));
        BrowserUtils.sendKeys(driver, usernameElement, username); // Corrected method call
    }

    /**
     * Enters the password into the password field.
     *
     * @param password The password to be entered
     */
    public void enterPassword(String password) {
        WebElement passwordElement = wait.until(ExpectedConditions.visibilityOfElementLocated(PASSWORD_FIELD));
        BrowserUtils.sendKeys(driver, passwordElement, password); // Corrected method call
    }

    /**
     * Clicks the login button to submit the form.
     */
    public void clickLoginButton() {
        WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(LOGIN_BUTTON));
        BrowserUtils.click(driver, loginButton); // Corrected method call
    }
}
