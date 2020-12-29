package com.techproed.tests;

import com.techproed.utulities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class D16_SeleniumWaits extends TestBase {

    @Test
    public void test1(){
        driver.get("https:\\www.youtube.com");
        WebElement logo=driver.findElement(By.xpath("(//div[@id='logo-icon-container'])[1]"));

    }
    @Test
    public void impilcitlywaittest(){
        //3. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        //4. Remove butonuna basin.
driver.findElement(By.xpath("//button[@onclick='swapCheckbox()']")).click();
//5. “It’s gone!” mesajinin goruntulendigini test edin.
        WebElement mesaj=driver.findElement(By.id("message"));
        Assert.assertTrue(mesaj.isDisplayed(),"It’s gone!");
        //6. Add buttonuna basin
        driver.findElement(By.xpath("//button[@onclick='swapCheckbox()']")).click();
        //7. It’s back mesajinin gorundugunu test edin
        WebElement SONUCyAZeLEMETI=driver.findElement(By.id("message"));
        //<p id="message">It's back!</p>
        Assert.assertTrue(SONUCyAZeLEMETI.isDisplayed());
    }

    @Test
    public void ExplicitlyWait(){
        //3. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        //4. Remove butonuna basin.
        //wait object`i olusturma
        WebDriverWait wait=new WebDriverWait(driver,30);
        WebElement reoveButtonu=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@onclick='swapCheckbox()']")));
        reoveButtonu.click();
        //impilictly wait olunca
        // WebElement removeButtonEski=driver.findElement(By.xpath("//button[@onclick='swapCheckbox()']"));
        //  removeButtonEski.click();
        //5. “It’s gone!” mesajinin goruntulendigini test edin.
       // WebElement mesaj=driver.findElement(By.id("message"));
      //  Assert.assertTrue(mesaj.isDisplayed(),"It’s gone!");
        WebElement ITSGOENmESAJI=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("message")));
        Assert.assertTrue(ITSGOENmESAJI.isDisplayed());
        //6. Add buttonuna basin
        WebElement itsGoneYazisielementi = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("message")));
       itsGoneYazisielementi.click();
        //7. It’s back mesajinin gorundugunu test edin
        WebElement itsBackButtonu=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("message")));

      Assert.assertTrue(itsBackButtonu.isDisplayed());


    }
}
