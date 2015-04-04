package com.warrensofthought.utilityCounter.mail;

import org.apache.commons.mail.Email;

/**
 * Created by till on 04.04.15.
 */
public interface MailClient {

    void sendNotificationMail() throws Exception;
}
