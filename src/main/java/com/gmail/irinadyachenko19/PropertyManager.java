package com.gmail.irinadyachenko19;

import java.io.InputStream;
import java.util.Properties;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class PropertyManager {

    private static final Logger logger = LogManager.getLogger(PropertyManager.class.getSimpleName());
    private static final Properties properties = new Properties();
    private static final String testDataFilesFolder = "testdata/";

    public PropertyManager(String testDataFileName){
        loadProperties(testDataFilesFolder + testDataFileName);
    }


    public String getProperty(String propertyName){
        return properties.getProperty(propertyName);
    }

    private void loadProperties(String filePath){
        logger.info("Trying to access property file: " + filePath);
        try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream(filePath)) {
            properties.load(inputStream);
        } catch (Exception e) {
            logger.error("Property file with path: " + filePath + " cannot be opened");
            LogUtil.logStackTrace(e, logger);
        }
    }
}
