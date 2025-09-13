package assignments.day06;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

public class T11_MultipleIFrames extends TestBase {
    /*
Go to URL: http://demo.guru99.com/test/guru99home/
1. Find the number of iframes on the page
2. Switch to the 2nd iframe
3. Click the link (https://www.guru99.com/live-selenium-project.html)
4. Exit the iframe and return to the main page
*/

    String url="http://demo.guru99.com/test/guru99home/" ;

    @Test
    void test1() throws InterruptedException {
        driver.get(url);
     //1. Find the number of iframes on the page
        List<WebElement> numberOfIframes = driver.findElements(By.tagName("iframe"));
        int numOfIFrame= numberOfIframes.size();
        System.out.println("numOfIFrame = " + numOfIFrame);


        //2. Switch to the 2nd iframe (JMeter Made Easy)
        driver.switchTo().frame(1);


        //3. Click the link (https://www.guru99.com/live-selenium-project.html)

        WebElement jmeterLink= driver.findElement(By.xpath("//a[@href='http://www.guru99.com/live-selenium-project.html']"));
        jmeterLink.click();

        //4. Exit the iframe and return to the main page
        driver.switchTo().defaultContent();
    }
}
