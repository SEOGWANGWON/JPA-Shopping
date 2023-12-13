package com.kh.springdb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.springdb.model.UserCreateForm;
import com.kh.springdb.model.UserRole;
import com.kh.springdb.service.UserService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/user")
// 공통으로 들어가는 url 이 있다면 RequestMapping 사용해서 user 로 묶어주기
public class UserController {
	
	private final UserService userService;
	
	// 회원가입 창
	@GetMapping("/signup")
	public String signUp(UserCreateForm userCheckForm) {
		return "signup_form";
	}
	
	// 회원가입에 대한 postMapping
	@PostMapping("/signup")
	public String signup(@Valid UserCreateForm userCreateForm,
			BindingResult bindingResult) {
		if(!userCreateForm.getPassword1().equals(userCreateForm.getPassword2())) {
			bindingResult.rejectValue("password2", 
					"passwordInCorrect",
					"비밀번호와 비밀번호 확인이 일치하지 않습니다.");
			return "signup_form";
			// bindingResult.rejectValue(필드,오브젝트,메세지)
		}
		// html 폼에서 선택한 역할을 가지고 오기 위해
		
		UserRole role = userCreateForm.getIsRole(); 
		
		userService.createUser(userCreateForm.getUsername() ,
				userCreateForm.getPassword1() ,
				userCreateForm.getEmail(),
				role);	// userCreateForm.getIsRole() 로 했었음
		
		return "redirect:/";
	}

	@GetMapping("/login")
	public String login() {
		return "login_form";
	}
	
}
