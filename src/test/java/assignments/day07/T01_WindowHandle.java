package assignments.day07;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class T01_WindowHandle extends TestBase {
    /*
Go to https://claruswaysda.github.io/
Click on Window Handle
Click on 'Open Index Page'
Verify the link 'https://claruswaysda.github.io/index.html'
*/
    String url=" https://claruswaysda.github.io/";
    @Test
    void Test1() throws InterruptedException {
        driver.get(url);
        By windowHandle=By.xpath("//a[text()='Window Handle']");
        By index1=By.id("openIndex");

        //Click on Window Handle

        driver.findElement(windowHandle).click();
        String handle= driver.getWindowHandle();
        for (String h: driver.getWindowHandles()){
            if(!h.equals(handle)){
                driver.switchTo().window(h);
                break;
            }
        }
      //Click on 'Open Index Page'
        driver.findElement(index1).click();
        String currentUrl="";
        for (String h: driver.getWindowHandles()){
            if(!h.equals(handle) && !h.equals(driver.getWindowHandle())){
                driver.switchTo().window(h);
                break;
            }
        }
        //Verify the link 'https://claruswaysda.github.io/index.html'
        currentUrl= driver.getCurrentUrl();
        Assertions.assertEquals("https://claruswaysda.github.io/index.html",currentUrl);
    }
}
