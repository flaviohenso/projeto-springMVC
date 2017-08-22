/**
 * projeto-springMVC : 21 de ago de 2017
 */
package com.projetoSpringMVC.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @author flavio
 *
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
	  auth.inMemoryAuthentication().withUser("mkyong").password("123456").roles("USER");
	  auth.inMemoryAuthentication().withUser("admin").password("123456").roles("ADMIN");
	  auth.inMemoryAuthentication().withUser("dba").password("123456").roles("DBA");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

	  http.authorizeRequests()
		.antMatchers("/produto/**").access("hasRole('ROLE_ADMIN')")
		.antMatchers("/**").access("hasRole('ROLE_ADMIN') or hasRole('ROLE_DBA')")
		.and().formLogin();

	}

}
