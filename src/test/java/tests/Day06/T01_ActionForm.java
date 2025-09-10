package tests.Day06;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

import java.time.Duration;
import java.util.List;

public class T01_ActionForm extends TestBase {
//    Go to https://claruswaysda.github.io/ActionsForm.html
//    Fill the form
//    Generate Passcode
//    Use passcode to submit form

String url ="https://claruswaysda.github.io/ActionsForm.html";

@Test
void test01() throws InterruptedException {
    driver.get(url);
    By name = By.id("name");
    By age = By.id("age");
    Select select = new Select(driver.findElement(By.xpath("//select[@id='options']")));
    By checkbox1value = By.xpath("//label[normalize-space()='Coding']");
    By checkbox2value = By.xpath("//label[normalize-space()='design']");
    By checkbox3value = By.xpath("//label[.=' Management']");
    By radioMale = By.xpath("//input[@value='male']");
    By radioFemale = By.xpath("//input[@value='female']");
    By radioOther = By.xpath("//input[@value='other']");
    By submitButton = By.xpath("//button[@type='button']");

    //locate elements and do actions
    driver.findElement(name).sendKeys("John");
    driver.findElement(age).sendKeys("27");
    select.getOptions().get(1).click();
    driver.findElement(checkbox1value).click();
    driver.findElement(checkbox3value).click();
    driver.findElement(radioFemale).click();
    driver.findElement(submitButton).click();

    Alert alert = driver.switchTo().alert();
    String alertText = alert.getText();
    String passcode = alertText.substring(alertText.indexOf(":") +1).trim();
    System.out.println("Passcode is: " + passcode);
    alert.accept();
    alert.sendKeys(passcode);
    alert.accept();
}





}

