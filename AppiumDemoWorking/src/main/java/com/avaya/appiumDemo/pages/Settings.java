package com.avaya.appiumDemo.pages;

import com.avaya.appiumDemo.base.PageActivity;
import com.gargoylesoftware.htmlunit.ElementNotFoundException;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by okulkarni on 10/27/2016.
 */
public class Settings extends PageActivity {

    public Settings(AndroidDriver driver, ExtentTest test) {
        super(driver, test);
    }

 AndroidElement  accounts_text_box;
 AndroidElement  IncomingScreen;
 AndroidElement  answercallButton;
 AndroidElement  ignoreCallButton;
 AndroidElement  done_toolbar;
 AndroidElement  extntion_text;
 AndroidElement  extnt_pass;
 AndroidElement  connectBtn;
 AndroidElement back_btn;

public void setAccount(String extn) throws InterruptedException {

//    test.log(LogStatus.INFO,"");
//
//    boolean isCallArriving ;
//
//    try {
//        Thread.sleep(5000);
//    } catch (InterruptedException e) {
//        e.printStackTrace();
//    }
//    try {
//       IncomingScreen = (AndroidElement) driver.findElement(By.id("incoming_call_title"));
//       isCallArriving =true;
//    }catch (ElementNotFoundException e){
//        isCallArriving =false;
//        e.printStackTrace();
//        test.log(LogStatus.FAIL,"Call Not received");
//    }
//
//    if(isCallArriving){
//
//        answercall(false);
//        try {
//
//            WebDriverWait wait = new WebDriverWait(driver,50);
//
//
//
//            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.TextView[@text='Done']")));
//            done_toolbar = (AndroidElement) driver.findElement(By.xpath("//android.widget.TextView[@text='Done']"));
//
//
//            done_toolbar.click();
//
//        }catch (Exception e){
//            test.log(LogStatus.FAIL,"Not able to land on the setting tab again"+e.getStackTrace().toString());
//            e.printStackTrace();
//        }
//
//
//    }else{

        test.log(LogStatus.INFO,"Setting account");

    try {
        Thread.sleep(5000);
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
    accounts_text_box = (AndroidElement) driver.findElement(By.xpath("//android.widget.TextView[@text='Accounts']"));

        accounts_text_box.click();

   extntion_text = (AndroidElement) driver.findElement(By.id("voip_service_username"));
   extnt_pass= (AndroidElement) driver.findElement(By.id("voip_service_password"));
    connectBtn= (AndroidElement) driver.findElement(By.id("voip_service_connect_button"));
    back_btn= (AndroidElement) driver.findElement(By.id("toolbar_up"));

    extntion_text.clear();
    extntion_text.sendKeys(extn);


extnt_pass.sendKeys("123456");

connectBtn.click();

back_btn.click();

    Thread.sleep(1000);

    done_toolbar = (AndroidElement) driver.findElement(By.xpath("//android.widget.TextView[@text='Done']"));

            done_toolbar.click();


    //}


//    if(IncomingScreen.isDisplayed()){
//
//
//    }




}

public void answercall(boolean answer){
    WebDriverWait wait = new WebDriverWait(driver,30);
if(answer){
answercallButton = (AndroidElement) driver.findElement(By.id("answer_audio_button"));
    wait.until(ExpectedConditions.visibilityOf(answercallButton));
answercallButton.click();
}else {

    ignoreCallButton = (AndroidElement) driver.findElement(By.id("ignore_button"));
    ignoreCallButton.click();


}

}


}
