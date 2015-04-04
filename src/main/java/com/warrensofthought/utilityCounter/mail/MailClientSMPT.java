package com.warrensofthought.utilityCounter.mail;

import com.warrensofthought.utilityCounter.util.PropertiesHelperFileReader;
import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.SimpleEmail;

/**
 * Created by till on 04.04.15.
 */
public class MailClientSMPT implements MailClient {


    public void sendNotificationMail() throws Exception{
        Email email = new NotificationMail().build();
        email.send();
    }
}
