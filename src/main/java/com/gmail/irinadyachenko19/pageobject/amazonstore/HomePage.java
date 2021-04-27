package com.gmail.irinadyachenko19.pageobject.amazonstore;

import com.gmail.irinadyachenko19.pageobject.BasePage;
import com.gmail.irinadyachenko19.PropertyManager;
import com.gmail.irinadyachenko19.pageobject.PageManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class HomePage extends BasePage {
    private static final Logger logger = LogManager.getLogger(HomePage.class.getSimpleName());
    @FindBy(xpath = "//*[@class=\"a-button-input\" and @data-action-type=\"DISMISS\"]")
    public WebElement dontChangeButton;
    @FindBy(xpath = "//*[contains(text(),'Gift Cards') and @class=\"nav-a  \"]")
    public WebElement giftCardButton;
    @FindBy(xpath = "//*[@alt=\"eGift\"]")
    public WebElement eGiftImage;
    @FindBy(xpath = "//*[@value=\"STANDARD\"]")
    public WebElement standardButton;
    @FindBy(xpath = "//*[@id=\"a-autoid-23\"]")
    public WebElement fiftyDollarsAmountButton;
    @FindBy(xpath = "//*[@id=\"gc-order-form-recipients\"]")
    public WebElement emailDeliveryField;
    @FindBy(xpath = "//*[@id=\"gc-order-form-senderName\"]")
    public WebElement yourNameField;
    @FindBy(xpath = "//*[@id=\"gc-buy-box-atc\"]")
    public WebElement addToCartButton;
    @FindAll(@FindBy(xpath = "//*[@id=\"ewc-compact-body\"]"))
    public List<WebElement> cartPanel;
    @FindBy(xpath = "//div[contains(text(),'Email address must contain one @ symbol, like name')] ")
    public WebElement errorEmailMessage;

    public HomePage(WebDriver driver, PageManager pageManager) {
        super(driver, pageManager);
    }

    public int getNumberOfElementsInTheCart(){
       new WebDriverWait(driver, Duration.ofSeconds(10), Duration.ofSeconds(1)).until(ExpectedConditions.visibilityOfAllElements(cartPanel));
       return cartPanel.size();
    }
}