package com.project.ecommerce.config;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;


import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()     
                .antMatchers("/login", "/css/**").permitAll()
                .antMatchers("/api/products").authenticated()
                .anyRequest().authenticated()
								.and()
            .formLogin()
                .loginPage("/login")
                .defaultSuccessUrl("/home", true)
                .permitAll()
								.and()
            .logout()
							.permitAll();

        return http.build();
    }

    @Bean
		public PasswordEncoder passwordEncoder() {
   	 return new BCryptPasswordEncoder(); // ✅ Encrypted passwords
		}

		// @SuppressWarnings("deprecation")
		// @Bean
		// public PasswordEncoder passwordEncoder() {
		// 		return NoOpPasswordEncoder.getInstance(); // ✅ Allows plain text
		// }


    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authConfig) throws Exception {
        return authConfig.getAuthenticationManager();
    }
}