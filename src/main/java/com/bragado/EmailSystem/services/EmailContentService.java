package com.bragado.EmailSystem.services;


import com.bragado.EmailSystem.dto.EmailContentDTO;
import com.bragado.EmailSystem.entities.EmailContent;
import com.bragado.EmailSystem.entities.User;

import java.util.List;

public interface EmailContentService {

    EmailContent createEmail(EmailContentDTO emailContent);
    EmailContent getEmail(Long id);
    void deleteEmail(Long id);
    List<EmailContent> getEmailList();
    User getUserByEmail(String email);
}
