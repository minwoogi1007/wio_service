package com.wio.crm.service;

import com.wio.crm.mapper.TipdwMapper;
import com.wio.crm.mapper.Tcnt01EmpMapper;
import com.wio.crm.mapper.Temp01Mapper;
import com.wio.crm.model.Tipdw;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final TipdwMapper tipdwMapper;
    private final Tcnt01EmpMapper tcnt01EmpMapper;
    private final Temp01Mapper temp01Mapper;

    private final Logger logger = LoggerFactory.getLogger(CustomUserDetailsService.class);

    public CustomUserDetailsService(TipdwMapper tipdwMapper,
                                    Tcnt01EmpMapper tcnt01EmpMapper,
                                    Temp01Mapper temp01Mapper) {
        this.tipdwMapper = tipdwMapper;
        this.tcnt01EmpMapper = tcnt01EmpMapper;
        this.temp01Mapper = temp01Mapper;
    }

    @Override
    public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
        logger.info("Attempting to load user: {}", userId);

        Tipdw tipdwUser = tipdwMapper.findById(userId);
        if (tipdwUser == null) {
            logger.error("User not found: {}", userId);
            throw new UsernameNotFoundException("User not found: " + userId);
        }

        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        logger.info("tipdwUser.getGubn() found: {}", tipdwUser.getGubn());
        if ("0".equals(tipdwUser.getGubn())) {
            // 직원 로직
            authorities.add(new SimpleGrantedAuthority("ROLE_EMPLOYEE"));
        } else if ("1".equals(tipdwUser.getGubn())) {
            // 슈퍼유저 로직
            authorities.add(new SimpleGrantedAuthority("ROLE_SUPERUSER"));
        } else if ("2".equals(tipdwUser.getGubn())) {
            // 업체유저 로직
            authorities.add(new SimpleGrantedAuthority("ROLE_COMPANY"));
        } else if ("3".equals(tipdwUser.getGubn())) {
            // 일반유저 로직
            authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
        } else {
            throw new UsernameNotFoundException("Invalid user role: " + userId);
        }

        return new User(tipdwUser.getId(), tipdwUser.getPw(), authorities);
    }
}
