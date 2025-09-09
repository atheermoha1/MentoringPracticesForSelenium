package assignments.day05;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class T06_OldStyle {
//    Launch browser
//    Open https://demoqa.com/select-menu
//    Select Old Style Select Menu using element id
//    Print all dropdown options
//    Select 'Purple' using index
//    Select 'Magenta' using visible text
//    Select an option using value
//    Close browser
WebDriver driver;
    String url = "https://demoqa.com/select-menu";

    @Test
    void test01() {
        driver.get(url);
        Select select = new Select(driver.findElement(By.id("oldSelectMenu")));
        List<WebElement> options = select.getOptions();
        System.out.println("Options = " );
        for (WebElement option : options) {
            System.out.println(option.getText());

        }
        select.selectByIndex(4);
        select.selectByVisibleText("Magenta");
        select.selectByValue("6");
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
