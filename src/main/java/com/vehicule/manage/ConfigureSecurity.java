package com.vehicule.manage;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;


@Configuration
@EnableWebSecurity
public class ConfigureSecurity extends WebSecurityConfigurerAdapter{

	@Override
	protected void configure(HttpSecurity http) throws Exception {
	

		
		http
		.csrf().disable()
		.authorizeRequests()
		.antMatchers("/login", "/resources/**", "/css/**", "/fonts/**", "/img/**").permitAll()
		.antMatchers("/register", "/resources/**", "/css/**", "/fonts/**", "/img/**", "/js/**").permitAll()
		.antMatchers("/users/addNew").permitAll()
		.anyRequest().authenticated()
		.and()
		.formLogin()
		.loginPage("/login").permitAll()
		.and()
		.logout().invalidateHttpSession(true)
		.clearAuthentication(true)
		.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
		.logoutSuccessUrl("/login").permitAll();
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		  return NoOpPasswordEncoder.getInstance();
		 
	}
	
	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Bean
	public AuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		provider.setUserDetailsService(userDetailsService);
//		provider.setPasswordEncoder(passwordEncoder());
		provider.setPasswordEncoder(bCryptPasswordEncoder());
		return provider;
	}
	
	
	
	
	
//	@Override
//	protected void configure(AuthenticationManagerBuilder builder) throws Exception {
//		builder.inMemoryAuthentication().withUser("farti").password("{noop}farti").roles("USER")
//      .and()
//      .withUser("admin").password("{noop}password").roles("ADMIN");	
//	}
	

//	protected void configure(HttpSecurity http) throws Exception {
//		http.formLogin();
//		.loginPage("/login");
//		http.authorizeRequests().anyRequest().authenticated();
//		http.authorizeRequests().antMatchers("/index").hasRole("USER");
//	} 
	
}
