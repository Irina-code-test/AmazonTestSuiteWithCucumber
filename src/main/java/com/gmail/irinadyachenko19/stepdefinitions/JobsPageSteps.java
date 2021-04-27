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

public class JobsPageSteps {

    private static final Logger logger = LogManager.getLogger(JobsPageSteps.class.getSimpleName());

    WebDriver driver = CucumberStepContext.getInstance().getDriver();
    PageManager pageManager = CucumberStepContext.getInstance().getPageManager();
    PropertyManager propertyManager = CucumberStepContext.getInstance().getPropertyManager();


    @Given("Customer is on jobs page")
    public void customerIsOnPageWithUrlHomePageUrl() {
        pageManager.open(propertyManager.getProperty("jobspage.url"))
            .waitForPageToLoad();
    }

    @When("Customer performs search for needed title")
    public void customerChoosesNeededTitle() {
        pageManager.jobsPage().jobSearchField.sendKeys(propertyManager.getProperty("default.customer.job"));
    }
    @Then("Customer chooses needed location")
    public void customerChoosesNeededLocation() {
        pageManager.jobsPage().locationField.sendKeys(propertyManager.getProperty("default.customer.location"));
        pageManager.jobsPage().searchButton.click();
    }

    @Then("Customer can see required jobs")
    public void checkIfCustomerSeesRequiredJobs(){
        Assert.assertNotEquals(0, pageManager.jobsPage().getNumberOfAvailableJobs());
    }

    @Then("Customer performs search for wrong title")
    public void customerChoosesWrongTitle() {
        pageManager.jobsPage().jobSearchField.sendKeys(propertyManager.getProperty("wrong.customer.title"));
    }

    @Then("Customer cannot see required jobs")
    public void checkThanCustomerCannotSeeRequiredJobs(){
        Assert.assertEquals(0, pageManager.jobsPage().getNumberOfAvailableJobs());
    }
}
