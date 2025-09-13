package assignments.day07;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class T02_Action extends TestBase {
    /*
Go to https://claruswaysda.github.io/submit-button.html
Click on submit
Verify link contains 'actionsClickDrag'
Drag 'Drag me' to 'Drop here'
Right-click on 'Right-click' me
Double-click on 'Double-click me'
Hover on 'Hover over me'
Verify all actions' success messages.
*/
String url = "https://claruswaysda.github.io/submit-button.html";
    @Test
    void test02() throws InterruptedException {

        driver.get(url);
        By submitButton = By.id("submitButton");
        driver.findElement(submitButton).click();
        //switch to new tab
        String handle1= driver.getWindowHandle();
        for (String h1: driver.getWindowHandles()){
            if(!h1.equals(handle1)){
                driver.switchTo().window(h1);
                String currentUrl = driver.getCurrentUrl();
                Assertions.assertTrue(currentUrl.contains("actionsClickDrag"));
                break;
            }
        }
        // Drag and Drop
        WebElement dragMe = driver.findElement(By.id("drag1"));
        WebElement dropHere = driver.findElement(By.id("drop1"));
        Actions actions = new Actions(driver);
        actions.dragAndDrop(dragMe, dropHere).perform();
        Assertions.assertTrue(driver.findElement(By.id("dragSuccessMessage")).isDisplayed());

        // Right Click
        WebElement rightClickMe = driver.findElement(By.id("showSuccessButton"));
        actions.contextClick(rightClickMe).perform();
        Assertions.assertTrue(driver.findElement(By.id("rightClickSuccessMessage")).isDisplayed());


        // Double Click
        WebElement doubleClickMe = driver.findElement(By.id("doubleClickButton"));
        actions.doubleClick(doubleClickMe).perform();
        Assertions.assertTrue(driver.findElement(By.id("doubleClickSuccessMessage")).isDisplayed());

        // Hover Over
        WebElement hoverOverMe = driver.findElement(By.id("hoverButton"));
        actions.moveToElement(hoverOverMe).perform();
        Assertions.assertTrue(driver.findElement(By.id("hoverSuccessMessage")).isDisplayed());


//        // Verify success messages
//        List<WebElement> successMessages = driver.findElements(By.className("message"));
//        for (WebElement message : successMessages) {
//            System.out.println("messages = " + message.getText());
//            Assertions.assertTrue(message.isDisplayed());
//
//        }
    }
}
