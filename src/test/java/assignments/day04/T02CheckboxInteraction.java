package assignments.day04;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class T02CheckboxInteraction {
    WebDriver driver;
     String url = "https://the-internet.herokuapp.com/checkboxes";
    /*
    Task: Go to "https://the-internet.herokuapp.com/checkboxes"
.   Write a method that:
    Checks the current state of both checkboxes
    Ensures both checkboxes are selected (click only if not already selected)
    Verify both checkboxes are checked after the operations
    Print the status of each checkbox to console */

        @Test
    void checkboxTest() throws InterruptedException {
            By checkbox1 = By.xpath("(//input[@type='checkbox'])[1]");
            By checkbox2 = By.xpath("(//input[@type='checkbox'])[2]");
            WebElement check1 = driver.findElement(checkbox1);
            WebElement check2 = driver.findElement(checkbox2);
            //Checks the current state of both checkboxes
            Boolean checkbox1Selected = check1.isSelected();
            Boolean checkbox2Selected = check2.isSelected();
            System.out.println("checkbox1Selected = " + checkbox1Selected);
            System.out.println("checkbox2Selected = " + checkbox2Selected);
            //Ensures both checkboxes are selected (click only if not already selected)
            if (!checkbox1Selected) {
                check1.click();
            }
            if (!checkbox2Selected) {
                check2.click();
            }

            Thread.sleep(1000);
            //Verify both checkboxes are checked after the operations
            Assertions.assertTrue(check1.isSelected(), "Checkbox 1 is not selected");
            Assertions.assertTrue(check2.isSelected(), "Checkbox 2 is not selected");

            //Print the status of each checkbox to console
            System.out.println("Checkbox 1 selected = " + check1.isSelected());
            System.out.println("Checkbox 2 selected = " + check2.isSelected());

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