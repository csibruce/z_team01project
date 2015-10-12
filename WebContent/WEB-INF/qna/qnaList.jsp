<%@page import="vo.QnaVO"%>
<%@page import="java.util.List"%>
<%@page import="service.QServiceImpl"%>
<%@page import="service.QService"%>
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
<table width="800" align="center" name="listview">
	<thead>
		<tr><td><input type="button" value="글쓰기" onclick="javascript:location.href='${pageContext.request.contextPath}/qna/qnaWrite.do'"></td></tr>
		<tr><td colspan="5"><hr color="black" style="margin: 0px;"></td></tr>
		<tr>
			<td>번호</td>
			<td>제목</td>
			<td>작성자</td>
			<td>날짜</td>
			<td>조회수</td>
		</tr>
		<tr><td colspan="5"><hr color="black" style="margin: 0px;"></td></tr>
	</thead>
	<tbody>
		<c:forEach items="${qnaList}" var="qna" >
		<tr>
			<td>${qna.qn_no}</td>
			<td><a href='${request.contextPath }/qna/qnaView.do?qn_no=${qna.qn_no}'>${qna.qn_title}</a></td>
			<td>${qna.qn_writer}</td>
			<td>${qna.qn_date}</td>
			<td>${qna.qn_count}</td>
		</tr>
		</c:forEach>
	</tbody>
	<tr><td colspan="5"><hr color="black" style="margin: 0px;"></td></tr>
	<tbody></tbody>
</table>
</body>
</html>
