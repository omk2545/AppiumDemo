package com.avaya.appiumDemo.testcases.basetest;

import com.avaya.appiumDemo.utils.ExtentManager;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

/**
 * Created by okulkarni on 10/17/2016.
 */
public class BaseTest {

    public ExtentReports extentReports;
    public ExtentTest test;
    public void init(){

    }

    public  AndroidDriver driver;
@BeforeMethod
@Parameters("port")
    public void launchApp() throws MalformedURLException {


        System.out.println("Inside Base test");

        extentReports = ExtentManager.getInstance();
        DesiredCapabilities capabilities = new DesiredCapabilities();

        // Set android deviceName desired capability. Set it Android Emulator.
//        capabilities.setCapability("deviceName", "148.147.154.52:5555");
        capabilities.setCapability("deviceName", "172.16.10.202:5555");

        // Set browserName desired capability. It's Android in our case here.
        capabilities.setCapability("browserName", "Android");

        // Set android platformVersion desired capability. Set your emulator's android version.
        capabilities.setCapability("platformVersion", "6.0.1");

        // Set android platformName desired capability. It's Android in our case here.
        capabilities.setCapability("platformName", "Android");

        // Set android appPackage desired capability. It is com.android.calculator2 for calculator application.
        // Set your application's appPackage if you are using any other app.
        capabilities.setCapability("appPackage", "com.avaya.android.flare");



        // Set android appActivity desired capability. It is com.android.calculator2.Calculator for calculator application.
        // Set your application's appPackage if you are using any other app.
        capabilities.setCapability("appActivity", "com.avaya.android.flare.MainActivity");
    capabilities.setCapability("no-reset", "true");
    capabilities.setCapability("full-reset", "false");

        driver = new AndroidDriver(new URL("http://127.0.0.1:4725/wd/hub"), capabilities);


    try {
        Thread.sleep(5000);
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
 //   driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);


    }

    @AfterMethod
    public void exitApp(){

        try {

            Thread.sleep(50000);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        extentReports.endTest(test);
        extentReports.flush();
        driver.quit();



    }
}
