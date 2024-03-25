package com.neonlab.common.repositories;

import com.neonlab.common.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

    Optional<User> findByPrimaryPhoneNo(String phone);

    @Query("select ur from User ur where ur.primaryPhoneNo = :searchParam or ur.email = :searchParam")
    Optional<User> findByPrimaryPhoneNoOrEmail(@Param("searchParam") String searchParam);

}
