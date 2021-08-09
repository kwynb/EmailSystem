package com.bragado.EmailSystem.controllers;

import com.bragado.EmailSystem.components.Response;
import com.bragado.EmailSystem.dto.EmailContentDTO;
import com.bragado.EmailSystem.dto.EmailId;
import com.bragado.EmailSystem.entities.EmailContent;
import com.bragado.EmailSystem.services.EmailContentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/email")
@Validated
public class EmailContentController {

    private final EmailContentService emailService;

    public EmailContentController(EmailContentService emailService) {
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

}
