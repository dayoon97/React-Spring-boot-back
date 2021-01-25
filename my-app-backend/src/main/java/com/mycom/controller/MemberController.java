package com.mycom.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.mycom.service.MemberServiceImpl;
import com.mycom.vo.MemberVo;

@RestController	
public class MemberController {

	@Autowired
	private MemberServiceImpl ms;
	
	@RequestMapping(value = "/")
    public String home() throws Exception{
        return "Hello World";
    }
	
	@RequestMapping(value="/member")
	public ModelAndView Member() throws Exception{
		
		List<MemberVo> memberList = ms.selectMember();
		ModelAndView mv = new ModelAndView();
		
		mv.addObject("list", memberList);
		
		return mv;
	}
}