package com.bragado.EmailSystem.controllers;

import com.bragado.EmailSystem.components.Response;
import com.bragado.EmailSystem.dto.EmailContentDTO;
import com.bragado.EmailSystem.dto.EmailId;
import com.bragado.EmailSystem.entities.EmailContent;
import com.bragado.EmailSystem.entities.User;
import com.bragado.EmailSystem.services.EmailContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

@RestController
@RequestMapping("/email")
@Validated
public class EmailContentController {

    private final EmailContentService emailService;
    private final RestTemplate restTemplate;

    public EmailContentController(EmailContentService emailService,RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
        this.emailService = emailService;
    }

    @PostMapping(value = "/new")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<EmailContent> createEmail(@Valid @RequestBody EmailContentDTO emailDTO) {
        return new ResponseEntity<>(emailService.createEmail(emailDTO), HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/delete")
    @ResponseStatus(HttpStatus.OK)
    public Response deleteEmail(@Valid @RequestParam(value="id") Long id) {
        EmailContent emailContent = emailService.getEmail(id);
        if (emailContent == null) {
            return new Response("No such email.");
        }
        emailService.deleteEmail(id);
        return new Response("Email deleted.");
    }

    @GetMapping(value = "/get/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Object> getUser(@EmailId @PathVariable(value = "id") Long id)  {
        EmailContent emailContent = emailService.getEmail(id);
        if (emailContent == null) {
            return new ResponseEntity<>(new Response("No such email."), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(emailContent, HttpStatus.OK);
    }

    @GetMapping(value = "/get")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<EmailContent>> getEmailList() { return new ResponseEntity<>(emailService.getEmailList(), HttpStatus.OK); }

    @GetMapping(value="/user")
    public ResponseEntity<User>  getUser(@RequestParam(value="email") String email) {
        return new ResponseEntity<>(emailService.getUserByEmail(email),HttpStatus.OK);
    }

}
