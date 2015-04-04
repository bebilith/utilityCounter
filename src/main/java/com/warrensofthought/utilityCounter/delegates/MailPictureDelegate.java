package com.warrensofthought.utilityCounter.delegates;

import com.warrensofthought.utilityCounter.mail.MailClient;
import com.warrensofthought.utilityCounter.mail.MailClientSMPT;
import com.warrensofthought.utilityCounter.util.PropertiesHelper;
import com.warrensofthought.utilityCounter.util.PropertiesHelperFileReader;
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


    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        LOGGER.info("Processing request by process instance " + delegateExecution.getProcessInstanceId());
        MailClient mailClient = new MailClientSMPT();
        mailClient.sendNotificationMail();


        /**
         *   // Create the attachment
         EmailAttachment attachment = new EmailAttachment();
         attachment.setPath("mypictures/john.jpg");
         attachment.setDisposition(EmailAttachment.ATTACHMENT);
         attachment.setDescription("Picture of John");
         attachment.setName("John");

         // Create the email message
         MultiPartEmail email = new MultiPartEmail();
         email.setHostName("mail.myserver.com");
         email.addTo("jdoe@somewhere.org", "John Doe");
         email.setFrom("me@apache.org", "Me");
         email.setSubject("The picture");
         email.setMsg("Here is the picture you wanted");

         // add the attachment
         email.attach(attachment);

         // send the email
         email.send();
         */
    }
}
