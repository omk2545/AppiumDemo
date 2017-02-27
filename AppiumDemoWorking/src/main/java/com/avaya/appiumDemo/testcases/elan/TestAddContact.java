package com.avaya.appiumDemo.testcases.elan;

import com.avaya.appiumDemo.helper.Helper;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import io.appium.java_client.android.AndroidDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.avaya.appiumDemo.base.TestBase;

/**
 * Created by okulkarni on 12/29/2016.
 */
public class TestAddContact extends TestBase {
    AndroidDriver device2;
    AndroidDriver device1;
    ExtentTest test;
Helper helper;
    @BeforeMethod
    public void init() throws  Exception {

        device2 = createDeviceInstance("4740", "148.147.195.173:5555", "com.android.launcher3");
        test = createTest("Make Miss call ");
        helper = new Helper(device2,test);


    }


    @Test
    public void testRoughTest() throws Exception {


        // ExtentTest test = createTest("TestOmkar");
//    ExtentTest test1 = createTest("Device 2");
     //   test.log(LogStatus.INFO, "Creating a Instances ");

        //   device1  = createDeviceInstance("4726","148.147.153.141:5555","com.android.launcher3");


     //   device2 = createDeviceInstance("4736", "148.147.195.53:5555", "com.android.launcher3");

        //pressint(device1);


        // openLauncher(device1);
        test.log(LogStatus.INFO, "Opening launcher ");

        helper.openLauncher(Helper.ApplicationName.ELAN);
        helper.makeElanAudioCall(4223);

       // helper.openLauncher(ApplicationName.ELAN,test);
        //  test.log(LogStatus.INFO,"Opening Launcher ");


        //  Helper helper = new Helper();
//        for (int i = 0; i <= 200; i++) {
//
//            test.log(LogStatus.PASS,"Iteatrion number "+i);
//
//            helper.redail();
//
//            helper.endCurrentcall();
//        }

    }


    @AfterMethod
public void cleanup(ITestResult result){



        if (result.getStatus() == ITestResult.FAILURE) {


            test.log(LogStatus.FAIL,"Test Failed");
            helper.take_ScreenShot();

        }else{

            test.log(LogStatus.PASS,"Test Case Pass");

        }






//        if(device1 != null){
//            device1.quit();
//        }
//

        if(device2 != null){
            device2.quit();
        }

//        device2.quit();
        extentReports.endTest(test);

        System.out.println("All test calculated and run " +
                "");
        extentReports.flush();


    }


}