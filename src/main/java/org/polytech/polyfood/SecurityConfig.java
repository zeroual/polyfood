package org.polytech.polyfood;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {


    // authorization
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // /index is public
        // /users public
        // /orders require authentication

        // /admin require ADMIN_ROLE
        // /restaurant require RESTAURANT_ROLE
        // ANY REQUEST require authentication

        http.authorizeRequests()
                .mvcMatchers("/index.html", "/users").permitAll()
                .mvcMatchers("/orders").authenticated()
                .mvcMatchers("/admin").hasRole("ADMIN")
                .mvcMatchers("/restaurant").hasRole("RESTAURANT")
                .anyRequest().authenticated();

    }


    // authentication
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        super.configure(auth);
    }
}
