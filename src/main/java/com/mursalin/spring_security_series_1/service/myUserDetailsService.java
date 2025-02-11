package com.mursalin.spring_security_series_1.service;

import com.mursalin.spring_security_series_1.model.UserPrinciples;
import com.mursalin.spring_security_series_1.model.Users;
import com.mursalin.spring_security_series_1.repository.UserRepo;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class myUserDetailsService implements UserDetailsService {

    private UserRepo repo;

    public myUserDetailsService(UserRepo repo) {
        this.repo = repo;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users user = repo.findByUsername(username);
        System.out.println(username);
        if(user == null) {
            System.out.println("User not found");
            throw new UsernameNotFoundException("user not found");
        }
        return new UserPrinciples(user);
    }
}
