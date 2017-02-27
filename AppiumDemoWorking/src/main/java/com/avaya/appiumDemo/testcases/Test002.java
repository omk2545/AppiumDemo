package com.avaya.appiumDemo.testcases;

import com.avaya.appiumDemo.pages.BaseActivityPage;
import com.avaya.appiumDemo.pages.DailingScreenPage;
import com.avaya.appiumDemo.testcases.basetest.BaseTest;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.annotations.Test;

/**
 * Created by okulkarni on 10/20/2016.
 */
public class Test002 extends BaseTest {

    @Test
    public void test002(){
        test = extentReports.startTest("Omkar Test002");
        // launchApp();
        BaseActivityPage baseActivityPage = new BaseActivityPage(driver,test);


        DailingScreenPage dailingScreenPage = baseActivityPage.gotoDailingPage();
        dailingScreenPage.Dailnumber(2228);

        test.log(LogStatus.PASS,"Called Successfully");



    }
}
