package tests.day10;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.TestBas2;

import java.util.List;

public class T02_CalTable extends TestBas2 {
    /*
Go to https://claruswaysda.github.io/webTable.html
Calculate and assert the total price in Table 2.
*/

    @Test
    void test1(){
        driver.get("https://claruswaysda.github.io/webTable.html");

        List<WebElement> prices= driver.findElements(By.xpath("//table[2]//td[3]"));
         int total=0;
        for(WebElement priceData: prices){
            int price = Integer.parseInt(priceData.getText().trim().replace("$",""));
            total += price;
        }

        System.out.println("total = " + total);
        Assertions.assertEquals(2275,total);
    }

}
