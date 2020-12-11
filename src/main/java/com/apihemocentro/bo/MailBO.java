package com.apihemocentro.bo;


import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.apihemocentro.dto.BancoDeSangueDTO;
import com.apihemocentro.dto.DoadorDTO;

public class MailBO {

    final String username = "ddronefiap@gmail.com";
    final String password = "12345@21";
    Properties prop;

    public void SendEmailTLSBancoDeSangue(BancoDeSangueDTO banco) {


        prop = new Properties();
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
            message.setFrom(new InternetAddress("sanguebom@gmail.com"));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(banco.getEmail()));
            message.setSubject("Confirmação de cadastro");
            message.setText("Ola " + banco.getNome() +"!\n\n Seu cadastro na plataforma Sangue Bom foi realizado com sucesso.");
            Transport.send(message);

            System.out.println("E-mail send!");

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
    public void SendEmailTLSDoador(DoadorDTO doador) {
        prop = new Properties();
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
            message.setFrom(new InternetAddress("sanguebom@gmail.com"));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(doador.getEmail()));
            message.setSubject("Confirmação de cadastro");
            message.setText("Ola " + doador.getNome() +"!\n\n Seu cadastro na plataforma Sangue Bom foi realizado com sucesso.");
            Transport.send(message);

            System.out.println("E-mail send!");

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
