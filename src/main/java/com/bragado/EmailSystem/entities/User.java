package com.bragado.EmailSystem.entities;


import com.bragado.userregistration.dto.UserDTO;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Past;
import java.util.Date;


@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
@Table(name="user_cp")
public class User {
    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userId;

    @Column(name = "firstname")
    private String firstName;
    @Column(name = "lastname")
    private String lastName;
//
//    @Column(name = "birthday")
//    @Past(message = "Birthday should be valid.")
//    @JsonFormat(pattern="MM/dd/yyyy", shape = JsonFormat.Shape.STRING, timezone = "Asia/Manila")
//    private Date birthDay;

    @Email(message = "Email should be valid.")
    private String email;
    public User() {}

    public User(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public UserDTO toUserDTO() {
        return new UserDTO(firstName,lastName,email);
    }

}
