package assignments.day08;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.awt.*;
import java.awt.event.KeyEvent;

public class T04_RobotWithNavigationandForm extends TestBase {
    /*
     * Open a demo login page (e.g. https://the-internet.herokuapp.com/login).
     * Click into the username field.
     * Type the username using sendKeys.
     * Use the Robot class to:
     * Press Tab → go to password field.
     * Type the password using sendKeys.
     * Press Enter → submit the form.
     * Verify login success or error message.
     */
    String url ="https://the-internet.herokuapp.com/login";

    @Test
    void test() throws AWTException {
        driver.get(url);
        WebElement username= driver.findElement(By.id("username"));
        username.sendKeys("tomsmith");


        Robot robot= new Robot();
        robot.keyPress(KeyEvent.VK_TAB);
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
        robot.keyRelease(KeyEvent.VK_TAB);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);

        WebElement msg= driver.findElement(By.className("flash"));
        Assertions.assertTrue(msg.isDisplayed());




    }

}
