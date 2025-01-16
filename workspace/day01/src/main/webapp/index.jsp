<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!--
 	method를 get으로 작성하면 폼 데이터를 get방식으로 서버에 전송하고
 	post로 작성하면 폼 데이터를 post방식으로 서버에 정송
 	즉, 우리가 method에 get을 쓰면 서블릿의 doGet()메소드가 실행
 	폼 태그의 method 속성을 생략하면 디폴트는 get
  -->
	<h1>안녕하세요 !!</h1>
	<form action="Test" method="get">
		<input type="text" name="userName" placeholder="이름">
		<button>전송</button>
		<!--
		button 태그는 기본적으로 타입이 submit이다
		submit 버튼은 현재 form 태그의 action에 작성된 경로로 요청(request)을 보냄
		이 떄 request에는 현재 폼에 속해있는 모든 폼 데이터를 가지고 있음
		
		index.jsp 파일인데 자바파일인 서블릿으로 요청을 보내기 위해서는 서블릿에 어노테이션으로 등록된 경로를 작성
		action = "/Hello"로 수정하면 오류남                          
		   -->
	</form>
</body>
</html>