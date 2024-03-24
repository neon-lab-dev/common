package com.neonlab.common.dto;

import lombok.Data;

@Data
public class VerificationReqDto extends Authenticationdto {
    private String otp;
}
