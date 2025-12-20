package JUnitTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import pages.web.CheckoutPage;
import pages.web.HomePage;
import pages.web.LoginPage;

import java.time.Duration;

public class LoginTest {
    @Test
    public void loginTest(){
        //inisialisasi webdriver
        WebDriver driver = WebDriverManager.chromedriver().create();

        //inisialisasi page object
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        CheckoutPage checkoutPage = new CheckoutPage(driver);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.saucedemo.com/");

        //action test
        loginPage.inputUsername("standard_user");
        loginPage.inputPassword("secret_sauce");
        loginPage.clickLoginButton();

        //
        homePage.validateOnHomePage();
        checkoutPage.validateOnCheckoutPage();

    }
}
