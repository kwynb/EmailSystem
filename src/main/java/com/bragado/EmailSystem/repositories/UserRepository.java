package com.bragado.EmailSystem.repositories;

import com.bragado.EmailSystem.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.validation.constraints.Email;


public interface UserRepository extends JpaRepository<User, Long> {

    @Query(value="SELECT * FROM user_copy WHERE email = :email", nativeQuery = true)
    User findByEmail(@Param("email") @Email String email);

    @Query(value="SELECT * FROM user_copy WHERE firstname = :firstname AND lastname = :lastname", nativeQuery = true)
    User findByName(@Param("firstname") String firstname, @Param("lastname") String lastname);


}
