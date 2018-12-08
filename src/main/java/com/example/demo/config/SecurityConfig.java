package com.example.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
@Configuration
public class SecurityConfig //extends WebSecurityConfigurerAdapter

{
/*
    @Override
    public void configure(HttpSecurity security) throws Exception {
        security.authorizeRequests().antMatchers("/h2-console/**").permitAll().antMatchers("/students").hasAnyRole("USER, ADMIN").antMatchers("/studentscreate").hasAnyRole("ADMIN").anyRequest().authenticated().and().formLogin().defaultSuccessUrl("/students");
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("user1").password("{noop}user1").roles("USER").and().withUser("admin1").password("{noop}admin1").roles("ADMIN");
    }
    */
}
