package tests.day01;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C04PositionCommands {
    public static void main(String[] args) throws InterruptedException {
        // TC - 04

// Go to the w3school URL : https://www.w3schools.com/
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://www.w3schools.com/");

// Print the position and size of the page.
    // check the position of the left upper if -, if+ check the position of up right
      Point position=  driver.manage().window().getPosition();
        System.out.println("position.getX() = " + position.getX());
        System.out.println("position.getY() = " + position.getY());
        System.out.println("position = " + position);
        Thread.sleep(2500);
      //check
        Dimension dimension = driver.manage().window().getSize();
        System.out.println("dimension.getWidth() = " + dimension.getWidth());
        System.out.println("dimension.getHeight() = " + dimension.getHeight());
        System.out.println("dimension = " + dimension);
        Thread.sleep(2500);

// Adjust the position and size of the page as desired.
        driver.manage().window().setPosition(new org.openqa.selenium.Point(position.getX()-10, position.getX()-5));
        int x= position.getX()-6;
        System.out.println("x = " + x);
        int y= position.getX()-9;
        System.out.println("y = " + y);
        driver.manage().window().setSize(new org.openqa.selenium.Dimension(600,600));
        Thread.sleep(2500);


// Test that the page is in the position and size you want.

// Close the page.
        driver.quit();
    }
}
