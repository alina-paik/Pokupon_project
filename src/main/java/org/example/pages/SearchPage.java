package org.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchPage extends BasePage {
    @FindBy(xpath = "//input[@role='searchbox']")
    private WebElement searchInput;

    @FindBy(xpath = "//button[@class='p-element search-button p-button p-component p-button-icon-only']")
    private WebElement searchButton;

    @FindBy(xpath = "//li[@class='container__block four ng-star-inserted']")
    private List<WebElement> searchResults;

    public SearchPage(WebDriver driver) {
        super(driver);
    }

    public void performSearch(String searchQuery) {
        searchInput.sendKeys(searchQuery);
        searchButton.click();
    }

    public boolean areSearchResultsDisplayed() {
        return !searchResults.isEmpty() && searchResults.get(0).isDisplayed();
    }

    public boolean areSearchResultsMatchingQuery(String searchQuery) {
        for (WebElement result : searchResults) {
            if (!result.getText().contains(searchQuery)) {
                return false;
            }
        }
        return true;
    }
}
