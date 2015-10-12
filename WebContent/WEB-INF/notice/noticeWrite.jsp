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
		alert(document.getElementById("nt_color").value);
		oEditors.getById["nt_content"].exec("UPDATE_CONTENTS_FIELD", []);
// 		alert(document.getElementById("nt_content").value);
		return true;
	}
</script>
</head>
<body>
<form action="${pageContext.request.contextPath }/notice/noticeWrite.do" method="post" onsubmit="return submitContents(this)">
	<table width="800">
		<tr>
			<td colspan="2">제목 : <input class="inputTitle" name="nt_title"  type="text" value=""></td>
		</tr>
		
		<tr>
			<td colspan="2">
			관리자 아이디 : <input name="nt_writer" type="text" value="">
			배경색지정 :  <select name="nt_color" onChange="this.style.backgroundColor=this.options[this.selectedIndex].style.backgroundColor">
						  <option value="nt01" style="background-color: rgba(138,226,255,1)" selected="selected">&nbsp;&nbsp;&nbsp;&nbsp;</option>
						  <option value="nt02" style="background-color: rgba(133,255,190,1)">&nbsp;&nbsp;&nbsp;&nbsp;</option>
						  <option value="nt03" style="background-color: rgba(255,163,212,1)">&nbsp;&nbsp;&nbsp;&nbsp;</option>
						  <option value="nt04" style="background-color: rgba(192,192,192,1)">&nbsp;&nbsp;&nbsp;&nbsp;</option>
						  <option value="nt05" style="background-color: rgba(255,253,158,1)">&nbsp;&nbsp;&nbsp;&nbsp;</option>
						  <option value="nt06" style="background-color: rgba(186,158,255,1)">&nbsp;&nbsp;&nbsp;&nbsp;</option>						  
						</select>
			</td>
		</tr>
		
		<tr>
			<td colspan="2">
				<textarea name="nt_content" id="nt_content" style="width: 100%; height:400px; display: hidden;" cols="100" rows="10" ></textarea>
				<script type="text/javascript">
					var oEditors = [];
					nhn.husky.EZCreator.createInIFrame({
				    oAppRef: oEditors,
				    elPlaceHolder: "nt_content",
				    sSkinURI: "/editor/SmartEditor2Skin.html",
				    fCreator: "createSEditor2"
					});
				</script>
			</td>
		</tr>
		<tr>
			<td>
				첨부파일<input type="file">
			</td>
		</tr>
		
		<tr>
			<td align="right">
				<input id="forAdmin" type="button" value="목록" onclick="javascript:location.href='${pageContext.request.contextPath}/notice/noticeList.do';">
				<input id="forAdmin" type="submit" value="완료">		
				<input id="forAdmin" type="reset" value="취소">		
			</td>
		</tr>
	</table>
</form>
</body>
</html>