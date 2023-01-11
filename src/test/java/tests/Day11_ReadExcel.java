package tests;

import org.apache.poi.ss.usermodel.*;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Day11_ReadExcel {
    @Test
    public void readExcelTest() throws IOException {
//        Store the path of the  file in a string
        String path = "./src/test/java/resources/Capitals.xlsx";
//        Open the file
        FileInputStream fileInputStream = new FileInputStream(path);
//        Open the workbook using fileinputstream
        Workbook workbook = WorkbookFactory.create(fileInputStream);
//        Open the first worksheet
        Sheet sheet1= workbook.getSheet("Sheet1");
//        workbook.getSheetAt(0);//Alternatively
//        Go to first row
       Row row1 =  sheet1.getRow(0);//Index starts at 0. going to the first row
//        Go to first cell on that first row and print
        Cell cell1 = row1.getCell(0);//Index starts at 0. reading the first cell data that is on the first row
        System.out.println(cell1);
//        We can convert the cell data to string
        String cell1Data = cell1.toString();
        System.out.println(cell1Data);
//        Go to second cell on that first row and print
        Cell r1c2 = row1.getCell(1);
        System.out.println("R1C2: "+r1c2.toString());
//        Go to 2nd row first cell  and assert if the data equal to USA
        String r2c1 = sheet1.getRow(1).getCell(0).toString();//METHOD CHAIN
        Assert.assertEquals("USA",r2c1);
//        Go to 3rd row 2nd cell-chain the row and cell
        String r3c2 =sheet1.getRow(2).getCell(1).toString();
        System.out.println(r3c2);
//        Find the number of row
        int numberOfRow = sheet1.getLastRowNum()+1;//indexs starts at 0, so add 1 to find total number of row
        System.out.println(numberOfRow);
//        Find the number of used row//index starts at 1. Returns the number of row that has a DATA
        int numberOfData = sheet1.getPhysicalNumberOfRows();
        System.out.println(numberOfData);
//        Print country, capital key value pairs as map object
//        {{USA,D.C},{France,Paris}.....}
//        Create a Map that will store the country, capital pairs
        Map<String,String> countryCapitals = new HashMap<>();
        for (int rowNum = 1; rowNum<numberOfRow; rowNum++) {//row index starts at 1, ends at 11
            String country = sheet1.getRow(rowNum).getCell(0).toString();
            String capital = sheet1.getRow(rowNum).getCell(1).toString();
            countryCapitals.put(country, capital);
        }
        System.out.println(countryCapitals);
//        Coll




    }

}
