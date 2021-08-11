package com.bragado.EmailSystem.repositories;


import com.bragado.EmailSystem.entities.EmailContent;
import com.bragado.EmailSystem.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.validation.constraints.Email;


@Repository
public interface EmailContentRepository extends JpaRepository<EmailContent, Long> {

//    @Query(value="SELECT firstname, lastname, email, FROM userdb u WHERE u.email = :email")
//    User findByEmail(@Param("email") @Email String email);

}
