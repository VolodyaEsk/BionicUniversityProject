package project.tests.ticketsForInfants;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.TestConditions;
import pages.TicketsPage;
import utils.Log4Test;

/**
 * Created by pc on 04.07.14.
 */
public class BuyTicketsTest extends TestConditions {

    @DataProvider(name = "NeededParam")
    public Object[][] param(){
        return new Object[][]{{1, 1, 3}};
    }

    @Test(dataProvider = "NeededParam" )
    public void buy2InfantTickets(int adults, int children, int infants){
        TicketsPage ticketsPage = new TicketsPage(driver);
        ticketsPage.open();
        ticketsPage.buyTickets(adults, children, infants);
        Assert.assertTrue(ticketsPage.isErrorWindowDisplayed(), Log4Test.error("Pop-up window is not displayed"));
    }



}
