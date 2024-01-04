package kr.spring.ch07.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import kr.spring.ch07.vo.LoginVO;

public class LoginVOValidator implements Validator{

	//검증
	@Override
	public boolean supports(Class<?> clazz) {
		return LoginVO.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		//다운캐스팅
		LoginVO loginVO = (LoginVO)target;
		if(loginVO.getUserId() == null || loginVO.getUserId().isEmpty()) {
							   //필드			에러코드
			errors.rejectValue("userId", "required");
		}
		if(loginVO.getPassword() == null || loginVO.getPassword().isEmpty()) {
								//필드		에러코드
			errors.rejectValue("password", "required");
		}
		
	}

}
