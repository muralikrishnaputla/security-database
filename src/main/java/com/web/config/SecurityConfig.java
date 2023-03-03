package com.web.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.web.service.EmployeeInfoDetailsService;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {
	
	@Bean   //authentication
	public UserDetailsService userDetailsService()
	{
		/*
		 * UserDetails admin=User.withUsername("thiru")
		 * .password(encoder.encode("thiru")) .roles("ADMIN") .build(); UserDetails
		 * user=User.withUsername("user") .password(encoder.encode("user"))
		 * .roles("USER") .build(); return new InMemoryUserDetailsManager(admin,user);
		 */
		
		return new EmployeeInfoDetailsService();
	}
	
	@Bean
    public SecurityFilterChain publicSecurityFilterChain(HttpSecurity http) throws Exception {
        return http.csrf().disable()
        		.authorizeHttpRequests()
        		.antMatchers("/employee/welcome","/employee/save").permitAll()
        		.and()
        		.authorizeHttpRequests()
        		.antMatchers("/employee/**").authenticated()
        		.and().formLogin()
        		.and().build(); 		
    }
	
	@Bean
	public PasswordEncoder passwordEncoder()
	{
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public AuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider daoAuthenticationProvider=new DaoAuthenticationProvider();
				daoAuthenticationProvider.setUserDetailsService(userDetailsService());
				daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
				return daoAuthenticationProvider;
	}

}
