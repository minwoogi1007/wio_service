package com.wio.crm.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/general/**").hasAuthority("ROLE_GENERAL")
                        .requestMatchers("/company/**").hasAuthority("ROLE_COMPANY")
                        .requestMatchers("/employee/**").hasAuthority("ROLE_EMPLOYEE")
                        .requestMatchers("/superuser/**").hasAuthority("ROLE_SUPERUSER")
                        .anyRequest().authenticated())
                .formLogin(form -> form
                        .loginPage("/login")
                        .permitAll())
                .logout(logout -> logout.permitAll());

        return http.build();
    }
}
