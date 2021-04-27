package com.gmail.irinadyachenko19.stepdefinitions;

import com.gmail.irinadyachenko19.PropertyManager;
import com.gmail.irinadyachenko19.context.CucumberStepContext;
import com.gmail.irinadyachenko19.pageobject.PageManager;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class MusicPageSteps {

    private static final Logger logger = LogManager.getLogger(MusicPageSteps.class.getSimpleName());

    WebDriver driver = CucumberStepContext.getInstance().getDriver();
    PageManager pageManager = CucumberStepContext.getInstance().getPageManager();
    PropertyManager propertyManager = CucumberStepContext.getInstance().getPropertyManager();


    @Given("Customer is on music page")
    public void customerIsOnMusicPage() {
        pageManager.open(propertyManager.getProperty("musicpage.url"))
            .waitForPageToLoad();
    }

    @When("Customer performs search for needed album")
    public void customerPerformsSearchForNeededAlbum() {
        pageManager.musicPage().fillInSearchField(propertyManager.getProperty("music.customer.album"));
        pageManager.musicPage().searchButton.click();
    }
    @Then("Customer sees a required album")
    public void customerSeesARequiredAlbum() {
        Assert.assertNotEquals(0, pageManager.musicPage().getNumberOfAvailableAlbums());
    }

    @When("Customer performs wrong search for needed album")
    public void customerPerformsWrongSearchForNeededAlbum() {
        pageManager.musicPage().fillInSearchField(propertyManager.getProperty("wrong.customer.album"));
        pageManager.musicPage().searchButton.click();
    }
    @Then("Customer cannot see a required album")
    public void customerCannotSeeARequiredAlbum() {
        Assert.assertEquals(0, pageManager.musicPage().getNumberOfAvailableAlbums());
    }

}
