package com.warrensofthought.utilityCounter.mail;

import com.warrensofthought.utilityCounter.util.PropertiesHelper;
import com.warrensofthought.utilityCounter.util.PropertiesHelperFileReader;
import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.SimpleEmail;
import java.util.logging.Logger;

/**
 * Created by till on 04.04.15.
 */
public class NotificationMail extends SimpleEmail {

    private static final Logger LOGGER = Logger.getLogger(NotificationMail.class.getName());

    private static final String HOST = "mailHost";
    private static final String PORT = "mailPort";
    private static final String SEND_ADDRESS = "mailUser";
    private static final String SEND_PASSWORD = "mailPassword";
    private static final String SEND_FROM = "mailUser";
    private static final String SEND_TO = "mailTo";
    private static final String SUBJECT = "Utility Counter Notification Mail";
    private static final String BODY = "It's time for the daily CAPTCHA...";

    public NotificationMail withSSL(){
        this.setSSLOnConnect(true);
        this.setSmtpPort(465);
        return this;
    }

    public NotificationMail build() throws Exception {
        PropertiesHelper propertiesHelper = new PropertiesHelperFileReader();
        this.setHostName(propertiesHelper.getPropertyValueForKey(HOST));
        this.setAuthenticator(new DefaultAuthenticator(propertiesHelper.getPropertyValueForKey(SEND_ADDRESS), propertiesHelper.getPropertyValueForKey(SEND_PASSWORD)));
        this.setFrom(propertiesHelper.getPropertyValueForKey(SEND_FROM));
        this.setSubject(SUBJECT);
        this.setMsg(BODY);
        this.addTo(propertiesHelper.getPropertyValueForKey(SEND_TO));

        //this.getMailSession().getProperties().put("mail.smtp.auth", "true");
        //this.getMailSession().getProperties().put("mail.debug", "true");
        //this.getMailSession().getProperties().put("mail.smtp.port", "465");
        //this.getMailSession().getProperties().put("mail.smtp.socketFactory.port", "465");
        this.getMailSession().getProperties().put("mail.smtp.starttls.enable", "true");
        return this;
    }

    public NotificationMail getMail() throws Exception {
        return withSSL().build();
    }
}
