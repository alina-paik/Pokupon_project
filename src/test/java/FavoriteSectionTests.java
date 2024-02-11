import jdk.jfr.Description;
import org.example.pages.FavoriteSectionPage;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class FavoriteSectionTests extends BaseTest {
    private FavoriteSectionPage favoriteSectionPage;
    @BeforeClass
    public void setUpBeforeTest() {
        favoriteSectionPage = new FavoriteSectionPage(webDriver);
    }

    @Test(priority = 1)
    @Description("Check that when an unauthorised user click the section, a login window appears")
    public void checkPopupLogin() {
        webDriver.get("https://pokupon.ua/");

        favoriteSectionPage.clickFavoriteButton();
        Assert.assertTrue(favoriteSectionPage.isLoginPopupDisplayed(), "Login popup not displayed");
        favoriteSectionPage.closeLoginPopup();
    }

    @Test(priority = 2)
    @Description("Check that authorised user can add product to favorite section")
    public void checkAddFavoriteSection() {
        webDriver.get("https://pokupon.ua/uk/deals/item/753562-vid-2-nochey-zi-snidankami-ta-bezlimitnim-spa-v-gotelnomu-kompleksi-karpati-v-migovo");

        favoriteSectionPage.loginBeforeTest();
        favoriteSectionPage.clickAddToFavorite();

        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.textToBePresentInElement(favoriteSectionPage.getAddToFavoriteButton(), "В обраному"));
        Assert.assertTrue(favoriteSectionPage.isProductInFavorites(), "Product is not added to favorites");
    }

    @Test(priority = 3)
    @Description("Check that user can remove product from favorite section")
    public void checkRemoveFromFavoriteSection() {
        webDriver.get("https://pokupon.ua/uk/deals/item/753562-vid-2-nochey-zi-snidankami-ta-bezlimitnim-spa-v-gotelnomu-kompleksi-karpati-v-migovo");

        /*favoriteSectionPage.loginBeforeTest();*/
        Assert.assertTrue(favoriteSectionPage.isProductInFavorites(), "Product is not in favorites");

        favoriteSectionPage.removeFromFavorite();

        Assert.assertTrue(favoriteSectionPage.isProductRemoveFromFavorite(), "Product is not removed from favorites");

    }
}
