package com.mycom.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mycom.model.vo.Member;

import lombok.AllArgsConstructor;
import lombok.Data;

@RestController
public class JwtAuthenticationController {

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Autowired
	private JwtUserDetailsService userDetailService;

	@PostMapping("/authenticate")
	public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception {
		final Member member = userDetailService.authenticateByEmailAndPassword(authenticationRequest.getEmail(),
				authenticationRequest.getPassword());
		final String token = jwtTokenUtil.generateToken(member.getEmail());
		return ResponseEntity.ok(new JwtResponse(token));
		}
		
	}
	
	@Data
	class JwtRequest {
	
		private String email;
		private String password;
		private String name;
	
	}
	
	@Data
	@AllArgsConstructor
	class JwtResponse {
	
		private String token;
}
