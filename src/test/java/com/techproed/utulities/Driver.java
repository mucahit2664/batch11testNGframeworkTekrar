package com.techproed.utulities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.util.concurrent.TimeUnit;

public class Driver {
    //Singleton class : obje olusturulmasi kontrol altina alinan  (genelde izin verilmeyen ) classdir
    //BUNUN ICIN BASKA CLASSLARDAN DRIVER CLASSINDAN OBJE URETMEMIZI SAGLAYAN DEFAULT CONSTRUCTOR`I
    //GORUNUR SEKILDE YAZIP ACCESS MODIFIER`I PRIVATE YAPARIZ
    //BU ZORUNLU olmayan birsey ama interviewlerde sorulabilir
    private Driver() {

    }

    static WebDriver driver;

    //bu isim tercih edilir
    static public WebDriver getDriver() {

        //ilk gonderdiginde bos oldugunda gidiyor ikincisinde gidiyor varsa aagiya iniyor sonra tekrar bir daha
        //calistiryor gidiyor o sayfaya
        ///driver bos mu degil mi yani driver acilmis mi? acilmadiysa ac,, aciksa birdaha acmana gerek yok.acik olandan devam et
        if (driver == null) {

            switch (ConfigReader.getProperty("browser")) {

                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;
                case "safari":
                    WebDriverManager.getInstance(SafariDriver.class);
                    driver = new SafariDriver();
                    break;
                case "opera":
                    WebDriverManager.operadriver().setup();
                    driver = new OperaDriver();
                    break;
            }

        }


        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        return driver;

    }


    static public void closeDriver() {
        if (driver != null) {
            driver.close();
            driver = null;
        }

    }

}

