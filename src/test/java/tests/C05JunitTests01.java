package tests;
// Go to YouTube homepage
// Do the following tasks by creating 4 different test methods. 
// Print "Test is running" before each test() method
// Print "Test finished" after each test() method
// Test if the currentURL contains "youtube" 
// Test if the title does not contain "Video". 
// Test if the URL contains "youtube". 
// Test if the sourcePage contains "youtube".

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C05JunitTests01 {
  static WebDriver driver;

 @Test
    void urlTest01(){
     System.out.println("the currentURL contains \"youtube\"");
     String url=driver.getCurrentUrl();
     Assertions.assertTrue(url.contains("youtube"));
 }
 @Test
    void urlTest02(){
     System.out.println("the title does not contain \"Video\"");
     String title = driver.getTitle();
     Assertions.assertFalse(title.contains("video"));

 }
 @Test
    void titleTest01(){
     System.out.println("2");

 }
 @Test
    void pageSourceTest01(){
     System.out.println("the sourcePage contains \"youtube\"");
Assertions.assertTrue(driver.getPageSource().contains("youtube"));

 }
 @BeforeEach
     void beforeEach(){
         System.out.println("Test is running");

     }
     @AfterEach
    void afterEach(){
         System.out.println("Test is finished");
     }
     @BeforeAll
     public static void setUp(){
     driver =new ChromeDriver();
     driver.manage().window().maximize();
     driver.get("https://www.youtube.com");

     }
 }

