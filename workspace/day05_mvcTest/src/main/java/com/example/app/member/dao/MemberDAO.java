package com.example.app.member.dao;

import org.apache.ibatis.session.SqlSession;

import com.example.app.dto.MemberDTO;
import com.mybatis.config.MyBatisConfig;

public class MemberDAO {
	public SqlSession sqlSession;

	public MemberDAO() {
		sqlSession = MyBatisConfig.getSqlSessionFactory().openSession(true);
	}
	
	public void join(MemberDTO memberDTO) {
		sqlSession.insert("member.join", memberDTO);
	}
	
	public MemberDTO login(String memberID, String memberPassword) {
		MemberDTO memberDTO = new MemberDTO();
		memberDTO.setMemberId(memberID);
		memberDTO.setMemberPassword(memberPassword);
		return sqlSession.selectOne("member.login", memberDTO);
	}
	
}
