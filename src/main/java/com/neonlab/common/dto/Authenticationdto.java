package com.neonlab.common.dto;

import com.neonlab.common.dto.enums.OtpPurpose;
import lombok.Data;

@Data
public class Authenticationdto {

    private String email;
    private String phoneNo;
    private OtpPurpose verificationPurpose;
}
