package tests.Day05;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class T02_Calculator {
    WebDriver driver;
    String url="https://testpages.eviltester.com/styled/calculator";
    By numId= By.id("number1");
    By num2Id= By.id("number2");
    By functionId= By.id("function");
    By calcId= By.id("calculate");
    By resultId= By.id("answer");
    String num1 = "20";
    String num2 = "5";
    String operations[]={"plus","minus","times","divide"};
    int addResult = Integer.parseInt(num1) + Integer.parseInt(num2);
    int subResult = Integer.parseInt(num1) - Integer.parseInt(num2);
    int mulResult = Integer.parseInt(num1) * Integer.parseInt(num2);
    int divResult = Integer.parseInt(num1) / Integer.parseInt(num2);

    String expectedAddResult = String.valueOf((int)addResult);
    String expectedSubResult = String.valueOf((int)subResult);
    String expectedMulResult = String.valueOf((int)mulResult);
    String expectedDivResult = String.valueOf(divResult);



    @Test
    void test01() {
        //   Type any number in first and second input
        //   Click Calculate for each operation
        //   Get and verify results for all operations
        driver.get(url);
//        driver.findElement(numId).sendKeys("34");
//        driver.findElement(num2Id).sendKeys("22");
//        Select select = new Select(driver.findElement(functionId));
//        String result;

        for (int i = 0; i < operations.length; i++) {

            driver.findElement(numId).clear();
            driver.findElement(numId).sendKeys(num1);
            driver.findElement(num2Id).clear();
            driver.findElement(num2Id).sendKeys(num2);

            WebElement op = driver.findElement(By.id("function"));
            Select select = new Select(op);
            select.selectByValue(operations[i]);
            driver.findElement(By.id("calculate")).click();

            //   Get and verify results for all operations
            switch (operations[i]) {
                case "plus" -> {
                    String additionResult = driver.findElement(By.id("answer")).getText();
                    Assertions.assertEquals(expectedAddResult, additionResult);
                    System.out.println("Addition Result: " + additionResult); // 20 + 5
                }
                case "minus" -> {
                    String subtractionResult = driver.findElement(By.id("answer")).getText();
                    Assertions.assertEquals(expectedSubResult, subtractionResult);
                    System.out.println("Subtraction Result: " + subtractionResult); // 20 - 5
                }
                case "times" -> {
                    String multiplicationResult = driver.findElement(By.id("answer")).getText();
                    Assertions.assertEquals(expectedMulResult, multiplicationResult);
                    System.out.println("Multiplication Result: " + multiplicationResult); // 20 * 5
                }
                case "divide" -> {
                    String divisionResult = driver.findElement(By.id("answer")).getText();
                    Assertions.assertEquals(expectedDivResult, divisionResult);
                    System.out.println("Division Result: " + divisionResult); // 20 / 5
                }
            }
            //for stale element exception
            driver.navigate().refresh();
        }

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

