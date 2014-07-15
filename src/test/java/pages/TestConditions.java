package pages;

import org.testng.annotations.*;
import selenium.WebDriverFactory;
import selenium.WebDriverWrapper;
import utils.Log4Test;
import utils.PropertyLoader;
import java.util.concurrent.TimeUnit;


public class TestConditions {

    public static WebDriverWrapper driver;

    @BeforeSuite
    public void initializeEnv(){
        driver = WebDriverFactory.initDriver(PropertyLoader.loadProperty("browser.name"));
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @AfterSuite
    public void closeBrowser(){
        if(driver != null){
            driver.quit();
        }
    }

    @BeforeTest
    public void beforeTest() {
        Log4Test.info("-------***Start executing the mini test suite***-------");
    }

    @AfterTest
    public void afterTest() {
        Log4Test.info("-------***End executing the mini test suite***--------");
    }


    @BeforeMethod
    public void beforeMethod() {
        Log4Test.info("___###___Start of the test case___###___");
    }

    @AfterMethod
    public void afterMethod() {
        Log4Test.info("___###___End of the test case___###___");
    }

}
