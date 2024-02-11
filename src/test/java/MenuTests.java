import jdk.jfr.Description;
import org.example.pages.MenuPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class MenuTests extends BaseTest {
    private MenuPage menuPage;
    private Actions actions;
    @BeforeClass
    public void setUpBeforeTest() {
        webDriver.get("https://pokupon.ua/");
        menuPage = new MenuPage(webDriver);
        actions = new Actions(webDriver);

    }

    @Test
    @Description("Check that promotion menu change color to blue on mouseover")
    public void testPromotionMenuColorChange() {
        actions.moveToElement(menuPage.getPromotionMenu()).perform();

        String actualColor = menuPage.getPromotionMenu().getCssValue("color");
        String expectedColor = "rgba(49, 188, 254, 1)";
        Assert.assertEquals(actualColor, expectedColor, "Color is not expected");
    }

    @Test
    @Description("Check that other menu elements change color to white on mouseover")
    public void testOtherElementColorChange() {

       WebElement[] elements = {
                menuPage.getTourismMenu(),
                menuPage.getFoodMenu(),
                menuPage.getEntertainmentMenu(),
                menuPage.getSpaMenu(),
                menuPage.getHealthMenu(),
                menuPage.getSportMenu(),
                menuPage.getEducationMenu(),
                menuPage.getOtherMenu()
        };

        for (WebElement menu : elements) {
            actions.moveToElement(menu).perform();

            String actualColor = menu.getCssValue("color");
            String expectedColor = "rgba(255, 255, 255, 1)";
            Assert.assertEquals(actualColor, expectedColor, "Color is not expected");
        }

    }
}
