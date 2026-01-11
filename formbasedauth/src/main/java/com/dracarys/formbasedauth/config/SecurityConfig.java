package com.dracarys.formbasedauth.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(auth ->
                auth.requestMatchers("/", "/h2-console").hasRole("USER")
                        .anyRequest().authenticated())
                .sessionManagement(session ->
                        session.maximumSessions(1)
                                .maxSessionsPreventsLogin(true))
                .csrf(csrf->csrf.disable())
                .headers(headers-> headers.frameOptions(frames->frames.disable()))
                .formLogin(Customizer.withDefaults());
        return http.build();
    }
}

