package tests;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C08GoogleSearch {
    static WebDriver driver;
    static String url="https://www.google.com/";
    //test data
    By searchBox = By.name("q");
    By resultCountryXpath= By.xpath("//div[@id='result-stats']");

    @BeforeAll
    public static void setUp() throws InterruptedException {
// TODO: Initialize static WebDriver
        driver= new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
// TODO: Navigate to Google
        driver.get(url);
        Thread.sleep(3500);
        //driver.findElement(By.xpath("//div[.='Tout accepter"))
    }
    @Test
    public void searchMovies() throws InterruptedException {
        String[] movies = {"Green Mile","Premonition","The Curious Case of Benjamin Button"};

        for(String movie : movies) {
// TODO: Find search box
            driver.findElement(searchBox).clear();
// TODO: Clear and enter movie name and submit
            driver.findElement(searchBox).sendKeys(movies[0], Keys.ENTER);
Thread.sleep(10000);
            // TODO: Get and print result count
// TODO: Clear search box for next iteration
            driver.findElement(searchBox).clear();
            driver.navigate().back();
        }
    }
    @AfterAll
    public static void tearDown() {
    driver.quit();
    }
}

