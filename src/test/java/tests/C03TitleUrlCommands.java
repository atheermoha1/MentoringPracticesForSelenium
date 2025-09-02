package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C03TitleUrlCommands {
    public static void main(String[] args) {
        // TC – 03

// Expected Title
String ExpectedTitle="Google";

// Launch Chrome browser
WebDriver driver = new ChromeDriver();

// Open URL of Website
driver.navigate().to("https://www.google.com");

// Maximize Window
driver.manage().window().maximize();

// Get Title of current Page
String title = driver.getTitle();
System.out.println("driver getCurrentUrl: "+driver.getCurrentUrl()); // other way
System.out.println("Title of Current page: "+title);

// Validate/Compare Page Title
if(title.equals(ExpectedTitle)){
            System.out.println("Page title appears as expected");
        }
else{
            System.out.println("does not pear as expected ");
        }

// Close Browser
        driver.quit();
    }
}
