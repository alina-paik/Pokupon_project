import jdk.jfr.Description;
import org.example.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {

    private LoginPage loginPage;
    @BeforeClass
    public void setUpBeforeTest() {
        webDriver.get("https://pokupon.ua/");
        loginPage = new LoginPage(webDriver);
    }
    @Test
    @Description("Check that login is worked with valid credentials")
    public void loginWithValidCredentials() {
        loginPage.login("yzvntqpioqaumwvqey@cazlp.com",
                "44250414");
        Assert.assertTrue(loginPage.isUserLoggedIn(), "User isn't logged in successfully");
    }

    @Test
    @Description("Check that login with invalid credentials displayed error message")
    public void loginWithInvalidCredentials() {
        loginPage.login("yzvntqpioqaumwvqey@cazlp.com", "invalid_password");

        String expectedErrorMessage = " Вы указали неверный e-mail или пароль. ";
        Assert.assertTrue(loginPage.isErrorDisplayed(expectedErrorMessage),
                "Expected error message is not displayed for invalid credentials");
    }

}
