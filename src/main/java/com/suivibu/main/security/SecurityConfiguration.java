package com.suivibu.main.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import com.suivibu.main.service.UserDetailsServiceImpl;


@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

	@Autowired
	public PasswordEncoder passwordEncoder;

	@Autowired
	private UserDetailsServiceImpl userDetailsService;

	@Autowired
	private CustomAuthenticationEntryPoint customAuthenticationEntryPoint;

	@Autowired
	private JwtUtil util;

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
	}



	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration)
			throws Exception {
		return authenticationConfiguration.getAuthenticationManager();
	}

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		
		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
			.exceptionHandling().authenticationEntryPoint(customAuthenticationEntryPoint).and()
			.authorizeHttpRequests()
			.requestMatchers(HttpMethod.GET,
					"/*")
			.permitAll()
			.anyRequest().authenticated().and()
			.addFilterBefore(new JwtFilter(util, userDetailsService),
					BasicAuthenticationFilter.class);

		http.csrf().disable();
		return http.build();
	}

	@Bean
	public WebSecurityCustomizer webSecurityCustomizer() {
		// TokenAuthenticationFilter will ignore the below paths
		return (web) -> {
			web.ignoring().requestMatchers(
					HttpMethod.POST,
					"/auth/*");
			web.ignoring().requestMatchers(
					HttpMethod.GET,
					"/");
		};
	}
	
}
