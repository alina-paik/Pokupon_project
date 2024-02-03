package org.example.pages.components;

import org.example.pages.BasePage;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class Header extends BasePage {
    @FindBy(xpath = "//div[@class='login ng-star-inserted']")
    private WebElement loginLink;

    @FindBy(xpath = "//div[@class='login authorized ng-star-inserted']")
    private WebElement accountButton;

    @FindBy(xpath = "//a[@class='favorite']")
    private WebElement favoriteButton;



    public Header(WebDriver driver) {
        super(driver);
    }

    public void clickLoginLink() {
        loginLink.click();
    }

    public void clickAccountButton() {
        waitForVisibility(accountButton);
        accountButton.click();
    }

    public void waitForVisibility(WebElement element) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOf(element));
            System.out.println("Element is visible and clickable: " + element);
        } catch (TimeoutException e) {
            System.out.println("Timeout waiting for visibility of element" + element + "'");
            throw e;
        }
    }

    public void clickFavoriteButton() {
        favoriteButton.click();
    }
}
