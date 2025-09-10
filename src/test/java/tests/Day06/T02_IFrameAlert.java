package tests.Day06;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class T02_IFrameAlert extends TestBase {
/*
Go to https://claruswaysda.github.io/iframe.html
Type your name in input
Click on 'Bold' button
Assert the alert message
*/

String url ="https://claruswaysda.github.io/iframe.html";




    @Test
        void Test02() throws InterruptedException{
        driver.get(url);
       //Selenium cannot see elements inside iFrames directly,
       // so you must switch to them first.
        driver.switchTo().frame("mce_0_ifr");
        By name = By.xpath("//input[@type='text']");
        By boldButton = By.xpath("//button[@aria-label='Bold']");

        driver.findElement(name).sendKeys("John");
        //Switch to main/default content (top level)
        driver.switchTo().defaultContent();

        driver.findElement(boldButton).click();
        Thread.sleep(2000);
        Assertions.assertEquals(driver.switchTo().alert().getText(),"Bold button clicked");
        driver.switchTo().alert().accept();

    }


        }



