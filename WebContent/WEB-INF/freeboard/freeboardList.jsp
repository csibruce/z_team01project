<%@page import="vo.FreeVO"%>
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
<table name="listview" width="800" align="center">
	<thead>
		<tr><td colspan="5"><input type="button" value="글쓰기" onclick="javascript:location.href='${pageContext.request.contextPath}/freeboard/freeboardWrite.do'"></td></tr>
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
		<c:forEach items="${freeList }" var="freeInfo">
			<tr>
				<td>${freeInfo.rowno }</td>
				<td><a href="${pageContext.request.contextPath }/freeboard/freeboardView.do?fb_no=${freeInfo.fb_no }&start=${param.start }&end=${param.end}"><span class="listtitle">${freeInfo.fb_title }</span>
				<c:if test="${not empty freeInfo.fb_rcnt && freeInfo.fb_rcnt !='0'}">
				<font color="red">[${freeInfo.fb_rcnt}]</font>
				</c:if>
				</a></td>
				<td>${freeInfo.fb_writer }</td>
				<td>${freeInfo.fb_date }</td>
				<td>${freeInfo.fb_count }</td>
			</tr>
		</c:forEach>
	</tbody>
	<tr><td colspan="5"><hr color="black" style="margin: 0px;"></td></tr>
</table>
			<div class="paging" style="text-align: center;">
				<c:forEach begin="0" end="${paging.listTotal}" step="${paging.show }" varStatus="i">
				<c:if test="${!i.last}">
				<a id="end${paging.listTotal-paging.show*(i.count-1) }" href="${pageContext.request.contextPath}/freeboard/freeboardList.do?end=${paging.listTotal-paging.show*(i.count-1) }&start=${((paging.listTotal-paging.show*(i.count))<0)?0:paging.listTotal-paging.show*(i.count)}">${i.count}</a>|
				</c:if>
				<c:if test="${i.last}">
				<a id="end${paging.listTotal-paging.show*(i.count-1) }" href="${pageContext.request.contextPath}/freeboard/freeboardList.do?end=${paging.listTotal-paging.show*(i.count-1) }&start=${((paging.listTotal-paging.show*(i.count))<0)?0:paging.listTotal-paging.show*(i.count)}">${i.count}</a>				
				</c:if>
						
				</c:forEach>
			</div>
</body>
</html>