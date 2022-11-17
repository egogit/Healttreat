package com.healthtreat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.healthtreat.domain.UserDTO;
import com.healthtreat.mapper.UserMapper;

@SpringBootTest
public class UserMapperTests {
	
	@Autowired
	private UserMapper userMapper;
	
//	@Test
//	public void testOfInsert() {
//		UserDTO params = new UserDTO();
//		params.setEmail("example@example.com");
//		params.setPasswd("test");
//		params.setName("홍길동");
//		params.setAddr("서울특별시 중구 00로");
//		params.setAddrDetail("3층");
//		params.setZipCode("12345");
//		params.setPhone("010-1234-5678");
//		
//		int result = userMapper.registerUser(params);
//		System.out.println("결과는 " +result + "입니다.");
//	}
	
//	@Test
//	public void testOfSelect() {
//		UserDTO user = userMapper.selectUserInfo((long) 1);
//		try {
//			String userJson = new ObjectMapper().registerModule(new JavaTimeModule()).writeValueAsString(user);
//			System.out.println("===============================");
//			System.out.println(userJson);
//			System.out.println("===============================");
//		} catch (JsonProcessingException e) {
//			e.printStackTrace();
//		}
//	}
	
//	@Test
//	public void testOfUpdate() {
//		UserDTO params = new UserDTO();
//		params.setId((long) 1);
//		params.setEmail("example@naver.com");
//		params.setPasswd("test1");
//		params.setAddr("서울특별시 서대문구 00로");
//		params.setAddrDetail("2층");
//		params.setZipCode("67891");
//		params.setPhone("010-5678-1234");
//		
//		int result = userMapper.updateUser(params);
//		if (result == 1) {
//			UserDTO user = userMapper.selectUserInfo((long) 1);
//			try {
//				String userJson = new ObjectMapper().registerModule(new JavaTimeModule()).writeValueAsString(user);
//				System.out.println("=========================");
//				System.out.println(userJson);
//				System.out.println("=========================");
//			} catch (JsonProcessingException e) {
//				e.printStackTrace();
//			}
//		}
//	}
	
//	@Test
//	public void testOfDelete() {
//		int result = userMapper.deleteUser((long) 1);
//		if (result == 1) {
//			UserDTO user = userMapper.selectUserInfo((long) 1);
//			try {
//				String userJson = new ObjectMapper().registerModule(new JavaTimeModule()).writeValueAsString(user);
//				
//				System.out.println("=================================");
//				System.out.println(userJson);
//				System.out.println("=================================");
//			} catch(JsonProcessingException e) {
//				e.printStackTrace();
//			}
//		}
//	}
	
	@Test
	public void testOfLogin() {
		UserDTO params = new UserDTO();
		params.setEmail("example@naver.com");
		params.setPasswd("test1");
		UserDTO user = userMapper.login(params);
		if (user != null) {
			System.out.println("반갑습니다 " + user.getName() + "님");
			try {
				String userJson = new ObjectMapper().registerModule(new JavaTimeModule()).writeValueAsString(user);
				System.out.println("===============================");
				System.out.println(userJson);
				System.out.println("===============================");
			} catch (JsonProcessingException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("없는 아이디이거나 잘못된 비밀번호입니다.");
		}
	}
}
