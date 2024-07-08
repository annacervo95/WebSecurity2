package com.example.PlantCommerce;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.security.web.csrf.CsrfTokenRepository;
import org.springframework.security.web.csrf.CsrfTokenRequestAttributeHandler;

@Configuration
@EnableWebSecurity
public class SecConfig {
    
   @Bean
    public CsrfTokenRepository csrfTokenRepository() {
        CookieCsrfTokenRepository cookieRepository = new CookieCsrfTokenRepository();
        return cookieRepository;
    } 
	
    @Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http
            .csrf(csrf -> csrf
            .csrfTokenRepository(csrfTokenRepository())
       //     .csrfTokenRequestHandler(new CsrfTokenRequestAttributeHandler())); //di default usa la versione XorCsrfTokenRequestAttributeHandler
            ); 
		return http.build();
	}
	

}

