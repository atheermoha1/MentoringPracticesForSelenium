package assignments.day09;

import org.apache.poi.ss.usermodel.*;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBas2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

public class T03_ExportTableToExcel extends TestBas2 {
    /*
Go to https://claruswaysda.github.io/webTable.html
Write the entire Table 1 to a new Excel sheet.
*/

    @Test
    void test() throws IOException {
        driver.get("https://claruswaysda.github.io/webTable.html");
        // create excel file
        Workbook workbook;
        workbook = WorkbookFactory.create(true);
        Sheet sheet = workbook.createSheet("StudenGrade");
       //lists that store the data of header and the entire body
        List<WebElement> stdGrades = driver.findElements(By.xpath("//table[1]//tbody//tr"));
        List<WebElement> header= driver.findElements(By.xpath("//table[1]//tr//th"));
        List<WebElement> dataCells ;

        // start with header
        Row headerRow= sheet.createRow(0);
        for (int k=0; k< header.size();k++){
            Cell headerCell= headerRow.createCell(k);
            headerCell.setCellValue(header.get(k).getText());
        }

        // create rows and cells and fetch data
        for (int i = 0; i <stdGrades.size(); i++) {
            Row row = sheet.createRow(i+1);
            dataCells= stdGrades.get(i).findElements((By.xpath(".//td")));
            //create grade cells and set the values
            for (int j = 0; j < dataCells.size(); j++) {
                Cell cells = row.createCell(j);
                cells.setCellValue(dataCells.get(j).getText());
            }
        }

        //write on file and close it
        FileOutputStream fos = new FileOutputStream(Path.of(".", "resources", "StudentGrade.xlsx").toString());
        workbook.write(fos);
        fos.close();
        workbook.close();


    }

}
