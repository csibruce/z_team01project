<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script type="text/javascript">
	$(function(){
		if('${sessionScope.LOGIN_INFO.mem_type}'=='admin'){
			$('input[id=forAdmin]').show();
// 			$('ul li').css('background-color','red');
			$('#header').css('border','2px solid red');
			$('#content').css('border','2px solid red');
			$('#footer').css('border','2px solid red');
// 			$('input[id=forAdmin]').css('background-color', 'red');
			$('ul[name=topmenu]').append('<li id="forAdmin"><a href="${pageContext.request.contextPath}/member/memberlist.do">회원관리</a></li>')
			$('form[name=fblistForm]').append('<input id="forAdmin" type="button" value="비밀번호 : ${freeInfo.fb_pass}">');
			$('form[name=fbReplylistForm]').append('<input id="forAdmin" type="submit" value="관리자권한삭제">');
// 			alert('관리자로 로그인 하셨습니다.\n빨간 버튼은 관리자모드에서만 보이는 기능들 입니다.');
		}else{
			$('input[id=forAdmin]').hide();
		}
		if('${sessionScope.LOGIN_INFO}'==''){
			$('#login').show();
			$('#logout').hide();
		}else{
			$('#login').hide();
			$('#logout').show();
			    setInterval(function(){
				$('div[id=logout]').toggleClass("blinking");	    	
			    },500)
		}
		$('div[class=inline] img').css('border', '2px solid white');
		$('div[class=inline] img').click(function(event) {
			$('div[class=inline] img').css('border', '2px solid white');
			$(this).css('border', '2px solid red').css('border-radius','10px');
			$('input[name=fb_img]').val($(this).attr('src'));
			//alert($('input[name=fb_img]').val());
			
		});
		$('.paging a').css('color','black');
		var idval ='#end'+'${param.end}';
		$(idval).css('color','red');
// 		$('select[class=memberInput]').attr('disabled',true);
		$('input[class=memberInput]').dblclick(function(event) {
			if($(this).attr('readonly')){
				$(this).attr('readonly', false).css('background-color','#FFA6B5');
			}else{
				$(this).attr('readonly', true).css('background-color','');
			}
		});
		
	});
</script>
<title>Insert title here</title>
<style type="text/css">
/* 	body{ */
/* 		background-color: black; */
/* 		color : #00FF00; */
/* 		font-size: 13px; */
/* 		font-weight: bold; */
/* 	} */
	
	.memberInput{
		cursor: pointer;
		width: 105px;
	}
	#forAdmin{
		background-color: red;
	}
	.inputTitle{
		width: 80%;
	}
	input{
		border : 1px solid black;
		border-radius:3px;
	}
	a{ 
		color : black;
		font-weight : bold; 
		text-decoration: none;
	} 
	a:hover{ 
		color : #00FF00; 
 	} 
	.noticeno{
		top : 3px;
		left: 5px;
		font-size: 12px;
	}
	.noticetitle{
		left: 0px;
		top : 19px;
		width : 252px;
		height : 135px;
		padding: 5px;
		font-style: italic;
		overflow: hidden;
	}
	.noticewriter{
		top : 3px;
		left: 90px;
		font-size: 12px;
	}
	.noticedate{
		text-align:right;
		top: 165px;
		right: 5px;
		font-size: 11px;
	}
	.relative{
		position: relative;
	}
	.absolute{
		position: absolute;
	}
	.noticeListbox{
		margin-top: 10px;
		margin-left: 3px;
		width: 257px;
		height: 180px;
/* 		background-color: rgba(255,33,00,0.3); */
		border: 1px solid red;
		border-radius:5px;
		cursor: pointer;	
	}
	.nt01{background-color:rgba(138,226,255,1);}
	.nt02{background-color:rgba(133,255,190,1);}
	.nt03{background-color:rgba(255,163,212,1);}
	.nt04{background-color:rgba(192,192,192,1);}
	.nt05{background-color:rgba(255,253,158,1);}
	.nt06{background-color:rgba(186,158,255,1);}
	.noticeListbox:hover{
		background-color: #BFFF00;
	}
	.listtitle{
		font-size: 13;
		font-weight: bold;
	}
	.title{
		font-size: 30px;
		font-weight: bold;
	}
	.inline{
		display: inline-block;
	}
	.reply{
		width: 450px;
	}
	.replyblock{
		width: 100px;
		height: 50px;
	}
	.blockauto{
		widows: auto;
		height: auto;
	}
	input[type=text], input[type=password]{
		padding-left: 7px;
		padding-right: 7px;
	}
	input[type=button],input[type=submit],input[type=reset]{
		background-color: black;
		color: white;
		font-weight: bold;
		border: none;
		cursor: pointer;
	}
	input[type=button]:HOVER,input[type=submit]:HOVER,input[type=reset]:HOVER{
		background-color: gray;
		color : #00FF00; 
	}
/* 	input[type=submit]{ */
/* 		background-color: black; */
/* 		color: white; */
/* 		font-weight: bold; */
/* 		border: none; */
/* 	} */
/* 	input[type=reset]{ */
/* 		background-color: black; */
/* 		color: white; */
/* 		font-weight: bold; */
/* 		border: none; */
/* 	} */
	.viewcontent{
/* 		height: 700px; */
/* 		overflow: auto; */
	}
	.viewcomment{
/* 		height: 500px; */
/* 		overflow: auto; */
	}
	.blinking{
		background-color: red;
		color: white;
	}
	#header{
	 	margin: auto;
		width: 800px;
		height: 50px;
		border: 2px solid black;
		border-top-left-radius : 10px;
		border-top-right-radius : 10px;
	}
	#content{
		margin: auto;
		width: 800px;
/* 		height: 600px; */
		border: 2px solid black;
	}
	#footer{
		margin: auto;
		width: 800px;
		height: 100px;
		border: 2px solid black;
		border-bottom-left-radius : 10px;
		border-bottom-right-radius : 10px;
	}
	table[name=listview]{
		font-size: 13px;
 	}
	table[name=listview] tbody tr:HOVER {
		background-color: gray;
 	}
</style>
</head>
<body>
	<div id="header">
		<tiles:insertAttribute name="header"></tiles:insertAttribute>
	</div>
	<div id="content">
		<tiles:insertAttribute name="content"></tiles:insertAttribute>
	</div>
	<div id="footer">
		<tiles:insertAttribute name="footer"></tiles:insertAttribute>
	</div>
</body>
</html>