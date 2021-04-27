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

public class HubPageSteps {

    private static final Logger logger = LogManager.getLogger(HubPageSteps.class.getSimpleName());

    WebDriver driver = CucumberStepContext.getInstance().getDriver();
    PageManager pageManager = CucumberStepContext.getInstance().getPageManager();
    PropertyManager propertyManager = CucumberStepContext.getInstance().getPropertyManager();

    @Given("Customer is on hub page")
    public void customerIsOnHubPage() {
        pageManager.open(propertyManager.getProperty("hubpage.url"))
            .waitForPageToLoad();
    }

    @When("Customer submits a form")
    public void customerSubmitsAForm() {
        pageManager.hubPage().clickSubmitButton();
    }
    @Then("Customer receives a list of error messages")
    public void customerReceivesAListOfErrorMessages() {
        Assert.assertEquals(15, pageManager.hubPage().getNumberOfElementsInTheCart());
    }

}
