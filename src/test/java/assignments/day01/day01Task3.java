package assignments.day01;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class day01Task3 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();

        //navigate to amazon url
         driver.navigate().to("https://www.amazon.com/");

         // print the position and the size
        Point position = driver.manage().window().getPosition();
        System.out.println("position.getY() = " + position.getY());
        System.out.println("position.getX() = " + position.getX());
        System.out.println("position = " + position);
        Thread.sleep(2500);

        Dimension dimension = driver.manage().window().getSize();
        System.out.println("dimension.getHeight() = " + dimension.getHeight());
        System.out.println("dimension.getWidth() = " + dimension.getWidth());
        System.out.println("driver = " + driver);
        Thread.sleep(2500);

        // adjust the position and size as desired
        driver.manage().window().setPosition(new org.openqa.selenium.Point(position.getX()-20,position.getY()-10));
        Thread.sleep(2500);
        driver.manage().window().setSize(new org.openqa.selenium.Dimension(800,850));

        //close the browser
        driver.quit();
    }
}
