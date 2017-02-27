package com.avaya.appiumDemo.helper;


import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.relevantcodes.extentreports.model.Test;
import com.sun.corba.se.impl.transport.ByteBufferPoolImpl;
import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.AndroidKeyCode;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.FalseFileFilter;
import org.openqa.jetty.html.Break;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import sun.management.ThreadInfoCompositeData;

import java.io.File;
import java.io.IOException;
import java.util.*;

/**
 * Created by okulkarni on 12/20/2016.
 */
public class Helper {
    public AndroidDriver driver;
    Dimension size;
    public ExtentTest test;
    public Set<String> entries = new HashSet<String>();
    public Set<String> contactValues = new HashSet<String>();

    public Helper(AndroidDriver driver, ExtentTest test) {
        this.driver = driver;
        this.test = test;
    }

    public Helper() {
    }

    public String getExtension() throws Exception {

        AndroidElement extn_text = findByXpath(Constants.exen_text);
        return extn_text.getText();


    }

    public void gotoContacts_Equinox() throws Exception {

        AndroidElement menu_drawer = findByXpath("//android.widget.ImageButton[@content-desc='Open Navigation Drawer']");
        menu_drawer.click();

        AndroidElement contcts_icon = findByXpath("//android.widget.TextView[@text='Contacts']");
        contcts_icon.click();

    }

    public void addEquinoxContacts(String name, String lastname, String num) throws Exception {

        AndroidElement createContacts = findByXpath(Constants.add_contacts_btn);
        createContacts.click();

        AndroidElement newContactBtn = findByXpath(Constants.newContactBtn);
        newContactBtn.click();

        AndroidElement firstName = findByXpath(Constants.firstName_editTXT);
        AndroidElement lastName = findByXpath(Constants.lastName_editTXT);
        AndroidElement number = findByXpath(Constants.Number_editTXT);
        AndroidElement done = findByXpath(Constants.Done_btn);

        firstName.sendKeys(name);
        lastName.sendKeys(lastname);
        number.sendKeys(num);
        //     done.click();
    }

    public void logout() throws Exception {


        //swipingVertical();

        AndroidElement menu = findByXpath(Constants.launcher_Icon_Btn);
        menu.click();

        AndroidElement lououtApp = findByXpath(Constants.brio_logout_app);
        lououtApp.click();

        AndroidElement okayBtn = findByXpath(Constants.ok_alert);
        okayBtn.click();


    }

    public enum CALL_TYPE {

        INCOMING, OUTGOING, MISSED
    }

    public enum ApplicationName {

        ELAN, EQUINOX
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
    AndroidElement End_Call_BTN;
    AndroidElement call_button;
    AndroidElement answer_call_button;


    public void answerElanCall() throws Exception {

//        Thread.sleep(500);
//        WebDriverWait wait = new WebDriverWait(driver,500);

        //  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("incoming_unknown_dialog_accept")));


        // answer_call_button = (AndroidElement) driver.findElement(By.id("incoming_unknown_dialog_accept"));

//       answer_call_button = (AndroidElement) driver.findElement(By.xpath(/));

        answer_call_button = findByXpath(Constants.answer_call_btn);
        answer_call_button.click();


    }

    public AndroidElement findByXpath(String xpath) throws Exception {


        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));

        AndroidElement element = (AndroidElement) driver.findElement(By.xpath(xpath));

        if (element.isDisplayed()) {
            //  test.log(LogStatus.PASS,"Element is found: "+element);
            return element;
        } else {

            takeScreenShot();
            test.log(LogStatus.FAIL, "Element not found by XPath " + xpath);
            //throw new Exception("Element is not found ");


        }

        //return  element;

