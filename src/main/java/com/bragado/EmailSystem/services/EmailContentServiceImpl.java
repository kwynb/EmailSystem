package com.bragado.EmailSystem.services;

import com.bragado.EmailSystem.dto.EmailContentDTO;
import com.bragado.EmailSystem.entities.EmailContent;
import com.bragado.EmailSystem.repositories.EmailContentRepository;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class EmailContentServiceImpl implements EmailContentService {

    private final EmailContentRepository emailRepository;

    public EmailContentServiceImpl(EmailContentRepository emailRepository) {
        this.emailRepository = emailRepository;
    }

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

    @Override
    public List<EmailContent> getEmailList() { return emailRepository.findAll(); }


}
