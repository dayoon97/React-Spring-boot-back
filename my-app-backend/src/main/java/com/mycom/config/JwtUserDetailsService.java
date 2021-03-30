package com.mycom.config;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class JwtUserDetailsService implements UserDetailsService {
	
	private final LoginRepository loginRepository;

	public JwtUserDetailsService(LoginRepository loginRepository) {
		this.loginRepository = loginRepository;
	}

	// security에서 지정한 서비스로 필수 구현해야 한다.
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		LoginEntity login = loginRepository.getEmail(username).orElseThrow();
		if (login.getEmail().equals(username)) {
			return new User(login.getEmail(), login.getPassword(), new ArrayList<>());
		} else {
			//저장된 인증 정보를 검색한 후 존재하면 객체를 반환하고, 없으면 Exception 반환함
			throw new UsernameNotFoundException("User not found with username : " + username);
		}
	}
}
