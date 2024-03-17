package com.homework.hw_hibernate.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class SecurityConfiguration{
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
             http
                .formLogin(withDefaults())
                .authorizeRequests().requestMatchers("/persons/all").permitAll()
//                .and()
//                .authorizeRequests().requestMatchers("/persons/by-name-surname").hasAuthority("read")
//                .and()
//                .authorizeRequests().requestMatchers("/persons/save", "/persons/delete").hasAuthority("write")
                .anyRequest().authenticated();

        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails user1 = User.withDefaultPasswordEncoder()
                .username("user1")
                .password("password1")
                .authorities("read")
                .roles("READ", "WRITE", "DELETE")
                .build();

        UserDetails user2 = User.withDefaultPasswordEncoder()
                .username("user2")
                .password("password2")
                .authorities("read", "write")
                .roles("READ")
                .build();

        return new InMemoryUserDetailsManager(user1, user2);
    }
}
