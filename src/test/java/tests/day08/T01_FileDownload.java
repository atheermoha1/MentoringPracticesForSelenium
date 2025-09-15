package tests.day08;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class T01_FileDownload extends TestBase {
/*
Go to https://claruswaysda.github.io/downloadUpload.html
Click on download
Verify that 'QAProgram.png' file is downloaded
*/
String url="https://claruswaysda.github.io/downloadUpload.html" ;

@Test
    void test() throws InterruptedException, IOException {
    driver.get(url);
    WebElement download= driver.findElement(By.className("download-btn"));
    // click on download
    download.click();
   //verify it is downloaded
    String file= System.getProperty("user.home");
    String filePath= file+"/Downloads/QAProgram.png";
    Path path= Path.of(filePath);

    Thread.sleep(2500);
    Assertions.assertTrue(Files.exists(path));
    Files.deleteIfExists(path);




}
}

