package com.auto.bigw.commonFunction;

import static org.apache.poi.ss.usermodel.Cell.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ExcelReader {

    private static final String xlsApiPath = System.getProperty("user.dir") + "/src/SampleRestAssured/resources/dataSheet/uatTestData.xlsx";
    private static final String xlsUIPath = System.getProperty("user.dir") + "/src/SampleRestAssured/resources/dataSheet/uatUITestData.xlsx";

    public static Object  getTestDataValueOfTestConfigSheet1(int row, int column) {


        try{
            File excel = new File(xlsApiPath);
            FileInputStream fis = new FileInputStream(excel);
            XSSFWorkbook book = new XSSFWorkbook(fis);
            XSSFSheet sheet = book.getSheetAt(0);

            Object sheetValue = "";
            Cell cell = sheet.getRow(row).getCell(column);

            switch (cell.getCellType()) {

                case CELL_TYPE_NUMERIC:
                    sheetValue = Math.round(cell.getNumericCellValue()); // CellType == Numeric
                    break;

                case CELL_TYPE_STRING:
                    sheetValue = cell.getStringCellValue(); // CellType == String
                    break;

                case CELL_TYPE_FORMULA:
                    sheetValue = cell.getCellFormula(); // CellType == Numeric
                    sheetValue = Math.round(cell.getNumericCellValue());
                    break;

                case CELL_TYPE_BLANK:
                     sheetValue =cell.getNumericCellValue(); // CellType == Blank
                    break;

                case CELL_TYPE_BOOLEAN:
                    // sheetValue = Math.round(cell.getNumericCellValue()); // /CellType == Boolean
                    break;

                case CELL_TYPE_ERROR:
                    //  sheetValue = Math.round(cell.getNumericCellValue()); // /CellType == Error
                    break;

                default:
                    sheetValue = 0;
                    break;
            }
            //System.out.println("TestData Value : " + sheetValue);
            return sheetValue;
        }catch (IOException ioe) {
            throw new ExceptionInInitializerError(ioe);
        }
    }


    //CALL THIS METHOD TO get the data
    public static String getTestDataSheet1(String testCaseName, String testHeaderName) {
        int rowData = 0;
        int colData = 0;
        try{
            File excel = new File(xlsApiPath);
            FileInputStream fis = new FileInputStream(excel);
            XSSFWorkbook book = new XSSFWorkbook(fis);
            XSSFSheet sheet = book.getSheetAt(0);

            for (int row =0; row<=sheet.getLastRowNum(); row++){
                Cell cell = sheet.getRow(row).getCell(0);
                Object sheetValue = cell.getStringCellValue();
                if (sheetValue.toString().equals(testCaseName)){
                    rowData = row;
                    //System.out.println("this is row number"+row);
                }
            }

            for (int col =0; col<=sheet.getRow(0).getLastCellNum()-1; col++){
                Cell cell = sheet.getRow(0).getCell(col);
                Object sheetValue = cell.getStringCellValue();
                if (sheetValue.toString().equals(testHeaderName)){
                    colData = col;
                    //System.out.println("this is column number"+col);
                }
            }

            return getTestDataValueOfTestConfigSheet1(rowData, colData).toString();
        }catch (IOException ioe) {
            throw new ExceptionInInitializerError(ioe);
        }
    }

    public static Object  getTestDataValueForUIScenario(int row, int column) {


        try{
            File excel = new File(xlsUIPath);
            FileInputStream fis = new FileInputStream(excel);
            XSSFWorkbook book = new XSSFWorkbook(fis);
            XSSFSheet sheet = book.getSheetAt(0);

            Object sheetValue = "";
            Cell cell = sheet.getRow(row).getCell(column);

            switch (cell.getCellType()) {

                case CELL_TYPE_NUMERIC:
                    sheetValue = Math.round(cell.getNumericCellValue()); // CellType == Numeric
                    break;

                case CELL_TYPE_STRING:
                    sheetValue = cell.getStringCellValue(); // CellType == String
                    break;

                case CELL_TYPE_FORMULA:
                    sheetValue = cell.getCellFormula(); // CellType == Numeric
                    sheetValue = Math.round(cell.getNumericCellValue());
                    break;

                case CELL_TYPE_BLANK:
                    sheetValue =cell.getNumericCellValue(); // CellType == Blank
                    break;

                case CELL_TYPE_BOOLEAN:
                    // sheetValue = Math.round(cell.getNumericCellValue()); // /CellType == Boolean
                    break;

                case CELL_TYPE_ERROR:
                    //  sheetValue = Math.round(cell.getNumericCellValue()); // /CellType == Error
                    break;

                default:
                    sheetValue = 0;
                    break;
            }
            //System.out.println("TestData Value : " + sheetValue);
            return sheetValue;
        }catch (IOException ioe) {
            throw new ExceptionInInitializerError(ioe);
        }
    }


    //CALL THIS METHOD TO get the data
    public static String getTestDataSheet1UI(String testCaseName, String testHeaderName) {
        int rowData = 0;
        int colData = 0;
        try{
            File excel = new File(xlsUIPath);
            FileInputStream fis = new FileInputStream(excel);
            XSSFWorkbook book = new XSSFWorkbook(fis);
            XSSFSheet sheet = book.getSheetAt(0);
            System.out.println("Last row number :: " +sheet.getLastRowNum());

            for (int row =0; row<=sheet.getLastRowNum(); row++){
                Cell cell = sheet.getRow(row).getCell(0);
                Object sheetValue = cell.getStringCellValue();
                if (sheetValue.toString().equals(testCaseName)){
                    rowData = row;
                    //System.out.println("this is row number"+row);
                }
            }

            for (int col =0; col<=sheet.getRow(0).getLastCellNum()-1; col++){
                Cell cell = sheet.getRow(0).getCell(col);
                Object sheetValue = cell.getStringCellValue();
                if (sheetValue.toString().equals(testHeaderName)){
                    colData = col;
                    //System.out.println("this is column number"+col);
                }
            }

            return getTestDataValueForUIScenario(rowData, colData).toString();
        }catch (IOException ioe) {
            throw new ExceptionInInitializerError(ioe);
        }
    }
    public static void main(String[] args) {
        //ExcelReader er = new ExcelReader();
        //er.searchString();
        System.out.println("output data value :: " +getTestDataSheet1UI("UI_TC_02_Checkout with Zippay payment","SearchField"));
    }



}

