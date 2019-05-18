package com.example.demo.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
		http
			.httpBasic()
			.and()
			.authorizeRequests()
			.antMatchers("/h2/**").anonymous()
			.antMatchers("/**").authenticated()
			//.antMatchers(HttpMethod.GET,"/item").hasRole("USER")
			//.antMatchers(HttpMethod.POST,"/item").hasRole("ADMIN")
			.and()
			.csrf().disable()
			.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		//pour h2
		http.headers().frameOptions().disable();
	}

}
