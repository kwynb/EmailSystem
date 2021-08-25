package com.bragado.EmailSystem.repositories;


import com.bragado.EmailSystem.entities.EmailContent;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.data.jpa.repository.JpaRepository;
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


}
