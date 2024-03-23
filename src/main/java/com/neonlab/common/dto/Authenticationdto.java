package com.neonlab.common.dto;

import lombok.Data;

@Data
public class Authenticationdto {

    private String email;
    private String phoneNo;
    private String verificationPurpose;
}
