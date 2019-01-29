<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>임대인 관리</title>
<link
	href="https://fonts.googleapis.com/css?family=Noto+Sans+KR:400,500,700,900|Yeon+Sung&amp;subset=korean"
	rel="stylesheet">

<link rel="stylesheet" type="text/css" href="/CSS/lessor.css">

<style>
.record {
	font-family: 'Noto Sans KR', sans-serif;
}

h1 {
	font-family: 'Yeon Sung', cursive;
}

tr {
	font-size: 17px;
}
</style>
</head>
<body>
	<div id="wrap" align="center">
		<h1>임대인 목록 - 관리자 페이지</h1>
		<table class="list">
			<tr>
				<td colspan="14"
					style="border: white; font-size: 20px; text-align: right;"><a
					href="lessorWrite.do">임대인 등록</a></td>
			</tr>

			<tr>
				<th>분류번호</th>
				<th>건물명</th>
				<th>방 번호</th>
				<th>임대인</th>
				<th>임대 금액</th>
				<th>입주일</th>
				<th>만료일</th>
				<th>담당자</th>
				<th>납부 여부</th>
				<th>수정</th>
				<th>삭제</th>
			</tr>

			<c:forEach var="lessor" items="${lessorList}">
				<tr class="record">
					<td>${lessor.classnum}</td>
					<td style="font-weight: bold">${lessor.buildingname}</td>
					<td>${lessor.roomnum}호</td>
					<td>${lessor.lessor}</td>
					<td>${lessor.rent}원</td>
					<td>${lessor.leasedate}</td>
					<td>${lessor.expiration}</td>
					<td>${lessor.manager}</td>
					<td>${lessor.payment}</td>
					<td><a href="lessorUpdate.do?lessor=${lessor.classnum}">
							임대인 수정 </a></td>
					<td><a href="lessorDelete.do?lessor=${lessor.classnum}">
							임대인 삭제</a></td>
				</tr>
			</c:forEach>
		</table>
		<br>
		<br> <input type="button" value="로그아웃"
			onclick="location.href='login.do'">
	</div>
</body>
</html>
