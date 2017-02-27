package com.avaya.appiumDemo.pages;

import com.avaya.appiumDemo.base.PageActivity;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;

/**
 * Created by okulkarni on 10/17/2016.
 */
public class BaseActivityPage extends PageActivity {

    AndroidElement dailpadbtn ;

    public BaseActivityPage(AndroidDriver driver, ExtentTest test) {
        super(driver,test);
    }

    //AndroidElement menuBtn = (AndroidElement) driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc='Open Navigation Drawer']"));



public Settings gotoSetteings(){
   AndroidElement menuBtn = (AndroidElement) driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc='Open Navigation Drawer']"));

    menuBtn.click();

    AndroidElement settingsIcon = (AndroidElement) driver.findElement(By.id("nav_header_settings"));

    try {
        Thread.sleep(500);
    } catch (InterruptedException e) {
        e.printStackTrace();
    }

    settingsIcon.click();
    Settings settings = new Settings(driver,test);
    return settings;

}

    public DailingScreenPage gotoDailingPage(){

        test.log(LogStatus.INFO,"Finding Dial-pad button");
        dailpadbtn = (AndroidElement) driver.findElement(By.id("homeDialpadButton"));
        dailpadbtn.click();
        test.log(LogStatus.INFO,"Clicked Button DialPad ");
        takeScreenShot();

        DailingScreenPage dailingScreenPage = new DailingScreenPage(driver,test);
//        PageFactory.initElements(driver,dailingScreenPage);

        return  dailingScreenPage;
    }




}
