package com.bragado.EmailSystem.services;

import com.bragado.EmailSystem.dto.EmailContentDTO;
import com.bragado.EmailSystem.entities.EmailContent;
import com.bragado.EmailSystem.repositories.EmailContentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmailContentServiceImpl implements EmailContentService {

    @Autowired
    private EmailContentRepository emailRepository;

    @Override
    public EmailContent createEmail(EmailContentDTO emailContent) {
        return emailRepository.save(emailContent.toEmail());
    }

    @Override
    public void deleteEmail(Long id) {
        emailRepository.deleteById(id);
    }


    @Override
    public EmailContent getEmail(Long id) {
        if (!emailRepository.findById(id).isPresent()) {
            return null;
        }
        return emailRepository.findById(id).get();
    }
}
