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

public class D12_IFrameTest {
    /*  ● https://the-internet.herokuapp.com/iframe adresine gidin.
             ● Bir metod olusturun: iframeTest
    //      ○ “An IFrame containing….” textinin ulasilabilir oldugunu dogrulayin ve yazdirin
//dogrulayin dedgimiz icin sofassert kullandik
  ○ Text Box’a “Merhaba Dunya!” yazin.
  ○ TextBox’in altinda bulunan “Elemental Selenium” linkini textini konsolda  yazdirin.

 */
    WebDriver driver;

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test
    public void iframeTEST() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/iframe ");
        //      ○ “An IFrame containing….” textinin ulasilabilir oldugunu dogrulayin ve yazdirin
//dogrulayin dedgimiz icin sofassert kullandik
        SoftAssert softAssert=new SoftAssert();
        WebElement anIFrameYazisiElementi=driver.findElement(By.tagName("h3"));
        softAssert.assertTrue(anIFrameYazisiElementi.isEnabled());
        System.out.println(anIFrameYazisiElementi.getText());
        //su an iframe gectik
        driver.switchTo().frame("mce_0_ifr");
      //  ○ Text Box’a “Merhaba Dunya!” yazin.
WebElement textBox=driver.findElement(By.tagName("p"));
textBox.clear();
textBox.sendKeys("Merhaba Dunya!");
// TextBox’in altinda bulunan “Elemental Selenium” linkini textini konsolda  yazdirin.
        //iframe geri gelcegiz
        Thread.sleep(5000);
       driver.switchTo().defaultContent();
       WebElement elementalElementYazisi=driver.findElement(By.linkText("Elemental Selenium"));
       softAssert.assertTrue(elementalElementYazisi.isDisplayed());
        System.out.println(elementalElementYazisi.getText());

        softAssert.assertAll();
    }

    @AfterClass
    public void tearDown() {
        driver.close();

    }
}