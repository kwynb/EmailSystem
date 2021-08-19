package com.bragado.EmailSystem.repositories;

import com.bragado.EmailSystem.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.validation.constraints.Email;


public interface UserRepository extends JpaRepository<User, Long> {

    @Query(value="SELECT * FROM user_cp WHERE email = :email", nativeQuery = true)
    User findByEmail(@Param("email") @Email String email);

}
