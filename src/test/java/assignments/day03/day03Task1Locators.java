package assignments.day03;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class day03Task1Locators {
    static WebDriver driver;

    @BeforeAll
    public static void setUp() {
// TODO: Initialize WebDriver
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    }
    @Test
    public void testNavigation() {
// TODO: Navigate to test pages
        driver.get("https://testpages.herokuapp.com/styled/index.html");

// TODO: Click on "Locators - Find By Playground Test Page"
        By locatorsLink = By.id("findbytest");
        driver.findElement(locatorsLink).click();
// TODO: Print current URL
        System.out.println("driver.getCurrentUrl() = " + driver.getCurrentUrl());
// TODO: Navigate back
        driver.navigate().back();
// TODO: Print URL after going back
        System.out.println("driver.getCurrentUrl() = " + driver.getCurrentUrl());
// TODO: Click on "WebDriver Example Page"
        By webDriverExampleLink = By.id("webdriverexamplepage");
        driver.findElement(webDriverExampleLink).click();
// TODO: Print current URL
        System.out.println("driver.getCurrentUrl() = " + driver.getCurrentUrl());
// TODO: Enter value 20 in number input
        By numberInput = By.name("number-entry");
        driver.findElement(numberInput).sendKeys("20");
         By submitButton = By.id("submit-to-server");
        driver.findElement(submitButton).click();
// TODO: Verify 'two, zero' message appears
        By message = By.id("message");
        String expectedMessage = "two, zero";
        String actualMessage = driver.findElement(message).getText();
        Assertions.assertEquals(expectedMessage,actualMessage);

    }
    @AfterAll
    static public void tearDown() {

        driver.quit();
    }

}
