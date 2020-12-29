package com.techproed.tests;

import com.techproed.utulities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class D16_Actions2 extends TestBase {

    @Test
    public  void test() throws InterruptedException {
        //1."http://webdriveruniversity.com/Actions" sayfasina gidin

        driver.get("http://webdriveruniversity.com/Actions");
        Actions actions=new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        WebElement H01=driver.findElement(By.xpath("(//button[@class='dropbtn'])[1]"));
        actions.moveToElement(H01).perform();

        // 3."Link 1" e tiklayin
        driver.findElement(By.linkText("Link 1")).click();
        Thread.sleep(5000);
        // 4.Popup mesajini yazdirin
        driver.switchTo().alert();
        // 4.Popup mesajini yazdirin
        System.out.println(driver.switchTo().alert().getText());
        // 5.Popup'i tamam diyerek kapatin
        driver.switchTo().alert().accept();
        // 6."Click and hold" kutusuna basili tutun
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        WebElement clickandHold=driver.findElement(By.id("click-box"));
        actions.clickAndHold(clickandHold).perform();

        // 7. "Click and hold" kutusunda cikan yaziyi yazdirin
        System.out.println(clickandHold.getText());
        // 8. "Double click me" butonunu cift tiklayin
        WebElement doubleClickButonu=driver.findElement(By.id("double-click"));
        actions.doubleClick(doubleClickButonu).perform();



    }

}
