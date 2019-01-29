<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <title>임대인 관리</title>
    <link href="https://fonts.googleapis.com/css?family=Noto+Sans+KR:400,500,700,900|Yeon+Sung&amp;subset=korean" rel="stylesheet">
    
    <link rel="stylesheet" type="text/css" href="/CSS/lessor.css">
    
    <style>

	h1{
  
  font-family: 'Yeon Sung', cursive;
  }
  td {
font-family: 'Noto Sans KR', sans-serif;
  font-size: 18px;
}

</style>
  </head>
  <body>
    <div align="center">
      <h1 id=se>임대인 삭제 - 관리자 페이지</h1>
      <br><br>
      <form action="lessorDelete.do" method="post">
        <table>
          <tr>
            <td>
              <table>

                <tr class="fon">
                  <th class= "seag">방 번호</th>
                  <td>
                  ${lessor.roomnum}호
                  </td>
                </tr>
  
  
                <tr class="fon">
                  <th class= "seag"> 임대인</th>
                  <td>${lessor.lessor}
                  </td>
                </tr>
  
                <tr class="fon">
                  <th class= "seag"> 임대 금액</th>
                  <td>${lessor.rent}원
                  </td>
                </tr>
  
                <tr class="fon">
                  <th class= "seag"> 입주일</th>
                  <td>${lessor.leasedate}
                  </td>
                </tr>
  
                <tr class="fon">
                  <th class= "seag"> 만료일</th>
                  <td>${lessor.expiration}
                  </td>
                </tr>
  
                <tr class="fon">
                  <th class= "seag"> 납부 여부</th>
                  <td >${lessor.payment}</td>
                </tr>                
              </table>
            </td>
          </tr>
        </table>
        <br>
        <input type="hidden" name="classnum" value="${lessor.classnum}">
        <input type="submit" value="삭제">
        <input type="button" value="목록" onclick="location.href='lessorList.do'">
        
      </form>
      
    </div>
    
  </body>
</html>