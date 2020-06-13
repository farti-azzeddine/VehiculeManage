package com.vehicule.manage;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


@Configuration
@EnableWebSecurity
public class ConfigureSecurity extends WebSecurityConfigurerAdapter{

	@Override
	protected void configure(AuthenticationManagerBuilder builder) throws Exception {
		builder.inMemoryAuthentication().withUser("farti").password("{noop}farti").roles("USER")
      .and()
      .withUser("admin").password("{noop}password").roles("ADMIN");	
	}
	

	protected void configure(HttpSecurity http) throws Exception {
		http.formLogin();
//		.loginPage("/login");
//		http.authorizeRequests().anyRequest().authenticated();
//		http.authorizeRequests().antMatchers("/index").hasRole("USER");
	} 
	
}
