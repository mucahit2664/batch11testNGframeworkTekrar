package com.techproed.tests;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class D35_WriteExcel {
    @Test
    public void test1() throws IOException {
        String path="src/test/java/resources/baskentler.xlsx";
        FileInputStream fileInputStream=new FileInputStream(path);
        Workbook workbook= WorkbookFactory.create(fileInputStream);
        workbook.getSheetAt(0).getRow(0).createCell(6).setCellValue("Nufus sayisi");
        workbook.getSheetAt(0).getRow(1).createCell(6).setCellValue("25000000");
        FileOutputStream fileOutputStream=new FileOutputStream(path);
        workbook.write(fileOutputStream);
        workbook.close();
        //6.hucreye nufus sayisi yazilfigini test edin
        Assert.assertEquals(workbook.getSheetAt(0).getRow(1).getCell(6).toString(),"25000000");

    }
}
