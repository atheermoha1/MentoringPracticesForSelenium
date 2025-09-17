package utilities;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;


public abstract class TestBas2 {
    // make it abstract so that it cannot be instantiated directly and no one can create objects from outside

        protected WebDriver driver;
        protected ActionHelper actionHelper;
        protected Logger logger;

        @BeforeEach
        void setUp() {
            logger= LogManager.getLogger(TestBas2.class);
            driver= new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            logger.info("Chrome browser is initialized...");
            driver.manage().window().maximize();
            actionHelper = new ActionHelper(driver);

        }

        @AfterEach
        void tearDown() {
            driver.quit();
            logger.info("Chrome browser is closed ...");

        }
    }
