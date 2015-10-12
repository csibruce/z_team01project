<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
	ul{
		margin: 0;
		padding: 0;
		position: relative;
		top: 27px;
	}
	ul li{
		display: inline;
		background-color: black;
		color: white;
		font-weight: bold;
		border-radius:3px;
		vertical-align: middle;
	}
	ul li:HOVER{
		display: inline;
		background-color: gray;
		color: white;
		font-weight: bold;
		border-radius:3px;
	}
	ul li a{
		color: white;
		text-decoration: none;
	}
	
</style>
</head>
<body>
	
	<div class="absolute blinking" id="logout" style="border-radius : 5px;">${sessionScope.LOGIN_INFO.mem_name }님 ${pageContext.request.remoteAddr}에서 접속중.</div>
	<ul name="topmenu">
		<li id="login"><a href="/main.do">로그인</a></li>
		<li id="logout"><a href="/main.do?logout=ok">로그아웃</a></li>
		<li><a href="/freeboard/freeboardList.do">자유게시판</a></li>
		<li><a href="/notice/noticeList.do">공지사항</a></li>
		<li><a href="/qna/qnaList.do">Q&A</a></li>
		<li><a href="">자료실</a></li>
	</ul>
	
</body>
</html>