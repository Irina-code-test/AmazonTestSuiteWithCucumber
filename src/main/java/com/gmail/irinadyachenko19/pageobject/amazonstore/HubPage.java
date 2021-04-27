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
    @FindBy(xpath = "//*[@id=\"431162_425525pi_431162_425525\"]")
    public WebElement lastNameField;
    @FindBy(xpath = "//*[@id=\"431162_425527pi_431162_425527\"]")
    public WebElement emailField;
    @FindBy(xpath = "//*[@id=\"431162_425529pi_431162_425529\"]")
    public WebElement companyField;
    @FindBy(xpath = "//*[@id=\"431162_425531pi_431162_425531\"]")
    public WebElement phoneField;
    @FindBy(xpath = "//*[@id=\"431162_425533pi_431162_425533\"]")
    public WebElement addressField;
    @FindBy(xpath = "//*[@id=\"431162_425535pi_431162_425535\"]")
    public WebElement cityField;
    @FindBy(xpath = "//*[@id=\"431162_425537pi_431162_425537\"]")
    public WebElement stateField;
    @FindBy(xpath = "//*[@id=\"431162_425539pi_431162_425539\"]")
    public WebElement zipCodeField;
    @FindBy(xpath = "//*[@id=\"431162_425541pi_431162_425541\"]")
    public WebElement countryField;
    @FindBy(xpath = "//*[@id=\"431162_425543pi_431162_425543\"]")
    public WebElement locationUnderConstructionField;
    @FindBy(xpath = "//*[@id=\"431162_425547pi_431162_425547\"]")
    public WebElement openBusinessField;
    @FindBy(xpath = "//*[@id=\"431162_425549pi_431162_425549\"]")
    public WebElement numberOfLocationsField;
    @FindBy(xpath = "//*[@id=\"431162_425551pi_431162_425551\"]")
    public WebElement franchiseeLocationField;
    @FindBy(xpath = "//*[@id=\"431162_425553pi_431162_425553\"]")
    public WebElement parentCompanyField;
    @FindBy(xpath = "//*[@id=\"431162_428121pi_431162_428121\"]")
    public WebElement productRequestedField;
    @FindBy(xpath = "//*[contains(text(),'Thank You')]")
    public WebElement thankYouMessage;



    public HubPage(WebDriver driver, PageManager pageManager) {
        super(driver, pageManager);
    }
    public void clickSubmitButton(){
        try {
            submitButton.click();
        }catch (org.openqa.selenium.ElementClickInterceptedException err) {
            submitButton.click();
        }
    }
    public int getNumberOfElementsInTheCart(){
       new WebDriverWait(driver, Duration.ofSeconds(10), Duration.ofSeconds(1)).until(ExpectedConditions.visibilityOfAllElements(errorList));
       return errorList.size();
    }
}