package com.techproed.pages;

import com.techproed.utulities.Driver;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.w3c.dom.html.HTMLInputElement;

public class CkHotelsHomePage {



    public CkHotelsHomePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(linkText = "Log in")
    public WebElement ilkLogIn;
    @FindBy(id = "UserName")
    public WebElement userNameTextBox;
    @FindBy(id = "Password")
    public WebElement passwordTextBox;
    @FindBy(id = "btnSubmit")
    public WebElement loginButonu;
    @FindBy(xpath = "//div[@class='validation-summary-errors']")
    public WebElement girilemediYazisi;


}
