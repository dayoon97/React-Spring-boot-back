package com.mycom.config;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import io.jsonwebtoken.ExpiredJwtException;

@Component									//OncePerRequestFilter란 같은 요청에 대해서 단 한번만 처리가 수행되는 것을 보장하는 클래스
public class JwtAuthenticationFilter extends OncePerRequestFilter {

	private final JwtUtil jwtUtil;
    private final JwtUserDetailsService jwtUserDetailsService;

    public JwtAuthenticationFilter(JwtUtil jwtUtil, JwtUserDetailsService jwtUserDetailsService) {
        this.jwtUtil = jwtUtil;
        this.jwtUserDetailsService = jwtUserDetailsService;
    }
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
		 try {
			 
	         String jwtToken = extractJwtFromRequest(request);
	
	         if (StringUtils.hasText(jwtToken) && jwtUtil.validateToken(jwtToken)) {
	             UserDetails userDetails = new User(jwtUtil.getUsernameFromToken(jwtToken), "",
	                     jwtUtil.getRolesFromToken(jwtToken));
	             UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
	                     userDetails, null, userDetails.getAuthorities());
	             SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
	         } else {
	             System.out.println("Cannot set the Security Context");
	         }
	         	  //ExpiredJwtException : 유효기간이 지난 JWT를 수신한 경우
	     } catch (ExpiredJwtException exception) {
	
	         String isRefreshToken = request.getHeader("isRefreshToken");
	         if (isRefreshToken != null && isRefreshToken.equals("true")) {
	             allowForRefreshToken(exception, request);
	         } else {
	             request.setAttribute("exception", exception);
	         }
	         
	     } catch (BadCredentialsException exception) {
	         request.setAttribute("exception", exception);
	     } catch (Exception exception) {
	         System.out.println(exception);
	     }
	     filterChain.doFilter(request, response);
	 }

	// 로그인 정보를 null로 만들어서 로그인 안한 상태로 판단하게 한다.
	private void allowForRefreshToken(ExpiredJwtException exception, HttpServletRequest request) {
		//검증을 위해 AuthenticationManager의 인스턴스로 전달이 되고, AuthenticationManager는 인증에 성공하면 Authentication 인스턴스를 리턴
		UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
				null, null, null);
		SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
		request.setAttribute("claims", exception.getClaims());
	}

	private String extractJwtFromRequest(HttpServletRequest request) {
		//bearer 토큰 : API 토큰을 HTTP Header에 넣는 인증 방식 (ex. Authorization: Bearer {토큰})
		String bearerToken = request.getHeader("Authorization");
		if (StringUtils.hasText(bearerToken) && bearerToken.startsWith("Bearer ")) {
			return bearerToken.substring(7, bearerToken.length());
		}
		return null;
	}
	
}
