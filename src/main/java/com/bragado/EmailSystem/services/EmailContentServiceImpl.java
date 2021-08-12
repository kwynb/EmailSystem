package com.bragado.EmailSystem.services;

import com.bragado.EmailSystem.components.RestService;
import com.bragado.EmailSystem.dto.EmailContentDTO;
import com.bragado.EmailSystem.entities.EmailContent;
import com.bragado.EmailSystem.entities.User;
import com.bragado.EmailSystem.repositories.EmailContentRepository;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Date;
import java.util.List;

@Service
public class EmailContentServiceImpl implements EmailContentService {
    private final EmailContentRepository emailRepository;

    private final RestTemplate restTemplate;

    public EmailContentServiceImpl(EmailContentRepository emailRepository, RestTemplateBuilder restTemplateBuilder) {
        this.emailRepository = emailRepository;
        this.restTemplate = restTemplateBuilder.build();
    }

    @Override
    public EmailContent createEmail(EmailContentDTO emailContent) {
        return emailRepository.save(emailContent.toEmail());
    }

    @Override
    public EmailContent updateEmail(EmailContentDTO emailContent, Long id) {
        EmailContent email = emailRepository.findById(id).get();
        email.setSender(emailContent.getSender());
        email.setRecipient(emailContent.getRecipient());
        email.setSubject(emailContent.getSubject());
        email.setText(emailContent.getText());
        return emailRepository.save(email);
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

    @Override
    public User getUserByEmail(String email) {
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl("http://localhost:8080/users/get/email")
                .queryParam("email", email);
        User response = RestService.call(builder,HttpMethod.GET,User.class);
        return response;
    }

    @Override
    public List<EmailContent> getEmailsSentBy(String sender) {
        return emailRepository.findEmailsSentBy(sender);
    }

    @Override
    public List<EmailContent> getEmailsReceivedBy(String recipient) {
        return emailRepository.findEmailsReceivedBy(recipient);
    }

    @Override
    public List<EmailContent> getEmailsCreatedAt(Date createdAt) {
        return emailRepository.findEmailsCreatedAt(createdAt);
    }


}
