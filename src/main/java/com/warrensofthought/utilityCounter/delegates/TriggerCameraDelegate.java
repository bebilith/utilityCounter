package com.warrensofthought.utilityCounter.delegates;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

import java.util.logging.Logger;

/**
 * Created by till on 07.03.15.
 */
public class TriggerCameraDelegate implements JavaDelegate {

    private static final Logger LOGGER = Logger.getLogger(TriggerCameraDelegate.class.getName());

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        LOGGER.info("Processing request by process instance " + delegateExecution.getProcessInstanceId());
    }
}
