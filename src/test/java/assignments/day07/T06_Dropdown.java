package assignments.day07;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

import java.util.List;

public class T06_Dropdown extends TestBase {
    /*
    Go to https://claruswaysda.github.io/Dropdowns.html
    In 1. Traditional Dropdown select 'Ford'
    In 2. Multi-Select Dropdown select 'Mercedes'
    In 3. Custom Dropdown (Bootstrap-like) select 'BMW'
    In 4. Static Auto-Suggest Dropdown select 'Tesla Model 3'
    In 5. Dynamic Auto-Suggest Dropdown select 'Toyota'
    */
    @Test
    void Test1() throws InterruptedException {
        String url = "https://claruswaysda.github.io/Dropdowns.html";
        driver.get(url);

        By traditionalDropdown = By.id("carSelect");
        By multiSelectDropdown = By.id("multiCarSelect");
        By customDropdown = By.id("customDropdown");
        By staticAutoSuggestDropdown = By.id("staticInput");
        By dynamicAutoSuggestDropdown = By.id("dynamicInput");


        //In 1. Traditional Dropdown select 'Ford'
        Select select1 = new Select(driver.findElement(traditionalDropdown));
        select1.selectByVisibleText("Ford");

        //In 2. Multi-Select Dropdown select 'Mercedes'
        Select select2 = new Select(driver.findElement(multiSelectDropdown));
        select2.selectByVisibleText("Mercedes");

        //In 3. Custom Dropdown (Bootstrap-like) select 'BMW'
        driver.findElement(customDropdown).click();
        Thread.sleep(2000);
        List<WebElement> list = driver.findElements(By.className("custom-dropdown"));
        for (WebElement w : list) {
            if (w.getText().equals("BMW")) {
                w.click();
                break;
            }}

            //In 4. Static Auto-Suggest Dropdown select 'Tesla Model 3'
          WebElement staticAuto = driver.findElement(staticAutoSuggestDropdown);
           staticAuto.sendKeys("Tesla Model");
        Thread.sleep(2000);
        List<WebElement> list1 =driver.findElements(By.className("suggestion-item"));
            for (WebElement w1 : list1) {
                if (w1.getText().equals("Tesla Model 3")) {
                    w1.click();
                    break;
                }
            }
            //In 5. Dynamic Auto-Suggest Dropdown select 'Toyota'
        WebElement DaynamicAuto = driver.findElement(dynamicAutoSuggestDropdown);
        DaynamicAuto.sendKeys("Toy");
        Thread.sleep(1000);
        List<WebElement> list2 =driver.findElements(By.xpath("//*[@id='dynamicSuggestions']/div"));
        for (WebElement w2 : list2) {
            if (w2.getText().equals("Toyota")) {
                w2.click();
                break;
            }}
        }
    }

