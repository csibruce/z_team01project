<%@page import="vo.NoticeVO"%>
<%@page import="service.NoticeServiceImpl"%>
<%@page import="service.NoticeService"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
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
<table width="800" align="center" >
			<tr>
				<td>글번호 : ${noticeInfo.nt_no }</td>
				<td>작성자 : ${noticeInfo.nt_writer } </td>
				<td>날짜 : ${noticeInfo.nt_date }</td>
			</tr>

			<tr>
				<td colspan="3"><hr color="black"><span class="title">${noticeInfo.nt_title }</span></td>
			</tr>
			
			<tr>
			<td colspan="3">
			<hr color="black">
			<div class="viewcontent">${noticeInfo.nt_content }</div>
			<hr color="black">
			</td>
			</tr>		
	
			<tr align="right">
				<td colspan="3">
				<input type="hidden" name="nt_no" value="${noticeInfo.nt_no}">
				<input type="button" value="목록" onclick="javascript:location.href='${pageContext.request.contextPath}/notice/noticeList.do';">
				<input id="forAdmin" type="button" value="수정" onclick="javascript:location.href='${pageContext.request.contextPath}/notice/noticeUpdate.do?nt_no=${noticeInfo.nt_no}';">
				<input id="forAdmin" type="button" value="삭제" onclick="javascript:location.href='${pageContext.request.contextPath}/notice/noticeDelete.do?nt_no=${noticeInfo.nt_no}';">
				</td>
			</tr>
</table>
</body>
</html>