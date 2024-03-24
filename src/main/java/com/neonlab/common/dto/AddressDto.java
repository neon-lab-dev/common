package com.neonlab.common.dto;

import lombok.Data;

@Data
public class AddressDto {

    private String userId;
    private String landMark;
    private String addressLine1;  // can't be null
    private String city; // UI dropdown list
    private String state;
    private String pinCode;
    private String addressName; // can't be null

}
