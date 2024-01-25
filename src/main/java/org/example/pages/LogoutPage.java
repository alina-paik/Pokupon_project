package org.example.pages;

import org.example.pages.components.Header;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LogoutPage extends BasePage {

    @FindBy(xpath = "//div[@class='login authorized ng-star-inserted']")
    private WebElement accountButton;

    @FindBy(xpath = "//app-header-dropdown-menu//li[normalize-space()='Вийти']")
    private WebElement logoutOption;

    public LogoutPage(WebDriver driver) {
        super(driver);
    }


    public boolean isUserLoggedIn() {
        try {
            return accountButton.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }


    public void logout() {
        Header header = new Header(driver);
        header.clickAccountButton();
        header.waitForVisibility(logoutOption);
        logoutOption.click();
    }
}
