<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>관리자 삭제</title>
<link
	href="https://fonts.googleapis.com/css?family=Noto+Sans+KR:400,500,700,900|Yeon+Sung&amp;subset=korean"
	rel="stylesheet">
<link rel="stylesheet" type="text/css" href="/CSS/lessor.css">
<style>
h1 {
	font-family: 'Yeon Sung', cursive;
}

td {
	font-family: 'Noto Sans KR', sans-serif;
	font-size: 18px;
}
</style>



</head>
<body>
	<div id="wrap" align="center">
		<h1>관리자 삭제 페이지</h1>
		<form action="managerDelete.do" method="post">
			<table>
				<tr>
					<td>
						<table>

							<tr class="fon">
								<th class="seag">아이디</th>
								<td>${manager.managerid}님</td>
							</tr>

							<tr class="fon">
								<th class="seag">이름</th>
								<td>${manager.name}</td>
							</tr>

							<tr class="fon">
								<th class="seag">생년월일</th>
								<td>${manager.birthdate}</td>
							</tr>

							<tr class="fon">
								<th class="seag">건물명</th>
								<td>${manager.buildingname}</td>
							</tr>


						</table>
					</td>
				</tr>
			</table>
			<br> <input type="hidden" name="classnum"
				value="${manager.classnum}"> <input type="hidden"
				name="buildingname" value="${manager.buildingname}"> 
				<input type="submit" value="삭제"> <input type="button" value="돌아가기"
				onclick="location.href='login.do'">

		</form>

	</div>

</body>
</html>
