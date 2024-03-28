package com.neonlab.common.entities;

import com.neonlab.common.enums.AuthType;
import com.neonlab.common.enums.VerificationMode;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@Table(name = "auth_user", indexes = {
        @Index(name = "idx_auth_user_id", columnList = "user_id"),
        @Index(name = "idx_user_name", columnList = "user_name"),
        @Index(name = "idx_auth_type", columnList = "auth_type")
})
public class AuthUser extends Generic {

    public AuthUser(){
        super();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(name = "user_id")
    private String userId;

    @Column(name = "user_name")//index/ph no/email
    private String userName;

    @Enumerated(EnumType.STRING)
    @Column(name = "auth_type") //index/otp
    private AuthType authType;

    @Enumerated(EnumType.STRING)
    @Column(name = "verification_mode")
    private VerificationMode verificationMode;

    @Column(name = "device_id") //index/otp
    private String deviceId;

    @Column(name = "token")
    private String JWTtoken;

    //generic

}
