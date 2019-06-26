package com.iist.hrm.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.iist.hrm.jwt.JwtAuthEntryPoint;
import com.iist.hrm.jwt.JwtTokenFilter;
import com.iist.hrm.utils.Constants;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Bean
	public JwtTokenFilter authenticationJwtTokenFilter() {
		return new JwtTokenFilter();
	}
	
	@Bean
	@Override
	public AuthenticationManager authenticationManager() throws Exception {
		return super.authenticationManager();
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public JwtAuthEntryPoint jwtAuthEntryPoint() {
		return new JwtAuthEntryPoint();
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
			.and()
			.authorizeRequests()
			.antMatchers("/api/account/*").permitAll()
			.antMatchers("/api/auth/login").permitAll()
			.antMatchers("/api/manage/*").hasAnyRole(Constants.ROLE_ADMIN)
			.antMatchers("/api/admin/*").hasAnyRole(Constants.ROLE_ADMIN)
			.anyRequest().authenticated()
			.and().httpBasic().disable()
			.csrf().disable();
		
		http.addFilterBefore(authenticationJwtTokenFilter(), UsernamePasswordAuthenticationFilter.class);
	}
	
	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers(HttpMethod.OPTIONS, "/**")
		.antMatchers("/app/**/*.{js,html}")
		.antMatchers("/content/**")
		.antMatchers("/v2/api-docs/**")
		.antMatchers("/swagger.js")
		.antMatchers("/swagger-ui.html")
		.antMatchers("/configuration/ui")
		.antMatchers("/swagger-resources/**")
		.antMatchers("/webjars/**");
	}
	
}
