package com.mycom.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycom.mapper.MemberMapper;
import com.mycom.vo.MemberVo;

@Service
public class MemberService {
	
	@Autowired
	public MemberMapper mapper;
	
	public List<MemberVo> selectMember(){
		return mapper.selectMember();
	}
	//왜 안돼ㅡㅡ
}	
