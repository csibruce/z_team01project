<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table name="listview" width="800" align="center" >
		<thead>
			<tr>
				<td>아이디</td>
				<td>비밀번호</td>
				<td>이 름</td>
				<td>이메일</td>
				<td>전 화</td>
				<td>권 한</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${memList }" var="memInfo">
				<tr>
					<form action="${pageContext.request.contextPath}/member/memberUpdate.do" method="post">
					<td>
					<input class="memberInput" type="text" value="${memInfo.mem_id }" disabled="disabled">
					<input type="hidden" name="mem_id" value="${memInfo.mem_id }">
					</td>
					<td><input class="memberInput" type="text" name="mem_pass" value="${memInfo.mem_pass }" readonly="readonly"></td>
					<td><input class="memberInput" type="text" name="mem_name" value="${memInfo.mem_name }" readonly="readonly"></td>
					<td><input class="memberInput" type="text" name="mem_mail" value="${memInfo.mem_mail }" readonly="readonly"></td>
					<td><input class="memberInput" type="text" name="mem_tel" value="${memInfo.mem_tel }" readonly="readonly"></td>
					<td>
					<select name="mem_type" class="memberInput">
						<option value="admin" ${memInfo.mem_type=='admin'?'selected':'' } >관리자</option>
						<option value="user" ${memInfo.mem_type=='user'?'selected':'' } >유저</option>
					</select>
					</td>
					<td><input type="submit" id="forAdmin" value="변경"></td>
					</form>
				</tr>	
			</c:forEach>
		</tbody>
	</table>
</body>
</html>