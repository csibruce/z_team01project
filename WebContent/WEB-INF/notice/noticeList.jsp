<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="http://code.jquery.com/jquery-latest.js"></script>
<script type="text/javascript">
// $(function(){
// 	$('input[value=글쓰기]').click(function(){
// 		$(location).attr('href','${pageContext.request.contextPath }/notice/noticeWrite.do');
// 	});
// });


</script>
</head>
<body>
		
	<c:forEach items="${noticeList }" var="noticeInfo">
	<div class="inline relative noticeListbox ${noticeInfo.nt_color }" onclick="javascript:location.href='${pageContext.request.contextPath }/notice/noticeView.do?nt_no=${noticeInfo.nt_no}'" >
		<div class="absolute noticeno"><b>번호 : ${noticeInfo.nt_no }<b></b></div>
		<div class="absolute noticewriter">게시자 : ${noticeInfo.nt_writer }</div>
		<div class="absolute noticetitle"><hr color="black" style="margin:0px;"><b>[공지]</b><br>${noticeInfo.nt_title }</div>
		<div class="absolute" style="padding: 5px; bottom: 15px; width: 252px;"><hr color="black" style="margin:0px;"></div>
		<div class="absolute noticedate">${noticeInfo.nt_date}</div>
		
	</div>
	</c:forEach>
	<script type="text/javascript">
		
	</script>
	<div align="right"><input id="forAdmin" type="button" value="글쓰기" onclick="javascript:location.href='${pageContext.request.contextPath}/notice/noticeWrite.do';"></div>
	
</body>
</html>