        return element;
    }


    public boolean verifyLogs(CALL_TYPE call_type) throws Exception {

        AndroidElement call_logs = findByXpath(Constants.elan_logs_tab);
        call_logs.click();

        AndroidElement all_logs_btn = findByXpath(Constants.all_logs_btn_elan);


        if (call_type.equals(CALL_TYPE.INCOMING)) {


        }

        return true;
    }


    public void addContact(AndroidDriver driver, ExtentTest test) throws Exception {

        WebDriverWait wait = new WebDriverWait(driver, 500);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.ImageView[@content-desc='Contacts']")));
        AndroidElement contactsMenu = (AndroidElement) driver.findElement(By.xpath("//android.widget.ImageView[@content-desc='Contacts']"));

        contactsMenu.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.ImageView[@content-desc='Add contact']")));

        AndroidElement createContactBtn = (AndroidElement) driver.findElement(By.xpath("//android.widget.ImageView[@content-desc='Add contact']"));

        createContactBtn.click();

        // waitForByxpath("//android.widget.EditText[@text='First name']");


        // AndroidElement firstName = (AndroidElement) driver.findElement(By.xpath("//android.widget.EditText[@text='First name']"));


        AndroidElement firstname_1 = findByXpath("//android.widget.EditText[@text='First name']");
        firstname_1.sendKeys("Automation" + randomString(4));

        driver.hideKeyboard();

        AndroidElement AddPhoneNumber_text = findByXpath("//android.widget.TextView[@text='Add phone number']");
        AddPhoneNumber_text.click();


        AndroidElement phoneNumber = findByXpath("//android.widget.EditText[@text='Phone']");
        phoneNumber.sendKeys(RandomInt(6));

        AndroidElement done_Btn = findByXpath("//android.widget.TextView[@text='Done']");
        done_Btn.click();


    }


    public void countContacts() throws Exception {

        getAllContacts();
        do{

            driver.swipe(400, 1034, 400, 600, 1000);

        }while (getAllContacts());

        System.out.println("number of contacts "+contactValues);
        System.out.println("number of contacts "+contactValues.size());
//        AndroidElement cointaier = findByXpath("//android.support.v4.view.ViewPager[@resource-id='com.avaya.android.vantage.basic:id/container']");
//
//        int count = 0;
//        if (cointaier.isDisplayed()) {
//
//            do {
//                List<WebElement> elements = cointaier.findElements(By.className("android.widget.LinearLayout"));
//                System.out.println(elements.size() + " == Length");
//                count = count + elements.size();
//                swipingVertical();
//                System.out.println(count);
//
//            } while (!isElementPresent());
//
//
//            System.out.println("Final Count" + count);


//        List<WebElement> elements = cointaier.findElements(By.className("android.widget.LinearLayout"));
//        System.out.println(elements.size() + " == Length");



    }


    public  boolean getAllContacts() throws Exception{

        String lastName ="tpawar4986 tpawar4986";
        boolean  isLastPresent = true;
        AndroidElement cointaier = findByXpath("//android.support.v7.widget.RecyclerView[@resource-id='com.avaya.android.vantage.basic:id/list']");
        // AndroidElement cointaier = driver.findElement();


        List<WebElement> logs = cointaier.findElements(By.className("android.widget.TextView"));


        logs.size();

        System.out.println("logs: " + logs.size());


        for (WebElement element : logs){

                 System.out.println(element.getText());


            String val = element.getText();
if (val.length()>2 ){
    contactValues.add(val);
}

if(val.equalsIgnoreCase(lastName)){
isLastPresent = false;
}

        }

        return isLastPresent;

    }


    public boolean logsCuttently() throws Exception {

      boolean  isLastPresent = true;
        AndroidElement cointaier = findByXpath("//android.support.v7.widget.RecyclerView[@resource-id='com.avaya.android.vantage.basic:id/list']");
        // AndroidElement cointaier = driver.findElement();


        List<WebElement> logs = cointaier.findElements(By.className("android.widget.TextView"));


        logs.size();

        System.out.println("logs: " + logs.size());


        for (WebElement element : logs){

       //     System.out.println(element.getText());

            String val = element.getText();
            if(val.contains("Today")){
                System.out.println("values are "+val);
                entries.add(val);
            }

            if (val.contains("10:34 AM")){

isLastPresent =false;
            }
//  String text  =          element.findElement(By.xpath("//android.widget.TextView[@index='2']")).getText();
//            System.out.println(text);
//            entries.add(text);
//

    }


        return isLastPresent;
    }
