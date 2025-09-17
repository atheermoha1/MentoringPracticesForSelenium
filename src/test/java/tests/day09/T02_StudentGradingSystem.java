package tests.day09;

import org.apache.poi.ss.usermodel.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;

public class T02_StudentGradingSystem {
    /*
    Given: Save StudentScores.xlsx file into your project
When: In the grade column, write the letter grades (A, B, C, D, F) based on the score ranges:
   Assert that the grade of "Alice" is "A"
     */
    //read excel file
    @Test
    void test() throws IOException {

        FileInputStream fis = new FileInputStream(Path.of(".", "resources", "TestData02.xlsx").toString());
        Workbook workbook = WorkbookFactory.create(fis);

        //open sheet
        String aliceGrade=null;
        Sheet sheet = workbook.getSheetAt(0);
        for (int i = 1; i <= sheet.getLastRowNum(); i++) {
            Row Row = sheet.getRow(i);
            // store student name
            String name= Row.getCell(0).getStringCellValue();
            //create grade cell
            Cell r1c1 = Row.createCell(2);
            //read the student's grade for each cell
            int grade = (int) Row.getCell(1).getNumericCellValue();
            String stdGrade = Grade(grade);
            r1c1.setCellValue((stdGrade));



        if (name.equals("Alice")) {
             aliceGrade = stdGrade;
        }

    }
        fis.close();

        FileOutputStream fos = new FileOutputStream(Path.of(".", "resources", "TestData02.xlsx").toString());
        workbook.write(fos);
        fos.close();
        workbook.close();

        Assertions.assertEquals("A", aliceGrade);
        System.out.println("Alice grade is:" + aliceGrade);



    }

    private String Grade(int grade) {
        if(grade>=90) return"A";
       else if(grade>=80) return"B";
       else if(grade>=70) return"C";
       else if(grade>=60) return"D";
       else return "F";
    }
}
