package com.bragado.EmailSystem.services;


import com.bragado.EmailSystem.dto.EmailContentDTO;
import com.bragado.EmailSystem.entities.EmailContent;

public interface EmailContentService {

    EmailContent createEmail(EmailContentDTO emailContent);
    EmailContent getEmail(Long id);
    void deleteEmail(Long id);
}
