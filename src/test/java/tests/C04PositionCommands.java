package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C04PositionCommands {
    public static void main(String[] args) {
        // TC - 04

// Go to the w3school URL : https://www.w3schools.com/
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://www.w3schools.com/");

// Print the position and size of the page.
        driver.manage().window().getPosition();
        driver.manage().window().getSize();
// Adjust the position and size of the page as desired.
//        driver.manage().window().setPosition(new Point(150,200));
//        driver.manage().window().setSize(new Dimension(500,700));


// Test that the page is in the position and size you want.

// Close the page.
        driver.quit();
    }
}
