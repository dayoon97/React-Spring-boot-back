//package com.mycom.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.BadCredentialsException;
//import org.springframework.security.authentication.DisabledException;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.mycom.config.JwtUserDetailsService;
//import com.mycom.config.JwtUtil;
//import com.mycom.model.service.MemberRepository;
//import com.mycom.model.vo.Member;
//
//import io.jsonwebtoken.Jwt;
//
//@RestController
//public class MemberController {
//	
////	@Autowired
////	private MemberService ms;
//	
//	private final JwtUtil jwtUtil;
//    private final JwtUserDetailsService userDetailsService;
//    private final AuthenticationManager authenticationManager;
//	
//	@Autowired
//	MemberRepository memberRepository;
//	
//	public MemberController(JwtUtil jwtUtil, JwtUserDetailsService userDetailsService, AuthenticationManager authenticationManager, MemberRepository memberRepository) {
//		this.memberRepository = memberRepository;
//		this.jwtUtil = jwtUtil;
//		this.userDetailsService = userDetailsService;
//		this.authenticationManager = authenticationManager;
//	}
//	/*
//	@PostMapping("/authenticate")
//	public ResponseEntity<?> login(@RequestBody JwtRequest login) throws Exception {
//		try {
//            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
//                    login.getUserEmail(), login.getPassword()));
//        } catch (DisabledException exception) {
//            throw new Exception("USER_DISABLED", exception);
//        } catch (BadCredentialsException exception) {
//            throw new Exception("INVALID_CREDENTIALS", exception);
//        }
//        UserDetails userDetails = userDetailsService.loadUserByUsername(login.getUserEmail());
//        String token = jwtUtil.generateToken(userDetails);
//        String refreshToken = jwtUtil.generateRefreshToken(userDetails);
//        Jwt jwt = new Jwt(token, refreshToken);
//        return ResponseEntity.ok(jwt);
//	}
//	*/
//	
////	@GetMapping("/")
////	public String root() {
////		return "redirect:member";
////	}
//	
////	@GetMapping("/list")
////	public List<Member> selectMember(ModelAndView mv) {
////
////		List<Member> list = new ArrayList<Member>();
////		list = ms.selectMember();
////
////		return list;
////	}
////	
////	@PutMapping("/name")
////	public String updateName(@RequestParam(value="newName", required = false) String newName, @RequestParam(value="oldName", required = false) String oldName) {
////		
////		int data = ms.updateMember(oldName, newName);
////		System.out.println(data);
////		
////		if(data > 0) {
////			return "1";
////		} else {
////			return "0";
////		}
////	}
////	
////	@PutMapping("/phone")
////	public String updatePhone(@RequestParam(value="newPhone", required = false) String newPhone, @RequestParam(value="oldPhone", required = false) String oldPhone) {
////		
////		System.out.println(oldPhone);
////		System.out.println(newPhone);
////		
////		int data = ms.updatePhone(oldPhone, newPhone);
////		System.out.println(data);
////		
////		
////		if(data > 0) { 
////			return "1";
////		} else {
////			return "0";
////		}
////	}
////	
////	@PostMapping("/member")
////	public String insertMember(@RequestParam(value="name", required = false) String name, @RequestParam(value="phone", required = false) String phone, 
////			@RequestParam(value="gender", required = false) String gender) {
////		
////		int data = ms.insertMember(name, phone, gender);
////		
////		if(data > 0) {
////			return "1";
////		} else {
////			return "0";
////		}
////	}
////	
////	@DeleteMapping("/delMember")
////	public String deleteMember(@RequestParam(value="no", required = false) int no) {
////		
////		int data = ms.deleteMember(no);
////		
////		if(data > 0) {
////			return "1";
////		} else {
////			return "0";
////		}
////	}
//	
//}
