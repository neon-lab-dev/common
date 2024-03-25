package com.neonlab.common.services;

import com.neonlab.common.annotations.Loggable;
import com.neonlab.common.dto.PhoneNoVerificationRequest;
import com.neonlab.common.entities.AuthUser;
import com.neonlab.common.entities.Otp;
import com.neonlab.common.enums.AuthType;
import com.neonlab.common.enums.VerificationMode;
import com.neonlab.common.expectations.InvalidInputException;
import com.neonlab.common.repositories.AuthUserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
@Loggable
@RequiredArgsConstructor
public class AuthUserService {

    private final AuthUserRepository authUserRepository;
    private final JwtTokenServices jwtTokenServices;

    public AuthUser createAuthUser(Otp otp, PhoneNoVerificationRequest request){
        var retVal = getAuthUserByUserNameAndMode(otp.getCommunicatedTo(), otp.getVerificationMode());
        retVal.setAuthType(AuthType.OTP);
        retVal.setUserName(otp.getCommunicatedTo());
        retVal.setDeviceId(request.getDeviceId());
        retVal.setVerificationMode(otp.getVerificationMode());
        retVal.setJWTtoken(UUID.randomUUID().toString());
        return authUserRepository.save(retVal);
    }

    public AuthUser getAuthUserByUserNameAndMode(String username, VerificationMode mode){
        try {
            return fetchAuthUserByUserNameAndMode(username, mode);
        } catch (InvalidInputException e) {
            log.warn(e.getMessage());
        }
        return new AuthUser();
    }

    public AuthUser fetchAuthUserByUserNameAndMode(String username, VerificationMode mode) throws InvalidInputException {
        var retVal = authUserRepository.findByUserNameAndVerificationModeOrderByCreatedAtDesc(username, mode);
        return retVal
                .orElseThrow(() ->
                        new InvalidInputException(String.format("AuthUser not found with username %s and verificationMode %s.", username, mode)));
    }

    public AuthUser fetchById(String id) throws InvalidInputException {
        return authUserRepository.findById(id).orElseThrow(() ->
                new InvalidInputException(String.format("AuthUser not found with id %s.",id)));
    }

    public AuthUser save(AuthUser authUser){
        return authUserRepository.save(authUser);
    }

}
