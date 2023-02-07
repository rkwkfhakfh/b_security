package com.jafa.service;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.jafa.domain.MemberVO;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"classpath:spring-config/root-context.xml",
		"classpath:spring-config/servlet-context.xml",
		"classpath:spring-config/security-context.xml"
})
@WebAppConfiguration
public class MemberServiceTest {
	
	@Autowired
	MemberService memberService;
	
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Test
	public void test() {
		MemberVO vo = MemberVO.builder()
				.memberId("1234")
				.password("1234")
				.email("leekwanghyup@naver.com")
				.build();
		memberService.join(vo);
	}

}
