package com.bragado.userregistration.dto;

import com.bragado.EmailSystem.entities.User;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.validation.constraints.Email;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UserDTO {

    private String firstName;
    private String lastName;
    @Email(message = "Email should be valid.")
    private String email;

    public UserDTO() {
    }

    public UserDTO(String firstName, String lastName, String email) {
        super();
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
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

    public User toUser() {
        return new User(firstName,lastName, email);
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
