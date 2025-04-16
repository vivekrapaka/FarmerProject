package com.farmersell.FarmerSell.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.farmersell.FarmerSell.securityconfig.CustomeAuthenticationProvider;

@Configuration
@EnableWebSecurity
public class AppConfig {
	
	@Autowired
	CustomeAuthenticationProvider customeAuthenticationProvider;
	
	@Bean
	@Lazy
    PasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
	}
	
		@Bean
	    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		 http
         .csrf(csrf -> csrf.disable())
         .authenticationProvider(customeAuthenticationProvider) 
         .authorizeHttpRequests(auth -> auth
             .requestMatchers(  "/loginPage",
                     "/registrationPage",
                     "/register",
                     "/login",
                     "/css/**",
                     "/js/**",
                     "/img/**",
                     "/scss/**").permitAll()
             .anyRequest().authenticated()
         )
         .formLogin(form -> form
             .loginPage("/loginPage")
             .loginProcessingUrl("/perform_login")
             .defaultSuccessUrl("/dashboard", true)
             .permitAll()
         )
         .logout(logout -> logout
             .logoutSuccessUrl("/loginPage")
             .permitAll()
         )
		 .sessionManagement(session -> session.maximumSessions(1).maxSessionsPreventsLogin(true)
					.sessionRegistry(sessionRegistry()));

        return http.build();
	    }
		
		@Autowired
		public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
			auth.authenticationProvider(this.customeAuthenticationProvider);
		}
		
		@Bean
		public SessionRegistry sessionRegistry() {
			return (SessionRegistry) new SessionRegistryImpl();
		}
	 
}
