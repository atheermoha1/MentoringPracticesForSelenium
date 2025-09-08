package tests.day04;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class T04FakerDataFromFilling {
        /*
    Task: Go to "https://demoqa.com/text-box"
        . Use Java Faker to:

        Generate and enter a fake full name
        Generate and enter a fake email address
        Generate and enter a fake current address
        Generate and enter a fake permanent address
        Submit the form and verify the output contains the entered data
    */
        WebDriver driver;
    String url = "https://demoqa.com/text-box";

    @Test
    void fakerTest() throws InterruptedException {
        driver.get(url);
        Faker fake = new Faker();
        //        Generate and enter a fake full name
        String fullName= fake.name().fullName();
        //System.out.println("fullName = " + fullName);
        driver.findElement(By.id("userName")).sendKeys(fullName);

        //        Generate and enter a fake email address
        String email= fake.internet().emailAddress();
       // System.out.println("email = " + email);
        driver.findElement(By.id("userEmail")).sendKeys(email);

        //        Generate and enter a fake current address
        String curraddress= fake.address().fullAddress();
       // System.out.println("address = " + curraddress);
        driver.findElement(By.id("currentAddress")).sendKeys(curraddress);

        //        Generate and enter a fake permanent address
        String permaddress= fake.address().fullAddress();
       // System.out.println("permaddress = " + permaddress);
        driver.findElement(By.id("permanentAddress")).sendKeys(permaddress);

        //        Submit the form and verify the output contains the entered data
       driver.findElement(By.id("submit")).submit();
       WebElement output= driver.findElement(By.id("output"));
       Thread.sleep(1000);

        //verify the output contains the entered data
       // Assertions.assertTrue(driver.findElement(By.xpath("//p[@class='mb-1']")).getText().equals(fullName));
    }

    @BeforeEach
    void setUp() {
        driver= new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }
}