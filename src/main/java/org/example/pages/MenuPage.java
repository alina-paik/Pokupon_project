package org.example.pages;

import dev.failsafe.internal.util.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class MenuPage extends BasePage {
    @FindBy(xpath = "//a[@class='ng-star-inserted' and text()='Туризм і відпочинок']")
    private WebElement tourismMenu;

    @FindBy(xpath = "//a[@class='ng-star-inserted' and text()='Їжа і ресторани']")
    private WebElement foodMenu;

    @FindBy(xpath = "//a[@class='ng-star-inserted' and text()='Розваги']")
    private WebElement entertainmentMenu;

    @FindBy(xpath = "//a[@class='ng-star-inserted' and text()='Краса і SPA']")
    private WebElement spaMenu;

    @FindBy(xpath = "//a[@class='ng-star-inserted' and text()=\"Здоров'я\"]")
    private WebElement healthMenu;

    @FindBy(xpath = "//a[@class='ng-star-inserted' and text()='Спорт і фітнес']")
    private WebElement sportMenu;

    @FindBy(xpath = "//a[@class='ng-star-inserted' and text()='Навчання']")
    private WebElement educationMenu;

    @FindBy(xpath = "//a[@class='ng-star-inserted' and text()='Інше']")
    private WebElement otherMenu;

    @FindBy(xpath = "//a[@class='selected-category-title']")
    private WebElement promotionMenu;

    public MenuPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getTourismMenu() {
        return tourismMenu;
    }

    public WebElement getFoodMenu() {
        return foodMenu;
    }

    public WebElement getEntertainmentMenu() {
        return entertainmentMenu;
    }

    public WebElement getSpaMenu() {
        return spaMenu;
    }

    public WebElement getHealthMenu() {
        return healthMenu;
    }

    public WebElement getSportMenu() {
        return sportMenu;
    }

    public WebElement getEducationMenu() {
        return educationMenu;
    }

    public WebElement getOtherMenu() {
        return otherMenu;
    }

    public WebElement getPromotionMenu() {
        return promotionMenu;
    }

}
