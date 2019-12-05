package boostshore;


import org.testng.annotations.BeforeSuite;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import sun.audio.*;
import java.io.*;
//import java.io.InterriptedException;
import java.net.*;
import java.util.concurrent.TimeUnit;
import java.lang.Thread.*;
import java.lang.*;

public class DogScannerTest{

    private IOSDriver<MobileElement> driver;
    //open/closeMac gsk-ecoutez-button-gray-circle



    @BeforeSuite
    public void setUp() throws Exception{

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceName","Yang's iPhone");
        caps.setCapability("platformName","iOS");
        caps.setCapability("platformVersion","13.2.2");
        caps.setCapability("automationName","XCUITest");
        caps.setCapability("bundleId","com.google.Translate");
        caps.setCapability("udid","auto");
        caps.setCapability("updatedWDABundleId","com.sjsu.WebDriverAgentLib7988");
        caps.setCapability("xcodeOrgId","98N6VX76F7");
        caps.setCapability("xcodeSigningId","iPhone Developer");

        driver = new IOSDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), caps);
    }
    @Test
    public void test1() throws IOException, InterruptedException{
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //driver.findElementByAccessibilityId("ConversationButton").click();
        driver.findElement(MobileBy.name("DictationInputButton")).click();
        Thread.sleep(500);

        try{
            String gongFile = "/Users/yang/Documents/tools/OneDrive - Tesla/CMPE 287 Testing/t3 i am very happy.wav";
            InputStream in = new FileInputStream(new File(gongFile));
            AudioStream audioStream = new AudioStream(in);
            AudioPlayer.player.start(audioStream);
        }catch(Exception e){
            e.printStackTrace();
        }

        MobileElement chinese = driver.findElement(MobileBy.AccessibilityId("InputTextView"));
        System.out.println("English: " + chinese.getText());
        driver.findElement(MobileBy.AccessibilityId("SwapLangButton")).click();
        MobileElement english = driver.findElement(MobileBy.name("InputTextView"));
        Thread.sleep(500);
        System.out.println("Translation: " + english.getText());
        driver.findElement(MobileBy.AccessibilityId("SwapLangButton")).click();
        Thread.sleep(500);

    }

    @Test
    public void test2() throws IOException, InterruptedException {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(MobileBy.name("DictationInputButton")).click();
        Thread.sleep(500);
        //how to automaticly get the recording.
        try{
            String gongFile = "/Users/tingtingzhu/Desktop/english.wav";
            InputStream in = new FileInputStream(new File(gongFile));
            AudioStream audioStream = new AudioStream(in);
            AudioPlayer.player.start(audioStream);
        }catch(Exception e){
            e.printStackTrace();
        }

        MobileElement chinese = driver.findElement(MobileBy.AccessibilityId("InputTextView"));
        System.out.println("English: " + chinese.getText());
        driver.findElement(MobileBy.AccessibilityId("SwapLangButton")).click();
        MobileElement english = driver.findElement(MobileBy.name("InputTextView"));
        Thread.sleep(500);
        System.out.println("Translation: " + english.getText());
        driver.findElement(MobileBy.AccessibilityId("SwapLangButton")).click();
        Thread.sleep(500);
    }


    @AfterTest
    public void tearDown(){
        if(driver != null){
            driver.quit();
        }
    }
}





//@Before
//public void setUp() throws Exception {
//        // set up appium against a local application
//        File appDir = new File(System.getProperty("user.dir"), "../../../apps/TestApp/build/Release-iphonesimulator");
//
//        File app = new File(appDir, "TestApp.app");
//        DesiredCapabilities capabilities = new DesiredCapabilities();
//        capabilities.setCapability(CapabilityType.BROWSER_NAME, "iOS");
//        capabilities.setCapability(CapabilityType.VERSION, "6.0");
//        capabilities.setCapability(CapabilityType.PLATFORM, "Mac");
//
//        //tell Appium where the location of the app is
//        capabilities.setCapability("app", app.getAbsolutePath());
//
//        //create a RemoteWebDriver, the default port for Appium is 4723
//        driver = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
//        }