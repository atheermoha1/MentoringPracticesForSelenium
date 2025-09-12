package assignments.day06;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class T04_Draw extends TestBase {
    /*
Go to https://claruswaysda.github.io/Draw.html
Draw a triangle
Reset
*/
String url ="https://claruswaysda.github.io/Draw.html";
@Test
    void Test1(){
    driver.get(url);
    By draw= By.id("myCanvas");
    By reset= By.id("resetButton");
    WebElement element= driver.findElement(draw);
    Actions actions = new Actions(driver);

    actions.moveToElement(element,20,40).clickAndHold();
    actions.moveByOffset(40,0);
    actions.moveByOffset(-20,-40);
    actions.moveByOffset(-20,40);
    actions.release().build().perform();
    driver.findElement(reset).click();

}
}

