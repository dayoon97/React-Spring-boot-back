package com.mycom.config;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;


//인증에 실패한 사용자의 response에 HttpServletResponse.SC_UNAUTHORIZED를 담는다.
@Component						
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint {

	 @Override
	    public void commence(HttpServletRequest request,
	                         HttpServletResponse response,
	                         AuthenticationException e) throws IOException, ServletException {

	        response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "접근 권한 없음");
	   }

}
