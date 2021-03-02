package com.mycom.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.mycom.model.service.MemberRepository;
import com.mycom.model.vo.MemberVo;

@Service
public class JwtUserDetailsService implements UserDetailsService {
	
	@Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private MemberRepository memberRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        MemberVo member = memberRepository.findByEmail(email).orElseThrow();
        if (email.equals("ekdbsekdbs@gmail.com")) {
        	return new User(member.getEmail(), member.getPassword(), new ArrayList<>());
        } 
        
        new User(member.getEmail(), member.getPassword(), new ArrayList<>());
    }

    public MemberVo authenticateByEmailAndPassword(String email, String password) {
    	MemberVo member = memberRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException(email));

        if(!passwordEncoder.matches(password, member.getPassword())) {
            throw new BadCredentialsException("Password not matched");
        }

        return member;
    }
}
