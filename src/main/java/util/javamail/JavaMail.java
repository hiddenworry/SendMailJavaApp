/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util.javamail;

import java.io.File;
import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

/**
 *
 * @author ADMIN
 */
public class JavaMail extends Mail{

    public JavaMail(String username, String password) {
        super(username, password);
    }
      public void sendMail(String recepient, String header, String content) throws MessagingException {
        System.out.println("Prepared sending email");
        Properties properties = new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");

        //
        final String account = username;
        final String password = this.password;
        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(account, password);
            }
        });
        Message message = preparedMessage(session, account, recepient, header, content);
        Transport.send(message);
        System.out.println("Send email successfully");

    }

    private  Message preparedMessage(Session session, String account, String recepient, String header, String content) {

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(account));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(recepient));
            message.setSubject(header);
            message.setText(content);
            // send attatch file
//            BodyPart messageBodyPart = new MimeBodyPart();
//            messageBodyPart.setText("Mail Body");
//            MimeBodyPart attachmentPart = new MimeBodyPart();
//            attachmentPart.attachFile(new File("//File direct"));
//            Multipart multipart = new MimeMultipart();
//            multipart.addBodyPart(messageBodyPart);
//            multipart.addBodyPart(attachmentPart);
//            message.setContent(multipart);

            return message;
        } catch (Exception e) {
            System.out.println("Failed!!!");
            e.printStackTrace();
        }
        return null;
    }
   
    
  
}
