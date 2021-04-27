package com.gmail.irinadyachenko19.pageobject.amazonstore;

import com.gmail.irinadyachenko19.pageobject.BasePage;
import com.gmail.irinadyachenko19.pageobject.PageManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class MusicPage extends BasePage{

    private static final Logger logger = LogManager.getLogger(MusicPage.class.getSimpleName());

    @FindBy(xpath = "//*[@id=\"navbarSearchInput\"]")
    public WebElement searchField;
    @FindBy(xpath = "//*[@id=\"navbarSearchInputButton\"]")
    public WebElement searchButton;
    @FindAll(@FindBy(xpath = "//*[@primary-text=\"Albums\"]//child::music-vertical-item"))
    public List<WebElement> listOfAvailableAlbums;


    public MusicPage(WebDriver driver, PageManager pageManager) {
        super(driver, pageManager);
    }

    public void fillInSearchField(String value){
        new WebDriverWait(driver, Duration.ofSeconds(10), Duration.ofSeconds(1)).until(ExpectedConditions.visibilityOfAllElements(searchField));
        searchField.sendKeys(value);
    }
    public int getNumberOfAvailableAlbums(){
        int result = 0;

        try {
            new WebDriverWait(driver, Duration.ofSeconds(10), Duration.ofSeconds(1)).until(ExpectedConditions.visibilityOfAllElements(listOfAvailableAlbums));
            result = listOfAvailableAlbums.size();
        }catch (TimeoutException err){

        }
        return result;
    }
}