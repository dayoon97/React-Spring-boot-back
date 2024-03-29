package com.mycom.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.mycom.model.vo.Member;

@Repository
@Mapper
public interface MemberMapper {
	List<Member> selectMember();

	int updateMember(String oldName, String newName);

	int updatePhone(String oldPhone, String newPhone);

	int insertMember(String name, String phone, String gender);

	int deleteMember(int no);
}
