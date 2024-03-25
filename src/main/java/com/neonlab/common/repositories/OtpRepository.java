package com.neonlab.common.repositories;

import com.neonlab.common.entities.Otp;
import com.neonlab.common.enums.OtpStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.Optional;

@Repository
public interface OtpRepository extends JpaRepository<Otp, String> {

    Optional<Otp> findFirstByCommunicatedToAndStatusOrderByCreatedAtDesc(String communicatedTo, String status);

    Optional<Otp> findFirstByCommunicatedToAndStatusAndPurposeOrderByCreatedAtDesc(String communicatedTo, OtpStatus status, String purpose);

}
