package com.mycom.model.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mycom.model.vo.MemberVo;

@Repository
public interface MemberRepository extends JpaRepository <MemberVo, Long>{

	MemberVo findByEmail(String email);
	//List<MemberVo> findByEmail(String email);
}
