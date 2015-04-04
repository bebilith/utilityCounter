package com.warrensofthought.utilityCounter.mail;

import com.warrensofthought.utilityCounter.util.PropertiesHelperFileReader;
import org.junit.Test;

import javax.mail.internet.InternetAddress;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Created by till on 04.04.15.
 */
public class NotificationMailTest {

    @Test
    public void shouldCreateCorrectNotificationMail() throws Exception {
        //GIVEN
        final PropertiesHelperFileReader propertiesHelper = new PropertiesHelperFileReader();
        final InternetAddress fromAddress = new InternetAddress(propertiesHelper.getPropertyValueForKey("mailUser"));
        final InternetAddress toAddress = new InternetAddress(propertiesHelper.getPropertyValueForKey("mailTo"));
        final String subject = "Utility Counter Notification Mail";
        final String sslSocket = "465";

        //WHEN
        NotificationMail mail = new NotificationMail().getMail();

        //THEN
        assertThat(mail.getFromAddress().getAddress(), is(fromAddress.getAddress()));
        assertThat(mail.getToAddresses().size(), is(1));
        assertThat(mail.getToAddresses().get(0).getAddress(), is(toAddress.getAddress()));
        assertThat(mail.getSubject(), is(subject));
        assertThat(mail.getSmtpPort(), is(sslSocket));
    }
}
