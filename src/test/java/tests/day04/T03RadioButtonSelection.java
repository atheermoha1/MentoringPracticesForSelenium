package tests.day04;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class T03RadioButtonSelection {
    WebDriver driver;
   String url = "http://test.rubywatir.com/radios.php";
    /*
    Task: Navigate to "https://demoqa.com/radio-button"
        . Create a test that:
        Attempts to select each radio button (Yes, Impressive, No)
        Prints whether each option is enabled/disabled
        For enabled options, select them and verify selection
        Print confirmation message for each successful selection
    */
    @Test
    void RadioButtonTest() throws InterruptedException {

        By radios = By.xpath("//p/input");
        By radioname = By.xpath("//p/input[3]");
        By radio5 = By.xpath("//p/input[4]");


        List<WebElement> radioButtons = driver.findElements(radios);
        for (WebElement radioButton : radioButtons) {
            radioButton.click();
            Thread.sleep(1000);

            Assertions.assertTrue(radioButton.isSelected());
        }
        System.out.println("selectFirst = " + driver.findElement(radios).isEnabled());
        driver.findElement(radios).click();
         Thread.sleep(1000);

        System.out.println("selectRadioName = " + driver.findElement(radioname).isEnabled());
        driver.findElement(radioname).click();
        Thread.sleep(1000);

        System.out.println("selectRadio5 = " + driver.findElement(radio5).isEnabled());
        driver.findElement(radio5).click();


    }
    @BeforeEach
    void setUp() {
        driver= new ChromeDriver();
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }

}
