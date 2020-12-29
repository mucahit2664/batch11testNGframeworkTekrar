package com.techproed.pages;

import com.techproed.utulities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class CrstalHotelRoomPage {

        public CrstalHotelRoomPage() {
            PageFactory.initElements(Driver.getDriver(), this);
        }

        @FindBy(linkText = "Log in")
        public WebElement ilkLoginButonu;
        @FindBy(id = "UserName")
        public WebElement usernameTextBox;
        @FindBy(id = "Password")
        public WebElement passwordTextBox;
        @FindBy(id = "btnSubmit")
        public WebElement ikinciLoginButonu;
        @FindBy(xpath = "//*[text()='Hotel Management']")
        public WebElement hotelManagementClick;
        @FindBy(partialLinkText = "Hotel Rooms")
        public WebElement hotelRoomClick;
        @FindBy(xpath = "//*[text()='Add Hotelroom ']")
        public WebElement addHotelClick;
        @FindBy(id = "IDHotel")
        public WebElement hotelDropDown;
        @FindBy(id = "Code")
        public WebElement codeTextBox;
        @FindBy(xpath = "//li[@data-id='500']")
        public WebElement tasinacakElement;
        @FindBy(xpath = "//input[@id='Price']")
        public WebElement hedefTextBox;
        @FindBy(id = "IDGroupRoomType")
        public WebElement roomTypeDropDown;
        @FindBy(xpath = "//input[@id='IsAvailable']")
        public WebElement approved;
        @FindBy(id = "MaxAdultCount")
        public WebElement maxAdult;
        @FindBy(id = "MaxChildCount")
        public WebElement maxChild;
        @FindBy(id = "btnSubmit")
        public WebElement save;
        @FindBy(xpath = "//input[@id='Name']")
        public WebElement nameTextBox;
        @FindBy(id = "Location")
        public WebElement locationTextBox;
        @FindBy(xpath = "//textarea[@dir='ltr']")
        public WebElement descriptionTextBox;
    }
