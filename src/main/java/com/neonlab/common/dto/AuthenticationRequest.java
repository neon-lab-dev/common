package com.neonlab.common.dto;

import lombok.Data;

@Data
public class AuthenticationRequest {

    private String verificationPurpose;
    private String otp;
}
