package tests.day08;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.nio.file.Path;

public class T02_UploadFile extends TestBase {
    /*
Go to https://claruswaysda.github.io/downloadUpload.html
Upload a PDF using single upload button
Verify that 'Files uploaded successfully!'
Do negative test (No file or other than PDF)
Verify that 'Please upload at least one PDF file. Only PDF files are allowed!'
Test multiple PDFs as well
*/

    String url = "https://claruswaysda.github.io/downloadUpload.html";

    @Test
    void test() throws InterruptedException {
        driver.get(url);

        //FIND THE PATH
        Path filePath=Path.of(System.getProperty("user.home"),"Downloads","08 - Selenium Files & Screenshots - Review and Summary.pdf");
        String filePathString= filePath.toString();
        System.out.println("File path: " + filePathString);

        //upload file and click upload
        driver.findElement(By.id("uploadInput")).sendKeys(filePathString);

        driver.findElement(By.className("upload-btn")).click();
        driver.findElement(By.className("submit-btn")).click();
        Thread.sleep(2000);
        //verify the message
        String msg =driver.findElement(By.id("successBox")).getText();
        Assertions.assertEquals("Files uploaded successfully!",msg.trim());



    }
}
