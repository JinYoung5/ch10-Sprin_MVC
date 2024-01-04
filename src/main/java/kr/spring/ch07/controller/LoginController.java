package kr.spring.ch07.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import kr.spring.ch07.service.LoginCheckException;
import kr.spring.ch07.service.LoginService;
import kr.spring.ch07.validator.LoginVOValidator;
import kr.spring.ch07.vo.LoginVO;

@Controller
public class LoginController {
	@Autowired //set 메서드를 만들어야되지만 @Autowired 가 자동으로 setter를 만들어줌
	private LoginService loginService;
	
	//자바빈 초기화
	@ModelAttribute
	public LoginVO initCommand() {
		return new LoginVO();
	}
	
	@GetMapping("/login/login.do")
	public String form() {
		return "login/form";
	}
	//유효성 체크
	@PostMapping("/login/login.do")
						//@ModelAttribute  생략되어있음
	public String submit(LoginVO loginVO, BindingResult result) {
		System.out.println("데이터 전송 후 : " + loginVO);
		
		//데이터 유효성 체크
		new LoginVOValidator().validate(loginVO, result);
		
		//유효성 체크 결과 오류가 있으면 폼 호출
		if(result.hasErrors()) {
			return form();
		}
		
		//로그인 체크
		try {
			loginService.checkLogin(loginVO);
			//로그인 성공
			return "redirect:/index.jsp";
			
		}catch(LoginCheckException e) {
			//로그인 실패
			//reject : 필드없이 사용가능 rejectValue : 필드가 있으면 사용
						//에러코드,메시지에 전달될 값,default message(안쓸경우 null)
			result.reject("invalidIdOrPassword",new Object[] {loginVO.getUserId()}, null);
			
			return form();
		}
		
		
	}
}
