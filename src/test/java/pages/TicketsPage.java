package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import selenium.WebDriverWrapper;
import utils.Log4Test;

/**
 * Created by pc on 04.07.14.
 */
public class TicketsPage extends BasePage {

    private static final String infantsTicketsLocator = "//div[@class='infants_block passengers_wrapper']/div[@class='persons']/div[%d]";
    private static final String adultsTicketsLocator = "//div[@class='adults_block passengers_wrapper']/div[@class='persons']/div[%d]";
    private static final String childrenTicketsLocator = "//div[@class='children_block passengers_wrapper']/div[@class='persons']/div[%d]";
    private static final By errorPopup = By.className("error_popup");


    public TicketsPage(WebDriverWrapper driver){
        super(driver);
        url = "http://rozetka.com.ua/travel/IEV/MOW/";
    }


    public void buyTickets(int adults, int children, int infant){
        Log4Test.info("Buy tickets for infants");
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(String.format(adultsTicketsLocator, adults))));
        driver.findElement(By.xpath(String.format(adultsTicketsLocator, adults))).click();
        driver.findElement(By.xpath(String.format(childrenTicketsLocator, children))).click();
        driver.findElement(By.xpath(String.format(infantsTicketsLocator, infant))).click();
        driver.findElement(findBtn).click();

    }

    public boolean isErrorWindowDisplayed(){
        Log4Test.info("Check that pop-up window is displayed");
        return driver.findElements(errorPopup).size()>0;
    }



}
