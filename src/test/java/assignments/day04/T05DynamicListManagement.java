package assignments.day04;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class T05DynamicListManagement {
    WebDriver driver;
    String url = "http://webdriveruniversity.com/To-Do-List/index.html";
    /*
    Task:  Go to "http://webdriveruniversity.com/To-Do-List/index.html" and create a test that:
            Uses Faker to generate 5 random task names
            Adds all tasks to the todo list
            Marks every other task as completed (strikethrough)
            Deletes all completed tasks
            Verifies only incomplete tasks remain
    */
    // Implement the test method here
    @Test
    void FakerTest() throws InterruptedException {
        // Your implementation goes here
        Faker faker = new Faker();
        WebElement inputBox = driver.findElement(By.xpath("//input[@type='text']"));
        for (int i = 0; i < 5; i++) {
            String task = faker.job().title();
            inputBox.sendKeys(task,Keys.ENTER);
        }
        // mark every other task as completed
        List<WebElement> tasks = driver.findElements(By.tagName("li"));
        for (int i = 0; i < tasks.size(); i += 2) {
            WebElement completedTask = tasks.get(i);
            completedTask.click();
            Thread.sleep(2000);
        }

        // delete completed tasks
        for (WebElement li : driver.findElements(By.tagName("li"))) {
            if (li.getAttribute("class").contains("completed")) {
                WebElement deleteBtn = li.findElement(By.tagName("i"));
                deleteBtn.click();
            }
        }
        // verify only incomplete tasks remain
        List<WebElement> remainingTasks = driver.findElements(By.tagName("li"));
        for (WebElement taskItem : remainingTasks) {
            WebElement span = taskItem.findElement(By.tagName("span"));
            Assertions.assertFalse(span.getAttribute("class").contains("completed"));
        }
        Thread.sleep(2000);

    }
    @BeforeEach
    void setUp() {
        driver= new ChromeDriver();
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }

}