package levi.advertisements.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

import levi.advertisements.service.impl.JpaUserDetailsService;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true) 
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
//	@Autowired
//	private DataSource dataSource;
	
	@Autowired
	private JpaUserDetailsService userDetailsService; 
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	    auth
	      .userDetailsService(userDetailsService);
	    	
	  } 
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http			
			.httpBasic().realmName("Oglasi")
			.and()			
			.formLogin()
			.and()
			.authorizeRequests()
				.antMatchers("/api/users/**").hasAuthority("ROLE_ADMIN")
				.anyRequest().permitAll()
				//.and().csrf().disable()				
			;
	}	
	

}
