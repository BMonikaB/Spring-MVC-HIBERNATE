package com.example.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter

{

    @Override
    public void configure(HttpSecurity security) throws Exception {
        security.authorizeRequests().antMatchers("/h2-console/**").permitAll()
                .antMatchers("/students")
                .hasAnyRole("USER,ADMIN")
                .antMatchers("/studentcreate")
                .hasAnyRole("ADMIN")
                .antMatchers("/university")
                .hasAnyRole("USER,ADMIN")
                .antMatchers("/universitycreate")
                .hasAnyRole("ADMIN")
                .antMatchers("/students")
                .hasAnyRole("USER,ADMIN")
                .antMatchers("/studentscreate")
                .hasAnyRole("ADMIN").antMatchers("/indexes")
                .hasAnyRole("USER,ADMIN")
                .antMatchers("/indexcreate")
                .hasAnyRole("ADMIN").anyRequest().authenticated().and().formLogin().defaultSuccessUrl("/students");
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("user1").password("{noop}user1").roles("USER").and().withUser("admin1").password("{noop}admin1").roles("ADMIN");
    }

}
