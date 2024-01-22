package com.altruist.google;

import com.altruist.google.pages.HomePage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;


public class TestFinance extends AbstractTest {
    private static final Logger LOGGER = LogManager.getLogger(TestFinance.class);
    @Test
    public void financePageTable(){
        LOGGER.info("test finance start");
        HomePage page = new HomePage(driver);
        LOGGER.info("navigating to the page");
        page.get();
        LOGGER.info("asserting title");
        Assert.assertTrue(page.pageIsOpen());


        //Given Test Data
        List<String> expectedStockSymbols = Arrays.asList("NFLX","MSFT", "TSLA");


        LOGGER.info("Retrieves the stock symbols listed under the section “You may be interested in info”");
        List<String> tickersSymbolsAsString = page.getTickersSymbolsAsString();
        System.out.println("List of tickers Symbols on the page ->  "+tickersSymbolsAsString);
        Assert.assertFalse(tickersSymbolsAsString.isEmpty(), "Empty List of elements from table 'You may be interested in'");


        LOGGER.info("Print all stock symbols that are in (3) but not in expectedStockSymbols");
        List<String> listOfAdditionalItems = tickersSymbolsAsString.stream()
                .filter(item -> !expectedStockSymbols.contains(item))
                .toList();
        System.out.println("All stock symbols that are in {actual list of Stock Symbols} but not in {list of expected Stock Symbols} ---> "
                +listOfAdditionalItems);

        LOGGER.info("Print all stock symbols that are in expectedStockSymbols but not in (3)");
        listOfAdditionalItems = expectedStockSymbols.stream()
                .filter(item -> !tickersSymbolsAsString.contains(item))
                .toList();
        System.out.println("All stock symbols that are in {list of expected Stock Symbols} but not in {actual list of Stock Symbols} ----> "
                + listOfAdditionalItems);



    }

}
