package com.neonlab.common.dto;

import lombok.Data;

@Data
public class LoginRequest {

    private String username;
    private Boolean verified;

}
