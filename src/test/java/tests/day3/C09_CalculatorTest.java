package tests.day3;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C09_CalculatorTest {
    /*
     Navigate to  https://testpages.herokuapp.com/styled/index.html
     Click on  Calculator under Micro Apps
     Type any number in the first input
     Type any number in the second input
     Click on Calculate
     Get the result
     Verify the result
     Print the result
     Close the browser by using @After annotation
*/
@BeforeEach
      void setUp() {
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(url);
    }
    String url= "https://testpages.herokuapp.com/styled/index.html";
    WebDriver driver;
By calculatorLinkId = By.id("calculatetest");
int num1=95;
int num2= 12;

By number1= By.name("number1");
By number2= By.name("number2");
By calButton= By.id("calculate");
By result= By.id("answer");

@Test
void additionTest() throws InterruptedException {
    driver.findElement(calculatorLinkId).click();
    driver.findElement(number1).sendKeys(String.valueOf(num1));
driver.findElement(number2).sendKeys(String.valueOf(num2));
driver.findElement(calButton).click();
String actualResult= driver.findElement(result).getText();
Thread.sleep(2500);
int expectedResult= num1+num2;
    System.out.println("expectedResult = " + expectedResult);
    Assertions.assertEquals(String.valueOf(expectedResult),actualResult);
}

@AfterEach
    void TearDown(){
    driver.quit();
}
}
