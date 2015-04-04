package com.warrensofthought.utilityCounter.util;

import java.io.FileNotFoundException;

/**
 * Created by till on 04.04.15.
 */
public interface PropertiesHelper {

    String getPropertyValueForKey(String key) throws FileNotFoundException;
}
