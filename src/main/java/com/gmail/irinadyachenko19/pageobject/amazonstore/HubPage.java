package com.gmail.irinadyachenko19.pageobject.amazonstore;

import com.gmail.irinadyachenko19.pageobject.BasePage;
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

public class HubPage extends BasePage {
    private static final Logger logger = LogManager.getLogger(HubPage.class.getSimpleName());
    @FindBy(xpath = "//*[@value=\"Submit Now\"]")
    public WebElement submitButton;
    @FindAll(@FindBy(xpath = "//*[@class=\"error no-label\"]"))
    public List<WebElement> errorList;
    @FindBy(xpath = "//*[@id=\"431162_425523pi_431162_425523\"]")
    public WebElement firstNameField;

    public HubPage(WebDriver driver, PageManager pageManager) {
        super(driver, pageManager);
    }
    public void clickSubmitButton(){
        new WebDriverWait(driver, Duration.ofSeconds(10), Duration.ofSeconds(1)).until(ExpectedConditions.elementToBeClickable(submitButton));
        submitButton.click();
    }
    public int getNumberOfElementsInTheCart(){
       new WebDriverWait(driver, Duration.ofSeconds(10), Duration.ofSeconds(1)).until(ExpectedConditions.visibilityOfAllElements(errorList));
       return errorList.size();
    }
}