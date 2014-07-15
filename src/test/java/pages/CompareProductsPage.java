package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import selenium.WebDriverWrapper;
import utils.Log4Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pc on 14.07.14.
 */
public class CompareProductsPage extends BasePage{

    public CompareProductsPage(WebDriverWrapper driver){
        super(driver);
    }

    private static final By productTitleLocator = By.xpath("//*[@class='title']/a");
    private static final By onlyDifferenceItem = By.xpath("//*[@href='#only-different']");
    private static final By productsDetails = By.xpath("//td[@class='detail-title']");
    private static final By productsDifferentKeysLocator = By.xpath("//tr[contains(@class, 'different')]/td[1]");
    private static final String valuesLocator = "//td[@class='detail-title']/ancestor::tr/td[%d]";
    private static final int PROD1_NUMBER = 2;
    private static final int PROD2_NUMBER = 3;


    public List<WebElement> getProductsKeys() {
        return driver.findElements(productsDetails);
    }

    public List<WebElement> getProductValues(int i) {
        return driver.findElements(By.xpath(String.format(valuesLocator, i)));
    }

    public boolean areProductsAvailable(String product1, String product2) {
        Log4Test.info("Check that searched products are added to the comparison page");
        boolean result = false;
        List<WebElement> comparedProducts = driver.findElements(productTitleLocator);
        if (comparedProducts.get(0).getText().equals(product1) && comparedProducts.get(1).getText().equals(product2)) {
                result = true;
        }else {
            result = false;
            }
        return result;
    }












}
