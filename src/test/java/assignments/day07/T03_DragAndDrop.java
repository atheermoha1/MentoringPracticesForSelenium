package assignments.day07;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class T03_DragAndDrop extends TestBase {
    /*
Go to https://claruswaysda.github.io/dragAndDrop.html
Drag the items in their right places
Assert the success message
*/

    String url =" https://claruswaysda.github.io/dragAndDrop.html";

    @Test
    void Test1() throws InterruptedException {
        driver.get(url);

        By piece1= By.id("piece1");
        By piece2=By.id("piece2");
        By piece3=By.id("piece3");
        By slot1=By.id("slot1");
        By slot2=By.id("slot2");
        By slot3=By.id("slot3");


        WebElement elemnt1= driver.findElement(piece1);
        WebElement elemnt2= driver.findElement(piece2);
        WebElement elemnt3= driver.findElement(piece3);
        WebElement elemnt4= driver.findElement(slot1);
        WebElement elemnt5= driver.findElement(slot2);
        WebElement elemnt6= driver.findElement(slot3);

        Actions actions = new Actions(driver);
        actions.dragAndDrop(elemnt1,elemnt4).perform();
        actions.dragAndDrop(elemnt2,elemnt5).perform();
        actions.dragAndDrop(elemnt3,elemnt6).perform();

        Assertions.assertTrue(driver.findElement(By.id("celebrate")).isDisplayed());


    }
}
