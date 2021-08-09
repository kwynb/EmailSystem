package com.bragado.EmailSystem.entities;

import com.bragado.EmailSystem.components.AttributeEncryptor;
import com.bragado.EmailSystem.dto.EmailId;

import javax.validation.constraints.Email;

import javax.persistence.*;

@Entity
@Table(name="emaildb")
public class EmailContent {

    @Id
    @EmailId
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Email(message = "Email should be valid.")
    private String sender;
    @Email(message = "Email should be valid.")
    private String recipient;

    @Convert(converter = AttributeEncryptor.class)
    private String subject;
    @Convert(converter = AttributeEncryptor.class)
    private String text;

    public EmailContent() {}

    public EmailContent(String sender, String recipient, String subject, String text) {
        this.sender = sender;
        this.recipient = recipient;
        this.subject = subject;
        this.text = text;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "EmailContent{" +
                "id=" + id +
                ", sender='" + sender + '\'' +
                ", recipient='" + recipient + '\'' +
                ", subject='" + subject + '\'' +
                ", text='" + text + '\'' +
                '}';
    }
}
