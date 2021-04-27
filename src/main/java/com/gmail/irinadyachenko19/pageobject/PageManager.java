package com.gmail.irinadyachenko19.pageobject;

import com.gmail.irinadyachenko19.pageobject.amazonstore.JobsPage;
import com.gmail.irinadyachenko19.pageobject.amazonstore.HomePage;
import com.gmail.irinadyachenko19.pageobject.amazonstore.HubPage;
import com.gmail.irinadyachenko19.pageobject.amazonstore.MusicPage;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PageManager {

    private static final Logger logger = LogManager.getLogger(PageManager.class.getSimpleName());

    private WebDriver driver;

    private HomePage homePage;
    private JobsPage jobsPage;
    private HubPage hubPage;
    private MusicPage musicPage;

    public PageManager(WebDriver driver){
        this.driver = driver;
    }

    public HomePage homePage(){
        if(this.homePage == null)
            homePage = new HomePage(driver, this);
        return homePage;
    }
    public JobsPage jobsPage(){
        if(this.jobsPage == null)
            jobsPage = new JobsPage(driver, this);
        return jobsPage;
    }
    public HubPage hubPage(){
        if(this.hubPage == null)
            hubPage = new HubPage(driver, this);
        return hubPage;
    }
    public MusicPage musicPage(){
        if(this.musicPage == null)
            musicPage = new MusicPage(driver, this);
        return musicPage;
    }
    public PageManager open(String url){
        logger.info("Opening page with url: " + url);
        driver.navigate().to(url);
        return this;
    }

    public PageManager waitForPageToLoad(){
        logger.info("Waiting till next page is loaded");
        new WebDriverWait(driver, Duration.ofSeconds(3)).until(
                webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
        return this;
    }
}
