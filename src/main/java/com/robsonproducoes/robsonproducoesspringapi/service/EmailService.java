/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.robsonproducoes.robsonproducoesspringapi.service;

import com.robsonproducoes.robsonproducoesspringapi.model.EmailBody;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import lombok.AllArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

/**
 *
 * @author pedro
 */
@Service
@AllArgsConstructor
public class EmailService {

  private final JavaMailSender mailSender;

  public void sendEmail(EmailBody emailBody) {
    try {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper;

        if (emailBody.getSampleFile().getSize() == 0) {
          helper = new MimeMessageHelper(message, true);
          helper.addAttachment(emailBody.getSampleFile().getOriginalFilename(), emailBody.getSampleFile());
        } else {
          helper = new MimeMessageHelper(message, false);
        }

        helper.setFrom("alohasarrante@gmail.com");
        helper.setTo("pedroclain20@gmail.com");
        helper.setSubject("robsonproduções");
        helper.setText(buildMessage(emailBody));

        mailSender.send(message);
      } catch (MessagingException ex) {
        Logger.getLogger(EmailService.class.getName()).log(Level.SEVERE, null, ex);
      }

  }

  private String buildMessage(EmailBody emailBody) {
    StringBuilder builder = new StringBuilder();
    builder.append("Olá Robson Freitas, você recebeu uma proposta.\n");
    builder.append("De: ");
    builder.append(emailBody.getName());
    builder.append("\n\n");
    builder.append(emailBody.getMessage());
    builder.append("\n\nDe: ");
    builder.append(emailBody.getEmail());
    return builder.toString();
  }
}
