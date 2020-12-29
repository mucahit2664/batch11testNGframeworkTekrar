package com.techproed.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

public class D11_SoftAssertHomework {
    WebDriver driver;

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test(groups = "2")
    public void Test01() {
        driver.get("https://www.amazon.com/");
        // 2. softassert kullanarak amazon websitesine gittiginizi dogrulayin


        // 2. softassert kullanarak amazon websitesine gittiginizi dogrulayin
        // title : Amazon.com: Online Shopping for Electronics, Apparel, Computers, Books, DVDs & more
        String actualTitle=driver.getTitle();
          SoftAssert softAssert=new SoftAssert();
        softAssert.assertEquals(actualTitle,"Amazon.com: Online Shopping for Electronics, Apparel, Computers, Books, DVDs & more","title yanlis amazon sayfasinda degilsin");
//3. kategori dropdown'indan Books kategorisini secin
//    arama kutusuna history yazdirip aratin
        WebElement dropDown = driver.findElement(By.id("searchDropdownBox"));
        Select select = new Select(dropDown);
        select.selectByIndex(5);
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("history" + Keys.ENTER);

        //2.yol tekrar dersinde yaptik
String ikinciElementi=driver.findElement(By.xpath("(//span[@class='a-size-medium a-color-base a-text-normal'])[2]")).getText();
String besinciElementi=driver.findElement(By.xpath("(//span[@class='a-size-medium a-color-base a-text-normal'])[5]")).getText();
         softAssert.assertTrue(ikinciElementi.contains("History"),"2.Kitap isiminde History kelimesi gecmiyor");
         softAssert.assertTrue(besinciElementi.contains("History"),"5.Kitap isiminde History kelimesi gecmiyor");
        //  5. cikan sonuc sayisinin 50000'den buyuk oldugunu dogrulayin
        String sonucYazisi = driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']")).getText();
        System.out.println(sonucYazisi);
        int indexOver = sonucYazisi.indexOf("over");
        sonucYazisi = sonucYazisi.substring(indexOver + 5);

        sonucYazisi = sonucYazisi.replaceAll("\\D", "");
        int sonucSayisi = Integer.parseInt(sonucYazisi);
        System.out.println(sonucSayisi);
        softAssert.assertTrue(sonucSayisi > 50000, "sonuc sayisi 50000 den azdir");

        softAssert.assertAll();

    }


    @AfterClass
    public void tearDown() {


        //driver.close();
    }
}