package com.techproed.tests;

import com.techproed.pages.AmazonPage;
import com.techproed.utulities.ConfigReader;
import com.techproed.utulities.Driver;
import com.techproed.utulities.TestBaseRapor;
import org.apache.commons.io.input.TeeInputStream;
import org.testng.Assert;
import org.testng.annotations.Test;

public class D26_AmazonHucreTest extends TestBaseRapor {

    @Test
    public void  hucreTesti(){
        //Bu class’in altinda bir test method olusturun : hucretesti() ve
        // webtable’da 3. satir 7.sutundaki yazinin “Home Services” yazisi icerdigini test edin
        extentTest=extentReports.createTest("hucre testi","3.satir 7.sutundaki yazinin dogrulugunu test ettik");
        Driver.getDriver().get(ConfigReader.getProperty("amazon_url"));
        extentTest.info("amazon sayfasina git");
        AmazonPage amazonPage=new AmazonPage();
        amazonPage.enAltagit();
        extentTest.info("en alta git");
        String hucreyAZISI=amazonPage.hucreYazisiniGetir(3,7);
extentTest.info("istedigim hucre yazisini al");
        Assert.assertTrue(hucreyAZISI.contains(ConfigReader.getProperty("aranan_hucre")));
        extentTest.pass("hucredeki yazi dogru,test PASS");
    }


    @Test
    public void AmazonYazisi(){

        Driver.getDriver().get(ConfigReader.getProperty("amazon_url"));
        AmazonPage amazonPage=new AmazonPage();
        amazonPage.enAltagit();
int kelimeSayaci=0;
        for (int i = 1; i <amazonPage.satirlarListesi.size() ; i+=2) {
            for (int j = 1; j <amazonPage.birinciSatirlarListesi.size() ; j+=2) {
                if (amazonPage.hucreYazisiniGetir(i,j).contains(ConfigReader.getProperty("aranan_kelime")))
                kelimeSayaci++;

            }

        }
        System.out.println(kelimeSayaci);
        Driver.closeDriver();
    }

}
