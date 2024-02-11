import jdk.jfr.Description;
import org.example.pages.LoginPage;
import org.example.pages.LogoutPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LogoutTests extends BaseTest {

    @BeforeMethod
    public void loginBeforeTest() {
        webDriver.get("https://pokupon.ua/");
        LoginPage loginPage = new LoginPage(webDriver);
        loginPage.login("yzvntqpioqaumwvqey@cazlp.com", "44250414");
    }

    @Test
    @Description("Check that user can successfully logout")
    public void logoutTest() {

        LogoutPage logoutPage = new LogoutPage(webDriver);
        logoutPage.logout();

        Assert.assertFalse(logoutPage.isUserLoggedIn(),"User is still logged in after logout");
    }
}
