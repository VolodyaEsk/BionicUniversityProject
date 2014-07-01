package project.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.ExpectedCondition;

import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.*;

/**
 * Created by pc on 30.06.14.
 */
public class MyProjectTest {

    public static WebDriver driver;


    @BeforeSuite
    public void initializeFFdriver(){
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("http://rozetka.com.ua/");
    }

    @Test
    public void buyTwoTicketsForBabies(){

        Actions builder = new Actions(driver);
        WebDriverWait wait = new WebDriverWait(driver, 10);

        WebElement AirTicketsCase = driver.findElement(By.id("fatmenu_14"));

        AirTicketsCase.click();

        // у меня все что связано с атрибутами ClassName не работает(Windows 8)
        // Делаю два варианта - один через xpath, второй - через ClassName
        // Попробуйте у себя варинат через ClassName

//        wait.until(elementToBeClickable(By.className("infants_block passengers_wrapper")));
//        WebElement infantsBlock = driver.findElement(By.className("infants_block passengers_wrapper"));
//        List<WebElement> blockInfantItem = infantsBlock.findElements(By.className("item"));
//        WebElement secondInfantItem = blockInfantItem.get(1);
//        secondInfantItem.click();

        //этот 3 строки заменить на закоментированные 5 строк выше
        wait.until(elementToBeClickable(By.xpath("//*[@id=\"content\"]/div/div/div/div/div[2]/div[4]")));
        WebElement secondInfantItem = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/div/div/div[2]/div[4]/div[2]/div[2]"));
        secondInfantItem.click();


//        WebElement adultsBlock = driver.findElement(By.className("adults_block passengers_wrapper"));
//        WebElement adultCheckItem = driver.findElement(By.className("item checked"));
//        adultCheckItem.click();

        //этот 2 строки заменить на закоментированные 3 строки выше
        WebElement adultCheckItem = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/div/div/div[2]/div[2]/div[2]/div[1]"));
        adultCheckItem.click();



        WebElement queryFrom = driver.findElement(By.xpath("//*[@id=\"new_search\"]/div[2]/div[1]/div[1]/input[1]"));
        queryFrom.sendKeys("Kiev");


        wait.until(elementToBeClickable(By.xpath("//*[@id=\"ui-id-1\"]/li[3]")));
        driver.findElement(By.xpath("//*[@id=\"ui-id-1\"]/li[3]")).click();


        WebElement queryDestination = driver.findElement(By.xpath("//*[@id=\"new_search\"]/div[2]/div[1]/div[2]/input[1]"));
        queryDestination.sendKeys("Barcelona");


        wait.until(elementToBeClickable(By.xpath("//*[@id=\"ui-id-2\"]/li[1]")));
        driver.findElement(By.xpath("//*[@id=\"ui-id-2\"]/li[1]")).click();

        wait.until(elementToBeClickable(By.xpath("//*[@id=\"ui-datepicker-div\"]/div[1]/table/tbody/tr[3]/td[2]/a")));;
        driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div[1]/table/tbody/tr[3]/td[2]/a")).click();

        WebElement buttonFindBlock = driver.findElement(By.id("start_search"));
        driver.findElement(By.xpath("//*[@id=\"start_search\"]/a/span")).click();


        





















    }






//    @AfterSuite
//    public void closeFF(){
//        if(driver != null){
//            driver.quit();
//        }
//    }






}
