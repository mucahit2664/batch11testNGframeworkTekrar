package com.techproed.tests;

import com.techproed.utulities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class D19_WebTables extends TestBase {
    //Bir Class olusturun D19_WebtablesHomework
    //1. “https://demoqa.com/webtables” sayfasina gidin
    //2. Headers da bulunan department isimlerini yazdirin
    //3. 3.sutunun basligini yazdirin
    //4. Tablodaki tum datalari yazdirin
    //5. Tabloda kac cell (data) oldugunu yazdirin
    //6. Tablodaki satir sayisini yazdirin
    //7. Tablodaki sutun sayisini yazdirin
    //8. Tablodaki 3.kolonu yazdirin
    //9. Tabloda "First Name" i Kierra olan kisinin Salary'sini yazdirin
    //10. Page sayfasinda bir method olusturun, Test sayfasindan satir ve sutun
    //sayisini girdigimde bana datayi yazdirsin
    @Test
    public void test() throws InterruptedException {
        //1. “https://demoqa.com/webtables” sayfasina gidin
        //2. Headers da bulunan department isimlerini yazdirin
        driver.get("https://demoqa.com/webtables");
        List<WebElement> baslikListesi=driver.findElements(By.xpath("//div[@class='rt-resizable-header-content']"));
        for (WebElement w: baslikListesi
        ) {
            System.out.println("Baslik Listesi: " +w.getText());
        }
        //3. 3.sutunun basligini yazdirin
        WebElement ucuncuSutunBasligi=driver.findElement(By.xpath("(//div[@class='rt-resizable-header-content'])[3]"));
        System.out.println("3.Sutun Basligi: " +ucuncuSutunBasligi.getText());
        //4. Tablodaki tum datalari yazdirin
        WebElement tumData=driver.findElement(By.xpath("//div[@class='rt-table']"));
        System.out.println("======Tum Datalar=====");
        System.out.println(tumData.getText());
        //5. Tabloda kac cell (data) oldugunu yazdirin
        List<WebElement> dataSayisi=driver.findElements(By.xpath("//div[@class='rt-td']"));
        // for (WebElement cell: dataSayisi
        //     ) {
        //   System.out.println(cell.getText());
        //}
        System.out.println("Toplam data sayisi: "+dataSayisi.size());
        //6. Tablodaki satir sayisini yazdirin
        List<WebElement> satirSayisi=driver.findElements(By.xpath("//div[@class='rt-tr-group']"));
        System.out.println("Satir sayisi: "+satirSayisi.size());
        //7. Tablodaki sutun sayisini yazdirin
        System.out.println("Sutun sayisi: "+baslikListesi.size());
        //8. Tablodaki 3.kolonu yazdirin
        for (int i = 1; i <satirSayisi.size() ; i++) {
            WebElement ucuncuKolon=driver.findElement(By.xpath("(//div[@class='rt-tr-group'])["+i+"]//div//div[3]"));
            System.out.println(ucuncuKolon.getText());
        }
        //9. Tabloda "First Name" i Kierra olan kisinin Salary'sini yazdirin
        Thread.sleep(5000);
        int salaryninSutunNumarasi=0;
        System.out.println(baslikListesi.get(4).getText());
        for (int k =1 ; k < baslikListesi.size() ; k++) {
            if (baslikListesi.get(k).getText().equals("Salary")){
                salaryninSutunNumarasi=k;
            }
        }
        salaryninSutunNumarasi++;
        System.out.println(salaryninSutunNumarasi);
        int kieraSatirNumarasi=0;
        for (int j =1 ; j <satirSayisi.size(); j++) {
            // WebElement birinciKolon=driver.findElement(By.xpath("(//div[@class='rt-tr-group'])["+j+"]//div//div[1]"));
            String elementYolu="(//div[@class='rt-tr-group'])["+j+"]//div//div[1]";
            WebElement element=driver.findElement(By.xpath(elementYolu));
            if (element.getText().equals("Kierra")){
                kieraSatirNumarasi=j;
            }
        }
        System.out.println(kieraSatirNumarasi);
        String arananSalaryXpeth="(//div[@class='rt-tr-group'])["+kieraSatirNumarasi+"]//div//div["+salaryninSutunNumarasi+"]";
        WebElement arananSalary=driver.findElement(By.xpath(arananSalaryXpeth));
        System.out.println("Aranan deger: "+arananSalary.getText());
        //10. Page sayfasinda bir method olusturun, Test sayfasindan satir ve sutun
        //sayisini girdigimde bana datayi yazdirsin


}

}
