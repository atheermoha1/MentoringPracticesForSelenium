package assignments.day03;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class day03Task2 {
        // TODO: Locate username using absolute XPath
        // TODO: Locate username using relative XPath
        // TODO: Locate password using both methods
        // TODO: Locate login button using both methods
        // TODO: Test both approaches work
    static WebDriver driver;
    static WebDriverWait wait;

    // Test login using relative XPaths
    @Test
    void relativeXpathTest() {
         String relativeUsernameXPath = "//input[@name='username']";
         String relativePasswordXPath = "//input[@name='password']";
         String relativeLoginButtonXPath = "//button[@type='submit']";

        WebElement username = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(relativeUsernameXPath)));
        WebElement password = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(relativePasswordXPath)));
        WebElement loginBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(relativeLoginButtonXPath)));

        username.sendKeys("Admin");
        password.sendKeys("admin123");
        loginBtn.click();
    }

    // Test login using absolute XPaths
    @Test
    void absoluteXpathTest(){
        // Absolute XPaths
         String absoluteUsernameXPath = "//*[@id='app']/div[1]/div/div[1]/div/div[2]/div[2]/form/div[1]/div/div[2]/input";
         String absolutePasswordXPath = "//*[@id='app']/div[1]/div/div[1]/div/div[2]/div[2]/form/div[2]/div/div[2]/input";
         String absoluteLoginButtonXPath = "//*[@id='app']/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button";

        WebElement username = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(absoluteUsernameXPath)));
        WebElement password = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(absolutePasswordXPath)));
        WebElement loginBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(absoluteLoginButtonXPath)));

        username.sendKeys("Admin");
        password.sendKeys("admin123");
        loginBtn.click();

    }
    @BeforeEach
     void setUp() {
// TODO: Initialize WebDriver
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://opensource-demo.orangehrmlive.com/");


    }
    @AfterEach
     void tearDown() {
        driver.quit();
    }

}
