package com.healthtreat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.healthtreat.constant.Method;
import com.healthtreat.domain.UserDTO;
import com.healthtreat.service.UserService;
import com.healthtreat.util.UiUtils;

@Controller
public class UserController{
	
	@Autowired
	private UserService userService;
	
	@GetMapping(value= "/user/login.do")
	public String openLogin(Model model) {
		model.addAttribute("user", new UserDTO());
		
		return "user/login";
	}
	
	
	@PostMapping(value = "/user/login.do")
	public String login(final UserDTO params, Model model) {
		System.out.println("도달..");
		try {
			UserDTO user = userService.login(params);
			if( user == null ) {
				System.out.println("도달..1");
				return "redirect:/user/login.do";
//				return showMessageWithRedirect("잘못된 이메일 주소나 패스워드를 입력하셨습니다.", "/user/login.do", Method.GET, null, model);
			}
		} catch (DataAccessException e) {
			System.out.println("도달..2");
			return "redirect:/user/login.do";
//			return showMessageWithRedirect("데이터베이스 처리 과정에 문제가 발생하였습니다.", "/user/login.do", Method.GET, null, model);
		} catch (Exception e) {
			System.out.println("도달..3");
			return "redirect:/user/login.do";
//			return showMessageWithRedirect("시스템에 문제가 발생하였습니다.", "/user/login.do", Method.GET, null, model);
		}
		return "redirect:/index.do";
//		return showMessageWithRedirect("로그인이 완료되었습니다.", "/index.do", Method.GET, null, model);
	}
	
	@GetMapping(value= "/user/register.do")
	public String openRegisterUser(Model model) {
		model.addAttribute("user", new UserDTO());
		
		return "user/register";
	}
	
	@PostMapping(value = "/user/register.do")
	public String registerUser(final UserDTO params, Model model) {
		try {
			boolean isRegistered = userService.registerUser(params);
			if( isRegistered == false ) {
				return "redirect:/user/login.do";
//				return showMessageWithRedirect("회원가입에 실패하였습니다.", "/user/login.do", Method.GET, null, model);
			}
		} catch (DataAccessException e) {
			return "redirect:/user/login.do";
//			return showMessageWithRedirect("데이터베이스 처리 과정에 문제가 발생하였습니다.", "/user/login.do", Method.GET, null, model);
		} catch (Exception e) {
			return "redirect:/user/login.do";
//			return showMessageWithRedirect("시스템에 문제가 발생하였습니다.", "/user/login.do", Method.GET, null, model);
		}
		return "redirect:/user/login.do";
//		return showMessageWithRedirect("회원가입이 완료되었습니다.", "/user/login.do", Method.GET, null, model);
		
	}
	
	@GetMapping(value = "/user/view.do")
	public String openUserDetail(@RequestParam(value = "idx", required = false) Long idx, Model model) {
		if (idx == null) {
			System.out.println("올바르지 않은 접근입니다.");
			return "redirect:/index.do";
		}
		
		UserDTO user = userService.selectUserInfo(idx);
		if (user == null) {
			System.out.println("탈퇴하었거나 존재하지 않는 사용자입니다.");
			return "redirect:/index.do";
		}
		model.addAttribute("user", user);
		
		return "user/view";
	}
	
	@PostMapping(value = "/user/delete.do")
	public String deleteUser(@RequestParam(value = "idx", required = false) Long idx, Model model) {
		if( idx == null ) {
			return showMessageWithRedirect("올바르지 않은 접근입니다.", "/user/view.do", Method.GET, null, model);
		}
		
		try {
			boolean isDeleted = userService.deleteUser(idx);
			if( isDeleted == false ) {
				return showMessageWithRedirect("탈퇴에 실패하였습니다.", "/user/view.do", Method.GET, null, model);
			}
		} catch (DataAccessException e) {
			return showMessageWithRedirect("데이터베이스 처리 과정에 문제가 발생하였습니다.", "/user/view.do", Method.GET, null, model);
		} catch (Exception e) {
			return showMessageWithRedirect("시스템에 문제가 발생하였습니다.", "/user/view.do", Method.GET, null, model);
		}
		return showMessageWithRedirect("회원탈퇴가 완료되었습니다.", "/index.do", Method.GET, null, model);
	}
	
}
