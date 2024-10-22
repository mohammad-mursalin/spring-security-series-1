package com.mursalin.spring_security_series_1.repository;

import com.mursalin.spring_security_series_1.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface UserRepo extends JpaRepository<Users, Integer> {
     Users findByUsername(String username);
}
