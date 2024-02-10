
import jdk.jfr.Description;
import org.example.pages.FilteringPage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class FilteringTests extends BaseTest {

    @Test
    @Description("Check that filtering by category works")
    public void checkFilterByCategory() {
        webDriver.get("https://pokupon.ua/uk/deals/kiev/eda_i_restorany");
        FilteringPage filteringPage = new FilteringPage(webDriver);

        filteringPage.getFoodDelivery().click();
        Assert.assertEquals(webDriver.getCurrentUrl(), "https://pokupon.ua/uk/deals/kiev/dostavka_edy", "URL doesn`t match for category 'Доставка їжі'");

        filteringPage.getPickUpFromRestaurants().click();
        Assert.assertEquals(webDriver.getCurrentUrl(), "https://pokupon.ua/uk/deals/kiev/samovyvoz-iz-restoranov", "URL doesn`t match for category 'Самовивіз з ресторанів");

        filteringPage.getBarsAndPubs().click();
        Assert.assertEquals(webDriver.getCurrentUrl(), "https://pokupon.ua/uk/deals/kiev/bary_i_paby", "URL doesn`t match for category 'Бари і паби'");

        filteringPage.getRestaurantsAndCafes().click();
        Assert.assertEquals(webDriver.getCurrentUrl(), "https://pokupon.ua/uk/deals/kiev/restorany_i_kafe", "URL doesn`t match for category 'Ресторани і кафе'");

        filteringPage.getHookah().click();
        Assert.assertEquals(webDriver.getCurrentUrl(), "https://pokupon.ua/uk/deals/kiev/kaljan", "URL doesn`t match for category 'Кальян'");

        filteringPage.getKaraoke().click();
        Assert.assertEquals(webDriver.getCurrentUrl(), "https://pokupon.ua/uk/deals/kiev/karaoke", "URL doesn`t match for category 'Караоке'");

        filteringPage.getBanquetsAndCatering().click();
        Assert.assertEquals(webDriver.getCurrentUrl(), "https://pokupon.ua/uk/deals/kiev/bankety", "URL doesn`t match for category 'Бари і кейтерінг'");

        filteringPage.getBirthdayPromotion().click();
        Assert.assertEquals(webDriver.getCurrentUrl(), "https://pokupon.ua/uk/deals/kiev/skydky-na-den-rozhdenyia", "URL doesn`t match for category 'Знижка до дня народження'");

    }

/*    @Test
    @Description("Check that filtering by price works")
    public void checkFilterByPrice() {
        webDriver.get("https://pokupon.ua/uk/deals/kiev/eda_i_restorany");
        FilteringPage filteringPage = new FilteringPage(webDriver);

        filteringPage.getMinPrice().clear();
        filteringPage.getMaxPrice().clear();

        filteringPage.getMinPrice().sendKeys("30");
        filteringPage.getMaxPrice().sendKeys("250");

        filteringPage.getMaxPrice().sendKeys(Keys.ENTER);
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(20));
        String expectedUrl = "https://pokupon.ua/uk/deals/kiev/eda_i_restorany?minPrice=30&maxPrice=250";
        wait.until(ExpectedConditions.urlToBe(expectedUrl));


        Assert.assertTrue(webDriver.getCurrentUrl().contains(expectedUrl), "URL doesn`t contain the expected price parameters");

    }*/
}
