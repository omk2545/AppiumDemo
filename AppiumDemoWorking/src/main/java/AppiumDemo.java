import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

/**
 * Created by okulkarni on 10/14/2016.
 */
public class AppiumDemo {
    AndroidDriver driver;

    @Test
    public void testDemoApp() throws MalformedURLException {

      //  AndroidDriver driver;

        DesiredCapabilities capabilities = new DesiredCapabilities();

        // Set android deviceName desired capability. Set it Android Emulator.
        capabilities.setCapability("deviceName", "148.147.154.52:5555");

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


        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

//        driver.findElementByAccessibilityId("Open Navigation Drawer").click();
//        try {
//            Thread.sleep(500);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        driver.findElementByAccessibilityId("Settings").click();



        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        AndroidElement dailpadbtn = (AndroidElement) driver.findElement(By.id("homeDialpadButton"));



        dailpadbtn.click();


        AndroidElement number_1 = (AndroidElement) driver.findElement(By.id("dialpad_one"));
        AndroidElement number_2 = (AndroidElement) driver.findElement(By.id("dialpad_two"));
        AndroidElement number_3 = (AndroidElement) driver.findElement(By.id("dialpad_three"));
        AndroidElement number_4 = (AndroidElement) driver.findElement(By.id("dialpad_four"));
        AndroidElement number_5 = (AndroidElement) driver.findElement(By.id("dialpad_five"));
        AndroidElement number_6 = (AndroidElement) driver.findElement(By.id("dialpad_six"));
        AndroidElement number_7 = (AndroidElement) driver.findElement(By.id("dialpad_seven"));
        AndroidElement number_8 = (AndroidElement) driver.findElement(By.id("dialpad_eight"));
        AndroidElement number_9 = (AndroidElement) driver.findElement(By.id("dialpad_nine"));
        AndroidElement number_0 = (AndroidElement) driver.findElement(By.id("dialpad_zero"));


        number_9.click();
        number_8.click();
        number_2.click();
        number_2.click();
        number_6.click();
        number_4.click();
        number_4.click();
        number_4.click();
        number_1.click();
        number_3.click();
        AndroidElement call_button = (AndroidElement) driver.findElement(By.id("dialpad_call"));
        call_button.click();






    }

public static void clickNo(int number){
}









}
