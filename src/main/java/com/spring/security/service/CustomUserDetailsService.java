package com.spring.security.service;

import com.spring.security.model.UserPrincipal;
import com.spring.security.model.Users;
import com.spring.security.repo.UserRepo;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepo repo;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Users user = repo.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found!"));

        return new UserPrincipal(user);
    }

    @PostConstruct
    public void init() {
        Users admin = new Users();
        admin.setUsername("admin");
        admin.setPassword("admin");
        repo.save(admin);
        Users user = new Users();
        user.setUsername("user");
        user.setPassword("user");
        repo.save(user);
    }
}
