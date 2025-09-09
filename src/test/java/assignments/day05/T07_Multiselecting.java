package assignments.day05;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class T07_Multiselecting {
    WebDriver driver;
    String url = "https://demoqa.com/select-menu";
//    Launch browser
//    Open https://demoqa.com/select-menu
//    Select Standard Multi-Select using element id
//    Verify element is multi-select
//    Select 'Opel' using index, then deselect using index
//    Select 'Saab' using value, then deselect using value
//    Deselect all options
//    Close browser

    @Test
    void test01() {
        driver.get(url);
        Select select = new Select(driver.findElement(By.id("cars")));
        Assertions.assertTrue(select.isMultiple());
        select.selectByIndex(2);
        select.deselectByIndex(2);
        select.selectByValue("saab");
        select.deselectByValue("saab");
        select.deselectAll();
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
