package com.CarSellingService.config;

import com.CarSellingService.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@AllArgsConstructor
public class SecurityConfig {
    @Autowired
    private UserRepository repository;
    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
    private CustomUserDetailService customUserDetailService;
    @Bean
    protected SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
             .csrf()
             .disable()
             .authorizeRequests()
             .requestMatchers("/signUp").not().fullyAuthenticated()
             .requestMatchers("/admin/**").hasRole("ADMIN")
             .requestMatchers("/Offer").permitAll()
             .anyRequest().authenticated()
             .and()
             .httpBasic();
        return http.build();
    }
}