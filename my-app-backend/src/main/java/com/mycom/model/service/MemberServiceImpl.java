package com.mycom.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycom.mapper.MemberMapper;
import com.mycom.model.vo.Member;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	private MemberMapper mapper;
	
	public List<Member> selectMember() {
		return mapper.selectMember();
	}

	@Override
	public int updateMember(String oldName, String newName) {
		int cnt = mapper.updateMember(oldName, newName);
		System.out.println("serviceImpl: " + cnt);
		return cnt;
	}

	@Override
	public int updatePhone(String oldPhone, String newPhone) {
		return mapper.updatePhone(oldPhone, newPhone);
	}

	@Override
	public int insertMember(String name, String phone, String gender) {
		return mapper.insertMember(name, phone, gender);
	}

	@Override
	public int deleteMember(int no) {
		return mapper.deleteMember(no);
	}

}
