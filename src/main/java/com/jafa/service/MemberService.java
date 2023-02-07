package com.jafa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jafa.domain.AuthVO;
import com.jafa.domain.MemberType;
import com.jafa.domain.MemberVO;
import com.jafa.repository.AuthRepository;
import com.jafa.repository.MemberRepository;

@Service
public class MemberService {
	
	@Autowired
	MemberRepository memberRepository;
	
	@Autowired
	AuthRepository authRepository;
	
	// 회원가입
		@Transactional
		public void join(MemberVO vo) {
			memberRepository.save(vo);
			AuthVO authVO = AuthVO.builder()
					.memberId(vo.getMemberId())
					.memberType(MemberType.ROLE_ASSOCIATE_MEMBER)
					.ordinal(MemberType.ROLE_ASSOCIATE_MEMBER.ordinal())
					.build();
			authRepository.save(authVO);
		}
}
