package pages;

import org.openqa.selenium.By;
import org.testng.Assert;
import selenium.WebDriverWrapper;
import utils.Log4Test;

public class SearchPage extends BasePage {

    public SearchPage(WebDriverWrapper driver){
        super(driver);
    }

    protected final By compareProduct = By.name("tocomparison");
    protected final By compare = By.xpath("//div[@name='comparison_catalog']/a[@class='lightblue underline']");



    public void addProductToComparison(){
        Log4Test.info("Add product to comparison");
        driver.findElement(compareProduct).click();
    }

    public void compareProducts() {
        Log4Test.info("Let's go compare");
        driver.findElement(compare).click();
    }

    public boolean isSearchCorrect(String product){
        Log4Test.info("Check the search result");
        return driver.findElement(By.xpath(String.format(productFoundLocator, product))).isDisplayed();

    }

    public void comparisonWorks(String prod1, String prod2)
    {
        compareProducts();
        Assert.assertTrue(isSearchCorrect(prod1));
        Assert.assertTrue(isSearchCorrect(prod2));
    }






}
