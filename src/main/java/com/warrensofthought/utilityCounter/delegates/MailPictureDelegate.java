package com.warrensofthought.utilityCounter.delegates;

import com.warrensofthought.utilityCounter.util.PropertiesHelper;
import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.SimpleEmail;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

import java.util.logging.Logger;

/**
 * Created by till on 07.03.15.
 */
public class MailPictureDelegate implements JavaDelegate {
    private static final Logger LOGGER = Logger.getLogger(MailPictureDelegate.class.getName());

    private static final String HOST = "mailHost";
    private static final String PORT = "mailPort";
    private static final String SEND_ADDRESS = "mailUser";
    private static final String SEND_PASSWORD = "mailPassword";
    private static final String SEND_FROM = "mailUser";
    private static final String SEND_TO = "mailTo";

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        LOGGER.info("Processing request by process instance " + delegateExecution.getProcessInstanceId());
        PropertiesHelper propertiesHelper = new PropertiesHelper();
        Email email = new SimpleEmail();
        email.setHostName(propertiesHelper.getPropertyValueForKey(HOST));
        email.setSmtpPort(465);
        email.setAuthenticator(new DefaultAuthenticator(propertiesHelper.getPropertyValueForKey(SEND_ADDRESS), propertiesHelper.getPropertyValueForKey(SEND_PASSWORD)));
        email.setSSLOnConnect(true);
        email.setFrom(propertiesHelper.getPropertyValueForKey(SEND_FROM));
        email.setSubject("TestMail");
        email.setMsg("This is a test mail ... :-)");
        email.addTo(propertiesHelper.getPropertyValueForKey(SEND_TO));
        email.send();
    }
}
