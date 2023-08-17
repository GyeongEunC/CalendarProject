<%@page import="com.mybb.ddd.HolidayVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Main Page</title>
<script src="https://code.jquery.com/jquery-3.4.1.js"
	integrity="sha256-WpOohJOqMqqyKL9FccASB9O0KwACQJpFTUBLTYOVvVU="
	crossorigin="anonymous">
	
</script>
</head>
<body>

	<h1>휴일 데이터 출력</h1>


	<h1> 휴일 목록 select </h1>
	
 <%-- 		 ${list[0].fullyear} ${list[0].reason}
	<br> ${list.year} --%>
<%-- 	<br> ${list.month} --%>
<%-- 	<br> ${list.day} --%>
<%-- 	<br> ${list.dow} --%>
<%-- 	<br> ${list.reason} --%>
<br>


<table>
		<thead>
			<tr>
				<th> TODAY </th>
				<th> 년 </th>
				<th> 월 </th>
				<th> 일 </th>
				<th> 요일 </th>
				<th> 사유 </th>
			</tr>
		</thead>
		
		<tbody>
			<c:forEach items="${list}" var="cal">
				<tr>
					<td> ${cal.fullyear} </td>
					<td> ${cal.year} </td>
					<td> ${cal.month} </td>
					<td> ${cal.day} </td>
					<td> ${cal.dow}요일 </td>
					<td> ${cal.reason} </td>
				</tr>
			</c:forEach>
		</tbody>
		
	</table>


	<br>
	<a href="/calendar/main"> home </a> <br>
	<a href="/holiday/add"> 휴일등록 </a>

	<script>
		$(document).ready(function() {
			let result = '<c:out value="${result}"/>';
			checkAlert(result);
			function checkAlert(result) {
				if (result === '') {
					return;
				}
				if (result === "add success") {
					alert("등록이 완료되었습니다.");
				}
			}
		});
	</script>

</body>
</html>