package com.avaya.appiumDemo.testcases.equinox;

import com.avaya.appiumDemo.base.TestBase;
import com.avaya.appiumDemo.helper.Helper;
import com.relevantcodes.extentreports.LogStatus;
import io.appium.java_client.android.AndroidDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by okulkarni on 1/10/2017.
 */




public class AddContactsEquinox extends TestBase {

    AndroidDriver device1;
    Helper helper_device1;;



    @BeforeMethod
    public void init() throws  Exception{
        test = createTest("Make Sequential Calls ");

        test.log(LogStatus.INFO, "Create Instances");
        device1  = createDeviceInstance("4739","148.147.195.223:5555","com.android.launcher3");
        helper_device1 = new Helper(device1,test);
    }

    @Test
    public void addContacts() throws Exception{
            helper_device1.openLauncher(Helper.ApplicationName.EQUINOX);
        helper_device1.gotoContacts_Equinox();

helper_device1.addEquinoxContacts("Omkar", "Avaya" , "4214");





    }

    @AfterMethod
    public void teardown(){

device1.quit();
        extentReports.endTest(test);
        extentReports.flush();



    }

}
