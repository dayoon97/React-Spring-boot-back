package com.mycom.model.service;

import java.util.List;

import com.mycom.model.vo.Member;

public interface MemberService {
	
	List<Member> selectMember();

	int updateMember(String oldName, String newName);

	int updatePhone(String oldPhone, String newPhone);

	int insertMember(String name, String phone, String gender);

	int deleteMember(int no);

}
