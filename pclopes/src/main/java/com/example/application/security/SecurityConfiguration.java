package com.example.application.security;


import com.vaadin.flow.spring.security.VaadinWebSecurity;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
@Configuration
public class SecurityConfiguration extends VaadinWebSecurity {
    public static final String LOGOUT_URL = "/";
    private static final String LOGIN_URL = "/loginGoogle";

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /* @Override
    protected void configure(HttpSecurity http) throws Exception {

        //http.authorizeRequests().antMatchers("/images/*.png").permitAll();
        super.configure(http);
        http.oauth2Login().loginPage(LOGIN_URL).permitAll();
        //setLoginView(http, LoginView.class, LOGOUT_URL);
    } */

    @Override
   protected void configure(HttpSecurity http) throws Exception {
    http.authorizeRequests().antMatchers("/images/*.png").permitAll();
       super.configure(http);
       http.oauth2Login().loginPage(LOGIN_URL).permitAll();
   }

}
