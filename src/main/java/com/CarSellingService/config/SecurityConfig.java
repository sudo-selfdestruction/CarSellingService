package com.CarSellingService.config;

import com.CarSellingService.repository.UserRepository;
import com.CarSellingService.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
    @Bean
    @Autowired
    public UserDetailsService userDetailsService(UserRepository repository) {
        return new UserService(repository);
    }
    @Bean
    protected SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http
             .csrf()
             .disable()
             .authorizeRequests()
             .requestMatchers("signUp").not().fullyAuthenticated()
             .requestMatchers("/admin/**").hasRole("ROLE_ADMIN")
             .requestMatchers("/").permitAll()
             .requestMatchers("/Offer/create").authenticated()
             .and()
             //Настройка для входа в систему
             .formLogin()
//             .loginPage("/signUp")
             //Перенарпавление на главную страницу после успешного входа
             .defaultSuccessUrl("/")
             .permitAll()
             .and()
             .logout()
             .permitAll()
             .logoutSuccessUrl("/");
        return http.build();
    }
}