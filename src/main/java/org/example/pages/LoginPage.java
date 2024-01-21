package org.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
    @FindBy(xpath = "//input[@formcontrolname='username']")
    private WebElement usernameInput;

    @FindBy(xpath = "//input[@formcontrolname='password']")
    private WebElement passwordInput;

    @FindBy(xpath = "//button[@class='submit-btn']")
    private WebElement loginButton;

    @FindBy(xpath = "//p[@class='message ng-star-inserted']")
    private WebElement errorMessage;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void login(String username, String password) {
        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        loginButton.click();
    }

    public boolean isErrorDisplayed(String expectedErrorMessage) {
        try {
            return errorMessage.isDisplayed() && errorMessage.getText().equals(expectedErrorMessage.trim());
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
    }
}
