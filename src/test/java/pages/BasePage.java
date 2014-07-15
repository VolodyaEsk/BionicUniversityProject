package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import selenium.WebDriverWrapper;
import utils.Log4Test;


public class BasePage {

    public BasePage(WebDriverWrapper driver){
        this.driver = driver;
    }

    protected WebDriverWrapper driver;
    protected String url = "http://rozetka.com.ua/";
    protected By searchLine = By.className("header-search-input-text");
    protected static final By findBtn = By.id("start_search");
    protected final String productFoundLocator = "//a[contains(text(),'%s')]";
    protected String productName;

    public void open(){
        driver.get(url);
    }

    public boolean isOpened(){
        return driver.getCurrentUrl().equals(url);
    }

    public  void searchProduct(String keyProduct){
        Log4Test.info("Searching product");
        productName = keyProduct;
        driver.findElement(searchLine).clear();
        driver.findElement(searchLine).sendKeys(productName);
        driver.findElement(searchLine).sendKeys(Keys.RETURN);

    }

}
