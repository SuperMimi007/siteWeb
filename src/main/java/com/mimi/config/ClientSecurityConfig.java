package com.mimi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@Order(2)
public class ClientSecurityConfig {


    @Bean
    public SecurityFilterChain filterChain2(HttpSecurity http) throws Exception {

        http.antMatcher("/client/**")
                .authorizeRequests().anyRequest().hasAuthority("USER")
                .and()
                .formLogin()
                .loginPage("/client/login")
                .usernameParameter("email")
                .loginProcessingUrl("/client/login")
                .defaultSuccessUrl("/client/pageClient")
                .permitAll()
                .and()
                .rememberMe().key("Babou1234")
                .and()
                .logout()
                .logoutUrl("/client/logout")
                .logoutSuccessUrl("/AmourChien93");

        return http.build();
    }
}
