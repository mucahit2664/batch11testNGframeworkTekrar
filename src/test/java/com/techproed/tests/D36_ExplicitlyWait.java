package com.techproed.tests;

import com.techproed.utulities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class D36_ExplicitlyWait extends TestBase {
    @Test
    public void test1() throws InterruptedException {

        //https://demoqa.com/browser-windows adresine gidin
        driver.get("https://demoqa.com/browser-windows");
        //Alerts’e tiklayin
        driver.findElement(By.xpath("(//li[@id='item-1'])[2]")).click();
        Actions actions=new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        //On button click, alert will appear after 5 seconds karsisindaki click me butonuna basin
        driver.findElement(By.id("timerAlertButton")).click();
        //Allert’in gorunur olmasini bekleyin
        WebDriverWait wait=new WebDriverWait(driver,20);
        wait.until(ExpectedConditions.alertIsPresent());
        //Allert uzerindeki yazinin “This alert appeared after 5 seconds” oldugunu test edin
        String alertYazisi=driver.switchTo().alert().getText();
        Assert.assertEquals(alertYazisi,"This alert appeared after 5 seconds");
        //Ok diyerek alerti kapatin
        driver.switchTo().alert().accept();
    }
    @Test
    public void test2(){
//https://demoqa.com/dynamic-properties adresine gidin
        driver.get("https://demoqa.com/dynamic-properties");
        //“Will enable 5 seconds” butonunun enable olmasini bekleyin
        WebDriverWait wait=new WebDriverWait(driver,20);
       // WebElement enableafter=wait.until(ExpectedConditions.elementToBeClickable(By.id("'enableAfter']")));
        //2.couzm
        WebElement enableafter=driver.findElement(By.id("enableAfter"));
        wait.until(ExpectedConditions.elementToBeClickable(enableafter));
        //“Will enable 5 seconds” butonunun enable oldugunu test edin
        Assert.assertTrue(enableafter.isEnabled());
    }

    @Test
    public void test3(){
        //visibleAfter
        //https://demoqa.com/dynamic-properties adresine gidin
        driver.get("https://demoqa.com/dynamic-properties");
        //“Visible After 5 seconds” butonunun gorunur olmasini bekleyin
        WebDriverWait wait=new WebDriverWait(driver,20);
        WebElement sonradanCikan=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("visibleAfter")));
        Assert.assertTrue(sonradanCikan.isDisplayed());
    }
    @Test
    public void test4(){
        //https://the-internet.herokuapp.com/add_remove_elements/ adresine gidin
        driver.get("https://the-internet.herokuapp.com/add_remove_elements/");
        //“Add Element” butona basin
        driver.findElement(By.xpath(" //*[text()='Add Element']")).click();
        //“Delete” butonu gorunur oluncaya kadar bekleyin
        WebDriverWait wait=new WebDriverWait(driver,20);
        WebElement delete=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Delete']")));
        Assert.assertTrue(delete.isDisplayed());
        //delete butonun basin ve silin
        delete.click();
      //  Assert.assertFalse(delete.isDisplayed());
    }
}
