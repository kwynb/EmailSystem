package com.bragado.EmailSystem.repositories;


import com.bragado.EmailSystem.entities.EmailContent;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.validation.constraints.Email;
import java.util.Date;
import java.util.List;


@Repository
public interface EmailContentRepository extends JpaRepository<EmailContent, Long> {

    @Query(value="SELECT * FROM email WHERE sender = :sender", nativeQuery = true)
    List<EmailContent> findEmailsSentBy(@Param("sender") @Email String sender);

    @Query(value="SELECT * FROM email WHERE recipient = :recipient", nativeQuery = true)
    List<EmailContent> findEmailsReceivedBy(@Param("recipient") @Email String recipient);

    @Query(value="SELECT * FROM email WHERE CAST(created_at AS DATE) = :created_at", nativeQuery = true)
    List<EmailContent> findEmailsCreatedAt(@Param("created_at") @JsonFormat(pattern = "MM-dd-yyyy") Date createdAt);

    @Query(value="SELECT * FROM email WHERE is_unread = :is_unread", nativeQuery = true)
    List<EmailContent> findUnreadEmails(@Param("is_unread") Boolean isUnread);

    @Modifying(clearAutomatically=true, flushAutomatically=true)
    @Query(value="UPDATE email SET is_unread = :is_unread WHERE id = :id", nativeQuery = true)
    void updateUnreadStatus(@Param("is_unread") Boolean isUnread, @Param("id") Long id );

    @Modifying(clearAutomatically=true, flushAutomatically=true)
    @Query(value="UPDATE email SET delivery_status = :delivery_status WHERE id = :id", nativeQuery = true)
    void updateDeliveryStatus(@Param("delivery_status") String delivery_status, @Param("id") Long id);

    @Query(value="SELECT * FROM email WHERE delivery_status = :delivery_status AND sender= :sender", nativeQuery = true)
    List<EmailContent> findEmailsByDeliveryStatus(@Param("delivery_status") String delivery_status, @Param("sender") @Email String sender);

    @Query(value="SELECT * FROM email ORDER BY last_modified ASC", nativeQuery = true)
    List<EmailContent> sortByASC();

    @Query(value="SELECT * FROM email ORDER BY last_modified DESC", nativeQuery = true)
    List<EmailContent> sortByDESC();

}
