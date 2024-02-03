package org.example.pages;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class FilteringPage extends BasePage {
    @FindBy(xpath = "//a[@href='/uk/deals/kiev/dostavka_edy']")
    private WebElement foodDelivery;

    @FindBy(xpath = "//a[@href='/uk/deals/kiev/samovyvoz-iz-restoranov']")
    private WebElement PickUpFromRestaurants;

    @FindBy(xpath = "//a[@href='/uk/deals/kiev/bary_i_paby']")
    private WebElement barsAndPubs;

    @FindBy(xpath = "//a[@href='/uk/deals/kiev/restorany_i_kafe']")
    private WebElement restaurantsAndCafes;

    @FindBy(xpath = "//a[@href='/uk/deals/kiev/kaljan']")
    private WebElement hookah;

    @FindBy(xpath = "//a[@href='/uk/deals/kiev/karaoke']")
    private WebElement karaoke;

    @FindBy(xpath = "//a[@href='/uk/deals/kiev/bankety']")
    private WebElement banquetsAndCatering;

    @FindBy(xpath = "//a[@href='/uk/deals/kiev/skydky-na-den-rozhdenyia']")
    private WebElement birthdayPromotion;

    @FindBy(xpath = "//input[@id='minPrice']")
    private WebElement minPrice;

    @FindBy(xpath = "//input[@id='maxPrice']")
    private WebElement maxPrice;

    @FindBy(xpath = "//div[@class='ng-select-container ng-has-value']")
    private WebElement dropDownStation;

    @FindBy(xpath = "//div[@id='a7b0a0531116-1']")
    private WebElement osokorkyStation;

    public FilteringPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getFoodDelivery() {
        return foodDelivery;
    }

    public WebElement getBarsAndPubs() {
        return barsAndPubs;
    }

    public WebElement getPickUpFromRestaurants() {
        return PickUpFromRestaurants;
    }

    public WebElement getRestaurantsAndCafes() {
        return restaurantsAndCafes;
    }

    public WebElement getHookah() {
        return hookah;
    }

    public WebElement getKaraoke() {
        return karaoke;
    }

    public WebElement getBanquetsAndCatering() {
        return banquetsAndCatering;
    }

    public WebElement getBirthdayPromotion() {
        return birthdayPromotion;
    }

    public WebElement getMinPrice() {
        return minPrice;
    }

    public WebElement getMaxPrice() {
        return maxPrice;
    }

    public void clickDropDownStation() {
        dropDownStation.click();
    }


    public void waitForVisibility(WebElement element) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            wait.until(ExpectedConditions.visibilityOf(element));
        } catch (TimeoutException e) {
            throw e;
        }
    }

    public void clickStation() {
        waitForVisibility(osokorkyStation);
        osokorkyStation.click();
    }
}
