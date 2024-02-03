package org.example.pages;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class FavoriteSectionPage extends BasePage {

    @FindBy(xpath = "//div[@class='container-modal container-modal-header']")
    private WebElement loginPopup;

    @FindBy(xpath = "//button[@class='close']")
    private WebElement closeLoginPopup;

   public FavoriteSectionPage(WebDriver driver) {
       super(driver);
   }

   public boolean isLoginPopupDisplayed() {
       try {
           WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
           wait.until(ExpectedConditions.visibilityOf(loginPopup));
           return true;
       } catch (TimeoutException e) {
         return false;
       }
   }

   public void closeLoginPopup() {
       WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
       wait.until(ExpectedConditions.elementToBeClickable(closeLoginPopup)).click();
   }

}
