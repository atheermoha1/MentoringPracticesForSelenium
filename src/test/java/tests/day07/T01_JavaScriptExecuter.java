package tests.day07;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class T01_JavaScriptExecuter extends TestBase {
    /*
Go to https://claruswaysda.github.io/signIn.html
enter username 'admin'
enter password '123'
Click on Sign In
Assert the 'Employee Table' is visible
Create a method to change border color and style of web elements.
Use the method on each element you interact with.
*/
    String url ="https://claruswaysda.github.io/signIn.html";
    @Test
    void test1(){
        driver.get(url);
        WebElement user= driver.findElement(By.id("username"));
        changeBorder(user);
        user.sendKeys("admin");

        WebElement pass= driver.findElement(By.id("password"));
        changeBorder(pass);
        pass.sendKeys("123");

        driver.findElement(By.xpath("//*[@id='loginForm']/form/input[2]")).click();
        Assertions.assertTrue(driver.findElement(By.id("employeeTable")).isDisplayed());
;



    }

    private void changeBorder(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].style.border='3px solid blue';",element);;
    }
}
