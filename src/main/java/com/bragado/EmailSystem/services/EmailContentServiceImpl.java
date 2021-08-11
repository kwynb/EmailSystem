package com.bragado.EmailSystem.services;

import com.bragado.EmailSystem.dto.EmailContentDTO;
import com.bragado.EmailSystem.entities.EmailContent;
import com.bragado.EmailSystem.entities.User;
import com.bragado.EmailSystem.repositories.EmailContentRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;


import java.util.Arrays;
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
    public User getUserByEmail(String email) {
        HttpHeaders headers = new HttpHeaders();
        headers.set(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE);

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl("http://localhost:8080/users/get/email")
                .queryParam("email", email);

        HttpEntity<?> entity = new HttpEntity<>(headers);

        HttpEntity<User> response = restTemplate.exchange(
                builder.toUriString(),
                HttpMethod.GET,
                entity,
                User.class);

        return response.getBody();
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
