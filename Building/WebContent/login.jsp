<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>로그인 화면</title>
<link
	href="https://fonts.googleapis.com/css?family=Yeon+Sung&amp;subset=korean"
	rel="stylesheet">
<link
	href="https://fonts.googleapis.com/css?family=Poor+Story&amp;subset=korean"
	rel="stylesheet">
<style>
div {
	font-family: 'Yeon Sung', cursive;
	font-size: 2rem;
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

#join {
	width: 20em;
	height: 2em;
	text-align: center;
}

.submi {
	width: 7em;
	height: 2em;
}

#mainf {
	font-family: 'Poor Story', cursive;
	font-size: 2rem;
	text-align: center;
}
</style>
</head>
<body>
	<form action="/login.do" autocomplete="off" method="post" name="frm">
		<div>
			<h2>로그인</h2>

			<p>
				<label>아이디: <input class="box" type="text" name="managerid"
					value="${managerid}" placeholder="아이디를 입력" required autofocus></label>
			</p>

			<p>
				<label>비밀번호: <input class="box" type="password"
					name="password" placeholder="비밀번호를 입력" required></label>
			</p>

			<input type="submit" value="로그인" class="submi"> <input
				type="reset" value="재입력" class="submi">
		</div>
	</form>
	<div>
		<p>
			<a href="join.jsp"> <input type="submit" value="회원가입" id="join">
			</a>
		</p>
	</div>
	<div id="mainf">
		<p>
			<br>건물관리의 모든 것, 건물킹입니다.
		</p>
	</div>
	<p style="text-align: center;">
		<img
			src="C:\eclipse\work\Building\WebContent\WEB-INF\image\건물.jpg"
			alt="건물이미지" title="건물이미지" width=500px>
	</p>

</body>
</html>
