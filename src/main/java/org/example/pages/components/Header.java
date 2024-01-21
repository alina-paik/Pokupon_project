package org.example.pages.components;

import org.example.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class Header extends BasePage {
    @FindBy(xpath = "//div[@class='login ng-star-inserted']")
    private WebElement loginLink;
    public Header(WebDriver driver) {
        super(driver);
    }

    public void clickLoginLink() {
        loginLink.click();
    }
}
