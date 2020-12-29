package com.techproed.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class D10_DropDownTest {
    //1. “http://zero.webappsecurity.com/” Adresine gidin
    //2. Sign in butonuna basin
    //3. Login kutusuna “username” yazin
    //4. Password kutusuna “password.” yazin
    //5. Sign in tusuna basin
    //6. Pay Bills sayfasina gidin
    //7. “Purchase Foreign Currency” tusuna basin
    //8. “Currency” drop down menusunden Eurozone’u secin
    //9. “amount” kutusuna bir sayi girin
    //10. “US Dollars” in secilmedigini test edin
    //11. “Selected currency” butonunu secin
    //12. “Calculate Costs” butonuna basin sonra “purchase” butonuna basin
    //13. “Foreign currency cash was successfully purchased.” yazisinin ciktigini
    //control edin.
    WebDriver driver;

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test
    public void webappsecurityTest() {
        //1. “http://zero.webappsecurity.com/” Adresine gidin

        driver.get("http://zero.webappsecurity.com/");
        // 2. Sign in butonuna basin
        driver.findElement(By.id("signin_button")).click();
        // 3. Login kutusuna “username” yazin
        WebElement userNameBox = driver.findElement(By.id("user_login"));
        userNameBox.sendKeys("username");
        // 4. Password kutusuna “password” yazin
        WebElement paswordBox = driver.findElement(By.id("user_password"));
        paswordBox.sendKeys("password");
        // 5. Sign in tusuna basin
        driver.findElement(By.name("submit")).click();
        // 6. Pay Bills sayfasina gidin
        driver.findElement(By.linkText("Pay Bills")).click();
        // 7. “Purchase Foreign Currency” tusuna basin
        driver.findElement(By.linkText("Purchase Foreign Currency")).click();
        // 8. “Currency” drop down menusunden Eurozone’u secin

        WebElement dropDown = driver.findElement(By.id("pc_currency"));
        Select select = new Select(dropDown);
        select.selectByVisibleText("Eurozone (euro)");

        // 9.“amount” kutusuna bir sayi girin
        WebElement amountBox = driver.findElement(By.id("pc_amount"));
        amountBox.sendKeys("100");


        String dropdownSeciliOpsiyon = select.getFirstSelectedOption().toString();
        Assert.assertFalse(dropdownSeciliOpsiyon.equals("US Dollars"));

        // 11. “Selected currency” butonunu secin
        driver.findElement(By.id("pc_inDollars_false")).click();

        // 12.“Calculate Costs” butonuna basin sonra “purchase” butonuna basin
        driver.findElement(By.id("pc_calculate_costs")).click();
        driver.findElement(By.id("purchase_cash")).click();

        // 13.“Foreign currency cash was successfully purchased.” yazisinin ciktigini control edin.
        WebElement sonucYAZISIElementi = driver.findElement(By.id("alert_content"));
        String sonucYaazisi = sonucYAZISIElementi.getText();
        Assert.assertEquals(sonucYaazisi, "Foreign currency cash was successfully purchased.");


    }

    @AfterClass
    public void tearDown() {


        driver.close();
    }
}