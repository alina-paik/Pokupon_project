import jdk.jfr.Description;
import org.example.pages.LoginPage;
import org.example.pages.components.Header;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends LoginAuthTest {

    @Test
    @Description("Check that login is worked with valid credentials")
    public void loginWithValidCredentials()  {
        webDriver.get("https://pokupon.ua/");

        Header header = new Header(webDriver);
        header.clickLoginLink();

        LoginPage loginPage = new LoginPage(webDriver);
        loginPage.login("yzvntqpioqaumwvqey@cazlp.com", "44250414");
        Assert.assertTrue(isUserLoggedIn(), "User isn't logged in successfully");
    }

    @Test
    @Description("Check that login with invalid credentials displayed error message")
    public void loginWithInvalidCredentials() {
        webDriver.get("https://pokupon.ua/");
        Header header = new Header(webDriver);
        header.clickLoginLink();

        LoginPage loginPage = new LoginPage(webDriver);
        loginPage.login("yzvntqpioqaumwvqey@cazlp.com", "invalid_password");

        String expectedErrorMessage = " Вы указали неверный e-mail или пароль. ";
        Assert.assertTrue(loginPage.isErrorDisplayed(expectedErrorMessage), "Expected error message is not displayed for invalid credentials");
    }
}
