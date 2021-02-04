package com.mycom.model.service;

import java.util.List;

import com.mycom.model.vo.MemberVo;

public interface MemberService {
	
	List<MemberVo> selectMember();

	int updateMember(String oldName, String newName);

	int updatePhone(String oldPhone, String newPhone);

	int insertMember(String name, String phone, String gender);

	int deleteMember(int no);

}
