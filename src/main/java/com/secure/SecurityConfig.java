package com.secure;


import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.csrf.CsrfFilter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebMvcConfigurerAdapter{

	protected void configure(HttpSecurity http) throws Exception {
	  http
	    .httpBasic()
	  .and()
	    .authorizeRequests()
	      .antMatchers("/index.html", "/home.html", "/login.html", "/").permitAll()
	      .anyRequest().authenticated()
	   .and()
	   		.addFilterAfter(new CsrfHeaderFilter(), CsrfFilter.class );
	}
}
