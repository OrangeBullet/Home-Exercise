package com.altruist.google.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;


public class HomePage extends AbstractPage {

    private static final String URL = "https://www.google.com/finance/";
    private static final String TITLE = "Google Finance";

    @FindBy(xpath = "//div[@id='smart-watchlist-title']/following-sibling::ul//li//a")
    private List<WebElement> tickersTableRows;

    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Override
    public void get() {
        driver.get(URL);
    }

    @Override
    public boolean pageIsOpen() {
        return driver.getTitle().contains(TITLE);
    }

    private List<WebElement> getTickersTableRows() {
        return tickersTableRows;
    }

    public List<String> getTickersSymbolsAsString() {
        List<String> listOfSymbols = new ArrayList<>();

        for (WebElement ticker : getTickersTableRows()) {
            listOfSymbols.add(ticker.findElement(By.xpath("div//div//div//div")).getText());
        }
        return listOfSymbols;
    }
}
