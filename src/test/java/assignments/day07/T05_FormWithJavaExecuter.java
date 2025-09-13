package assignments.day07;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class T05_FormWithJavaExecuter extends TestBase {
/*
Go to https://claruswaysda.github.io/form.html
Create a method to flash the elements you are working on and use it.
Register a user
Login
Celebrate the login!
*/

    String url= "https://claruswaysda.github.io/form.html";

@Test
    void test1() throws InterruptedException {
    driver.get(url);
    Faker faker= new Faker();
    String firstName= faker.name().firstName();
    String lastName= faker.name().lastName();
    String address= faker.address().fullAddress();
    String phone= faker.phoneNumber().cellPhone();
    String username= faker.name().username();
    String email= faker.internet().emailAddress();
    String password= faker.internet().password();

    WebElement FirstName= driver.findElement(By.id("first-name"));
    WebElement LastName= driver.findElement(By.id("last-name"));
    WebElement Address= driver.findElement(By.id("address"));
    WebElement Phone= driver.findElement(By.id("phone"));
    WebElement Username= driver.findElement(By.id("username"));
    WebElement Email= driver.findElement(By.id("email"));
    WebElement Password= driver.findElement(By.id("password"));
    WebElement PasswordConfirmation= driver.findElement(By.id("confirm-password"));
    WebElement register= driver.findElement(By.className("button"));

    flash(FirstName);
    FirstName.sendKeys(firstName);

    flash(LastName);
    LastName.sendKeys(lastName);

    flash(Address);
    Address.sendKeys(address);

    flash(Phone);
    Phone.sendKeys(phone);

    flash(Username);
    Username.sendKeys(username);

    flash(Email);
    Email.sendKeys(email);

    flash(Password);
    Password.sendKeys(password);

    flash(PasswordConfirmation);
    PasswordConfirmation.sendKeys(password);

    register.click();


}

    private void flash(WebElement js) {
        JavascriptExecutor js1 = (JavascriptExecutor) driver;
        for (int i = 0; i < 10; i++) {
            js1.executeScript("arguments[0].setAttribute('style', arguments[1]);", js, "background: grey; border: 2px solid black;");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            js1.executeScript("arguments[0].setAttribute('style', arguments[1]);", js, "");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
            }
        }
    }}