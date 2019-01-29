<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>임대인 관리</title>
<link href="https://fonts.googleapis.com/css?family=Noto+Sans+KR:400,500,700,900|Yeon+Sung&amp;subset=korean" rel="stylesheet">

<link rel="stylesheet" type="text/css" href="/CSS/lessor.css">


<link rel="stylesheet" href="http://code.jquery.com/ui/1.8.18/themes/base/jquery-ui.css" type="text/css" />  

<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>  

<script src="http://code.jquery.com/ui/1.8.18/jquery-ui.min.js"></script>  

<script>
$(function() {
    $( "#testDatepicker" ).datepicker({
    	changeMonth: true, 
        changeYear: true,
        nextText: '다음 달',
        prevText: '이전 달', 
        dateFormat: 'yy-mm-dd',
        dayNames: ['일요일', '월요일', '화요일', '수요일', '목요일', '금요일', '토요일'],
        dayNamesMin: ['일', '월', '화', '수', '목', '금', '토' ], 
        monthNamesShort: ['1','2','3','4','5','6','7','8','9','10','11','12'],
        monthNames: ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'],
        showButtonPanel: true, 
    	closeText: '닫기'
    });
});
$(function() {
    $( "#testDatepicker2" ).datepicker({
    	changeMonth: true, 
        changeYear: true,
        nextText: '다음 달',
        prevText: '이전 달', 
        dateFormat: 'yy-mm-dd',
        dayNames: ['일요일', '월요일', '화요일', '수요일', '목요일', '금요일', '토요일'],
        dayNamesMin: ['일', '월', '화', '수', '목', '금', '토'], 
        monthNamesShort: ['1','2','3','4','5','6','7','8','9','10','11','12'],
        monthNames: ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'],
        showButtonPanel: true, 
        closeText: '닫기' 
    });
});

</script>



<style>

	h1{
  
  font-family: 'Yeon Sung', cursive;
  }
  tr {
font-family: 'Noto Sans KR', sans-serif;
  font-size: 17px;
}

td {
text-align: center;
}
</style>
</head>
<body>
	<div id="wrap" align="center">
		<h1 id=pp>임대인 등록 - 관리자 페이지</h1>
		<br><br>
		<form action="/lessorWrite.do" method="post" enctype="application/x-www-form-urlencoded" name="frm">
			<table id="siz" >
				<tr>
					<th class="pink">방 번호</th>
					<td style="width:300px"><input style=height:23px  size="45" type="number" name="roomnum" required placeholder="ex) 202" /></td>
				</tr>
				<tr>
					<th class="pink">임대인</th>
					<td><input style=height:23px size="45" type="text" name="lessor" required></td>
				</tr>
				<tr>
					<th class="pink">임대 금액</th>
					<td><input  style=height:23px size="45" type="number" name="rent" required placeholder="ex) 2000" /></td>
				</tr>
				<tr>
					<th class="pink">입주일</th>
					<td><input style=height:23px size="45" id="testDatepicker" type="text"  name="leasedate" required></td>
				</tr>
				<tr>
					<th class="pink">만료일</th>
					<td><input style=height:23px size="45" id="testDatepicker2" type="text" name="expiration" required></td>
				</tr>
				<tr>
					<th class="pink">납부 여부</th>
					<td>납부:<input type="radio" name="payment" checked value="Y">
						미납:<input type="radio" name="payment" value="N">
					</td>
				</tr>
			</table>
			<br> <input type="submit" value="등록"> 
				 <input	type="reset" value="재입력"> 
				 <input type="button" value="목록"
				onclick="location.href='lessorList.do'">

		</form>

	</div>

</body>
</html>
