<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="/editor/js/HuskyEZCreator.js" charset="utf-8"></script>
<script type="text/javascript">
	function submitContents(elClickedObj){
		oEditors.getById["nt_content"].exec("UPDATE_CONTENTS_FIELD", []);
		alert(document.getElementById("nt_content").value);
		return true;
	}
</script>
</head>
<body>
<form action="${pageContext.request.contextPath }/notice/noticeDelete.do" method="post" onsubmit="return submitContents(this)">
	<table width="800">
		<tr>
			<td>제목</td>
			<td><input name="nt_title" type="text" value="${noticeInfo.nt_title }"></td>
		</tr>
		
		<tr>
			<td>관리자아이디</td>
			<td><input name="nt_writer" type="text" value="${noticeInfo.nt_writer }"></td>
		</tr>
		
		<tr>
			<th>내용</th>
			<td>
				<div class="item">
						<textarea name="nt_content" id="nt_content" cols="100" rows="10" >${noticeInfo.nt_content }</textarea>
							<script type="text/javascript">
								var oEditors = [];
								nhn.husky.EZCreator.createInIFrame({
							    oAppRef: oEditors,
							    elPlaceHolder: "nt_content",
							    sSkinURI: "/editor/SmartEditor2Skin.html",
							    fCreator: "createSEditor2"
								});
							</script>
				</div>
				
			</td>
		</tr>
		
		<tr>
			<td align="right">
				<input type="hidden" name="nt_no" value="${noticeInfo.nt_no }">
				<input type="submit" value="완료">		
				<input type="reset" value="취소">		
			</td>
		</tr>
	</table>
</form>
</body>
</html>