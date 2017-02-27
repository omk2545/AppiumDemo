package com.avaya.appiumDemo.testcases.elan.ElanRegression;

import com.avaya.appiumDemo.base.TestBase;
import com.avaya.appiumDemo.helper.Helper;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import io.appium.java_client.android.AndroidDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by okulkarni on 1/12/2017.
 */
public class Elan_3_devices_Tests extends TestBase {


    AndroidDriver device2;
    AndroidDriver device3;
    AndroidDriver device1;
public int exten1 = 4214;
public int exten2 = 4223;
public int exten3 = 4213;


    ExtentTest test;
    Helper helper_device1, helper_device2,helper_device3;

    @BeforeMethod
    public void init() throws Exception {

        test = createTest("Make Sequential Calls ");

        test.log(LogStatus.INFO, "Create Instances");

        device1  = createDeviceInstance("4736","172.16.4.200:5555","com.android.launcher3");
        helper_device1 = new Helper(device1,test);

        device2  = createDeviceInstance("4737","172.16.4.202:5555","com.android.launcher3");
        helper_device2 = new Helper(device2,test);

        device3  = createDeviceInstance("4738","172.16.4.212:5555","com.android.launcher3");
        helper_device3 = new Helper(device3,test);







        // device2  = createDeviceInstance("4726","148.147.201.72:5555","com.android.launcher3");

    }

    @Test
    public void testTransferCall() throws Exception {

        helper_device1.openLauncher(Helper.ApplicationName.ELAN);

        helper_device2.openLauncher(Helper.ApplicationName.ELAN);

        helper_device3.openLauncher(Helper.ApplicationName.ELAN);

        helper_device1.makeElanVideoCall(exten2);

        helper_device2.answerElanCall();

        helper_device1.endCurrentcall();
    }

    @AfterMethod
    public void teardDown(){

        device1.quit();
        device2.quit();
        device3.quit();

    }







}
