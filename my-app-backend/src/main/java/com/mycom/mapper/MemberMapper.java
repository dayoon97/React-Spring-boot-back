package com.mycom.mapper;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.mycom.model.vo.MemberVo;

@Repository
@Mapper
public interface MemberMapper {
	List<MemberVo> selectMember();

	int updateMember(String oldName, String newName);
}
