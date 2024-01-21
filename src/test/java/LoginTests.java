import jdk.jfr.Description;
import org.example.pages.LoginPage;
import org.example.pages.components.Header;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {
    @Test
    @Description("Check that login is worked with valid credentials")
    public void loginWithValidCredentials() throws InterruptedException {
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

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        String expectedErrorMessage = " Вы указали неверный e-mail или пароль. ";
        Assert.assertTrue(loginPage.isErrorDisplayed(expectedErrorMessage), "Expected error message is not displayed for invalid credentials");
    }

        private boolean isUserLoggedIn() {
            try {
                WebElement accountUser = webDriver.findElement(By.xpath("//div[@class='login authorized ng-star-inserted']"));
                return accountUser.isDisplayed();
            } catch (NoSuchElementException e) {
                return false;
            }
        }
}
