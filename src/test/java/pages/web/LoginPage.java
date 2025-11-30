package pages.web;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginPage {
    WebDriver driver;

    By usernameInputText = By.cssSelector("input#user-name");
    By passwordInputText = By.xpath("//*[@id=\"password\"]");
    By loginButton = By.id("login-button");
    By errormessage = By.xpath("//*[@id=\"login_button_container\"]/div/form/div[3]");

    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    public void goToLoginPage(){
        driver.get("https://www.saucedemo.com/");
    }

    public void inputUsername (String username){
        driver.findElement(usernameInputText).sendKeys(username);
    }

    public void inputPassword(String password){

        driver.findElement(passwordInputText).sendKeys(password);
    }

    public void clickLoginButton(){

        driver.findElement(loginButton).click();
    }

    public void validateErrorAppear(String errorMessage){
        driver.findElement(errormessage).getText();
//        assertTrue(driver.getPageSource().contains(errorMessage));
    }
}
