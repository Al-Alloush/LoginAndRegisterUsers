package com.sourceproject.loginregister.appuser;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

// because use lombok, don't add constructor, for that annotate: AllArgsConstructor

@Service
@AllArgsConstructor
public class AppUserService implements UserDetailsService {
	
	private AppUserRepository appUserRepository;
	
	private final static String USER_NOT_FOUND_MSG = "User with Email: %s not found";
	

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		return appUserRepository.findByEmail(username)
				.orElseThrow(()-> new UsernameNotFoundException(String.format(USER_NOT_FOUND_MSG, username)));
	}

}
