package assignments.day03;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class day03Task1Locators {
        static WebDriver driver;

        @BeforeAll
        public static void setUp() {
// TODO: Initialize WebDriver
            driver= new ChromeDriver();
            driver.manage().window().maximize();
// TODO: Navigate to LinkedIn
            driver.get("https://www.linkedin.com/login");
        }
        @Test
        public void testLoginElements() {
// TODO: Locate email field using By.id
// TODO: Locate password field using By.name
// TODO: Locate sign-in button using By.xpath
// TODO: Enter test credentials
// TODO: Verify elements are displayed
        }
        @AfterAll
        public static void tearDown() {
// TODO: Close driver
        }
    }

