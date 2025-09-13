package assignments.day06;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

public class T10_jQueryEmojiPicker extends TestBase {
    /*
Go to https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/
1. Maximize the website
2. Click on the second emoji
3. Click on all second emoji items
4. Return to the parent iframe
5. Fill out the form and press the apply button
*/
String url="https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/";
    @Test
    void test1() throws InterruptedException {
        driver.get(url);

        driver.manage().window().maximize();
        WebElement frame= driver.findElement(By.id("emoojis"));
        driver.switchTo().frame(frame);


        //2. Click on the second emoji
        List<WebElement> SecEmoji = driver.findElements(By.xpath("//div[@class='mdl-tabs__tab-bar']/a"));
        SecEmoji.get(1).click();


       //3. Click on all second emoji items
        List<WebElement> Emojis = driver.findElements(By.xpath("//div[@id='nature']//img[contains(@class,'emoji')]"));
        for (WebElement emoji : Emojis) {
          emoji.click();
        }
        Thread.sleep(1000);

       //4. Return to the parent iframe
       driver.switchTo().defaultContent();

       //5. Fill out the form and press the apply button
        driver.findElement(By.id("text")).sendKeys("Text");
        driver.findElement(By.id("smiles")).sendKeys("Smiles");
        driver.findElement(By.id("nature")).sendKeys("Nature");
        driver.findElement(By.id("food")).sendKeys("Food");
        driver.findElement(By.id("activities")).sendKeys("Activities");
        driver.findElement(By.id("places")).sendKeys("Places");
        driver.findElement(By.id("objects")).sendKeys("Objects");
        driver.findElement(By.id("symbols")).sendKeys("Symbols");
        driver.findElement(By.id("flags")).sendKeys("Flags");
        driver.findElement(By.id("hide")).sendKeys("Hide");
        driver.findElement(By.id("active")).sendKeys("smile");
        driver.findElement(By.id("send")).click();

    }
}