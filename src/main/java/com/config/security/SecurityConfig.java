package com.config.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@EnableWebSecurity
@Configuration
//@EnableMethodSecurity(prePostEnabled = true)
public class SecurityConfig {

    @Bean
    public UserDetailsService userDetailsService(PasswordEncoder passwordEncoder) {
        UserDetails admin = User
                .withUsername("surachita")
                .password(passwordEncoder.encode("pwd1"))
                .roles("ADMIN").build();

        UserDetails user = User
                .withUsername("chayan")
                .password(passwordEncoder.encode("pwd1"))
                .roles("USER").build();
        return new InMemoryUserDetailsManager(admin, user);

    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        final String[] SWAGGER_WHITELIST = {
                "/v3/api-docs/**",
                "*/swagger-ui/**",
                "*/swagger-ui.html",
        };
        httpSecurity
                .authorizeRequests(authorizeRequests ->
                        authorizeRequests

                                .requestMatchers("/products/filter/*").hasRole("ADMIN")
                                .requestMatchers("/products/allProductsByPage").hasRole("ADMIN")
                                .requestMatchers("/products/productById/*").hasRole("USER")
                                .requestMatchers("/products/allProducts").permitAll()
                                .requestMatchers(SWAGGER_WHITELIST).permitAll()
                                .anyRequest().authenticated()
                )
                .httpBasic(withDefaults());

        return httpSecurity.build();
    }


    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
