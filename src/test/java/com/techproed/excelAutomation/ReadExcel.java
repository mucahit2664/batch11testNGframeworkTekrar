package com.techproed.excelAutomation;

import org.apache.poi.ss.usermodel.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ReadExcel {
    @Test
    public void readExcel() throws IOException {
        String path=".\\src\\test\\java\\resources\\ulkeler.xlsx";
        FileInputStream fileInputStream=new FileInputStream(path);
        Workbook workbook= WorkbookFactory.create(fileInputStream);
        Sheet sheet=workbook.getSheetAt(0);
        //ilgili satira ulasmak icin
        Row row=sheet.getRow(0);
        //hucreye ulasmak icin
        Cell cell=row.getCell(0);
        System.out.println(cell);
        //data uzerinde bir manipule yapmak icin toStringmethodu ile cevirmeliyiz
        String hucre=cell.toString();
        System.out.println(hucre);
    }
    @Test
    public  void readExcel2() throws IOException {
        String path=".\\src\\test\\java\\resources\\ulkeler.xlsx";
        FileInputStream fileInputStream=new FileInputStream(path);
        Workbook workbook= WorkbookFactory.create(fileInputStream);
       //1.satirdaki 2.hucreye gidelim ve yazdiralim
        System.out.println(workbook.getSheetAt(0).getRow(0).getCell(1));
       //1 satirdaki 2.hucreyi bir String degiskenine atayalim ve yazdiralim
        String birinciSatirikinciHucre=workbook.getSheetAt(0).getRow(0).getCell(1).toString();
        System.out.println(birinciSatirikinciHucre);
        //2 satir 4.cell`in afganistan baskenti oldgunu test edelim
        String ikinciSatirDorduncuCell=workbook.getSheetAt(0).getRow(1).getCell(3).toString().toLowerCase();
        Assert.assertEquals(ikinciSatirDorduncuCell,"kabil");
//- Satir sayisini bulalim
        System.out.println(workbook.getSheetAt(0).getLastRowNum());
        // - Fiziki olarak kullanilan satir sayisini bulun(index degil sayma sayilari kullanilir)
        System.out.println("son satir sayisi "+workbook.getSheetAt(1).getLastRowNum());
        System.out.println("fiziki kullanim satir sayisi "+workbook.getSheetAt(1).getPhysicalNumberOfRows());
        // - Ingilizce Ulke isimleri ve baskentleri bir map olarak kaydedelim
        // her bir ulke icin /her satir icin
        // 0.index ulke adi ve 1.index baskent adi
        String ulkeAdi="";
        String baskent="";
        Map<String,String>baskentler=new HashMap<>();
        for (int i = 0; i <workbook.getSheetAt(0).getLastRowNum() ; i++) {
            ulkeAdi=workbook.getSheetAt(0).getRow(i).getCell(0).toString();
            baskent=workbook.getSheetAt(0).getRow(i).getCell(1).toString();
            baskentler.put(ulkeAdi,baskent);
        }
        System.out.println(baskentler);
        }


    }

