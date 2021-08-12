package com.bragado.EmailSystem.services;


import com.bragado.EmailSystem.dto.EmailContentDTO;
import com.bragado.EmailSystem.entities.EmailContent;
import com.bragado.EmailSystem.entities.User;

import java.util.Date;
import java.util.List;

public interface EmailContentService {

    EmailContent createEmail(EmailContentDTO emailContent);
    EmailContent updateEmail(EmailContentDTO emailContent, Long id);
    EmailContent getEmail(Long id);
    void deleteEmail(Long id);
    List<EmailContent> getEmailList();

    User getUserByEmail(String email);
    List<EmailContent> getEmailsSentBy(String sender);
    List<EmailContent> getEmailsReceivedBy(String recipient);
    List<EmailContent> getEmailsCreatedAt(Date createdAt);

}
