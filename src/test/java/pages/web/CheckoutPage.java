package pages.web;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage {
    By productTitle = By.xpath("//*[@id=\"add-to-cart-sauce-labs-backpack\"]");
    By buttonAddToChart = By.xpath("//*[@id=\"add-to-cart-sauce-labs-backpack\"]"); //*[@id="checkout"]
    By iconShippingCart = By.xpath("//*[@id=\"shopping_cart_container\"]");
    By buttonCheckout = By.xpath("//*[@id=\"checkout\"]");
    By firstnameInputText = By.cssSelector("input#first-name");
    By lastnameInputText = By.xpath("//*[@id=\"last-name\"]");
    By postalcodeInputText = By.xpath("//*[@id=\"postal-code\"]");
    By buttonContinue = By.xpath("//*[@id=\"continue\"]");
    By buttonFinish = By.xpath("//*[@id=\"finish\"]");
    By buttonBackHome = By.xpath("//*[@id=\"back-to-products\"]");
    By iconHamburger = By.xpath("//*[@id=\"menu_button_container\"]/div/div[1]/div");
    By buttonTextLogout = By.xpath("//*[@id=\"logout_sidebar_link\"]");
    private WebDriver driver;

    public void inputFirstname (String firstname){
        driver.findElement(firstnameInputText).sendKeys(firstname);
    }

    public void inputLastname(String lastname){

        driver.findElement(lastnameInputText).sendKeys(lastname);
    }
    public void inputPostalcode(String postalcode){

        driver.findElement(postalcodeInputText).sendKeys(postalcode);
    }

    public CheckoutPage(WebDriver driver){

        this.driver = driver;
    }

    public void validateOnCheckoutPage(){
        driver.findElement(productTitle).getText();
 //       WebElement productElement = driver.findElement(productTitle);
//        assertTrue(productElement.isDisplayed());
//        assertEquals("Sauce Labs Backpack", productElement.getText());
    }

    public void clickButtonAddtoChart() throws InterruptedException {

        driver.findElement(buttonAddToChart).click();
        Thread.sleep(2000);
    }

    public void clickIconShippingToChart() throws InterruptedException {

        driver.findElement(iconShippingCart).click();
        Thread.sleep(3000);
    }

    public void clickButtonCheckout() throws InterruptedException {

        driver.findElement(buttonCheckout).click();
        Thread.sleep(3000);
    }

    public void clickButtonContinue() throws InterruptedException {

        driver.findElement(buttonContinue).click();
        Thread.sleep(3000);
    }

    public void clickButtonFinish() throws InterruptedException {

        driver.findElement(buttonFinish).click();
        Thread.sleep(3000);
    }

    public void clickButtonBackHome() throws InterruptedException {

        driver.findElement(buttonBackHome).click();
        Thread.sleep(3000);
    }

    public void clickIconHamburger() throws InterruptedException {

        driver.findElement(iconHamburger).click();
        Thread.sleep(1000);
    }

    public void clickButtonTextLogout() throws InterruptedException {

        driver.findElement(buttonTextLogout).click();
        Thread.sleep(1000);
    }
}
