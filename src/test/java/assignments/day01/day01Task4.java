package assignments.day01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class day01Task4 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver= new ChromeDriver();
        driver.get("https://www.google.com/");
        //maximize the window
        driver.manage().window().maximize();

        //print the position and the size
        System.out.println("driver.manage().window().getSize() = " + driver.manage().window().getSize());
        System.out.println("driver.manage().window().getPosition() = " + driver.manage().window().getPosition());

        // minimize the page
        driver.manage().window().minimize();
        //wait 5 sec
        Thread.sleep(5000);
        //maximize the page
        driver.manage().window().maximize();
        //print the position and the size in the maximize  state
        System.out.println("driver.manage().window().getSize() = " + driver.manage().window().getSize());
        System.out.println("driver.manage().window().getPosition() = " + driver.manage().window().getPosition());

        //make a full screen page
        driver.manage().window().fullscreen();

        //close the browser
        driver.quit();

    }
}
