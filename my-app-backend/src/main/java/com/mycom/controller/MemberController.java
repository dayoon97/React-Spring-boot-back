package com.mycom.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.mycom.model.service.MemberService;
import com.mycom.model.vo.MemberVo;


@RestController
public class MemberController {
	
	@Autowired
	private MemberService ms;
	
	@GetMapping("/member")
	public List<MemberVo> selectMember(ModelAndView mv) {

		List<MemberVo> list = new ArrayList<MemberVo>();
		list = ms.selectMember();

		return list;
	}
	
	@PutMapping(value = "/{oldName}", produces="text/plain;charset=UTF-8")
	public String updateMember(@PathVariable("oldName") String oldName, @RequestParam String newName) {
		
		System.out.println(newName);
		System.out.println(oldName);
		
		
//		HashMap<String, String> map = new HashMap<String, String>();
//		map.put(oldName, "oldName");
//		map.put(newName, "newName");
		
//		List<MemberVo> list = new ArrayList<MemberVo>();
//		list = ms.updateMember();
//		System.out.println(list);
		
//		ms.updateMember(newName);
//		if(ms.updateMember(newName) > 0) {
//			return "redirect:/member";
//		} else {
//			return "redirect:/member";
//		}
		
		return "1";
	}
	
}
