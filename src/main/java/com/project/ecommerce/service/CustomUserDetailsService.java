package com.project.ecommerce.service;

import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;
import java.util.*;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    // hardcoded valid credentials
    private static final Map<String, String> USERS = Map.of(
			"admin", "$2a$10$uVGicTWF/Z7.ILGE1En9VeOBi27BQ0eSpwiVGXpu44Y9QZTSofBMy", //password123
    "user", "$2a$10$SPmhA7aU7sSMzpdnJ5KRw.bXvKAwzpLDvhqz6BIOb2/U8IEVhFrpy" //welcome123
		);


    @Override
		public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
				System.out.println("Looking up user: " + username);
				String encodedPassword = USERS.get(username);
				if (encodedPassword == null) {
						System.out.println("User not found");
						throw new UsernameNotFoundException("User not found");
				}
				System.out.println("User found: " + username);
				
				return new User(username, encodedPassword, List.of(new SimpleGrantedAuthority("ROLE_USER")));
		}


}