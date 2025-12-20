package com.dio.stepdef.web;

import com.dio.BaseTest;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.web.CheckoutPage;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CheckoutStepDef extends BaseTest {
    CheckoutPage checkoutPage;

    @Then("user is on checkoutpage")
    public void userIsOnCheckOutPage() throws InterruptedException {
        By productTitle = By.xpath("//*[@id=\"add-to-cart-sauce-labs-backpack\"]");
        WebElement productElement = driver.findElement(productTitle);
        assertTrue(productElement.isDisplayed());
        Assert.assertEquals("Add to cart", productElement.getText());
        checkoutPage = new CheckoutPage(driver);
        checkoutPage.validateOnCheckoutPage();
        Thread.sleep(3000);

    }

    @When("user click button Add to chart")
    public void userClickButtonAddtoChart() throws InterruptedException {
        checkoutPage.clickButtonAddtoChart();
        Thread.sleep(2000);
    }

    @When("user click icon shipping to cart")
    public void userClickIconShippingToChart() throws InterruptedException {
        checkoutPage.clickIconShippingToChart();
        Thread.sleep(2000);
    }

    @When("user click button checkout")
    public void userClickButtonCheckout() throws InterruptedException {
        checkoutPage.clickButtonCheckout();
        Thread.sleep(2000);
    }

    @And("user input first name with {string}")
    public void userInputFirstNameWith(String firstname) throws InterruptedException {
        checkoutPage.inputFirstname(firstname);
        Thread.sleep(2000);
    }

    @And("user input last name with {string}")
    public void userInputLastNameWith(String lastname) throws InterruptedException {
        checkoutPage.inputLastname(lastname);
        Thread.sleep(2000);
    }


    @And("user input postal code with {string}")
    public void userInputPostalCodeWith(String postalcode) throws InterruptedException {
        checkoutPage.inputPostalcode(postalcode);
        Thread.sleep(2000);
    }

    @When("user click button continue")
    public void userClickButtonContinue() throws InterruptedException {
        checkoutPage.clickButtonContinue();
        Thread.sleep(2000);
    }

    @When("user click button finish")
    public void userClickButtonFinish() throws InterruptedException {
        checkoutPage.clickButtonFinish();
        Thread.sleep(2000);
    }

    @When("user click button back home")
    public void userClickButtonBackHome() throws InterruptedException {
        checkoutPage.clickButtonBackHome();
        Thread.sleep(1000);
    }

    @When("user click button hamburger")
    public void userClickIconHamburger() throws InterruptedException {
        checkoutPage.clickIconHamburger();
        Thread.sleep(1000);
    }

    @When("user click logout")
    public void userClickButtonTextLogout() throws InterruptedException {
        checkoutPage.clickButtonTextLogout();
        Thread.sleep(1000);
    }

}
