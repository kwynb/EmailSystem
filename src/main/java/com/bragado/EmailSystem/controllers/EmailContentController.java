package com.bragado.EmailSystem.controllers;

import com.bragado.EmailSystem.components.Response;
import com.bragado.EmailSystem.dto.EmailContentDTO;
import com.bragado.EmailSystem.components.EmailId;
import com.bragado.EmailSystem.entities.EmailContent;
import com.bragado.EmailSystem.services.EmailContentService;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/emails")
@Validated
public class EmailContentController {

    private final EmailContentService emailService;
    public EmailContentController(EmailContentService emailService) {
        this.emailService = emailService;
    }

    @PostMapping(value = "/new")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Object> createEmail(@Valid @RequestBody EmailContentDTO emailDTO) {
        if (!emailService.isEmailValid(emailDTO.getSender(), emailDTO.getRecipient())) {
            return new ResponseEntity<>(new Response("Invalid email. User not found."), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(emailService.createEmail(emailDTO), HttpStatus.CREATED);
    }

    @PutMapping(value = "/update")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Object> createEmail(@Valid @RequestBody EmailContentDTO emailDTO, @Valid @RequestParam(value = "id") Long id ) {
        if (!emailService.isEmailValid(emailDTO.getSender(), emailDTO.getRecipient())) {
            return new ResponseEntity<>(new Response("Invalid email. User not found."), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(emailService.updateEmail(emailDTO,id), HttpStatus.OK);
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

    @GetMapping(value = {"","/get"})
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<EmailContent>> getEmailList() { return new ResponseEntity<>(emailService.getEmailList(), HttpStatus.OK); }


    @GetMapping(value="/sent")
    public ResponseEntity<List<EmailContent>>  getEmailsSentBy(@RequestParam(value="by") @Email String email) {
        return new ResponseEntity<>(emailService.getEmailsSentBy(email),HttpStatus.OK);
    }

    @GetMapping(value="/received")
    public ResponseEntity<List<EmailContent>>  getEmailsReceivedBy(@RequestParam(value="by") @Email String email) {
        return new ResponseEntity<>(emailService.getEmailsReceivedBy(email),HttpStatus.OK);
    }

    @GetMapping(value="/created")
    public ResponseEntity<List<EmailContent>>  getEmailsCreatedAt(@RequestParam(value="at") @JsonFormat(pattern = "MM/dd/yyyy") Date date) {
        return new ResponseEntity<>(emailService.getEmailsCreatedAt(date),HttpStatus.OK);
    }

}
