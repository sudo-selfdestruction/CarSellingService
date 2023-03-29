package com.CarSellingService.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    protected SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
             .csrf()
             .disable()
             .authorizeRequests()
             //Доступ только для не зарегистрированных пользователей
             .requestMatchers("signUp").not().fullyAuthenticated()
//             Доступ только для пользователей с ролью Администратор
//             .requestMatchers("/admin/**").hasRole("ADMIN")
             //Доступ разрешен всем пользователей
             .requestMatchers("/", "/resources/**").permitAll()
             //Все остальные страницы требуют аутентификации
//           //.anyRequest().authenticated()
             .and()
             //Настройка для входа в систему
             .formLogin()
             .loginPage("/signUp")
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