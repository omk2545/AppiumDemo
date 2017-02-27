package com.avaya.appiumDemo.testcases.elan;

import com.avaya.appiumDemo.base.TestBase;
import com.avaya.appiumDemo.helper.Helper;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import io.appium.java_client.android.AndroidDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by okulkarni on 1/3/2017.
 */
public class SequentialCalls extends TestBase {


    AndroidDriver device2;
    AndroidDriver device1;
    ExtentTest test;
    Helper helper_device1, helper_device2;


    @BeforeMethod
    public void init() throws Exception {


        String device1_Ip =  "148.147.201.91";

        String device2_ip = "148.147.195.53";


        test = createTest("Make Sequential Calls ");

        test.log(LogStatus.INFO, "Create Instances");
        //device1  = createDeviceInstance("4736","148.147.195.53:5555","com.android.launcher3");

        device1  = createDeviceInstance("4736",device1_Ip +
                ":5555","com.android.launcher3");
        helper_device1 = new Helper(device1,test);

        device2  = createDeviceInstance("4738",device2_ip +
                ":5555","com.android.launcher3");

        helper_device1 = new Helper(device1,test);
        helper_device2 = new Helper(device2,test);

    }

    @Test
    public void testSequentialCalls() throws Exception  {


helper_device1.openLauncher( Helper.ApplicationName.ELAN);
helper_device2.openLauncher(Helper.ApplicationName.ELAN);

        for(int i = 1;i<=500; i++) {

            test.log(LogStatus.PASS,"Iteration Number "+i);

            helper_device1.redail();

            helper_device2.answerElanCall();

            helper_device1.endCurrentcall();


        }








    }



    @AfterMethod
    public void TearDown(ITestResult result) {


        if (result.getStatus() == ITestResult.FAILURE) {
            test.log(LogStatus.FAIL, "Test Failed");
            helper_device2.takeScreenShot();
            helper_device1.takeScreenShot();
            extentReports.flush();
        } else {

            test.log(LogStatus.PASS, "Test Case Pass");
            extentReports.flush();
        }


        System.out.println("Closing Instances ");

        device1.quit();
        device2.quit();
        extentReports.endTest(test);
        extentReports.flush();


    }
}