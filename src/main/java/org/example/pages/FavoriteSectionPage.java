package org.example.pages;

import org.example.pages.components.Header;
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

    @FindBy(xpath = "//a[@class='add-favorites-btn']")
    private WebElement addToFavoriteButton;

    @FindBy(xpath = "//a[@class='add-favorites-btn']//span[text()='В обраному']")
    private WebElement inFavorite;

    private final LoginPage loginPage;

    private final Header header;

   public FavoriteSectionPage(WebDriver driver) {
       super(driver);
       loginPage = new LoginPage(driver);
       header = new Header(driver);
   }

   public void clickFavoriteButton() {
     header.getFavoriteButton().click();
   }

   public void loginBeforeTest() {
       loginPage.login("yzvntqpioqaumwvqey@cazlp.com", "44250414");
   }


   public boolean isProductInFavorites() {
           WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
           wait.until(ExpectedConditions.visibilityOf(inFavorite));
           return inFavorite.isDisplayed();
   }

   public boolean isProductRemoveFromFavorite() {
       WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
       wait.until(ExpectedConditions.visibilityOf(addToFavoriteButton));
       return addToFavoriteButton.isDisplayed();
   }

    public void clickAddToFavorite() {
        addToFavoriteButton.click();
    }

    public void removeFromFavorite() {
       inFavorite.click();
    }

    public WebElement getAddToFavoriteButton() {
       return addToFavoriteButton;
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
