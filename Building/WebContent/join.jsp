<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>회원가입 화면</title>
<link rel="stylesheet"
	href="http://code.jquery.com/ui/1.8.18/themes/base/jquery-ui.css"
	type="text/css" />

<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>

<script src="http://code.jquery.com/ui/1.8.18/jquery-ui.min.js"></script>
<script type="text/javascript" src="script/idCheck.js"></script>
<link
	href="https://fonts.googleapis.com/css?family=Yeon+Sung&amp;subset=korean"
	rel="stylesheet">


<script>
	$(function() {
		$("#Datepicker").datepicker(
				{
					changeMonth : true,
					changeYear : true,
					nextText : '다음 달',
					prevText : '이전 달',
					dateFormat : 'yy-mm-dd',
					dayNames : [ '일요일', '월요일', '화요일', '수요일', '목요일', '금요일',
							'토요일' ],
					dayNamesMin : [ '일', '월', '화', '수', '목', '금', '토' ],
					monthNamesShort : [ '1', '2', '3', '4', '5', '6', '7', '8',
							'9', '10', '11', '12' ],
					monthNames : [ '1월', '2월', '3월', '4월', '5월', '6월', '7월',
							'8월', '9월', '10월', '11월', '12월' ],
					showButtonPanel : true,
					closeText : '닫기'
				});
	});
</script>



<style>
div {
	font-family: 'Yeon Sung', cursive;
	font-size: 25px;
	text-align: center;
}

.box {
	width: 250px;
	height: 25px;
}

h2 {
	font-family: 'Yeon Sung', cursive;
	border-bottom: 2px solid red;
	display: inline;
}

.submi {
	width: 7em;
	height: 2em;
}

#comment {
	font-size: 18px;
}
</style>
</head>
<body>
	<form action="/join.do" autocomplete="off" method="post" name="frm">
		<div>
			<h2>회원가입</h2>

			<p id="comment">(*표시 항목은 필수 입력 항목입니다)</p>

			<p>
				<label>*아이디: <input class="box" type="text" name="managerid"
					placeholder="아이디를 입력" required autofocus> <input
					type="hidden" name="reid" size="20"> <input type="button"
					value="중복 체크" onclick="idCheck()"></label>
			</p>

			<p>
				<label>*비밀번호: <input class="box" type="password" name="pwd"
					placeholder="비밀번호를 입력" required></label>
			</p>

			<p>
				<label>*이름: <input class="box" type="text" name="name"
					placeholder="이름을 입력" required></label>
			</p>

			<p>
				<label>생년월일: <input class="box" id="Datepicker" type="text"
					name="birthdate"></label>
			</p>

			<p>
				<label>*건물명: <input class="box" type="text"
					name="buildingname" placeholder="건물명을 입력" required></label>
			</p>

			<input type="submit" value="완료" class="submi"> <input
				type="reset" value="재입력" class="submi">

		</div>
	</form>
	<div>
		<p>
			<a href="login.jsp"> <input type="submit" value="로그인 화면으로"
				id="for login">
			</a>
		</p>
	</div>
	<p style="text-align: center;">
		<img
			src="C:\eclipse\work\Building\WebContent\WEB-INF\image\Join-us.png"
			alt="회원가입이미지" title="join us" width=360px>
	</p>
</body>
</html>
