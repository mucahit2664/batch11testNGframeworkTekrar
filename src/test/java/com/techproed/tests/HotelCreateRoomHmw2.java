package com.techproed.tests;

import com.techproed.pages.CrstalHotelRoomPage;
import com.techproed.utulities.ConfigReader;
import com.techproed.utulities.Driver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class HotelCreateRoomHmw2 {
    //1. Tests packagenin altına class olusturun: HotelRoomCreation
    //2. Bir metod olusturun: RoomCreateTest()
    //3. qa-environment.crystalkeyhotels.com adresine gidin.
    //4. Username textbox ve password metin kutularını locate edin ve aşağıdaki
    //verileri girin.
    //a. Username : manager2 b. Password : Man1ager2!
    //5. Login butonuna tıklayın.
    //6. Hotel Management menusunden Add Hotelroom butonuna tıklayın.
    //7. Açılan sayfadaki tüm metin kutularına istediğiniz verileri girin.
    //8. Save butonuna basin.
    //9. "HotelRoom was inserted successfully" textinin göründüğünü test edin.
    //10. OK butonuna tıklayın.
    //11. Hotel rooms linkine tıklayın.
    //12. "LIST OF HOTELROOMS" textinin göründüğünü doğrulayın..
    @Test
    public void test() throws InterruptedException {
        CrstalHotelRoomPage crstalHotelRoomPage = new CrstalHotelRoomPage();
        Thread.sleep(5000);
        Driver.getDriver().get(ConfigReader.getProperty("c_url"));
        crstalHotelRoomPage.ilkLoginButonu.click();
        crstalHotelRoomPage.usernameTextBox.sendKeys(ConfigReader.getProperty("valid_user"));
        crstalHotelRoomPage.passwordTextBox.sendKeys(ConfigReader.getProperty("valid_password"));
        crstalHotelRoomPage.ikinciLoginButonu.click();
        crstalHotelRoomPage.hotelManagementClick.click();
        crstalHotelRoomPage.hotelRoomClick.click();
        crstalHotelRoomPage.addHotelClick.click();
        Select select = new Select(crstalHotelRoomPage.hotelDropDown);
        select.selectByIndex(1);
        Thread.sleep(10000);
        crstalHotelRoomPage.nameTextBox.sendKeys(ConfigReader.getProperty("name"));
        crstalHotelRoomPage.locationTextBox.sendKeys(ConfigReader.getProperty("location"));
        crstalHotelRoomPage.descriptionTextBox.sendKeys(ConfigReader.getProperty("description"));
        /*Actions actions=new Actions(Driver.getDriver());
        actions.click(crstalHotelRoomPage.codeTextBox).sendKeys("0101")
                .sendKeys(Keys.TAB)
                .sendKeys("oda1")
                .sendKeys(Keys.TAB)
                .sendKeys("istanbul")
                .sendKeys(Keys.PAGE_DOWN)
                .sendKeys("aile icindir.")
                //.sendKeys(Keys.TAB).sendKeys("200").perform();*/
        Actions actions = new Actions(Driver.getDriver());
        actions.dragAndDrop(crstalHotelRoomPage.tasinacakElement, crstalHotelRoomPage.hedefTextBox).perform();
        Select select1 = new Select(crstalHotelRoomPage.roomTypeDropDown);
        select1.selectByIndex(1);
        Thread.sleep(1000);
        crstalHotelRoomPage.maxAdult.sendKeys(ConfigReader.getProperty("max_Adult"));
        crstalHotelRoomPage.maxChild.sendKeys(ConfigReader.getProperty("max_Child"));
        crstalHotelRoomPage.approved.click();
        crstalHotelRoomPage.save.click();
        Driver.closeDriver();
    }
}