package iist.training.hrm.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import iist.training.hrm.jwt.JwtConfigurer;
import iist.training.hrm.jwt.JwtTokenProvider;
import iist.training.hrm.utils.Constants;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private JwtTokenProvider jwtTokenProvider;
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/api/login").permitAll();
		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
			.and()
			.authorizeRequests()
			.antMatchers("/auth/signin").permitAll()
			.antMatchers(HttpMethod.POST, "/api/role/**").hasAnyRole(Constants.ROLE_USER, Constants.ROLE_ADMIN)
			.antMatchers("/api/admin/**").hasAnyRole(Constants.ROLE_ADMIN)
			.anyRequest().authenticated()
			.and().httpBasic().disable()
			.csrf().disable()
			.apply(new JwtConfigurer(jwtTokenProvider));
	}
	
	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers(HttpMethod.OPTIONS, "/**")
		.antMatchers("/app/**/*.{js,html}")
		.antMatchers("/content/**")
		.antMatchers("/v2/api-docs/**")
		.antMatchers("/swagger.js")
		.antMatchers("swagger-ui.html")
		.antMatchers("/configuration/ui")
		.antMatchers("/swagger-resources/**")
		.antMatchers("/webjars/**");
	}
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
	}
	
}
