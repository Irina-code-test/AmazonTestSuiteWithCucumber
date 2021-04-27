package com.gmail.irinadyachenko19.pageobject;

import com.gmail.irinadyachenko19.PropertyManager;
import java.util.List;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v89.page.Page;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;


public abstract class BasePage extends Page {

    protected WebDriver driver;
    protected PageManager pageManager;

    public BasePage(WebDriver driver,PageManager pageManager){
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
        this.pageManager = pageManager;
    }

    protected void selectFromDropdownByValue(WebElement element, String value, Logger logger){
        logger.info("Trying to select option: \"" + value + "\" from dropdown: " + element);
        Select dropdown = new Select(element);
        try {
            dropdown.selectByValue(value);
        } catch (Exception e) {
            logger.error("Option cannot be selected from dropdown");
            throw e;
        }
    }

    protected void selectFromDropdownByVisibleText(WebElement element, String text, Logger logger){
        logger.info("Trying to select option: \"" + text + "\" from dropdown: " + element);
        Select dropdown = new Select(element);
        try {
            dropdown.selectByVisibleText(text);
        } catch (Exception e) {
            logger.error("Option cannot be selected from dropdown");
            throw e;
        }
    }

    protected String getTextFromField(WebElement element){
        return element.getText();
    }

}
