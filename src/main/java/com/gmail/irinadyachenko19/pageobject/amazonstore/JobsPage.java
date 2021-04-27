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

public class JobsPage extends BasePage{

    private static final Logger logger = LogManager.getLogger(JobsPage.class.getSimpleName());

    @FindBy(xpath = "(//*[@id=\"search_typeahead\"])[last()]")
    public WebElement jobSearchField;
    @FindBy(xpath = "(//*[@id=\"location-typeahead\"])[last()]")
    public WebElement locationField;
    @FindBy(xpath = "//*[@id=\"search-button\"]/span")
    public WebElement searchButton;
    @FindAll(@FindBy(xpath = "//*[@class=\"job-tile\"]"))
    public List<WebElement> listOfAvailableJobs;


    public JobsPage(WebDriver driver, PageManager pageManager) {
        super(driver, pageManager);
    }

    public int getNumberOfAvailableJobs(){
        int result = 0;

        try {
            new WebDriverWait(driver, Duration.ofSeconds(10), Duration.ofSeconds(1)).until(ExpectedConditions.visibilityOfAllElements(listOfAvailableJobs));
            result = listOfAvailableJobs.size();
        }catch (TimeoutException err){

        }
        return result;
    }
}