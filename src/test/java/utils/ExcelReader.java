package utils;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ExcelReader {

    static Workbook book;
    static Sheet sheet;


    public static void openExcel(String filePath){
        //opening the excel file
        try {
            FileInputStream fis = new FileInputStream(filePath);
            book = new XSSFWorkbook(fis);
        } catch (FileNotFoundException e) {
            //to get exception if file is not available
            e.printStackTrace();
        } catch (IOException e) {
            //to get exception if input or output is not upto the mark
            e.printStackTrace();
        }
    }

    public static void getSheet(String sheetName){
        // it will identify the sheet we are going to read from excel file
        sheet = book.getSheet(sheetName);
    }

    public static int getRowCount(){
        //it will return total rows having the data
        return sheet.getPhysicalNumberOfRows();
    }

    public static int getColsCount(int rowIndex){
        //it will return total number of columns from every row
        return sheet.getRow(rowIndex).getPhysicalNumberOfCells();
    }

    public static String getCellData(int rowIndex, int colIndex){
        return sheet.getRow(rowIndex).getCell(colIndex).toString();
    }

    public static List<Map<String, String>> excelListIntoMap
            (String filePath, String sheetName){

        openExcel(filePath);
        getSheet(sheetName);

        List<Map<String, String>> listData = new ArrayList<>();

        //outer loop
        //it takes care of total rows in excel file
        //it will read the values from all thr rows
        for (int row =1; row<getRowCount(); row++){

            //create a map every row
            Map<String, String> map = new LinkedHashMap<>();
            //looping through all the values of the cell
            for (int col=0; col<getColsCount(row); col++){
                //it will add keys and values
                //0 index for row and col variable so that we get all the keys
                map.put(getCellData(0,col), getCellData(row, col));
            }
            listData.add(map);
        }

        return listData;
    }
}
