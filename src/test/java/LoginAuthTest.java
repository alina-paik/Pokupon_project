import org.example.pages.LoginPage;
import org.example.pages.components.Header;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

public abstract class LoginAuthTest extends BaseTest {

    protected boolean isUserLoggedIn() {
        try {
            WebElement accountUser = webDriver.findElement(By.xpath("//div[@class='login authorized ng-star-inserted']"));
            return accountUser.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    protected void login(String username, String password) {
        webDriver.get("https://pokupon.ua/");

        Header header = new Header(webDriver);
        header.clickLoginLink();

        LoginPage loginPage = new LoginPage(webDriver);
        loginPage.login(username, password);
    }
}
