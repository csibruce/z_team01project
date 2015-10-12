<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="/editor/js/HuskyEZCreator.js" charset="utf-8"></script>
<script type="text/javascript">
	$(function(){
		if('${param.message}'=='wrong'){
			alert('비밀번호가 일치하지 않습니다.');
		}
	});


	function submitContents(elClickedObj) {
	    // 에디터의 내용이 textarea에 적용된다.
	    oEditors.getById["fb_content"].exec("UPDATE_CONTENTS_FIELD", []);
// 	 	alert(document.getElementById("fb_content").value);
	    // 에디터의 내용에 대한 값 검증은 이곳에서
	    // document.getElementById("ir1").value를 이용해서 처리한다.
	    return true;
	}
</script>
<title>Insert title here</title>
</head>
<body>
	<form action="${pageContext.request.contextPath }/freeboard/freeboardUpdate.do" method="post" onsubmit="return submitContents(this)">
	작성자<input type="text" name="fb_writer" value="${freeinfo.fb_writer }"> 비밀번호<input type="password" name="fb_pass"><br>
	제목<input type="text" class="inputTitle" name="fb_title" value="${freeinfo.fb_title }"><br>
	<textarea name="fb_content" id="fb_content" style="width: 100%; height:400px; display: hidden;" rows="10" cols="100">${freeinfo.fb_content }</textarea>
		<script type="text/javascript">
			var oEditors = [];
			nhn.husky.EZCreator.createInIFrame({
		    oAppRef: oEditors,
		    elPlaceHolder: "fb_content",
		    sSkinURI: "/editor/SmartEditor2Skin.html",
		    fCreator: "createSEditor2"
			});
		</script>
		
	<input type="hidden" name="fb_no" value="${freeinfo.fb_no }">
	<input type="submit" value="완료">
	<input type="reset" value="취소">
	</form>
</body>
</html>