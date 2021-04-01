package com.mycom.model.service;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mycom.model.vo.Member;

@Repository
public interface MemberRepository extends JpaRepository <Member, Long>{

	//Member findByEmail(String email);
	public Optional<Member> findByEmail(String email);
	public Optional<Member> findByPassword(String password);
	
}
