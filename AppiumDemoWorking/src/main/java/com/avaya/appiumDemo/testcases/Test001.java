package com.avaya.appiumDemo.testcases;

import com.avaya.appiumDemo.pages.BaseActivityPage;
import com.avaya.appiumDemo.pages.DailingScreenPage;
import com.avaya.appiumDemo.pages.Settings;
import com.avaya.appiumDemo.testcases.basetest.BaseTest;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.util.List;
import java.util.logging.Level;

/**
 * Created by okulkarni on 10/17/2016.
 */
public class Test001 extends BaseTest {

ExtentTest test;
    @Test
    public void test_TestCallNumber() throws MalformedURLException, InterruptedException {

        test = extentReports.startTest("Omkar Test");
       // launchApp();
        BaseActivityPage baseActivityPage = new BaseActivityPage(driver,test);

        Settings settings = baseActivityPage.gotoSetteings();
        settings.setAccount("4213");













//        for (int i =0;i<5;i++) {
//
//
//            DailingScreenPage dailingScreenPage = baseActivityPage.gotoDailingPage();
//            dailingScreenPage.Dailnumber(4990);
//
//            test.log(LogStatus.PASS,"Called Successfully");
//        }
//        DailingScreenPage dailingScreenPage = baseActivityPage.gotoDailingPage();
//        dailingScreenPage.Dailnumber(4990);
//
//        test.log(LogStatus.PASS,"Called Successfully");


//        AndroidElement dailpadbtn = (AndroidElement) driver.findElement(By.id("homeDialpadButton"));
//
//        dailpadbtn.click();
//
//        AndroidElement number_1 = (AndroidElement) driver.findElement(By.id("dialpad_one"));
//        AndroidElement number_2 = (AndroidElement) driver.findElement(By.id("dialpad_two"));
//        AndroidElement number_3 = (AndroidElement) driver.findElement(By.id("dialpad_three"));
//        AndroidElement number_4 = (AndroidElement) driver.findElement(By.id("dialpad_four"));
//        AndroidElement number_5 = (AndroidElement) driver.findElement(By.id("dialpad_five"));
//        AndroidElement number_6 = (AndroidElement) driver.findElement(By.id("dialpad_six"));
//        AndroidElement number_7 = (AndroidElement) driver.findElement(By.id("dialpad_seven"));
//        AndroidElement number_8 = (AndroidElement) driver.findElement(By.id("dialpad_eight"));
//        AndroidElement number_9 = (AndroidElement) driver.findElement(By.id("dialpad_nine"));
//        AndroidElement number_0 = (AndroidElement) driver.findElement(By.id("dialpad_zero"));
//
//        number_9.click();
//        number_8.click();
//        number_2.click();
//        number_2.click();
//        number_6.click();
//        number_4.click();
//        number_4.click();
//        number_4.click();
//        number_1.click();
//        number_3.click();
//        AndroidElement call_button = (AndroidElement) driver.findElement(By.id("dialpad_call"));
//        call_button.click();

//    extentReports.endTest(test);
//    extentReports.flush();
   }

@AfterMethod
public void exit(){
    List<LogEntry> logEntries = driver.manage().logs().get("logcat").filter(Level.ALL);
    System.out.println(logEntries);
}

}
