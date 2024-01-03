<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>계정 생성</title>
</head>
<body>
<%-- 커스텀태그를 명시했을 때, method를 지정하지않으면 method값은 post --%>
<%-- 미리보기를 사용하기위해서 modelAttribute 사용 --%>
<form:form action="create.do" modelAttribute="vo">
	아이디 : <form:input path="id" />
	<form:errors path="id"/>
	<br>
	이름 : <form:input path="name" />
	<form:errors path="name"/>
	<br>
	우편번호 : <form:input path="zipcode" />
	<form:errors path="zipcode"/>
	<br>
	주소 : <form:input path="address1" />
	<form:errors path="address1"/>
	<br>
	상세 주소 : <form:input path="address2" />
	<form:errors path="address2"/>
	<br>
	<form:button>전송</form:button>
</form:form>
</body>
</html>