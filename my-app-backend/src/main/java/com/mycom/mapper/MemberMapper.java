package com.mycom.mapper;

import java.util.List;

import org.mybatis.spring.annotation.MapperScan;

import com.mycom.vo.MemberVo;


@MapperScan(value = {"com.mycom.mapper.*"})
public interface MemberMapper{
	List<MemberVo> selectMember();
}
