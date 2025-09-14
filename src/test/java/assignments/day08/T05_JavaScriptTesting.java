package assignments.day08;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.List;

public class T05_JavaScriptTesting extends TestBase {
/*
Go to https://testpages.herokuapp.com/styled/events/javascript-events.html
Click all the buttons and verify they are all clicked
*/
    String url="https://testpages.herokuapp.com/styled/events/javascript-events.html";
@Test
    void test() throws AWTException, InterruptedException {
    driver.get(url);
Thread.sleep(3000);
    //onBlur-
    WebElement blur = driver.findElement(By.id("onblur"));
    blur.click();
    driver.findElement(By.className("page-body")).click();

    //onClick
    WebElement onClick= driver.findElement(By.id("onclick"));
    onClick.click();

    //onContext
    WebElement onContext= driver.findElement(By.id("oncontextmenu"));
    Actions actions =new Actions(driver);
    actions.contextClick(onContext).perform();

    //ondoubleclick
    WebElement onDoubleclick= driver.findElement(By.id("ondoubleclick"));
    actions.doubleClick(onDoubleclick).perform();

    //onfocus
    WebElement onFocus = driver.findElement(By.id("onfocus"));
    onFocus.click();

    //onkeydown
    WebElement onKeyDown= driver.findElement(By.id("onkeydown"));
    onKeyDown.click();
    actions.sendKeys(Keys.ARROW_DOWN).perform();


    //onkeyup
    WebElement onKeyUp= driver.findElement(By.id("onkeyup"));
    onKeyUp.click();
    actions.sendKeys(Keys.ARROW_UP).perform();

    //onkeypress
    WebElement onKeypress = driver.findElement(By.id("onkeypress"));
    onKeypress.click();
   actions.sendKeys("1").perform();
    //onmouseover
    WebElement onMouseOver= driver.findElement(By.id("onmouseover"));
    actions.moveToElement(onMouseOver).perform();

    //onmouseleave
    WebElement onMouseLeave= driver.findElement(By.id("onmouseleave"));
    onMouseLeave.click();
    actions.moveByOffset(-55,0);

    //onmousedown
    WebElement onMouseDown= driver.findElement(By.id("onmousedown"));
    actions.clickAndHold(onMouseDown).release().perform();
}

}
