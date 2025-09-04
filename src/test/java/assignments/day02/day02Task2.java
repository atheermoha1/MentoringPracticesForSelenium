package assignments.day02;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class day02Task2 {

    static WebDriver driver;

//  Setup:
//  Use @BeforeEach to open Chrome and maximize.

    @BeforeEach
    void setUp(){
        System.out.println("Tests start running");
        driver= new ChromeDriver();
        driver.manage().window().maximize();

    }
//    Teardown:
//    Close the browser with @AfterEach.

    @AfterEach
    void tearDown(){
      System.out.println("Test finished");
      driver.quit();
    }

//    Test 1:
//    Navigate to https://www.selenium.dev/.
//    Verify that the page source contains the word "WebDriver".
    @Test
    void test01(){
        driver.navigate().to("https://www.selenium.dev/");
        Assertions.assertTrue(driver.getPageSource().contains("WebDriver"),"Page contains webDriver word");

    }

//    Test 2:
//    Navigate to https://www.python.org/.
//    Assert the page source contains "Python".
    @Test
    void test02(){
        driver.navigate().to("https://www.python.org/");
        Assertions.assertTrue(driver.getPageSource().contains("Python"),"Page contains webDriver word");

    }
}
