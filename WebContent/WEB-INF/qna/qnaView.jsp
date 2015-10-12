<%@page import="java.util.List"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="vo.QnaVO"%>
<%@page import="service.QServiceImpl"%>
<%@page import="service.QService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="${pageContext.request.contextPath }/qna/qnaDelete.do?qn_no=${qnaInfo.qn_no}" method="post">
<table>
      <tr>
         <td colspan="4">
            <input type="button" value="수정" onclick="javascript:location.href='${pageContext.request.contextPath}/qna/qnaUpdate.do?qn_no=${qnaInfo.qn_no }'">
            <input type="password" name="qn_pass" placeholder="삭제비밀번호">
            <input type="hidden" name="qn_no" value="${qnaInfo.qn_no }">
            <input type="submit" value="삭제"> 
            <input type="button" value="목록" onclick="javascript:location.href='${pageContext.request.contextPath}/qna/qnaList.do'">
         </td>
      </tr>
      <tr>
         <td>번호: ${qnaInfo.qn_no }</td>
         <td>작성자: ${qnaInfo.qn_writer }</td>
         <td>날짜: ${qnaInfo.qn_date }</td>
         <td>조회수: ${qnaInfo.qn_count }</td>
      </tr>         
      <tr>
         <td colspan="4">제목: ${qnaInfo.qn_title }</td>
      </tr>
      <tr>
         <td colspan="4">내용: ${qnaInfo.qn_content }</td>
      </tr>
   </table>
</table>
</form>
</body>
</html>