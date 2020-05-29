package org.polytech.polyfood;

import org.polytech.polyfood.buisness.PasswordEncoder;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import javax.sql.DataSource;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {


    PasswordEncoder passwordEncoder;
    private DataSource datasource;

    public SecurityConfig(PasswordEncoder passwordEncoder, DataSource datasource) {
        this.passwordEncoder = passwordEncoder;
        this.datasource = datasource;
    }

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
                .anyRequest().authenticated()
                .and().formLogin().and().csrf().disable();

    }


    // authentication
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        /*
        by default spring security will use this tables to fetch user credentials and authorities
        -----
        create table users(
	        username varchar(50) not null primary key,
	        password varchar(50) not null,
	        enabled boolean not null
        );
        
        create table authorities (
	        username varchar(50) not null,
	        authority varchar(50) not null,
	        constraint fk_authorities_users foreign key(username) references users(username)
        );

         */
        auth.jdbcAuthentication().dataSource(datasource)
                .usersByUsernameQuery("select username,password, enabled from T_USERS where username= ?");
        // .authoritiesByUsernameQuery("select username,authority from authorities where username = ?");


    }
}
