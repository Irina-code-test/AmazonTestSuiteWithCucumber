package com.gmail.irinadyachenko19;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features",
        glue="com/gmail/irinadyachenko19/stepdefinitions")
public class CucumberRunner {

}