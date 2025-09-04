package assignments.day02;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class day02Task4 {
static WebDriver driver;

//   Setup:
//    Launch Chrome and maximize in @BeforeEach.
    @BeforeEach
    void setUp() {

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        System.out.println("Test is running");

    }
//    Teardown:
//    Use @AfterAll to quit the browser.

    @AfterEach
    void tearDown() {
        driver.quit();
        System.out.println("Test finished");
    }

//    Test 1:
//    Navigate Google → YouTube → LinkedIn.
//    Assert titles contain "Google", "YouTube", "LinkedIn" respectively.
    @Test
    void test01() {
        driver.navigate().to("https://www.google.com");
        System.out.println(driver.getTitle());
        Assertions.assertTrue(driver.getTitle().contains("Google"));

        driver.navigate().to("https://www.YouTube.com");
        System.out.println(driver.getTitle());
        Assertions.assertTrue(driver.getTitle().contains("YouTube"));

        driver.navigate().to("https://www.LinkedIn.com");
        System.out.println(driver.getTitle());
        Assertions.assertTrue(driver.getTitle().contains("LinkedIn"));
    }

//    Test 2:
//    Navigate back twice and assert the URL of Google.
//    Navigate forward twice and assert URL of LinkedIn.
    @Test
    void test02(){
        driver.get("https://www.google.com/");
        driver.navigate().to("https://www.youtube.com/");
        driver.navigate().to("https://www.linkedin.com/");

        driver.navigate().back();
        driver.navigate().back();
        Assertions.assertEquals("https://www.google.com/", driver.getCurrentUrl(), "URL is Google");

        driver.navigate().forward();
        driver.navigate().forward();
        Assertions.assertEquals("https://www.linkedin.com/", driver.getCurrentUrl(), "URL is LinkedIn");
    }
    }


