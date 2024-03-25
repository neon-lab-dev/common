package com.neonlab.common.repositories;

import com.neonlab.common.entities.AuthUser;
import com.neonlab.common.enums.VerificationMode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AuthUserRepository extends JpaRepository<AuthUser, String> {

    Optional<AuthUser> findByUserId(String userId);

    Optional<AuthUser> findByUserNameAndVerificationModeOrderByCreatedAtDesc(String userName, VerificationMode mode);

}
