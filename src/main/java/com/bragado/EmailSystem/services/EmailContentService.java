package com.bragado.EmailSystem.services;


import com.bragado.EmailSystem.dto.EmailContentDTO;
import com.bragado.EmailSystem.entities.EmailContent;

import java.util.Date;
import java.util.List;

public interface EmailContentService {

    EmailContent createEmail(EmailContentDTO emailContent);
    EmailContent updateEmail(EmailContentDTO emailContent, Long id);
    void updateUnreadStatus(Boolean isUnread, Long id);
    void updateDeliveryStatus(String deliveryStatus, Long id);
    EmailContent getEmail(Long id);

    boolean isEmailValid(String sender, String recipient);
    void deleteEmail(Long id);

    List<EmailContent>  getEmailList();
    List<EmailContent>  getUnreadEmails();
    List<EmailContent>  getReadEmails();

    List<EmailContent>  getDraftsSentBy(String email);
    List<EmailContent> getEmailsSentBy(String sender);
    List<EmailContent> getEmailsReceivedBy(String recipient);
    List<EmailContent> getEmailsCreatedAt(Date createdAt);

}
