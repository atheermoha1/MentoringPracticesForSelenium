package assignments.day01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class day01Task2 {
    public static void main(String[] args) {

        // invoke EdgeDriver; I used edgedriver becuase I do not have FireFox on my laptop
        WebDriver driver =new EdgeDriver();

        //navigate to youtube
        driver.get("https://www.youtube.com/");

        // verify the page title
        String title = driver.getTitle();
        System.out.println("title = " + title);
        if(title.equals("video")){
            System.out.println("the page contains a video word");
        }
        else{
            System.out.println("the page does not contain a video word");
        }
        // close the browser
        driver.quit();
    }
}
