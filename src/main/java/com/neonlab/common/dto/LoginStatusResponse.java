package com.neonlab.common.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LoginStatusResponse {
    private boolean loginStatus;
}
