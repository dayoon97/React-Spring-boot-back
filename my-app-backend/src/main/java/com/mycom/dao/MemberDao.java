package com.mycom.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.mycom.vo.MemberVo;

@Repository
public class MemberDao {
	private SqlSession sqlSession;
	
	public MemberDao(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	public List<MemberVo> selectMember() {
		return sqlSession.selectList("com.mycom.mapper.MemberSerivce");
	}
	
	
}
