package com.techproed.tests;

import com.techproed.utulities.TestBase;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class D15_FileDowland extends TestBase {

    //1. Tests packagenin altina bir class oluşturalim : D14_FileDownload
    //2. Iki tane metod oluşturun : isExist() ve downloadTest()
    //3. downloadTest () metodunun icinde aşağıdaki testi yapalim:
    //      - https://the-internet.herokuapp.com/download adresine gidelim.
    //      - image1.jpg dosyasını indirelim
    //4. Ardından isExist()  methodunda dosyanın başarıyla indirilip indirilmediğini test edelim
@Test (dependsOnMethods = "downloadTest")
public void isExist(){
    String homePath=System.getProperty("user.home");
    String filePath=homePath+"\\Dowlands\\Capturegit.PNG";
    boolean dosyaVarmi= Files.exists(Paths.get(filePath));
    System.out.println(dosyaVarmi);
}


    @Test
    public void downloadTest() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/download");
driver.findElement(By.linkText("Capturegit.PNG")).click();
Thread.sleep(5000);
    }
}
