/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.spring.service;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.stereotype.Service;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Febryo
 */
@Service
public class MailSender {

    private Session session;
    private String host;
    private String user;
    private String password;
    static final Logger logger = Logger.getLogger(MailSender.class.getName());
    public MailSender(){}
    public MailSender(String host, String user, String password) {
        //Init variables
        this.host =  ""; //host;
        this.user =  "";
        this.password = "";
        // Get system properties
        Properties props = System.getProperties();
        // Setup mail server
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.user", user);
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.debug", "true");
        session = Session.getDefaultInstance(props);
    }

    public int sendMessage(String to, String subject, String msgText) {
        // Define message
        MimeMessage message = new MimeMessage(session);
        Transport tr = null;
        try {
            // Set the from address
            message.setFrom(new InternetAddress(user));
            // Set the to address
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            // Set the subject
            message.setSubject(subject);
            // Set the content
            message.setText(msgText);
            // Send message
            tr = session.getTransport("smtp");
            tr.connect("", 587, "", "");
            message.saveChanges();
            tr.sendMessage(message, message.getAllRecipients());
        } catch (AddressException e) {
            logger.log(Level.SEVERE, null, e);
            // Error AddressException
            return 1;
        } catch (MessagingException e) {
            logger.log(Level.SEVERE, null, e);
            // Error MessagngException
            return 2;
        } catch (Exception e) {
            logger.log(Level.SEVERE, null, e);
        } finally {
            try {
                tr.close();
            } catch (MessagingException e) {
                logger.log(Level.SEVERE, null, e);
            }
        }
        return 0;
    }
}
