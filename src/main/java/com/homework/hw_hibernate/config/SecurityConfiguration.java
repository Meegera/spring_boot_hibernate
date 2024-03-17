package com.homework.hw_hibernate.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.WebSecurityConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true, jsr250Enabled = true)
@Configuration
public class SecurityConfiguration {

//    @Bean
//    public PasswordEncoder encoder(){ return PasswordEncoderFactories.createDelegatingPasswordEncoder();}

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
        UserDetails user1 = User.builder()
                .username("user1")
                .password("password1")
                .authorities("read")
                .roles("READ", "WRITE", "DELETE")
                .build();

        UserDetails user2 = User.builder()
                .username("user2")
                .password("{noop}password2")
                .authorities("read", "write")
                .roles("READ")
                .build();

        return new InMemoryUserDetailsManager(user1, user2);
    }
}
