import jdk.jfr.Description;
import org.example.pages.SearchPage;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SearchTests extends BaseTest {
    @DataProvider(name = "searchQuery")
    public Object[][] searchQuery() {
        return new Object[][] {
                {"50%"},
                {"60"},
                {"55%"}
        };
    }

    @Test(dataProvider = "searchQuery")
    @Description("Check that the search on the site is working and gives the desired results")
    public void searchTest(String searchQuery) {
        webDriver.get("https://pokupon.ua/");

        SearchPage searchPage = new SearchPage(webDriver);
        searchPage.performSearch(searchQuery);

        Assert.assertTrue(searchPage.areSearchResultsDisplayed(), "Search results are not displayed");
        Assert.assertTrue(searchPage.areSearchResultsMatchingQuery(searchQuery),
                "Not all search results match the query: " + searchQuery);

    }
}
