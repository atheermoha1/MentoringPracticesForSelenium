package assignments.day02;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class day02Task3 {

static WebDriver driver;

//    Setup:
//    Open Chrome in @BeforeEach.

    @BeforeEach
    void setUp(){
        System.out.println("Tests start running");
        driver= new ChromeDriver();

    }
//    Teardown:
//    Close the browser.

    @AfterEach
    void tearDown(){
        System.out.println("Test finished");
        driver.quit();
    }

//    Test 1:
//    Navigate to https://www.bbc.com/.
//    Set browser size to 800x600 and assert the window size.

    @Test
    void test01(){
        driver.navigate().to("https://www.bbc.com/");
        driver.manage().window().setSize(new org.openqa.selenium.Dimension(800,600));
        Assertions.assertEquals(800,driver.manage().window().getSize().getWidth(),"The expected width is 800");
        Assertions.assertEquals(600,driver.manage().window().getSize().getHeight(),"The expected height is 600");


    }


//    Test 2:
//    Move the window to position (100, 100) and assert its position.
    @Test
    void test02(){
        driver.manage().window().setPosition(new org.openqa.selenium.Point(100,100));
        Assertions.assertEquals(100, driver.manage().window().getPosition().getX(), "X position is 100");
        Assertions.assertEquals(100, driver.manage().window().getPosition().getY(), "Y position is 100");

    }
}
