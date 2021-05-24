package com.example.services.Config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class BasicSecurity extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailsService userDetailsService;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
//		http.authorizeRequests()
//			.anyRequest().authenticated()
//			
//			.and().formLogin().loginPage("/entrar").permitAll()
//			.and()
//				.logout().logoutSuccessUrl("/entrar?logout")
//				
//			.and()
//				.httpBasic()
//				
//			.and()
//				.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)

		/*
		 * .and() .csrf().disable()
		 */		
		http.authorizeRequests().antMatchers("/").permitAll()
	        .anyRequest().authenticated()// Para qualquer requisição (anyRequest) é preciso estar autenticado (authenticated).
	    .and()
	    	.formLogin().loginPage("/entrar").permitAll()// Aqui passamos a página customizada. (permiteAll avisa o spring pra liberar o acesso pra ela)
		.and()
			.logout().logoutSuccessUrl("/entrar")//customização da url de logout, a url padrão causa bugs no login.
		.and()
			.httpBasic()
			.and().csrf().disable();		
		
	}
}