public void countLogs() throws Exception {

int count = 0;

logsCuttently();

    do{

        driver.swipe(400, 1034, 400, 600, 1000);

    }while (logsCuttently());


    System.out.println( "Entries are "+entries.size());

    }

    public boolean isElementPresent(){


        try{

            AndroidElement element =       findByXpath("//android.widget.TextView[@text ='Palsule rajiv']");
            return true;
        }catch (Exception e){

            return false;
        }

      //  return false ;

    }


    public void openLauncher( ApplicationName app ) throws  Exception{

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


     AndroidElement menuBtn =   findByXpath(Constants.launcher_Icon_Btn);
//        AndroidElement menuBtn = (AndroidElement) driver.findElement(By.xpath("//android.widget.TextView[@content-desc='Apps']"));

        menuBtn.click();


//        AndroidElement eqinox = (AndroidElement) driver.findElement(By.xpath("//android.widget.TextView[@content-desc='Avaya Equinox']"));
//
//        eqinox.click();

        if(app.equals(ApplicationName.ELAN)) {


            //AndroidElement elanAppIcon = (AndroidElement) driver.findElement(By.xpath("//android.widget.TextView[@content-desc='Avaya Vantage™ Basic']"));
            AndroidElement elanAppIcon = findByXpath("//android.widget.TextView[@content-desc='Avaya Vantage™ Basic']");

            //android.widget.TextView[@content-desc='Avaya Vantage™ Basic']

            elanAppIcon.click();

        }else if(app.equals(ApplicationName.EQUINOX)){

            AndroidElement eqinox = (AndroidElement) driver.findElement(By.xpath("//android.widget.TextView[@content-desc='Avaya Equinox']"));
            eqinox.click();

        }







    }


    public void take_ScreenShot(){


        Date date  = new Date();
        String updatedName = date.toString().replace(":","_").replace(" ","_");

        File scrFile;
        String path = Constants.USER_DIR+"\\screenshots\\"+updatedName+".png";

        System.out.println(path);
        scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        //The below method will save the screen shot in d drive with name "screenshot.png"
        try {
            FileUtils.copyFile(scrFile, new File(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
        //Change
        test.log(LogStatus.INFO,"Adding the screens ",test.addScreenCapture(path));



    }











    public  String randomString(int length){
        String alphabet =
                new String("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz"); //9
        int n = alphabet.length(); //10

        String result = new String();
        Random r = new Random(); //11

        for (int i=0; i<length; i++) //12
            result = result + alphabet.charAt(r.nextInt(n)); //13

        return result;
    }
public String RandomInt(int length){

    String alphabet =
            new String("0123456789"); //9
    int n = alphabet.length(); //10

    String result = new String();
    Random r = new Random(); //11

    for (int i=0; i<length; i++) //12
        result = result + alphabet.charAt(r.nextInt(n)); //13

    return result;

}







    public void takeScreenShot(){


        Date date  = new Date();
        String updatedName = date.toString().replace(":","_").replace(" ","_");

        File scrFile;
        String path = Constants.USER_DIR+"\\screenshots\\"+updatedName+".png";

        System.out.println(path);
        scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        //The below method will save the screen shot in d drive with name "screenshot.png"
        try {
            FileUtils.copyFile(scrFile, new File(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
        //Change
        test.log(LogStatus.INFO,"Adding the screens ",test.addScreenCapture(path));

    }


    public void logoutFromNotifications(){
        driver.openNotifications();


        try {
            AndroidElement logoutBtn = findByXpath(Constants.logout_btn_notification);

            if (logoutBtn.isDisplayed()) {

                logoutBtn.click();

                AndroidElement ok_icon = findByXpath(Constants.ok_alert);
                ok_icon.click();
            }else {
                test.log(LogStatus.INFO,"already logged out ");
                System.out.println("Already logged out ");
            }

        }catch (Exception e){
            System.out.println("Already logged out ");

        }


    }



    public void lockTheScreen() throws Exception {


        driver.openNotifications();

       try {
           AndroidElement logoutBtn = findByXpath(Constants.logout_btn_notification);

           if (logoutBtn.isDisplayed()) {

               logoutBtn.click();

               AndroidElement ok_icon = findByXpath(Constants.ok_alert);
               ok_icon.click();
           }else {
               test.log(LogStatus.INFO,"already logged out ");
               System.out.println("Already logged out ");

           }

       }catch (Exception e){
           System.out.println("Already logged out ");

       }
        swipingVertical();




    }





   public void  login(String userName,String psdwrd) throws Exception {

       swipingVertical();

       AndroidElement userName_txt = findByXpath(Constants.userName_txt);
       AndroidElement password_txt = findByXpath(Constants.password_txt);
       AndroidElement next_btn = findByXpath(Constants.next_btn);



       userName_txt.sendKeys(userName);
       password_txt.sendKeys(psdwrd);
       next_btn.click();

       Thread.sleep(5000);

     //  swipingVertical();

       WebDriverWait wait = new WebDriverWait(driver,60);

       wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Constants.presence_status_Indicatior)));

     //  AndroidElement menu_Icon = findByXpath(Constants.launcher_Icon_Btn);

       AndroidElement presence_status_Indicatior = findByXpath(Constants.presence_status_Indicatior);
       if (presence_status_Indicatior.isDisplayed()){

           test.log(LogStatus.INFO,"Logged in Successfully ");

       }else{

           test.log(LogStatus.FAIL,"Login failed");
           takeScreenShot();
           //throw new Exception("Login failed");
}





    }





    public void swipingVertical() throws InterruptedException {
        //Get the size of screen.

        Thread.sleep(3000);

        size = driver.manage().window().getSize();
        System.out.println(size);

        //Find swipe start and end point from screen's with and height.
        //Find starty point which is at bottom side of screen.
        int starty = (int) (size.height * 0.80);
        //Find endy point which is at top side of screen.
        int endy = (int) (size.height * 0.20);
        //Find horizontal point where you wants to swipe. It is in middle of screen width.
        int startx = size.width / 2;
        System.out.println("starty = " + starty + " ,endy = " + endy + " , startx = " + startx);

        //Swipe from Bottom to Top.
        driver.swipe(startx, starty, startx, endy, 3000);
      //  Thread.sleep(2000);
        //Swipe from Top to Bottom.
//        driver.swipe(startx, endy, startx, starty, 3000);
//        Thread.sleep(2000);
    }

    




    public void redail() throws Exception {


    WebDriverWait wait = new WebDriverWait(driver,50);

    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.ImageButton[@index='1']")));

   // AndroidElement redail = (AndroidElement) driver.findElement(By.xpath("//android.widget.ImageButton[@resource-id='com.avaya.android.vantage.basic:id/redialButton'] "));
   AndroidElement redail = findByXpath(Constants.redail_btn);
    redail.click();

        test.log(LogStatus.INFO,"Redail button clicked ");
//    WebDriverWait wait = new WebDriverWait(driver,50);

    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.ImageButton[@index='1']")));

    AndroidElement call_button = (AndroidElement) driver.findElement(By.xpath("//android.widget.ImageButton[@index='1']"));

    call_button.click();
        test.log(LogStatus.INFO,"Call button clicked ");




    //android.widget.ImageButton[@resource-id='com.avaya.android.vantage.basic:id/redialButton']
}


  public void   makeElanVideoCall(int num) throws Exception {



      AndroidElement videoCallBtnElan = findByXpath(Constants.videoCallBtnElan);
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

      //   test.log(LogStatus.INFO,"Finding and clicking the numbers ");

      try {
          Thread.sleep(500);
      } catch (InterruptedException e) {
          e.printStackTrace();
      }


      //call_button = (AndroidElement) driver.findElement(By.id("audioButton"));


      //   call_button.click();

//        test.log(LogStatus.INFO,"Element is "+call_button);
//        test.log(LogStatus.INFO,"Clicking on call button ");


      videoCallBtnElan.click();
//endCurrentcall();






  }




    public void makeElanAudioCall(int  num ) throws Exception {

        AndroidElement dailerTab = findByXpath(Constants.elan_dailer_tab);

        dailerTab.click();

//        WebDriverWait wait = new WebDriverWait(driver,50);
//
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.ImageButton[@index='1']")));
//
//        AndroidElement call_button = (AndroidElement) driver.findElement(By.xpath("//android.widget.ImageButton[@index='1']"));


AndroidElement call_button = findByXpath(Constants.audio_call_Btn_elan);


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

     //   test.log(LogStatus.INFO,"Finding and clicking the numbers ");

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


         //call_button = (AndroidElement) driver.findElement(By.id("audioButton"));


     //   call_button.click();

//        test.log(LogStatus.INFO,"Element is "+call_button);
//        test.log(LogStatus.INFO,"Clicking on call button ");


        call_button.click();
//endCurrentcall();

    }


    public void endCurrentcall() throws Exception {

      //  Thread.sleep(500);
//        WebDriverWait wait = new WebDriverWait(driver,10);
//
//        //  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("incoming_unknown_dialog_accept")));
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.ToggleButton[@resource-id='com.avaya.android.vantage.basic:id/control_endcall']")));




//
//
    // End_Call_BTN = (AndroidElement) driver.findElement(By.xpath("//android.widget.ToggleButton[@resource-id='com.avaya.android.vantage.basic:id/control_endcall']"));
      //  test.log(LogStatus.INFO,"Call placed Successfully ");

        End_Call_BTN = findByXpath("//android.widget.ToggleButton[@resource-id='com.avaya.android.vantage.basic:id/control_endcall']");


//        test.log(LogStatus.INFO,"Call end btn found on screen ");
//        test.log(LogStatus.INFO,"Ending Current on going call ");

        End_Call_BTN.click();

      //  test.log(LogStatus.INFO,"Call ended Successfully");

    }







    public  void  pressNumber(char num){


        switch(num){
            case '1':
                number_1.click();
               // test.log(LogStatus.INFO,"Clicking number"+1);
                break;
            case '2':
                number_2.click();
               // test.log(LogStatus.INFO,"Clicking number"+2);
                break;
            case '3':
                number_3.click();
               // test.log(LogStatus.INFO,"Clicking number"+3);
                break;
            case '4':
                number_4.click();
                //test.log(LogStatus.INFO,"Clicking number"+4);
                break;

            case '5':
                number_5.click();
                //test.log(LogStatus.INFO,"Clicking number"+5);
                break;
            case '6':
                number_6.click();
                //test.log(LogStatus.INFO,"Clicking number"+6);
                break;
            case '7':
                number_7.click();
                //test.log(LogStatus.INFO,"Clicking number"+7);
                break;
            case '8':
                number_8.click();
              //  test.log(LogStatus.INFO,"Clicking number"+8);
                break;
            case '9':
                number_9.click();
                //test.log(LogStatus.INFO,"Clicking number"+9);
                break;
            case '0':
                number_0.click();
                //test.log(LogStatus.INFO,"Clicking number"+0);
                break;
        }


    }


}
