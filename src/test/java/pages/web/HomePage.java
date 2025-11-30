package pages.web;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class HomePage {
    By productTitle = By.xpath("//*[@id=\"item_4_title_link\"]");
    private WebDriver driver;



    public HomePage(WebDriver driver){

        this.driver = driver;
    }

    public void validateOnHomePage(){
        driver.findElement(productTitle).getText();
//        WebElement productElement = driver.findElement(productTitle);
//        assertTrue(productElement.isDisplayed());
//        assertEquals("Sauce Labs Backpack", productElement.getText());
    }
}
