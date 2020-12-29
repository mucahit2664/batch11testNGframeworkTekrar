package com.techproed.excelAutomation;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class WriteExcel {
    @Test
    public void writeExcel() throws IOException {
        //Yeni bir Class olusturalim WriteExcel
        //Yeni bir test method olusturalim writeExcel()
        //Adimlari takip ederek 1.satira kadar gidelim
        String path=".\\src\\test\\java\\resources\\ulkeler.xlsx";
        FileInputStream fileInputStream=new FileInputStream(path);
        Workbook workbook= WorkbookFactory.create(fileInputStream);

        //4.hucreye yeni bir cell olusturalim
        //Olusturdugumuz hucreye “Nufus” yazdiralim
        workbook.getSheetAt(0).getRow(0).createCell(4).setCellValue("NUFUS");

        //2.satir nufus kolonuna 1500000 yazdiralim
        workbook.getSheetAt(0).getRow(1).createCell(4).setCellValue("1500000");
        //10.satir nufus kolonuna 250000 yazdiralim
        workbook.getSheetAt(0).getRow(9).createCell(4).setCellValue("25000");
        //15.satir nufus kolonuna 54000 yazdiralim
        workbook.getSheetAt(0).getRow(14).createCell(4).setCellValue("5400");

        //ornek benim
        //5.hucreye yeni bir cell kaydedelim
        workbook.getSheetAt(0).getRow(0).createCell(5).setCellValue("GELIR");
        //2.SATIR GELIR KOLUNUNA 1500000 YAZDIRIM
        workbook.getSheetAt(0).getRow(1).createCell(5).setCellValue("1500000");
        workbook.getSheetAt(0).getRow(2).createCell(5).setCellValue("200000");
        //Dosyayi kaydedelim
        //Dosyayi kapatalim
        FileOutputStream fileOutputStream=new FileOutputStream(path);
        workbook.write(fileOutputStream);
        fileInputStream.close();
        fileOutputStream.close();
        workbook.close();



    }
}
