package com.mycom.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.mycom.model.service.MemberServiceImpl;
import com.mycom.model.vo.MemberVo;


@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("/")
public class MemberController {
	
	@Autowired
	private MemberServiceImpl ms;
	
	
	@RequestMapping("/hello")
	public String sayhello() {
		return "hello";
	}
	
	@GetMapping(value="/member")
	public ModelAndView selectMember(ModelAndView mv) {

		List<MemberVo> list = new ArrayList<MemberVo>();
		list = ms.selectMember();

		System.out.println(list);
		mv.addObject("list", list);
		mv.setViewName("jsonView");
		
		return mv;
	}
	
}
