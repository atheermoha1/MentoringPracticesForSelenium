package tests.day03;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C07Locators {
      static  WebDriver driver;
        static String url="https://www.linkedin.com/login";
        static String testerEmail= "tester@test.com";
        static String testerPass= "Pass.123";
// TODO: Initialize WebDriver
// TODO: Navigate to LinkedIn
        @BeforeAll
         static public void setUp() {
         driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(url);
        }

// TODO: Locate email field using By.id
// TODO: Locate password field using By.name
// TODO: Locate sign-in button using By.xpath
// TODO: Enter test credentials
// TODO: Verify elements are displayed
        @Test
        public void testLoginElements() {
            By emailFieldById= By.id("username");
            By passFieldById= By.name("session_password");
            By signInButton= By.xpath("//button[@type='submit']");
WebElement idElement =driver.findElement(emailFieldById);
WebElement passElement =driver.findElement(passFieldById);
WebElement signInElement= driver.findElement(signInButton);
idElement.sendKeys(testerEmail);
passElement.sendKeys(testerPass);

            //TODO: Verify elements are displayed
            Assertions.assertTrue(idElement.isDisplayed());
            Assertions.assertTrue(passElement.isDisplayed());
            Assertions.assertTrue(signInElement.isDisplayed());

            signInElement.click();
        }
        @AfterAll
        static public void tearDown() {
        driver.quit();
        }
    }


