/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util.javamail;

import javax.mail.MessagingException;

/**
 *
 * @author ADMIN
 */
public class SendMailTest {
    public static void main(String[] args) throws MessagingException {
      JavaMail j = new JavaMail("xxxx@gmail.com", "xxxxx");
      j.sendMail("xxxx@mail.com", "<h1>hi</h1>", "something");
    }
}
