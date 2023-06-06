package com.example.javatechieauth.service;

import com.example.javatechieauth.config.UserInfoUserDetails;
import com.example.javatechieauth.entity.UserInfo;
import com.example.javatechieauth.repository.UserInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserInfoUserDetailsService implements UserDetailsService {

    @Autowired
    private UserInfoRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserInfo> optionalUserInfo = repository.findByName(username);
        return optionalUserInfo.map(UserInfoUserDetails::new).orElseThrow(() -> new UsernameNotFoundException("User not found: " + username));
    }
}
