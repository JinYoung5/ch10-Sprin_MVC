package kr.spring.ch09.vo;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Range;

public class MemberVO {
	//정규표현식(regexp(regular expression)으로 패턴 검사 (^: 시작, $: 끝, +: 한번이상반복)
	@Pattern(regexp = "^[0-9a-zA-Z]+$")
	private String id;
	
	//문자열의 길이 지정
	@Size(min=4,max=10)
	private String password;
	
	@NotEmpty 	//필수적으로 입력하게 하는 어노테이션
	private String name;
	
	//숫자데이터의 길이 지정
	@Range(min=1,max=200)
	private int age;
	
	@Email		//이메일 형식에 맞게하는 어노테이션
	@NotEmpty 	//어노테이션 여러개 작성가능
	private String email;
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "MemberVO [id=" + id + ", password=" + password + ", name=" + name + ", age=" + age + ", email=" + email
				+ "]";
	}
	
}
