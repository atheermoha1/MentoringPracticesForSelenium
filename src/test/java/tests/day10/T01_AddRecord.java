package tests.day10;

import com.github.javafaker.Faker;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.ActionHelper;
import utilities.TestBas2;

import java.util.Arrays;
import java.util.List;

public class T01_AddRecord extends TestBas2 {
    /*
Go to https://claruswaysda.github.io/addRecordWebTable.html
Add 10 records.
Store the name, age, and country columns in separate arrays (not ArrayList).
*/


    @Test
    void test01() {
        driver.get("https://claruswaysda.github.io/addRecordWebTable.html");
        logger.info("claruswaysda website is opened");

        //Add 10 records.
        logger.info("Added 10 records to this site");

        for (int i = 0; i < 10; i++) {
            actionHelper.sendKeys(By.id("nameInput"), Faker.instance().name().firstName());
            actionHelper.sendKeys(By.id("ageInput"), "" + (Faker.instance().number().numberBetween(18, 35)));
            Select select = new Select(actionHelper.findElement(By.id("countrySelect")));
            int index = Faker.instance().number().numberBetween(1, 5);
            try {
                select.selectByIndex(index);
                logger.info("Country is selected with index : " + index);
            } catch (Exception e) {
                logger.error("Could not select by reference with index" + index);
            }
            actionHelper.click(actionHelper.findElement(By.xpath("//button[.='Add Record']")));

        }

        //Store the name, age, and country columns in separate arrays (not ArrayList).

        List<WebElement> storeRows = driver.findElements(By.xpath("//table//tbody//tr"));
        String[] name = new String[storeRows.size()];
        String[] age = new String[storeRows.size()];
        String[] country = new String[storeRows.size()];

        for (int i = 0; i < 10; i++ ){
            List<WebElement> cols = storeRows.get(i).findElements(By.tagName("td"));
            name[i]=cols.get(0).getText();
            age[i]= cols.get(1).getText();
            country[i]=cols.get(2).getText();

        }
        System.out.println("Names: ");
        for(String names:name){
            System.out.print(names+ " ");
        }
//        //Store the name, age, and country columns in separate arrays (not ArrayList).
//        List<WebElement> namesList = driver.findElements(By.xpath("//table//td[1]"));
//
//        String[] namesArr = new String[namesList.size()];
//        for (int i=0;i< namesList.size();i++){
//            namesArr[i] = namesList.get(i).getText();
//        }
//
//        List<WebElement> agesList = driver.findElements(By.xpath("//table//td[2]"));
//
//        String[] agesArr = new String[namesList.size()];
//        for (int i=0;i< agesList.size();i++){
//            agesArr[i] = agesList.get(i).getText();
//        }
//
//        List<WebElement> countryList = driver.findElements(By.xpath("//table//td[3]"));
//
//        String[] countryArr = new String[countryList.size()];
//        for (int i=0;i< countryList.size();i++){
//            countryArr[i] = countryList.get(i).getText();
//        }
//
//        System.out.println("Names: ");
//        for(String name:namesArr){
//            System.out.print(name+ " ");
//        }
//
//        System.out.println(Arrays.asList(countryArr));
//        System.out.println(Arrays.asList(agesArr));
//    }
//

}

}