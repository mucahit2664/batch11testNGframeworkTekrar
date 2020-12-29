package com.techproed.tests;

import com.techproed.pages.AmazonPage;
import com.techproed.utulities.ConfigReader;
import com.techproed.utulities.Driver;
import com.techproed.utulities.TestBaseRapor;
import org.testng.Assert;
import org.testng.annotations.Test;

public class D26_AmazonSatirSutunSayisi extends TestBaseRapor {

    @Test
    public void  satirSayisi(){
        extentTest=extentReports.createTest("satir sayisi","amazon web sayfasindaki web table satir saysiini bulma");
        Driver.getDriver().get(ConfigReader.getProperty("amazon_url"));
        extentTest.info("amazon sayfasina git");
        AmazonPage amazonPage=new AmazonPage();
        amazonPage.enAltagit();
        extentTest.info("en alta in");
        System.out.println(amazonPage.satirlarListesi.size());
        extentTest.info("tablodaki satirlar sayisini al");
        Assert.assertTrue(amazonPage.satirlarListesi.size()==10);
        extentTest.pass("satir sayisinin 10 oldugunu test et");
        Driver.closeDriver();
    }
    @Test
    public void sutunSayisi(){
        Driver.getDriver().get(ConfigReader.getProperty("amazon_url"));
        AmazonPage amazonPage=new AmazonPage();
        amazonPage.enAltagit();
        System.out.println(amazonPage.birinciSatirlarListesi.size());
        Assert.assertTrue(amazonPage.birinciSatirlarListesi.size()==14);
        Driver.closeDriver();
    }
}
