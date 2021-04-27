package com.gmail.irinadyachenko19.stepdefinitions;

import com.gmail.irinadyachenko19.PropertyManager;
import com.gmail.irinadyachenko19.context.CucumberStepContext;
import com.gmail.irinadyachenko19.pageobject.PageManager;
import com.gmail.irinadyachenko19.pageobject.amazonstore.HubPage;
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
    @When("Customer completes the form")
    public void customerCompletesTheForm(){
        HubPage hubPage = pageManager.hubPage();
        hubPage.firstNameField.sendKeys(propertyManager.getProperty("firstNameField.hub"));
        hubPage.lastNameField.sendKeys(propertyManager.getProperty("lastNameField.hub"));
        hubPage.emailField.sendKeys(propertyManager.getProperty("emailField.hub"));
        hubPage.companyField.sendKeys(propertyManager.getProperty("companyField.hub"));
        hubPage.phoneField.sendKeys(propertyManager.getProperty("phoneField.hub"));
        hubPage.addressField.sendKeys(propertyManager.getProperty("addressField.hub"));
        hubPage.cityField.sendKeys(propertyManager.getProperty("cityField.hub"));
        hubPage.stateField.sendKeys(propertyManager.getProperty("stateField.hub"));
        hubPage.zipCodeField.sendKeys(propertyManager.getProperty("zipCodeField.hub"));
        hubPage.countryField.sendKeys(propertyManager.getProperty("countryField.hub"));
        hubPage.locationUnderConstructionField.sendKeys(propertyManager.getProperty("locationUnderConstructionField.hub"));
        hubPage.openBusinessField.sendKeys(propertyManager.getProperty("openBusinessField.hub"));
        hubPage.numberOfLocationsField.sendKeys(propertyManager.getProperty("numberOfLocationsField.hub"));
        hubPage.franchiseeLocationField.sendKeys(propertyManager.getProperty("franchiseeLocationField.hub"));
        hubPage.parentCompanyField.sendKeys(propertyManager.getProperty("parentCompanyField.hub"));
        hubPage.productRequestedField.sendKeys(propertyManager.getProperty("productRequestedField.hub"));
    }
    @Then("Customer receives a Thank you message")
    public void customerReceivesAThankYouMessage(){
        Assert.assertTrue(pageManager.hubPage().thankYouMessage.isDisplayed());
    }
}
