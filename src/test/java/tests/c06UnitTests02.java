package tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class c06UnitTests02 {
// Go to google homepage
// Do the following tasks by creating 3 different test methods.
// Print "Tests are starting to run" before each test() method
// Print "Tests have finished running" after each test() method
// Test if the title is the same when the page window is maximize and minimize
// Test if the title does not contain "Video" when the page window is fullscreen
// Test if the URL contains "google"
    WebDriver driver;
    String url = "https://google.com";

    @Test
    void Test01(){
        String max;
        String min;

        driver.manage().window().maximize();
        max= driver.getTitle();

        driver.manage().window().minimize();
        min= driver.getTitle();

        Assertions.assertEquals(max,min,"titles are !=");

    }
    @Test
    void Test02(){
        String title = driver.getTitle();
        driver.manage().window().fullscreen();
        Assertions.assertFalse(title.contains("video"));

    }
    @Test
    void Test03(){
        Assertions.assertTrue(driver.getCurrentUrl().contains("google"));

    }
    @BeforeEach
    void setUp(){
        System.out.println("Tests are starting to run");
        driver= new ChromeDriver();
        driver.get(url);

    }
    @AfterEach
    void tearDown(){
        System.out.println("Test is finished");
        driver.quit();
    }

}
