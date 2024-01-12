package com.wio.crm.service;

import com.wio.crm.mapper.TipdwMapper;
import com.wio.crm.mapper.Tcnt01EmpMapper;
import com.wio.crm.mapper.Temp01Mapper;
import com.wio.crm.model.Tcnt01Emp;
import com.wio.crm.model.Temp01;
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
    public UserDetails loadUserByUsername(String userid) throws UsernameNotFoundException {
        logger.info("Attempting to load user: {}", userid);

        Tipdw user = tipdwMapper.findByUserId(userid);
        if (user == null) {
            throw new UsernameNotFoundException("인증 실패");
        }

        if ("N".equals(user.getConfirmYn())) {
            throw new UsernameNotFoundException("승인 대기중");
        }

        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        if ("0".equals(user.getGubn())) {
            // temp01 테이블에서 유저 정보 조회
            Temp01 employeeInfo = temp01Mapper.findByUserId(userid);
            // 직원과 슈퍼유저 권한 설정
            authorities.add(new SimpleGrantedAuthority("ROLE_EMPLOYEE"));
          //  if (employeeInfo != null && "some_condition".equals(employeeInfo.getSomeField())) { // 슈퍼유저 조건 확인
                authorities.add(new SimpleGrantedAuthority("ROLE_SUPERUSER"));
          //  }
        } else if ("1".equals(user.getGubn())) {
            // tcnt01emp 테이블에서 유저 정보 조회
            Tcnt01Emp companyUserInfo = tcnt01EmpMapper.findByUserId(userid);
            // 일반유저와 업체유저 권한 설정
            authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
            //if (companyUserInfo != null && "some_condition".equals(companyUserInfo.getSomeField())) { // 업체유저 조건 확인
                authorities.add(new SimpleGrantedAuthority("ROLE_COMPANY"));
          //  }
        }

        return new User(user.getUserid(), user.getPw(), authorities);
    }
}
