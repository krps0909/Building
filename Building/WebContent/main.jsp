<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:if test="${empty loginuser}">
	<jsp:forward page='login.do' />
</c:if>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>관리자 페이지</title>
<link
	href="https://fonts.googleapis.com/css?family=Noto+Sans+KR:400,500,700,900|Yeon+Sung&amp;subset=korean"
	rel="stylesheet">


<style>
#cen {
	text-align: center;
	font-size: 25px;
}

#bye {
	width: 1200px;
	text-align: right;
	font-family: 'Yeon Sung', cursive;
	font-size: 25px;
}

.byby {
	color: black;
	text-decoration: underline;
}

a:hover {
	text-decoration: underline;
	color: green;
}

div {
	font-family: 'Yeon Sung', cursive;
	font-size: 30px;
	text-align: center;
}

h2 {
	font-family: 'Yeon Sung', cursive;
	border-bottom: 2px solid red;
	display: inline;
}
</style>

</head>
<body>
	<div id="cen">
		<h2>관리자 전용 페이지</h2>
	</div>

	<table>
		<tr>
			<td id="bye"><a class="byby"
				href="managerDelete.do?userid=${loginuser.managerid}">회원 탈퇴</a></td>
		</tr>
	</table>


	<div>

		<form action="/logout.do">
			<p style="text-align: center;">

				<img src="C:\eclipse\work\Building\WebContent\WEB-INF\image\hello.png" alt="hello"
					title="hello" width=300px>
			</p>
			<br>


			<p>안녕하세요. ${loginuser.managerid}님</p>


			<p>
				<input type="submit" value="로그아웃"> &nbsp;&nbsp; 
				<input type="button" value="임대인 목록보기"
					onclick="location.href='lessorList.do?userid=${loginuser.managerid}'">
			</p>

		</form>
	</div>


</body>
</html>