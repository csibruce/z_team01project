<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	
</script>
</head>
<body align="center">
<h1>로그인</h1>
<div id="login">
<form action="${pageContext.request.contextPath }/login/loginCheck.do" method="post">
	<table align="center">
		<tr>
			<td>아이디</td>
			<td><input type="text" name="mem_id" placeholder="아이디를 입력하세요"></td>
		</tr>
		<tr>
			<td>비밀번호</td>
			<td><input type="password" name="mem_pass" placeholder="비밀번호를 입력하세요"></td>
		</tr>
		<tr>
			<td colspan="2" style="text-align:right;"><input type="submit" value="로그인">
			<input type="submit" value="회원가입"></td>
		</tr>
	</table>
</form>
</div>
</body>
</html>