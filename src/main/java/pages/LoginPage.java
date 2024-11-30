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
 * Page class representing the Login Page.
 * Encapsulates interaction with login-related elements and actions.
 */
public class LoginPage extends BasePage {

    // Locators for elements on the login page
    private static final By USERNAME_FIELD = By.id("username");
    private static final By PASSWORD_FIELD = By.id("password");
    private static final By LOGIN_BUTTON = By.id("submit");

    // Explicit wait to handle dynamic elements
    private WebDriverWait wait;

    /**
     * Constructor to initialize the WebDriver and WebDriverWait.
     *
     * @param driver WebDriver instance
     */
    public LoginPage(WebDriver driver) {
        super(driver);  // Call the BasePage constructor
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
        BrowserUtils.sendKeys(driver, usernameElement, username); // Pass driver here
    }

    /**
     * Enters the password into the password field.
     *
     * @param password The password to be entered
     */
    public void enterPassword(String password) {
        WebElement passwordElement = wait.until(ExpectedConditions.visibilityOfElementLocated(PASSWORD_FIELD));
        BrowserUtils.sendKeys(driver, passwordElement, password); // Pass driver here
    }

    /**
     * Clicks the login button to submit the form.
     */
    public void clickLoginButton() {
        WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(LOGIN_BUTTON));
        BrowserUtils.click(driver, loginButton); // Pass driver here
    }

    /**
     * Verifies if the login button is displayed (useful for validation in tests).
     *
     * @return True if the login button is displayed, false otherwise
     */
    public boolean isLoginButtonDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(LOGIN_BUTTON)).isDisplayed();
    }
}
