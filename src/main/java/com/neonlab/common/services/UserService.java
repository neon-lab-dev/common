package com.neonlab.common.services;

import com.neonlab.common.annotations.Loggable;
import com.neonlab.common.dto.SignUpRequest;
import com.neonlab.common.entities.User;
import com.neonlab.common.expectations.InvalidInputException;
import com.neonlab.common.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@Loggable
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public User createUser(SignUpRequest request){
        var retVal = new User();
        retVal.setName(request.getName());
        retVal.setEmail(request.getEmail());
        retVal.setPrimaryPhoneNo(request.getPrimaryPhoneNo());
        retVal.setCreatedAt(new Date());
        retVal.setModifiedAt(new Date());
        return userRepository.save(retVal);
    }

    public User fetchByPrimaryPhoneNo(String phone) throws InvalidInputException {
        return userRepository.findByPrimaryPhoneNo(phone)
                .orElseThrow(() -> new InvalidInputException(String.format("User not found with primary Phone no %s", phone)));
    }

}
