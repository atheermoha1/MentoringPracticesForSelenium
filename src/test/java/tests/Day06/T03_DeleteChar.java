package tests.Day06;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class T03_DeleteChar extends TestBase {

    /*
    Go to https://claruswaysda.github.io/deleteChars.html
    Enter your full name
    Delete the letters
    Verify the message 'Deleted'
    */
    String url = "https://claruswaysda.github.io/deleteChars.html";

    @Test
    void Test03() throws InterruptedException {
        driver.get(url);
        Faker faker = new Faker();
        String fullName = faker.name().fullName();
       driver.findElement(By.id("inputText")).sendKeys(fullName);
       driver.findElement(By.id("enterButton")).click();
       for (int i=0; i < fullName.length(); i++) {
        driver.findElement(By.id("deleteButton")).click();
       }
        Assertions.assertEquals(driver.findElement(By.id("deletedMessage")).getText(),"Deleted");
    }
}