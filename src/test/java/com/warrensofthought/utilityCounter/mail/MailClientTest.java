package com.warrensofthought.utilityCounter.mail;

import org.junit.Test;

/**
 * Created by till on 04.04.15.
 */
public class MailClientTest {

    @Test
    public void shouldSendMail() throws Exception {
        MailClient mailClient = new MailClientSMPT();
        mailClient.sendNotificationMail();
    }
}
