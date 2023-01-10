package com.Sanches.Company.config.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

    @Bean
    public InMemoryUserDetailsManager userDetailsService(PasswordEncoder passwordEncoder) {
        UserDetails user = User.withUsername("BradyAdmin")
                .password(passwordEncoder.encode("Kobe0824"))
                .roles("ADMIN")
                .build();
        return new InMemoryUserDetailsManager(user);
    }
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .httpBasic()
                .and()
                .authorizeHttpRequests()
                .requestMatchers(HttpMethod.GET, "/funcionario/find-all").hasRole("ADMIN")
                .requestMatchers(HttpMethod.GET, "/funcionario/").hasRole("ADMIN")
                .requestMatchers(HttpMethod.POST, "/funcionario/").hasRole("ADMIN")
                .requestMatchers(HttpMethod.PUT, "/funcionario/**").hasRole("ADMIN")
                .requestMatchers(HttpMethod.DELETE, "/funcionario/**").hasRole("ADMIN")
                .requestMatchers(HttpMethod.POST, "/departamentos/").hasRole("ADMIN")
                .requestMatchers(HttpMethod.POST, "/tarefas").hasRole("ADMIN")
                .requestMatchers(HttpMethod.PUT, "/tarefas/**").hasRole("ADMIN")
                .requestMatchers(HttpMethod.PUT, "/tarefas/alocar/**/funcionario/").hasRole("ADMIN")
                .anyRequest().authenticated()
                .and()
                .csrf().disable();
        return http.build();
    }
    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }
}
