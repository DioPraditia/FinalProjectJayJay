package com.dio.stepdef.web;

import com.dio.BaseTest;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.web.HomePage;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class HomeStepDef extends BaseTest {
    HomePage homePage;

    @Then("user is on homepage")
    public void userIsOnHomepage(){
        By productTitle = By.xpath("//*[@id=\"item_4_title_link\"]");
        WebElement productElement = driver.findElement(productTitle);
        assertTrue(productElement.isDisplayed());
        Assert.assertEquals("Sauce Labs Backpack", productElement.getText());
        homePage = new HomePage(driver);
        homePage.validateOnHomePage();
    }
}
