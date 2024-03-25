package com.neonlab.common.dto;

import lombok.Data;

@Data
public class PhoneNoVerificationRequest extends AuthenticationRequest {
    private String phoneNo;
}
