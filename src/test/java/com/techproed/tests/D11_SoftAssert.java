package com.techproed.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

public class D11_SoftAssert {


    //1. “http://https://www.amazon.com/” Adresine gidi
    // 2. Basliginin "Online eShopping,electrics...." oldugunu dogrulayin
    // 3. search kutusuna tv yazip arattirin
    // 4.   bulunan sonuc sayisini yazdirin
    // 5.   sonuc yazisinin "araba" icerdigini dogrulayin
    //7.    Bulunan sonucu yazdirin
    //8.    Sonuc yazisinin “tv” kelimesi icermedigini dogrulayin
    WebDriver driver;

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }
@Test
public void test01(){
    //1. “http://https://www.amazon.com/” Adresine gidin
    driver.get("https://www.amazon.com/");
    SoftAssert softAssert=new SoftAssert();
    // 2. Basliginin "Online eShopping,electrics...." oldugunu dogrulayin
    String actualTitle= driver.getTitle();
    String expectedTitle="Amazon.com: Online Shopping for Electronics, Apparel, Computers, Books, DVDs & more";
    softAssert.assertEquals(actualTitle,expectedTitle,"title mesaji icermiyor");
    // 3. search kutusuna tv yazip arattirin
    WebElement searchBox= driver.findElement(By.id("twotabsearchtextbox"));
    searchBox.sendKeys("tv");
    searchBox.submit();
    //7.    Bulunan sonucu yazdirin
    WebElement sonucSayisiElemnti=driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
    System.out.println(sonucSayisiElemnti.getText());
    //8.    Sonuc yazisinin “tv” kelimesi icermedigini dogrulayin
softAssert.assertTrue(sonucSayisiElemnti.getText().contains("tv"),"arama sonucu tv kelimesi icermiyor");





    softAssert.assertAll();

}


    @AfterClass
    public void tearDown(){
        driver.close();
    }
}
