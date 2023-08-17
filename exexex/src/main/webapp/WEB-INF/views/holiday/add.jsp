<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h1>휴일 등록</h1>

<form action="/holiday/add" method="post">

	<div class="input_t">
		<label>년.월.일</label>
		<input name="fullyear">
	</div>
	
	<div class="input_t">
		<label>년</label>
		<input name="year">
	</div>
	
	<div class="input_t">
		<label>월</label>
		<input name="month">
	</div>
	
	<div class="input_t">
		<label>일</label>
		<input name="day">
	</div>
	
	<div class="input_t">
		<label>요일</label>
		<input name="dow">
	</div>
	
	<div class="input_t">
		<label>사유</label>
		<input name="reason">
	</div>
	
	<button class="btn"> 등록 </button>

</form>
</body>
</html>