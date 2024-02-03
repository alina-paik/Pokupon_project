package org.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends BasePage {
    @FindBy(xpath = "//div[@class='add-favorites ng-star-inserted']//button[@class='favorite']")
    private WebElement addToFavoriteSection;

    @FindBy(xpath = "")
    private WebElement productName;

    public ProductPage(WebDriver driver) {
        super(driver);
    }

}
