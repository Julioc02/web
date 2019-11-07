package com.clj.monitoria.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;

@Configuration
public class InMemorySecurityConfig {
          public void configureGlobal(AuthenticationManagerBuilder builder)
                throws Exception{
        	       builder
        	       .inMemoryAuthentication()
        	       .withUser("Cesar").password("1234567").roles("USER")
        	       .and()
        	       .withUser("Jhon").password("102030").roles("USER")
        	       .and()
        	       .withUser("Lidia").password("203040").roles("USER");    
          }
}
