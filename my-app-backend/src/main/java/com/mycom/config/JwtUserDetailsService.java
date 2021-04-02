package com.mycom.config;

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
import com.mycom.model.vo.Member;
import com.mycom.model.vo.Role;

//들어온 email으로 Member를 찾아서 결과적으로 User 객체를 반환해주는 역할 + 컨트롤러에서 넘어온 email과 password 값이 db에 저장된 비밀번호와 일치하는지 검사
@Service
public class JwtUserDetailsService implements UserDetailsService {
	
	//memberRepository를 통해 DB에 정보와 비교해야함
	@Autowired
	private  MemberRepository memberRepository;

	@Autowired
    private PasswordEncoder passwordEncoder;
	
	//security에서 지정한 서비스로 필수 구현해야 한다.
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
															//orElseThrow -> Java Optional : null 체크를 줄일 수 있기 때문에 사용하면 매우 편리
		Member member = memberRepository.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException("no such data"));
		Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
		grantedAuthorities.add(new SimpleGrantedAuthority(Role.USER.getValue()));
		if (member.getEmail().equals(email)) {
			 grantedAuthorities.add(new SimpleGrantedAuthority(Role.ADMIN.getValue()));
		} 
		
		return new User(member.getEmail(), member.getPassword(), grantedAuthorities);
	}
	
	 public Member authenticateByEmailAndPassword(String email, String password) {
	        Member member = memberRepository.findByEmail(email)
	                .orElseThrow(() -> new UsernameNotFoundException(email));
//	        if(!passwordEncoder.matches(password, member.getPassword())) {
//	            throw new BadCredentialsException("Password not matched");
//	        }
	        //아직 패스워드를 암호화하지 않았기때문에 저장된 비밀번호와 입력후 전달된 비밀번호를 비교하여 예외처리해줌
	        if(!member.getPassword().matches(password)) {
	        	throw new BadCredentialsException("Pssword not matched");
	        }

	        return member;
	    }
}
