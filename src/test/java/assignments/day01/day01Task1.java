package assignments.day01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class day01Task1
{
    public static void main(String[] args) {
        //Chrome Driver
        WebDriver driver =new ChromeDriver();

        //open google website
        driver.navigate().to("https://www.google.com");

        //get title on page
        System.out.println("driver.getTitle() = " + driver.getTitle());

        //get current url
        System.out.println("driver.getCurrentUrl() = " + driver.getCurrentUrl());

        //close browser
        driver.quit();


    }
}
