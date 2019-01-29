<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>회원 관리</title>
<script type="text/javascript" src="script/idCheck.js">
	
</script>
</head>
<body>
	<h2>아이디 중복확인</h2>
	<form action="/idCheck.do" method="get" name="frm">
		아이디 <input type="text" name="managerid" value="${managerid}">
		<input type="submit" value="중복 체크"> <br>
		<c:if test="${result == 1}">
			<script type="text/javascript">
				opener.document.frm.managerid.value = "";
			</script>
      ${managerid}은(는) 이미 사용 중인 아이디입니다.
      </c:if>
		<c:if test="${result == -1}">
      ${managerid}은(는) 사용 가능한 아이디입니다.

      <input type="button" value="사용" class="cancel" onclick="idok()">
		</c:if>
	</form>

</body>
</html>