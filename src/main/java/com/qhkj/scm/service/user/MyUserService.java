//package com.qhkj.scm.service.user;
//
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.stereotype.Service;
//
///**
// * @ClassName MyUserService
// * @Description
// * @Author zouwenhai
// * @Date 2021/4/25 22:28
// * @Version 1.0
// */
//@Slf4j
//@Service
//public class MyUserService implements UserDetailsService {
//
//
//    @Override
//    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
//        log.info("userName:{}进入自定义用户校验", userName);
//        return User.builder().username("jack").password(new BCryptPasswordEncoder().encode("1234")).roles("admin").build();
//    }
//}
