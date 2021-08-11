package com.bragado.EmailSystem.dto;

import com.bragado.EmailSystem.entities.EmailContent;

public class EmailContentDTO {

    private String sender;
    private String recipient;

    private String subject;
    private String text;

    public EmailContentDTO(String sender, String recipient, String subject, String text) {
        this.sender = sender;
        this.recipient = recipient;
        this.subject = subject;
        this.text = text;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public EmailContent toEmail() { return new EmailContent(sender,recipient,subject,text); }
}


