package com.bragado.userregistration.entities;


import com.bragado.userregistration.dto.UserDTO;

import javax.validation.constraints.NotNull;

public class UserEvent {
    private String event;

    @NotNull
    private UserDTO userDTO;

    public UserEvent() {
    }

    public UserEvent(String event, UserDTO userDTO) {
        this.event = event;
        this.userDTO = userDTO;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public UserDTO getUserDTO() {
        return userDTO;
    }

    public void setUserDTO(UserDTO userDTO) {
        this.userDTO = userDTO;
    }

    @Override
    public String toString() {
        return "UserEvent{" +
                "event='" + event + '\'' +
                ", userDTO=" + userDTO +
                '}';
    }

}
