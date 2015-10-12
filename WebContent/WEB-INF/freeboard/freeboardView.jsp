<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	$(function(){
		if('${param.message}'=='wrong'){
			alert('비밀번호가 일치하지 않습니다.');
		}
	});
	
	function beforesubmit(get){
		if(get.fb_img.value == ""){
			alert("댓글 이미지를 선택해주세요!");
			return false;
		}
		if(get.fb_content.value == ""){
			alert("댓글 내용을 입력해주세요!");
			return false;
		}
		if(get.fb_writer.value == ""){
			alert("댓글 작성자를 입력해주세요!");
			return false;
		}
		if(get.fb_pass.value == ""){
			alert("비밀번호를 입력해주세요!");
			return false;
		}
		return true;
	}

</script>
</head>
<body>

	<table style="width:800px;">
		<tr>
			<td colspan="4">
			<form name="fblistForm" action="${pageContext.request.contextPath}/freeboard/freeboardDelete.do" method="post">
				<input type="button"  value="수정" onclick="javascript:location.href='${pageContext.request.contextPath}/freeboard/freeboardUpdate.do?fb_no=${freeInfo.fb_no }'">
				<input type="password" name="fb_pass" placeholder="삭제비밀번호">
				<input type="hidden" name="fb_no" value="${freeInfo.fb_no }">
				<input type="submit" value="삭제"> 
				<input type="button" value="목록" onclick="javascript:location.href='${pageContext.request.contextPath}/freeboard/freeboardList.do?start=${param.start }&end=${param.end }'">
			</form>
			</td>
		</tr>
		<tr>
			<td>번호: ${freeInfo.fb_no }</td>
			<td>작성자: ${freeInfo.fb_writer }</td>
			<td>날짜: ${freeInfo.fb_date }</td>
			<td>조회수: ${freeInfo.fb_count }</td>
		</tr>			
		<tr>
			<td colspan="4"><hr color="black"><span class="title">${freeInfo.fb_title }</span></td>
		</tr>
		<tr>
			<td colspan="4">
			<hr color="black">
			<div class="viewcontent">${freeInfo.fb_content }</div>
			<hr color="black">
			<div class="viewcomment">
			<c:forEach items="${replyList}" var="reply">
				<div  class="inline replyblock"></div>
				<div  class="inline replyblock">
					<img alt="" src="${reply.fb_img }" width="70px">
				</div>
				<div  class="inline reply">
				작성자:${reply.fb_writer } 
				<form name="fbReplylistForm" action="${pageContext.request.contextPath }/freeboard/freeboardDeleteReply.do?start=${param.start }&end=${param.end}" method="post" >
				<input type="hidden" name="fb_noA" value="${freeInfo.fb_no }">
				<input type="hidden" name="fb_no" value="${reply.fb_no }"> 
				<input type="password" name="fb_pass" placeholer="password">
				<input type="submit" value="삭제">
				</form><br> 
			     내용:${reply.fb_content }
				</div>
				<div class="inline blockauto"></div>
			    <hr>
			</c:forEach>
			<div style="text-align: center;">
			<form id="replyfocus" action="${pageContext.request.contextPath}/freeboard/freeboardWriteReply.do?start=${param.start }&end=${param.end}" method="post" onsubmit="return beforesubmit(this);">
				<div class="inline" style="width: 80px;">
				<img id="1" alt="" src="/images/1.png" width="30">
				<img id="2" alt="" src="/images/2.png" width="30"><br>
				<img id="3" alt="" src="/images/3.png" width="30">
				<img id="4" alt="" src="/images/5.gif" width="30">
				</div>
				<input type="hidden" name="fb_no" value="${freeInfo.fb_no }">
				<textarea name="fb_content" rows="4" cols="80"></textarea><br>
				작성자<input name="fb_writer" type="text" placeholder="작성자">
				비밀번호<input type="password" name="fb_pass" placeholer="비밀번호">
				<input type="hidden" name="fb_img">
				<input type="submit" value="댓글달기"><br>
			</form>
			</div>
			</div>
			</td>
		</tr>
	</table>

</body>
</html>