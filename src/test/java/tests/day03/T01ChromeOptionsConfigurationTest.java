package tests.day03;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class T01ChromeOptionsConfigurationTest {
    /*
    Task: Create a test method that opens a browser with the following configurations:
    Maximize window on startup
    Disable extensions
    Run in incognito mode
    Disable infobars Navigate to "https://www.example.com" and verify the title contains "Example"
     */
    WebDriver driver;


   @Test
  public void chromeTest(){
        String url2 = "https://www.example.com";
        driver.get(url2);
        String title= driver.getTitle();
       Assertions.assertTrue(title.contains("Example"));

   }

    @BeforeEach
    void setUp() {
        ChromeOptions option= new ChromeOptions();
        option.addArguments("--start-maximized");
        option.addArguments("--disable-extensions");
        option.addArguments("--incognito");
        option.addArguments("--disable-infobars");
        driver= new ChromeDriver(option);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }
}
