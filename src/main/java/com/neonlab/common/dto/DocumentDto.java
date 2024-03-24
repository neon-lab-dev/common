package com.neonlab.common.dto;


import lombok.Data;

@Data
public class DocumentDto {

    private String userId;
    private String documentName; // != null
    private String MIMEtype;
    private String base64; // standard
    private String docIdentifier;
    private String entityName;

}
