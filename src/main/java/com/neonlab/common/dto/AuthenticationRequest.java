package com.neonlab.common.dto;

import lombok.Data;

@Data
public class AuthenticationRequest {

    private String deviceId;
    private String purpose;
    private String otp;
}
