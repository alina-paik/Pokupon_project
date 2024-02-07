import jdk.jfr.Description;
import org.example.pages.LogoutPage;
import org.example.pages.components.Header;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LogoutTests extends LoginAuthTest {

    @Test
    @Description("Check that user can successfully logout")
    public void logoutTest() {
        webDriver.get("https://pokupon.ua/");
        login("yzvntqpioqaumwvqey@cazlp.com", "44250414");

        LogoutPage logoutPage = new LogoutPage(webDriver);
        logoutPage.logout();

        Assert.assertFalse(logoutPage.isUserLoggedIn(),"User is still logged in after logout");
    }
}
