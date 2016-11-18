package com.poi.test;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;

/**
 * Created by 肖明明 on 2016/11/18.
 */
public class test {
    
    
    public static void createXLSX() throws IOException {
        Workbook wb = new XSSFWorkbook();
        CreationHelper createHelper = wb.getCreationHelper();
        Sheet sheet = wb.createSheet("xmm sheet");

        // Create a row and put some cells in it. Rows are 0 based.
        Row row = sheet.createRow((short)0);
        // Create a cell and put a value in it.
        Cell cell = row.createCell(0);
        cell.setCellValue(1);

        // Or do it on one line.
        row.createCell(1).setCellValue(1.2);
        row.createCell(2).setCellValue(
                createHelper.createRichTextString("This is a string"));
        row.createCell(3).setCellValue(true);
        row.createCell(4).setCellValue("dsdfdsfewvd");

        // Write the output to a file
        FileOutputStream fileOut = new FileOutputStream("d:/workbook.xlsx");
        wb.write(fileOut);
        fileOut.close();
        wb.close();
        
    }
    
    
    public static void readXLSX() throws IOException, InvalidFormatException {
        Workbook wb = WorkbookFactory.create(new File("D://workbook.xlsx"));
        Iterator<Sheet> sheets=wb.sheetIterator();
        while(sheets.hasNext()){
            Sheet sheet=sheets.next();
            System.out.print("sheet---"+sheet.getSheetName()+"\t");
            System.out.println("this sheet has -"+sheet.getLastRowNum()+"- rows");
            Iterator<Row> rows=sheet.rowIterator();
            while(rows.hasNext()){
                Row row=rows.next();
                System.out.print("row num is ----\t"+row.getRowNum()+"\t");
                System.out.println("this row last -"+row.getLastCellNum()+"- cells");
                System.out.println("this row first -"+row.getFirstCellNum()+"- cells");
                Iterator<Cell> cells=row.cellIterator();
                while(cells.hasNext()){
                    Cell cell=cells.next();
                    String value=getCellValueAsString(cell);
                    System.out.print(value+"|\t"+cell.getColumnIndex());
                    
                }
                System.out.println();
                
                
            }
        }
    }
    
   
    
    
    public static void readXLSXbyNum() throws IOException, InvalidFormatException {
        Workbook wb = WorkbookFactory.create(new File("D://workbook.xlsx"));
        Iterator<Sheet> sheets=wb.sheetIterator();
        while(sheets.hasNext()) {
            Sheet sheet=sheets.next();
            int rowMaxIndex=sheet.getLastRowNum()+1;//这个从0开始
            for(int r=0;r<rowMaxIndex;r++){
                Row row=sheet.getRow(r);
                if(row==null)continue;
                int cellMaxIndex=row.getLastCellNum();//这个从1开始。POI的api里的傻逼搞法
                for(int c=0;c<cellMaxIndex;c++){
                    Cell cell=row.getCell(c);
                    String value=getCellValueAsString(cell);
                    System.out.println(value+"\t");
                }
            }
        }
    }

    public static void main(String[] args) throws IOException, InvalidFormatException {
        readXLSXbyNum();
    }


    private static String getCellValueAsString(Cell cell){
        if(cell==null) return "here is a null shit";
        int n=cell.getCellType();
        String value="";
        switch (n){
            case -1:value=cell.getStringCellValue()+"-is none ";break;
            case 0:value=cell.getNumericCellValue()+"-is double ";break;
            case 1:value=cell.getStringCellValue()+"-is String ";break;
            case 2:value=cell.getCellFormula()+"-is FORMULA";break;
            case 3:value=cell.getStringCellValue()+"-is blank";break;
            case 4:value=cell.getBooleanCellValue()+"-is boolean";break;
            case 5:value=cell.getErrorCellValue()+"-is error";break;
            default:value="fuck is nothing";
        }
        return value;
    }
    
    
    
}
