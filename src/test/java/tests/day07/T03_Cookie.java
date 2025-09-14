package tests.day07;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import utilities.TestBase;

import java.util.Set;

public class T03_Cookie extends TestBase {
    /*
Go to https://claruswaysda.github.io/CookiesWait.html
Accept the alert if it is present
Print the cookies
Delete all cookies and assert
*/

    String url ="https://claruswaysda.github.io/CookiesWait.html";

    @Test
    void test(){
        driver.get(url);

    //Accept the alert if it is present
        try {
            Alert cookieAlert = driver.switchTo().alert();
            cookieAlert.accept();

        } catch (Exception e) {
            System.out.println(" there is no alert");
        }

        driver.findElement(By.id("acceptCookiesButton")).click();
        //Print the cookies
        Set<Cookie> cookie= driver.manage().getCookies();
        System.out.println("---------- Cookies-----------");
        cookie.forEach(System.out::println);


        System.out.println("---------- Cookies After Deleted -----------");
        driver.manage().deleteAllCookies();
        Assertions.assertTrue( driver.manage().getCookies().isEmpty());
    }
}
