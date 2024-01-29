package org.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


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
}
