package com.jxl.test;

import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.WritableWorkbook;

import java.io.File;
import java.io.IOException;

/**
 * Created by 肖明明 on 2016/11/25.
 */
public class test {
    
    
    public static void readXLSX() throws IOException, BiffException {
        Workbook wb=Workbook.getWorkbook(new File("D://1.xls"));
        int num=wb.getNumberOfSheets();
        System.out.println(num);
        
        
        
        
    }


    public static void main(String[] args) throws IOException, BiffException {
        readXLSX();
        
    }
    
    
}
