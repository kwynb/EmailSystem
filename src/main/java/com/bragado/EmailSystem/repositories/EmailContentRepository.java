package com.bragado.EmailSystem.repositories;

import com.bragado.EmailSystem.entities.EmailContent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmailContentRepository extends JpaRepository<EmailContent, Long> {
}
