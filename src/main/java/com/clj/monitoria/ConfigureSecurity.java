package com.clj.monitoria;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class ConfigureSecurity extends WebSecurityConfigurerAdapter{
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication()
		.withUser("cesar")
		.password("cesar")
		.roles("USER")
		.and()	
		.withUser("lidia")
		.password("lidia")
		.roles("ADMIN")
		.and().withUser("jhon")
		.password("jhon")				
		.roles("ADMIN");
			
	}
	
	@Bean
	public PasswordEncoder PasswordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()		
		
		.antMatchers("/resources**", "/webjars/**").permitAll()
	
		.antMatchers("/adm").hasAnyRole("ADMIN")
		.antMatchers("/aluno").hasAnyRole("ADMIN")
		.antMatchers("/EA").hasRole("ADMIN")
		.antMatchers("/editarAlunos/id").hasRole("ADMIN")
		.antMatchers("/delete/id").hasRole("ADMIN")
		
		
		
	
		.antMatchers("/monitores").hasRole("ADMIN")
		.antMatchers("/monit").hasRole("ADMIN")
		.antMatchers("/EM").hasRole("ADMIN")
		.antMatchers("/DMonitores/id").hasRole("ADMIN")
		.antMatchers("/editarMonitores/id").hasRole("ADMIN")
		
		
		.antMatchers("/userp1").hasAnyRole("USER", "ADMIN")
		.antMatchers("/user").hasAnyRole("USER", "ADMIN")
		.antMatchers("/userp2").hasAnyRole("USER", "ADMIN")
		.antMatchers("/user1").hasAnyRole("USER", "ADMIN")
		
		.anyRequest().authenticated()
		.and()
		.formLogin()
		.loginPage("/entrar")
		.permitAll();
			}

	
	
}