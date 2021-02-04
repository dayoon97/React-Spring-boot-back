package com.mycom.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.mycom.model.service.MemberService;
import com.mycom.model.vo.MemberVo;


@RestController
public class MemberController {
	
	@Autowired
	private MemberService ms;
	
	@GetMapping("/")
	public String root() {
		return "redirect:member";
	}
	
	@GetMapping("/list")
	public List<MemberVo> selectMember(ModelAndView mv) {

		List<MemberVo> list = new ArrayList<MemberVo>();
		list = ms.selectMember();

		return list;
	}
	
	@PutMapping("/name")
	public String updateName(@RequestParam(value="newName", required = false) String newName, @RequestParam(value="oldName", required = false) String oldName) {
		
		int data = ms.updateMember(oldName, newName);
		System.out.println(data);
		
		if(data > 0) {
			return "1";
		} else {
			return "0";
		}
	}
	
	@PutMapping("/phone")
	public String updatePhone(@RequestParam(value="newPhone", required = false) String newPhone, @RequestParam(value="oldPhone", required = false) String oldPhone) {
		
		System.out.println(oldPhone);
		System.out.println(newPhone);
		
		int data = ms.updatePhone(oldPhone, newPhone);
		System.out.println(data);
		
		
		if(data > 0) { 
			return "1";
		} else {
			return "0";
		}
	}
	
	@PostMapping("/member")
	public String insertMember(@RequestParam(value="name", required = false) String name, @RequestParam(value="phone", required = false) String phone, 
			@RequestParam(value="gender", required = false) String gender) {
		
		int data = ms.insertMember(name, phone, gender);
		
		if(data > 0) {
			return "1";
		} else {
			return "0";
		}
	}
	
	@DeleteMapping("/delMember")
	public String deleteMember(@RequestParam(value="no", required = false) int no) {
		
		int data = ms.deleteMember(no);
		
		if(data > 0) {
			return "1";
		} else {
			return "0";
		}
	}
}
