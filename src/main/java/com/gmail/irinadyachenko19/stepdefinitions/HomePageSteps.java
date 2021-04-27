package com.gmail.irinadyachenko19.stepdefinitions;

import com.gmail.irinadyachenko19.context.CucumberStepContext;
import com.gmail.irinadyachenko19.pageobject.PageManager;
import com.gmail.irinadyachenko19.PropertyManager;
import com.gmail.irinadyachenko19.pageobject.amazonstore.HomePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;


public class HomePageSteps {

    private static final Logger logger = LogManager.getLogger(HomePageSteps.class.getSimpleName());

    WebDriver driver = CucumberStepContext.getInstance().getDriver();
    PageManager pageManager = CucumberStepContext.getInstance().getPageManager();
    PropertyManager propertyManager = CucumberStepContext.getInstance().getPropertyManager();


    @Given("Customer is on Home page")
    public void customerIsOnPageWithUrlHomePageUrl() {
        pageManager.open(propertyManager.getProperty("homepage.url"))
            .waitForPageToLoad();
        pageManager.homePage().dontChangeButton.click();
    }

    @When("Customer chooses '<Gift Cards>'")
    public void customerChoosesGiftCard() {
        pageManager.homePage().giftCardButton.click();
    }
    @Then("Customer chooses '<eGift>'")
    public void customerChoosesEGiftCard() {
        pageManager.homePage().eGiftImage.click();
    }

    @Then("Customer fills in the form")
    public void customerFillsInTheForm(){
        HomePage homePage = pageManager.homePage();
        homePage.standardButton.click();
        homePage.fiftyDollarsAmountButton.click();
        homePage.emailDeliveryField.sendKeys(propertyManager.getProperty("default.customer.email"));
        homePage.yourNameField.sendKeys(propertyManager.getProperty("default.customer.name"));
    }

    @Then("Customer fills in the form using the wrong email")
    public void customerFillsInTheFormUsingWrongEmail(){
        HomePage homePage = pageManager.homePage();
        homePage.standardButton.click();
        homePage.fiftyDollarsAmountButton.click();
        homePage.emailDeliveryField.sendKeys(propertyManager.getProperty("wrong.customer.email"));
        homePage.yourNameField.sendKeys(propertyManager.getProperty("default.customer.name"));
    }

    @Then("error message is shown")
    public void checkTheErrorMessageIsShown(){
        Assert.assertTrue(pageManager.homePage().errorEmailMessage.isDisplayed());
    }

    @Then("eGift card is added to the cart")
    public void eGiftCardIsAddedToCart(){
        pageManager.homePage().addToCartButton.click();
    }

    @Then("eGift card should be present in the cart")
    public void eGiftCardShouldBePresentInCart(){
        logger.info("Checking eGift cart in the cart");
        int count = pageManager.homePage().getNumberOfElementsInTheCart();
        Assert.assertEquals(count, 1);
    }
}
