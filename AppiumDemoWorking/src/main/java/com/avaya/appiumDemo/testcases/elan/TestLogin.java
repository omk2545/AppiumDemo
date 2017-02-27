package com.avaya.appiumDemo.testcases.elan;

import com.avaya.appiumDemo.base.TestBase;
import com.avaya.appiumDemo.helper.Helper;
import com.relevantcodes.extentreports.LogStatus;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by okulkarni on 1/4/2017.
 */
public class TestLogin extends TestBase{

    AndroidDriver device1;
    Helper helper_device1;;


    @BeforeMethod
    public void init() throws Exception {
        test = createTest("Test Login and Logout");
        String device_Ip = "172.16.4.202:5555";
        String portNo ="4736";


        test.log(LogStatus.INFO, "Create Instances");
        device1  = createDeviceInstance(portNo,device_Ip,"com.android.launcher3");
        helper_device1 = new Helper(device1,test);
       // device2  = createDeviceInstance("4726","148.147.201.72:5555","com.android.launcher3");

    }
@Test
public void countContacts() throws Exception {


    helper_device1.openLauncher(Helper.ApplicationName.ELAN);
    helper_device1.countLogs();
//helper_device1.countContacts();




    }

    //@Test
    public void testLockScreen() throws Exception {
//     device1.openNotifications();
//        Thread.sleep(5000);



        for(int i=0; i<10;i++) {

             try {

                  test.log(LogStatus.INFO,"iteration "+i);
                  helper_device1.logoutFromNotifications();

                  helper_device1.login("4214", "123456");
                  test.log(LogStatus.PASS,"Passed");

                 //helper_device1.logout();

                // helper_device1.openLauncher(Helper.ApplicationName.EQUINOX);

             }catch (Exception e){
                 helper_device1.takeScreenShot();
                 test.log(LogStatus.FAIL,"Failed");
                 helper_device1.login("4214","123456");


             }
                 // String extn =    helper_device1.getExtension();

            //   System.out.println(extn);

            // helper_device1.lockTheScreen();
        }

    }

    @AfterMethod
    public void tearDown(){

        device1.quit();
        extentReports.endTest(test);
        extentReports.flush();




    }


}



