import jdk.jfr.Description;
import org.example.pages.FavoriteSectionPage;
import org.example.pages.components.Header;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FavoriteSectionTests extends BaseTest {

    @Test
    @Description("Check that when an unauthorised user click the section, a login window appears")
    public void checkPopupLogin() {
        webDriver.get("https://pokupon.ua/");

        Header header = new Header(webDriver);
        header.clickFavoriteButton();

        FavoriteSectionPage favoriteSectionPage = new FavoriteSectionPage(webDriver);
        Assert.assertTrue(favoriteSectionPage.isLoginPopupDisplayed(), "Login popup not displayed");
        favoriteSectionPage.closeLoginPopup();
    }

    /*@Test
    @Description("Check that authorised user can add product to favorite section")
    public void checkAddFavoriteSection() {
        webDriver.get("");
    }*/
}
