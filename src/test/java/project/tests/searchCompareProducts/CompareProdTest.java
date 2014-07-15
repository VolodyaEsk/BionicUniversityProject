package project.tests.searchCompareProducts;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.CompareProductsPage;
import pages.SearchPage;
import pages.TestConditions;
import utils.Log4Test;

/**
 * Created by pc on 14.07.14.
 */
public class CompareProdTest extends TestConditions {

    @BeforeMethod
    public void deleteCookies(){
        driver.manage().deleteAllCookies();
    }

    @DataProvider(name = "productDifference")
    public Object[][] products(){
        return new Object[][] {
                new Object[] {"Samsung Gear 2 Neo Mocha Grey (SM-R3810ZAASEK)", "Samsung Gear Fit Charcoal Black (SM-R3500ZKASEK)"},
    };
    }

    @Test(dataProvider = "productDifference")
    public void compareDiffTest(String prod1, String prod2){
        SearchPage searchPage = new SearchPage(driver);
        searchPage.open();
        searchPage.searchProduct(prod1);
        Assert.assertTrue(searchPage.isSearchCorrect(prod1), Log4Test.error("Incorrect Search Result"));
        searchPage.addProductToComparison();
        searchPage.searchProduct(prod2);
        Assert.assertTrue(searchPage.isSearchCorrect(prod2), Log4Test.error("Incorrect Search Result"));
        searchPage.addProductToComparison();
        searchPage.compareProducts();
        CompareProductsPage compareProductsPage = new CompareProductsPage(driver);
        Assert.assertTrue(compareProductsPage.areProductsAvailable(prod1, prod2), Log4Test.error("Adding to comparison is working incorrect"));



    }

}
