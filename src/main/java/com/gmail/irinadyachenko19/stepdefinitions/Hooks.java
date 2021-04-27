package com.gmail.irinadyachenko19.stepdefinitions;

import com.gmail.irinadyachenko19.context.CucumberStepContext;
import com.gmail.irinadyachenko19.drivers.DriverManager;
import com.gmail.irinadyachenko19.pageobject.PageManager;
import com.gmail.irinadyachenko19.PropertyManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {

    @Before
    public void setup(){
        CucumberStepContext.getInstance().setPropertyManager(new PropertyManager("amazonStore.properties"));
        CucumberStepContext.getInstance().setDriver(DriverManager.getDriver("Chrome", "LOCAL"));
        CucumberStepContext.getInstance().setPageManager( new PageManager(CucumberStepContext.getInstance().getDriver()));
    }

   @After
    public void cleanUp(){
        CucumberStepContext.getInstance().getDriver().quit();
    }

}
