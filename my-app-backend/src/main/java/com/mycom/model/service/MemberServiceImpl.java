package com.mycom.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycom.mapper.MemberMapper;
import com.mycom.model.vo.MemberVo;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	private MemberMapper mapper;
	
	public List<MemberVo> selectMember() {
		return mapper.selectMember();
	}
	
}
