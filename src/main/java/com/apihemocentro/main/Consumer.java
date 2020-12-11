package com.apihemocentro.main;

import java.util.List;

import com.apihemocentro.bo.ConsumerBO;
import com.apihemocentro.bo.MailBO;
import com.apihemocentro.dto.DoadorDTO;
import com.apihemocentro.dto.BancoDeSangueDTO;

public class Consumer {

    public static void main(String[] args) throws InterruptedException {

        while (true) {

            List<String> messages = new ConsumerBO().getMessages();

            if (messages.size() > 0) {

                for (String message : messages) {
                    if (message.contains(";hemocentro")) {

                        DoadorDTO doador = new DoadorDTO(message);
                        new MailBO().SendEmailTLSDoador(doador);
                        continue;
                    }
                    if (message.contains(";doador"))
                    {
                        BancoDeSangueDTO banco = new BancoDeSangueDTO(message);
                        new MailBO().SendEmailTLSBancoDeSangue(banco);
                        continue;
                    }

                }
            }

            Thread.sleep(5000);
        }
    }
}
