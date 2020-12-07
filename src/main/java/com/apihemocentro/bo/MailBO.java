package com.apihemocentro.bo;


import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.apihemocentro.dto.DoadorDTO;

public class MailBO {

    public void SendEmailTLS(DoadorDTO doador) {

        final String username = "ddronefiap@gmail.com";
        final String password = "12345@21";

        Properties prop = new Properties();
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true"); // TLS

        Session session = Session.getInstance(prop, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("ddronefiap@gmail.com"));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("ifgandrade@gmail.com"));
            message.setSubject("Confirmação de cadastro");
            message.setText("Ola " + doador.getNome() +"!\n\n Seu cadastro na plataforma Sangue Bom foi realizado com sucesso.");
            Transport.send(message);

            System.out.println("E-mail send!");

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
