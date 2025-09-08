package assignments.day03;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class day03Task2 {
    static WebDriver driver;

    @BeforeAll
    public static void setUp() {
// TODO: Initialize WebDriver
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    }
    @Test
            void FirstTest(){
        // Navigate to: https://opensource-demo.orangehrmlive.com/
        driver.get("https://opensource-demo.orangehrmlive.com/");
    }

    // TODO: Locate username using absolute XPath
        String absoluteUsernameXPath = ""; // Fill absolute path

        // TODO: Locate username using relative XPath
        String relativeUsernameXPath = ""; // Fill relative path
        // TODO: Locate password using both methods

        // TODO: Locate login button using both methods

        // TODO: Test both approaches work

        @Test
        void relativeXpathTest() {
        }

        @Test
        void absoltuXpathTest() {

        }
    @AfterAll
    static public void tearDown() {

        driver.quit();
    }

}
