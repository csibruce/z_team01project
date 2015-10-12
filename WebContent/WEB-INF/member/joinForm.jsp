<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/commons.js"></script>
<script type="text/javascript">
$(function(){
	$('input[value=가입하기]').click(function(){    

	    $('form[name=memberForm]').submit();
    });

	$('form[name=memberForm]').submit(function(){
		 if(frm.mem_tel.value != ''){
             if(!/^\d{3}-\d{3,4}-\d{4}$/.test(frm.mem_tel.value)){
                alert('휴대폰번호를 올바르게 입력해주세요.');
                frm.mem_tel.value = '';
                frm.mem_tel.focus();
                return false;
             }
          } else {
             alert('휴대폰번호를 입력해주세요.');
                frm.mem_tel.value = frm.mem_tel1.value + '-' +
                frm.mem_tel2.value + '-' +
                frm.mem_tel3.value;

           return false;
          }
//--------------------------------------------------------------------
		  if(frm.mem_mail.value != ''){
              frm.mem_mail.value = frm.mem_mail.value + '@' + frm.mem_mail_id.value;
              // test@ddit.or.kr   test1@ddit.kr
              if(!/^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/.test(frm.mem_mail.value)){
                 alert('메일을 올바르게 입력해주세요.');
                 frm.mem_mail.value = '';
                 frm.mem_mail.focus();
                 return false;
              }
           } else {
              alert('메일 주소를 입력해주세요.');
              return false;      
           }
	});
	
	function idCheck(){
		if($('input[name=mem_id]:eq(1)').val() == ""){
			alert('아이디를 입력해주세요');
		}else{
			$.ajax({
				
				type:"post",
				url:"${pageContext.request.contextPath}/member/idCheck.jsp",
				dataType:"json",
				data:{mem_id : $('input[name=mem_id]:eq(1)').val()},
				error:function(result){
					alert(result);
				},
				success:function(result){
			
				if(eval(result.rtn)){
					alert('사용가능');
					$('input[name=mem_pass]:eq(1)').focus();
				}else{
					alert('사용불가능');
					$('input[name=mem_id]:eq(1)').val();
					$('input[name=mem_id]:eq(1)').focus();
				
					}		
				}
				
			});
		}
	}
}

</script>
</head>
<style>
.fieldName {text-align: center; background-color: #f4f4f4;}
.btnGroup { text-align: right; }
td {text-align: left; }
</style>
<body>
<h2 align="center">회원가입</h2>
<form name="memberForm" action="#" method="post" onsubmit="#">
<table width="600" border="1" cellpadding="0" cellspacing="0" align="center">
	
		
	<tr>
      <td class="fieldName" width="100px" height="25">성 명</td>
      <td>
         <input type="text" name="mem_name" value="" /> 실명을 입력하세요.
      </td>
   </tr>	
		
		
	<tr>
		<td class="fieldName" width="100px" height="25">아이디</td>
		<td>
			<input type="text" name="mem_id" 
				value="" /> 8 ~ 20 자리 영문자 및 숫자 사용 <b><a href="javascript:idCheck();">[ID 중복검사]</a></b>
		</td>
	</tr>
	
	
	<tr>
		<td class="fieldName" width="100px" height="25">비밀번호</td>
		<td>
			<input type="text" name="mem_pass" 
				value="" /> 8 ~ 20 자리 영문자 및 숫자 사용
		</td>
	</tr>
	
	
	<tr>
		<td class="fieldName" width="100px" height="25">비밀번호확인</td>
		<td>
			<input type="text" name="mem_pass_confirm" 
				value="" /> 8 ~ 20 자리 영문자 및 숫자 사용
		</td>
	</tr>

	
	
	<tr>
		<td class="fieldName" width="100px" height="25">핸드폰</td>
		<td>
			<input type="hidden" name="mem_tel1"/>
			<select name="mem_tel1">
				<option value="010">010</option>
				<option value="016">016</option>				        	
				<option value="017">017</option>				        	
				<option value="019">019</option>				        	
			</select>	-
			<input type="text" name="mem_tel2" size="4" 
				value="" /> - 
			<input type="text" name="mem_tel3" size="4" 
				value="" />
		</td>
	</tr>

	
	<tr>
		<td class="fieldName" width="100px" height="25">이메일</td>
		<td>
			<input type="hidden" name="mem_mail" />
			<input type="text" name="mem_mail_id" 
					value="" /> @
			<select name="mem_mail_domain">
				<option value="naver.com">naver.com</option>
				<option value="daum.net">daum.net</option>
				<option value="hanmail.net">hanmail.net</option>
				<option value="nate.com">nate.com</option>
				<option value="gmail.com">gmail.com</option>				
			</select>
		</td>
	</tr>
	

	
	<tr>
		<td class="btnGroup" colspan="2" align="right">
			<input type="submit" value="가입하기"/>
			<input type="reset" value="취소"/>
			<input type="button" value="목록"/>
		</td>
		
	</tr>
</table>
</form>
</body>
</html>