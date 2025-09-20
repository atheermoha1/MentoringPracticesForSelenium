package assignments.day09;


import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBas2;
import java.io.IOException;
import java.util.List;
import java.util.Random;

public class T04_FindYoungestRecord extends TestBas2 {
    /*
Go to https://claruswaysda.github.io/addRecordWebTable.html
Add 10 records using Faker.
Find the name of the youngest record.
*/

    @Test
    void test1() throws IOException {
        driver.get("https://claruswaysda.github.io/addRecordWebTable.html");

        //locate elements
        WebElement inputName = driver.findElement(By.id("nameInput"));
        WebElement inputAge = driver.findElement(By.id("ageInput"));
        WebElement countrySelect = driver.findElement(By.id("countrySelect"));
        WebElement addButton = driver.findElement(By.xpath("//button[normalize-space()='Add Record']"));

        // select country
        Select countries = new Select(countrySelect);
        Faker faker=new Faker();


        //save country's name in a list and use random to select country by index
        List<WebElement> countryName= countries.getOptions();
        Random random= new Random();

        //fill the table by sendKeys name, age and country selection
        for (int i = 1; i < 10; i++) {
            String name = faker.name().fullName();
            int age = faker.number().numberBetween(10,35);
            int RandomIndex= 1+random.nextInt(countryName.size()-1);

            // sendKeys and click button
            inputName.sendKeys(name);
            inputAge.sendKeys(age+"");
            countries.selectByIndex(RandomIndex);
            addButton.click();
        }

        List<WebElement> rows= driver.findElements(By.xpath("//table//tbody//tr"));
        int youngest=Integer.MAX_VALUE;
        String youngestName="";

        // iterate over every row to find the youngest record
        for (int j=0; j< rows.size();j++) {
           WebElement row= rows.get(j);
            List<WebElement> cell= row.findElements(By.xpath(".//td"));

            //get the data of first and second columns
            String name= cell.get(0).getText();
            String age = cell.get(1).getText();
            int castAge= Integer.parseInt(age);

            // check if the current age is the smallest
            if(castAge<youngest){
               youngest=castAge;
               youngestName=name;
           }
        }
        System.out.println("YoungestName = " + youngestName+" With youngestAge= "+youngest);





    }

    }
