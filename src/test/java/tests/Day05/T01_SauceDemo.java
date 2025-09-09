package tests.Day05;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class T01_SauceDemo {
//    Given: Go to https://www.saucedemo.com/
    WebDriver driver;
    String url = "https://www.saucedemo.com/";
    @Test
    void test01() {
        driver.get(url);

        By username = By.id("user-name");
        By password = By.id("password");
        By loginButton = By.id("login-button");
        By orderDropdown = By.className("product_sort_container");
        By pricesClass = By.className("inventory_item_price");
        //    When: Enter username as "standard user"
        driver.findElement(username).sendKeys("standard_user");
        //    And: Enter password as "secret sauce"
        driver.findElement(password).sendKeys("secret_sauce");
        //    And: Click login button
        driver.findElement(loginButton).click();
//    And: Order products by "Price (low to high)"
        Select select = new Select(driver.findElement(orderDropdown));
        //driver.findElement(orderDropdown).click();
        select.selectByVisibleText("Price (low to high)");
        //    Then: Assert last product costs $49.99, first product costs $7.99
        List<WebElement> prices = driver.findElements(pricesClass);
        Assertions.assertEquals("$7.99",prices.getFirst().getText());
        Assertions.assertEquals("$49.99",prices.getLast().getText());





    }
    @BeforeEach
    void setUp() {
        driver= new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }
}
