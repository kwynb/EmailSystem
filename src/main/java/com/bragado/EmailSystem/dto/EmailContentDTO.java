package com.bragado.EmailSystem.dto;

import com.bragado.EmailSystem.entities.EmailContent;

import java.util.Date;

public class EmailContentDTO {

    private String sender;
    private String recipient;
    private String subject;
    private String text;
    private Date createdAt;
    private Date lastModified;

    public EmailContentDTO(String sender, String recipient, String subject, String text, Date createdAt, Date lastModified) {
        this.sender = sender;
        this.recipient = recipient;
        this.subject = subject;
        this.text = text;
        this.createdAt = createdAt;
        this.lastModified = lastModified;
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

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getLastModified() {
        return lastModified;
    }

    public void setLastModified(Date lastModified) {
        this.lastModified = lastModified;
    }

    public EmailContent toEmail() { return new EmailContent(sender,recipient,subject,text); }
}


