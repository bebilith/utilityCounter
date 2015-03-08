package com.warrensofthought.utilityCounter.application;

import com.warrensofthought.utilityCounter.util.Constants;
import org.camunda.bpm.application.ProcessApplication;
import org.camunda.bpm.application.impl.ServletProcessApplication;

/**
 * Created by till on 07.03.15.
 */
@ProcessApplication(Constants.APP_NAME)
public class UtilityCounterApplication extends ServletProcessApplication {
}
