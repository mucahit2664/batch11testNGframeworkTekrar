package com.techproed.tests;

import com.techproed.pages.CkHotelsHomePage;
import com.techproed.utulities.ConfigReader;
import com.techproed.utulities.Driver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class D33_DataProviderCoklu {

    //{{"Manager","Manager"},{"Manager1","Manager1"},{"Manager2","Manager2"},{"Manager3","Manager3"}};
   @Test(dataProvider = "kullanicilar")
   public void test(String isim,String sifre){
       Driver.getDriver().get(ConfigReader.getProperty("ck_hotels_url"));
       CkHotelsHomePage ckHotelsHomePage=new CkHotelsHomePage();
       ckHotelsHomePage.ilkLogIn.click();
       ckHotelsHomePage.userNameTextBox.sendKeys(isim);
       ckHotelsHomePage.passwordTextBox.sendKeys(sifre);
       ckHotelsHomePage.loginButonu.click();
       Assert.assertTrue(ckHotelsHomePage.girilemediYazisi.isDisplayed());
   }



   //array[4][4]
   @DataProvider(name = "kullanicilar")
   public static Object[][] kulllaniciOlustur() {
       String datalar[][]={{"Manager","Manager"},{"Manager1","Manager1"},{"Manager2","Manager2"},{"Manager3","Manager3"}};

       return datalar;
   }

}
