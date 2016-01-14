/**
 * 
 */
package com.dci.service.impl;

import java.io.File;

import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.MailException;
import org.springframework.mail.MailSender;
//import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import com.dci.model.Users;
import com.dci.service.OrderManager;

/**
 * @author Administrator
 *
 */
@Service
public class OrderManagerImpl implements OrderManager {

	private JavaMailSender mailSender;
	private MailSender mailSenders;
    private SimpleMailMessage preConfiguredMessage;
    private MimeMessageHelper helper;

    public void setMailSender(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    public void setPreConfiguredMessage(SimpleMailMessage preConfiguredMessage) {
        this.preConfiguredMessage = preConfiguredMessage;
    }
    
    public void sendMail(String to, String subject, String body) {
    MimeMessage message = mailSender.createMimeMessage();

 
    try {
    	// use the true flag to indicate you need a multipart message
				helper = new MimeMessageHelper(message, true);
				helper.setFrom("rahadhitya@sriboga-smg.co.id");
				helper.setTo(to); /*"test@host.com"*/
				
				helper.setSubject("Sriboga FlourMill - Request to Approval for Purchase " + subject);
				
			 // use the true flag to indicate the text included is HTML
			 helper.setText(
			   /*"<html><body><img src='cid:identifier1234'></body></html> " + body);*/
			   /*true);*/
					 "Dear Sales, \n" 
					 + "Please see attachment, there Purchase Order awaiting for your approval. \n"
					 + "if you Agreed, please click >> www.sriboga-flourmill.co.id.  \n"
					 + "Thank You for your sincerly. \n"
					 + body);
			
			 // let's include the infamous windows Sample file (this time copied to c:/)
			 FileSystemResource res = new FileSystemResource(new File("c:/test.txt"));
			 helper.addInline("identifier1234", res);
			/* helper.addAttachment(subject, res);*/
			 // if you would need to include the file as an attachment, use
			 // addAttachment() methods on the MimeMessageHelper
			
			 mailSender.send(message);
		} catch (MessagingException e) {
			System.out.println(e);
			e.printStackTrace();
		}

    }
    public void sendPreConfiguredMail(Users users) {

        //... * Do the business calculations....
        //... * Call the collaborators to persist the order

        //Create a thread safe "sandbox" of the message
        SimpleMailMessage msg = new SimpleMailMessage(this.preConfiguredMessage);
        msg.setTo("agung.setyawan@sriboga-smg.co.id"); /*order.getCustomer().getEmailAddress()*/
        msg.setText(
            "Dear "
        		+ users.getName()
                /*+ order.getCustomer().getFirstName()
                + order.getCustomer().getLastName()*/
                + ", thank you for placing order. Your order number is "
                + users.getPassword());
                /*+ order.getOrderNumber());*/
        try{
        	mailSenders.send(msg);
        }
        catch(MailException ex) {
            //log it and go on
            System.err.println(ex.getMessage());            
        }
    }

}
