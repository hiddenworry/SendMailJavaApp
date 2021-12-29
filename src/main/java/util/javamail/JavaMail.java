/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util.javamail;

import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author ADMIN
 */
public class JavaMail {

    public static void sendMail(String recepient) throws MessagingException {
        System.out.println("Prepared sending email");
        Properties properties = new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");
        
        
        //
        final String account = "hidden2792001@gmail.com";
        final String password = "bao2792001";
        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
             return new PasswordAuthentication(account, password);
            }   
        });
        Message message = preparedMessage(session, account, recepient);
        Transport.send(message);
        System.out.println("Send email successfully");

    }

    private static Message preparedMessage(Session session, String account, String recepient) {
      
        try {
             Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(account));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(recepient));
            message.setSubject("Hi there");
            message.setText("Hi there\n i'm youselt");
            return message;
        } catch (Exception e) {
            System.out.println("Failed!!!");
            e.printStackTrace();
        }
       return null;
    }
}
