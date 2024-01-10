package com.wio.crm.service;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CustomUserDetailsService implements UserDetailsService {

    private Map<String, UserDetails> users = new HashMap<>();

    public CustomUserDetailsService() {
        users.put("generalUser", new User("generalUser", "password", Arrays.asList(new SimpleGrantedAuthority("ROLE_GENERAL"))));
        users.put("companyUser", new User("companyUser", "password", Arrays.asList(new SimpleGrantedAuthority("ROLE_COMPANY"))));
        users.put("employee", new User("employee", "password", Arrays.asList(new SimpleGrantedAuthority("ROLE_EMPLOYEE"))));
        users.put("superUser", new User("superUser", "password", Arrays.asList(new SimpleGrantedAuthority("ROLE_SUPERUSER"))));
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if (users.containsKey(username)) {
            return users.get(username);
        }
        throw new UsernameNotFoundException("User not found: " + username);
    }
}
