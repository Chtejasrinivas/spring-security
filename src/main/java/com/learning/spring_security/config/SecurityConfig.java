package com.learning.spring_security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity

/**
 * This class is created to tell spring security that you don't do the security related stuff let me
 * take care of it. Like overriding the spring security default configuration and create your own configuration.
 */
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity security) {

        // we are disabling the CSRF now for the POST requests we can send the request without the CSRF token
        // now create the customer order without the CSRF token and you will see the request is successful
        security.csrf(csrf -> csrf.disable());

        // here we are telling spring that all the request should be authenticated
        security.authorizeHttpRequests(requests -> requests.anyRequest().authenticated());

        // here we are telling spring to use the basic authentication for the authentication process
        security.httpBasic(Customizer.withDefaults());

        /**
         * here we are telling spring to use the stateless session management policy,
         * which means that spring will not create a session for the user and will not store any information about the user in the session.
         * This is useful for REST ful APIs where we want to be stateless and not store any information about the user in the session.
         * once you mention stateless you can see the session id is being changes for every request to test this
         * open the home page and do refresh everytime you will get a new session id.
         **/
        security.sessionManagement(session->session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
        return security.build();
    }
}
