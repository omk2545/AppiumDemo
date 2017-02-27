package com.avaya.appiumDemo.pages;

import com.avaya.appiumDemo.base.PageActivity;
import com.avaya.appiumDemo.pages.ElanA.HomePageElan;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;

/**
 * Created by okulkarni on 11/10/2016.
 */
public class LauncherActivity extends PageActivity {
    public LauncherActivity(AndroidDriver driver, ExtentTest test) {
        super(driver, test);
    }




    public void openLauncher(){
        test.log(LogStatus.INFO,"Opening menu ");
        AndroidElement menuBtn = (AndroidElement) driver.findElement(By.xpath("//android.widget.TextView[@content-desc='Apps']"));

        menuBtn.click();

        try {
            Thread.sleep(600);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

//        AndroidElement eqinox = (AndroidElement) driver.findElement(By.xpath("//android.widget.TextView[@content-desc='Avaya Equinox']"));
//
//        eqinox.click();


    }



    public HomePageElan OpenElan(){



AndroidElement elanAppIcon = (AndroidElement) driver.findElement(By.xpath("//android.widget.TextView[@content-desc='Avaya Vantage™ Light']"));

elanAppIcon.click();

        HomePageElan pageElan = new HomePageElan(driver,test);
        return  pageElan;


    }


}
