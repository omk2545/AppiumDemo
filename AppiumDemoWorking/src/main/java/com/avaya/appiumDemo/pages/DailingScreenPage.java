package com.avaya.appiumDemo.pages;

import com.avaya.appiumDemo.base.PageActivity;
import com.avaya.appiumDemo.helper.Constants;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.sun.xml.internal.fastinfoset.stax.events.StAXEventWriter;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;

/**
 * Created by okulkarni on 10/17/2016.
 */
public class DailingScreenPage  extends PageActivity{
    public DailingScreenPage(AndroidDriver driver, ExtentTest test) {
        super(driver,test);
    }

    AndroidElement number_1;
    AndroidElement number_2;
    AndroidElement number_3;
    AndroidElement number_4;
    AndroidElement number_5;
    AndroidElement number_6;
    AndroidElement number_7;
    AndroidElement number_8;
    AndroidElement number_9;
    AndroidElement number_0;
AndroidElement End_Call_BTN ;


public void Dailnumber(int  num){


String number = String.valueOf(num);

char[] digits1 = number.toCharArray();





number_1 = (AndroidElement) driver.findElement(By.xpath(Constants.dailingscreenPage_number_1));
number_2 = (AndroidElement) driver.findElement(By.xpath(Constants.dailingscreenPage_number_2));
number_3 = (AndroidElement) driver.findElement(By.xpath(Constants.dailingscreenPage_number_3));
number_4 = (AndroidElement) driver.findElement(By.xpath(Constants.dailingscreenPage_number_4));
number_5 = (AndroidElement) driver.findElement(By.xpath(Constants.dailingscreenPage_number_5));
number_6 = (AndroidElement) driver.findElement(By.xpath(Constants.dailingscreenPage_number_6));
number_7 = (AndroidElement) driver.findElement(By.xpath(Constants.dailingscreenPage_number_7));
number_8 = (AndroidElement) driver.findElement(By.xpath(Constants.dailingscreenPage_number_8));
number_0 = (AndroidElement) driver.findElement(By.xpath(Constants.dailingscreenPage_number_0));
number_9 = (AndroidElement) driver.findElement(By.xpath(Constants.dailingscreenPage_number_9));

//    number_9.click();
//
//    number_8.click();
//    number_2.click();
//    number_2.click();
//    number_6.click();
//    number_4.click();
//    number_4.click();
//    number_4.click();
//
//    number_3.click();

for (int i = 0; i < digits1.length; i++) {

pressNumber(digits1[i]);

}

    test.log(LogStatus.INFO,"Finding and clicking the numbers ");
    AndroidElement call_button = (AndroidElement) driver.findElement(By.id("dialpad_call"));
    call_button.click();

    test.log(LogStatus.INFO,"Element is "+call_button);
    test.log(LogStatus.INFO,"Clicking on call button ");
    try {
        Thread.sleep(500);
    } catch (InterruptedException e) {
        e.printStackTrace();
    }


//endCurrentcall();

}


public void endCurrentcall(){

    End_Call_BTN = (AndroidElement) driver.findElement(By.id("active_call_end_call"));
    test.log(LogStatus.INFO,"Call placed Successfully ");

    test.log(LogStatus.INFO,"Call end btn found on screen ");
    test.log(LogStatus.INFO,"Ending Current on going call ");

    End_Call_BTN.click();

    test.log(LogStatus.INFO,"Call ended Successfully");

}

public  void  pressNumber(char num){


    switch(num){
        case '1':
            number_1.click();
            test.log(LogStatus.INFO,"Clicking number"+1);
            break;
        case '2':
            number_2.click();
            test.log(LogStatus.INFO,"Clicking number"+2);
            break;
        case '3':
            number_3.click();
            test.log(LogStatus.INFO,"Clicking number"+3);
            break;
        case '4':
            number_4.click();
            test.log(LogStatus.INFO,"Clicking number"+4);
            break;

        case '5':
            number_5.click();
            test.log(LogStatus.INFO,"Clicking number"+5);
            break;
        case '6':
            number_6.click();
            test.log(LogStatus.INFO,"Clicking number"+6);
            break;
       case '7':
            number_7.click();
            test.log(LogStatus.INFO,"Clicking number"+7);
            break;
       case '8':
            number_8.click();
            test.log(LogStatus.INFO,"Clicking number"+8);
            break;
       case '9':
            number_9.click();
            test.log(LogStatus.INFO,"Clicking number"+9);
            break;
       case '0':
            number_0.click();
            test.log(LogStatus.INFO,"Clicking number"+0);
            break;
    }


}




}
