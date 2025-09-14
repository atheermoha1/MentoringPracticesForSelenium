package tests.day07;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.awt.*;
import java.awt.event.KeyEvent;

public class T02_RobotActions extends TestBase {
    /*
Go to https://claruswaysda.github.io/downloadUpload.html
Click on 'Upload'
Close the opening page using 'CTRL+F4'
*/

    String url ="https://claruswaysda.github.io/downloadUpload.html";

@Test
    void Test1() throws AWTException, InterruptedException {
    driver.get(url);
    WebElement upload= driver.findElement(By.className("upload-btn"));
   //Click on 'Upload'
    upload.click();

    //Close the opening page using 'CTRL+F4'
    Robot robot= new Robot();
    robot.setAutoDelay(1000);
    robot.keyPress(KeyEvent.VK_CONTROL);
    robot.keyPress(KeyEvent.VK_F4);
    robot.keyRelease(KeyEvent.VK_F4);
    robot.keyRelease(KeyEvent.VK_CONTROL);
    robot.delay(1500);


}

}
