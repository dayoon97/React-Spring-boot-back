package com.mycom.config;

import java.util.Date;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtUtil {
	
	private static final long serialVersionUID = -2550185165626007488L;
    public static final long JWT_TOKEN_VALIDITY = 5 * 60 * 60;
	
	/**
     * jwt key를 application.yml에서 가져온다.
     */
    @Value("${jwt.secret}")
    private String SECRET_KEY;
    /**
     * refresh token 시간
     */
    private final static long REFRESH_TOKEN_VALIDITY = 1000L * 60 * 60 * 24 * 7;

    //retrieve username from jwt token
    public String getUsernameFromToken(String token) {
        return getClaimFromToken(token, Claims::getSubject);
    }
    
    public <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = getAllClaimsFromToken(token);
        return claimsResolver.apply(claims);
    }
    
    //for retrieveing any information from token we will need the secret key
    private Claims getAllClaimsFromToken(String token) {
        return Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody();
    }
    
    //check if the token has expired
    private Boolean isTokenExpired(String token) {
        final Date expiration = getExpirationDateFromToken(token);
        return expiration.before(new Date());
    }

    //retrieve expiration date from jwt token
    public Date getExpirationDateFromToken(String token) {
        return getClaimFromToken(token, Claims::getExpiration);
    }
    
    public String generateToken(UserDetails userDetails) {
        return doGenerateToken(userDetails.getUsername(), JWT_TOKEN_VALIDITY);
    }

    public String generateRefreshToken(UserDetails userDetails) {
        return doGenerateToken(userDetails.getUsername(), REFRESH_TOKEN_VALIDITY);
    }

    private String doGenerateToken(String username, long expireTime) {

    	//JWS(Signed JWT) 생성
    	//1. Jwts.builder() 메소드로 JwtBuilder 인스턴스를 생성한다.
    	//2. JwtBuilder의 메소드로 header 매개변수와 claims 를 정의한다.
    	//3. JWT를 서명하고 싶다면 비밀키나 공유키를 지정한다.
    	//4. compact() 메소드로 JWS를 생성한다.
        return Jwts.builder()
                .setHeaderParam("typ", "JWT")										//Token 헤더(토큰 타입과 알고리즘이 포함되어야 함)
                .setSubject(username)												//Token 제목
                .setIssuedAt(new Date(System.currentTimeMillis()))					
                .setExpiration(new Date(System.currentTimeMillis() + expireTime))	//Token 만료 시간 (milliseconds 기준!, JWT_TOKEN_VALIDITY = 5 60 60 => 5시간)
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)		//signWith (알고리즘, 비밀키)
                .compact();
    }

    //validate token
    public Boolean validateToken(String authToken, UserDetails userDetails) {
    	final String username = getUsernameFromToken(authToken);
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(authToken));
    }

}
