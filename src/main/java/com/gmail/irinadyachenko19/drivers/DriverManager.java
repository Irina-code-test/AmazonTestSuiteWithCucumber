package com.gmail.irinadyachenko19.drivers;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Locale;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class DriverManager {
    private static final Logger log = LogManager.getLogger(DriverManager.class.getSimpleName());

    public static WebDriver getDriver(String driverType){
        return getDriver(driverType, "LOCAL");
    }

    public static WebDriver getDriver(String driverType, String gridMode){

        WebDriver requestedDriver = null;
        switch (driverType.toUpperCase(Locale.ROOT)) {
            case "CHROME" -> {
                log.info("Chrome driver selected");
                requestedDriver = gridMode.toUpperCase(Locale.ROOT).equals("GRID") ?
                    getRemoteDriver(CapabilityManager.getChromeOptions()) : getLocalChrome();
            }
            case "FIREFOX" -> {
                log.info("Firefox driver selected");
                requestedDriver = gridMode.toUpperCase(Locale.ROOT).equals("GRID") ?
                    getRemoteDriver(CapabilityManager.getFirefoxOptions()) : getLocalFirefox();
            }
        }
        return requestedDriver;
    }

    private static WebDriver getLocalChrome(){
        log.info("Setting up new ChromeDriver");
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        ChromeDriver chromeDriver = new ChromeDriver(CapabilityManager.getChromeOptions());
        chromeDriver.manage().window().maximize();
        return chromeDriver;
    }
    private static WebDriver getLocalFirefox(){
        //firefox requires not only browser to be installed but also profile to be created.
        log.info("Setting up new FirefoxDriver");
        System.setProperty("webdriver.gecko.driver", "drivers/geckodriver");
        return new FirefoxDriver(CapabilityManager.getFirefoxOptions());
    }


    private static WebDriver getRemoteDriver(Capabilities capabilities){
        WebDriver requestedDriver = null;
        try{
            requestedDriver = new RemoteWebDriver(new URL(System.getProperty("selenium.grid.url")), capabilities);
        } catch (MalformedURLException e) {
            log.error("Remote driver creation failed");
        }
        return requestedDriver;
    }
}
