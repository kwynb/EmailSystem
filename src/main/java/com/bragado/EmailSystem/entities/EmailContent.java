package com.bragado.EmailSystem.entities;

import com.bragado.EmailSystem.components.AttributeEncryptor;
import com.bragado.EmailSystem.components.EmailId;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.validation.constraints.Email;
import javax.persistence.*;
import java.util.Date;


@Entity
@DynamicUpdate
@Table(name="email")
@EntityListeners(AuditingEntityListener.class)
public class EmailContent {

    @Id
    @EmailId
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Email
    private String sender;
    @Email
    private String recipient;
    @Convert(converter = AttributeEncryptor.class)
    private String subject;
    @Convert(converter = AttributeEncryptor.class)
    private String text;
    @Column(name = "delivery_status")
    private String deliveryStatus;
    @Column(name = "is_unread")
    private Boolean isUnread;
    @CreatedDate
    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(pattern = "MM/dd/yyyy HH:mm:ss", timezone = "Asia/Manila")
    private Date createdAt;

    @LastModifiedDate
    @Column(name = "last_modified")
    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(pattern = "MM/dd/yyyy HH:mm:ss", timezone = "Asia/Manila")
    private Date lastModified;

    public EmailContent() {}


    public EmailContent(String sender, String recipient, String subject, String text) {
        this.sender = sender;
        this.recipient = recipient;
        this.subject = subject;
        this.text = text;
    }

    public EmailContent(String sender, String recipient, String subject, String text, String deliveryStatus, Boolean isUnread) {
        this.sender = sender;
        this.recipient = recipient;
        this.subject = subject;
        this.text = text;
        this.deliveryStatus = deliveryStatus;
        this.isUnread = isUnread;
    }

    public EmailContent(Long id, String sender, String recipient, String subject, String text, String deliveryStatus, Boolean isUnread, Date createdAt, Date lastModified) {
        this.id = id;
        this.sender = sender;
        this.recipient = recipient;
        this.subject = subject;
        this.text = text;
        this.deliveryStatus = deliveryStatus;
        this.isUnread = isUnread;
        this.createdAt = createdAt;
        this.lastModified = lastModified;
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

    public String getDeliveryStatus() {
        return deliveryStatus;
    }

    public void setDeliveryStatus(String deliveryStatus) {
        this.deliveryStatus = deliveryStatus;
    }

    public Boolean getUnread() {
        return isUnread;
    }

    public void setUnread(Boolean unread) {
        isUnread = unread;
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

    @Override
    public String toString() {
        return "EmailContent{" +
                "id=" + id +
                ", sender='" + sender + '\'' +
                ", recipient='" + recipient + '\'' +
                ", subject='" + subject + '\'' +
                ", text='" + text + '\'' +
                ", isUnread=" + isUnread +
                ", createdAt=" + createdAt +
                ", lastModified=" + lastModified +
                '}';
    }
}

