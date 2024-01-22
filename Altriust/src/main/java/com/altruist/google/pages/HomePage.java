package com.altruist.google.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class HomePage extends AbstractPage{
    private final String URL = "https://www.google.com/finance/";
    private final String TITLE = "Google Finance";

    private By tickersTable = By.xpath("//div[@id='smart-watchlist-title']/following-sibling::ul//li//a");

    public HomePage(WebDriver driver){
        super(driver);
    }

    @Override
    public void get() {
        driver.get(URL);
    }

    @Override
    public boolean pageIsOpen() {
        return driver.getTitle().contains(TITLE);
    }

    private List<WebElement> getTickersTable(){
        return driver.findElements(tickersTable);
    }

    public List<String> getTickersSymbolsAsString(){
        List<WebElement> listOfWebElements = getTickersTable();
        List<String> listOfSymbols = new ArrayList<String>();

        for(WebElement x: listOfWebElements){
            listOfSymbols.add(
                    x.findElement(By.xpath("div//div//div//div")).getText()
            );
        }
        return listOfSymbols;
    }

}
