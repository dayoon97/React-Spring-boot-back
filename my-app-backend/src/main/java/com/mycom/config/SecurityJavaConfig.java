package com.mycom.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import lombok.extern.java.Log;

@Log
@Configuration
@EnableWebSecurity
public class SecurityJavaConfig extends WebSecurityConfigurerAdapter {
	
	private final JwtAuthenticationFilter jwtAuthenticationFilter;
	private final JwtUserDetailsService jwtUserDetailsService;

	public SecurityJavaConfig(JwtAuthenticationFilter jwtAuthenticationFilter,
			JwtUserDetailsService jwtUserDetailsService) {
		this.jwtAuthenticationFilter = jwtAuthenticationFilter;
		this.jwtUserDetailsService = jwtUserDetailsService;
	}

	// 비밀번호 암호화를 지원하는 인터페이스(PasswordEncoder)
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(jwtUserDetailsService);
	}
	
	@Override
    protected void configure(HttpSecurity http) throws Exception {
        http
	        .httpBasic().disable()													    // security에서 기본으로 생성하는 login 페이지 사용 안함
	        .csrf().disable()															// csrf 사용 안 함 == REST API 사용하기 때문에
	        .cors().disable()
	        .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS) // JWT인증 사용하므로 세션 사용 안 함 (스프링시큐리티가 생성하지도 않고 기존 것을 사용하지도 않음)
	        .and()
	        	.authorizeRequests()													// 다음 리퀘스트에 대한 사용권한 체크
	        		.antMatchers("/admin").hasRole("ADMIN")
	        		.antMatchers("/*/login", "/*/signUp").permitAll()					// 가입 및 인증 주소는 누구나 접근 가능
	        		.anyRequest().hasRole("USER")										// 그 외 나머지 요청은 모두 인증된 회원만 접근 가능
	        .and()
	        	.addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
	}
}