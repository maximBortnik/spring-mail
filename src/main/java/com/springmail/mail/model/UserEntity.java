package com.springmail.mail.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserEntity {

    private String name;
    private String surname;
    private String mail;
}
