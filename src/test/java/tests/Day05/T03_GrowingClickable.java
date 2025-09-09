package tests.Day05;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class T03_GrowingClickable {
//    Go to https://testpages.herokuapp.com/styled/challenges/growing-clickable.html
//    Click "click me" button
//    Verify "Event Triggered" appears
    WebDriver driver;
    String url = "https://testpages.herokuapp.com/styled/challenges/growing-clickable.html";
    @Test
    void test01() throws InterruptedException {
        By growButton = By.xpath("//button[@id='growbutton']");
        By status = By.id("growbuttonstatus");
        // Go to https://testpages.herokuapp.com/styled/challenges/growing-clickable.htm
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get(url);
        // Click "click me" button
        wait.until(ExpectedConditions.elementToBeClickable(growButton)).click();
        // Verify "Event Triggered" appears
        wait.until(ExpectedConditions.visibilityOfElementLocated(status));
        Assertions.assertEquals("Event Triggered", driver.findElement(status).getText());

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
