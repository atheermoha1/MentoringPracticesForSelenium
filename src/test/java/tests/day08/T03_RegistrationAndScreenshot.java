package tests.day08;

import com.github.javafaker.Faker;
import com.github.javafaker.File;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.nio.file.Path;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class T03_RegistrationAndScreenshot extends TestBase {
    /*
Go to https://claruswaysda.github.io/homepage.html
Register a user
Sign in with the registered user
Take all pages' screenshots
Take 'Celebrate Login' button's screenshot.
Capture a screenshot of the page with confetti.
*/
    String url = "https://claruswaysda.github.io/homepage.html";

    @Test
    void test() throws InterruptedException {
        driver.get(url);

        WebElement onMouseOver= driver.findElement(By.className("user-icon"));
        Actions actions= new Actions(driver);
        actions.moveToElement(onMouseOver).perform();

        WebElement register= driver.findElement(By.xpath("//*[@id='menu']/a[1]"));
        register.click();

        Faker faker= new Faker();
        String ssn=faker.idNumber().ssnValid();
        String firstName= faker.name().firstName();
        String lastName= faker.name().lastName();
        String address= faker.address().fullAddress();
        String phone= faker.phoneNumber().cellPhone();
        String username= faker.name().username();
        String email= faker.internet().emailAddress();
        String password= faker.internet().password();

        WebElement SSN= driver.findElement(By.id("ssn"));
        WebElement FirstName= driver.findElement(By.id("first-name"));
        WebElement LastName= driver.findElement(By.id("last-name"));
        WebElement Address= driver.findElement(By.id("address"));
        WebElement Phone= driver.findElement(By.id("phone"));
        WebElement Username= driver.findElement(By.id("username"));
        WebElement Email= driver.findElement(By.id("email"));
        WebElement Password= driver.findElement(By.id("password"));
        WebElement PasswordConfirmation= driver.findElement(By.id("confirm-password"));
        WebElement registerButton= driver.findElement(By.className("button"));

        SSN.sendKeys(ssn);
        FirstName.sendKeys(firstName);
        LastName.sendKeys(lastName);
        Address.sendKeys(address);
        Phone.sendKeys(phone);
        Username.sendKeys(username);
        Email.sendKeys(email);
        Password.sendKeys(password);
        PasswordConfirmation.sendKeys(password);
        registerButton.click();

        //Take screenshot
        // Create folder if not exists
        WebElement mussg = driver.findElement(By.xpath("//div[@id='successMessage']"));
        Assertions.assertTrue(mussg.isEnabled());
        WebElement loginusername = driver.findElement(By.xpath("//button[@class='login-button']"));
        loginusername.click();



    }
}