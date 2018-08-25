package com.springmail.mail.service;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class Constant {

    public static final String NAME = "firstName";
    public static final String SURNAME = "lastName";
    public static final String LOCATION = "location";
    public static final String SIGNATURE = "signature";
}
