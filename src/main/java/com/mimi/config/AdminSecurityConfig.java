package com.mimi.config;

import org.springframework.context.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.*;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@Order
public class AdminSecurityConfig {

    @Bean
    public UserDetailsService userDetailsService(){
        return new LoginUserDetailsService();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
      //  http.authorizeRequests().antMatchers("/").permitAll();

        http.antMatcher("/template/**")
                .authorizeRequests().anyRequest().hasAuthority("ADMIN")
                .and()
                .formLogin()
                .loginPage("/adminLogin")
                .usernameParameter("email")
                .loginProcessingUrl("/adminLogin")
                .defaultSuccessUrl("/gestionAdmin")
                .permitAll()
                .and()
                .logout()
                .logoutUrl("/adminLogout")
                .logoutSuccessUrl("/home");

        return http.build();
    }
}
