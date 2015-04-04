package com.warrensofthought.utilityCounter.util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by till on 08.03.15.
 */
public class PropertiesHelperFileReader implements PropertiesHelper{
    private static final Logger LOGGER = Logger.getLogger(PropertiesHelperFileReader.class.getName());

    @Override
    public String getPropertyValueForKey(String key) throws FileNotFoundException {
        String value = "";
        Properties properties = new Properties();
        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(Constants.PROPERTIES_LOCATION);
        if (null != inputStream) {
            try {
                properties.load(inputStream);
            } catch (IOException e) {
                LOGGER.log(Level.SEVERE, String.format("Property file '%s' not found! ", Constants.PROPERTIES_LOCATION));
                throw new FileNotFoundException(String.format("Property file %s not found in classpath!", Constants.PROPERTIES_LOCATION));
            }
        }
        value = properties.getProperty(key);

        if (null == value) {
            LOGGER.log(Level.SEVERE, String.format("Property  '%s' not found! ", key));
            throw new FileNotFoundException(String.format("Property  '%s' not found in property file!", key));
        }
        LOGGER.info(String.format("Found value '%s' for key '%s'", value, key));
        return value;
    }


}
