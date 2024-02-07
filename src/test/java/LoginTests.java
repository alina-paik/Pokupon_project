import jdk.jfr.Description;
import org.example.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends LoginAuthTest {

    @Test(priority = 1)
    @Description("Check that login is worked with valid credentials")
    public void loginWithValidCredentials()  {
        webDriver.get("https://pokupon.ua/");

        login("yzvntqpioqaumwvqey@cazlp.com", "44250414");

        Assert.assertTrue(isUserLoggedIn(), "User isn't logged in successfully");
    }

    @Test(priority = 2)
    @Description("Check that login with invalid credentials displayed error message")
    public void loginWithInvalidCredentials() {
        webDriver.get("https://pokupon.ua/");

        login("yzvntqpioqaumwvqey@cazlp.com", "invalid_password");

        LoginPage loginPage = new LoginPage(webDriver);

        String expectedErrorMessage = " Вы указали неверный e-mail или пароль. ";
        Assert.assertTrue(loginPage.isErrorDisplayed(expectedErrorMessage), "Expected error message is not displayed for invalid credentials");
    }
}
