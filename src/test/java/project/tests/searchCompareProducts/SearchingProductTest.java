package project.tests.searchCompareProducts;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.SearchPage;
import pages.TestConditions;
import selenium.WebDriverWrapper;
import utils.Log4Test;

import java.util.concurrent.TimeUnit;


/**
 * Created by pc on 12.07.14.
 */
public class SearchingProductTest extends TestConditions{

    @DataProvider(name = "product")
    public Object[][] products(){
        return new Object[][]{
                new Object[]{"Samsung Gear 2 Neo", "Samsung Gear Fit"},
                };
    }

    @BeforeMethod
    public void deleteCookies(){
        driver.manage().deleteAllCookies();
    }

    @Test(dataProvider = "product")
    public void searchProduct(String product1, String product2){
        By compareMenu = By.id("compare-menu");
        SearchPage searchPage = new SearchPage(driver);
        searchPage.open();
        searchPage.searchProduct(product1);
        Assert.assertTrue(searchPage.isSearchCorrect(product1), Log4Test.error("Incorrect Search Result"));
        searchPage.searchProduct(product2);
        Assert.assertTrue(searchPage.isSearchCorrect(product2), Log4Test.error("Incorrect Search Result"));
    }
}
