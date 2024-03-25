package com.neonlab.common.entities;

import com.neonlab.common.enums.OtpStatus;
import com.neonlab.common.enums.VerificationMode;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "otp", indexes = {
        @Index(name = "idx_communicated_to", columnList = "communicated_to"),
        @Index(name = "idx_status", columnList = "status")
})
@Data
@AllArgsConstructor
public class Otp extends Generic {

    public Otp(){
        super();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "communicated_to")
    private String communicatedTo;

    @Enumerated(EnumType.STRING)
    @Column(name = "verification_mode")
    private VerificationMode verificationMode;

    @Column(name = "otp")
    private String otp;

    @Column(name = "service_provider")
    private String serviceProvider;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private OtpStatus status;

    @Column(name = "expiry_time")
    private Date expiryTime;

    @Column(name = "purpose")
    private String purpose;


}
