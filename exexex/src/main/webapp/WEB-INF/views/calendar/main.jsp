<%@page import="org.springframework.ui.Model"%>
<%@page import="com.mybb.controller.CalendarController"%>
<%@page import="com.mybb.mapper.calendarMapper"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="com.mybb.service.CalendarServiceImpl"%>
<%@page import="com.mybb.service.CalendarService"%>
<%@page import="java.util.*"%>
<%@page import="com.mybb.ddd.CalendarVO"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Document</title>
<link rel="stylesheet" type="text/css" href="../../css/reset.css" />
<link rel="stylesheet" type="text/css" href="../../css/calendar.css" />
</head>
<body>

	<div class="header">
		<div class="header_logo">Calendar</div>
		<div class="header_nav">
			<button class="today">
				오늘 <br> ${getTodayList[0].fullyear}
			</button>
			<button class="lastMonth"><</button>

			<button class="nextMonth" onclick="console.log(currentMonth)">></button>
			<span class="dateInfo">${getTodayList[0].year}년
				${getTodayList[0].month}월</span>
		</div>
	</div>
	<div class="contents">
		<label>휴일 선택</label>
		<!-- <input type="date" id="h_day" name="h_day" /> -->
		<form action="/holiday/add" method="post">

			<div class="input_t">
				<label>년.월.일</label> <input name="fullyear">
			</div>
			<div class="input_t">
				<label>년</label> <input name="year">
			</div>

			<div class="input_t">
				<label>월</label> <input name="month">
			</div>

			<div class="input_t">
				<label>일</label> <input name="day">
			</div>

			<div class="input_t">
				<label>요일</label> <input name="dow">
			</div>

			<div class="input_t">
				<label>사유</label> <input name="reason">
			</div>

			<button class="btn">등록</button>
		</form>

		<div class="contents_right">
			<c:set var="currentYear" value="${getTodayList[0].year}" />
			<%
			int year = (int) pageContext.getAttribute("currentYear");
			%>
			<%-- <%= year %> 년 --%>

			<c:set var="currentMonth" value="${getTodayList[0].month}" />
			<%
			int month = (int) pageContext.getAttribute("currentMonth");
			%>

			<%= month %> 월

			<%

			int total = (year - 1) * 365 + (year - 1) / 4 - (year - 1) / 100 + (year - 1) / 400;

			int[] lastDay = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
			//윤년 계산기
			/* if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
			lastDay[1] = 29;
			} else {
			lastDay[1] = 28;
			}
			*/
			for (int i = 0; i < month - 1; i++) {
				total += lastDay[i];
			}
			total++;
			int week = total % 7;
			%>
			<table class="calendar">
				<th>일</th>
				<th>월</th>
				<th>화</th>
				<th>수</th>
				<th>목</th>
				<th>금</th>
				<th>토</th>

				<tr>
					<!-- 공백처리 로직 시작 -->
					<%
					for (int i = 1; i <= lastDay[month - 1]; i++) {
						if (i == 1) {
							for (int j = 0; j < week; j++) {
					%>
					<!-- 공백처리 로직 끝-->
					<td></td>
					<%
					}
					}
					%>
					<td><%=i%></td>
					<%
					week++;
					if (week > 6) {
						week = 0;
					%>
				</tr>
				<%
				}
				}
				%>


			</table>
		</div>
</body>
</html>

<script>
	document.getElementById('h_day').value = new Date().toISOString()
			.substring(0, 10);
	;
</script>