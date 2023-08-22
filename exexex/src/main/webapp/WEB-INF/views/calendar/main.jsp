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
		<div class="header_logo">달력</div>
		<div class="header_nav">
			<button class="today">오늘 ${getTodayList[0].fullyear}</button>
			<button class="lastMonth"><</button>
			<button class="nextMonth">></button>
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
			<table class="calendar">
				<th>일</th>
				<th>월</th>
				<th>화</th>
				<th>수</th>
				<th>목</th>
				<th>금</th>
				<th>토</th>
				<%-- 					<tr>
						<td></td>
						<td></td>
						<td>${list[ㅑ].day}</td>
						<!-- 01일 -->
						<td>${list[1].day}</td>
						<td>${list[2].day}</td>
						<td>4</td>
						<td>5</td>
					</tr> --%>

				<tr>

					<c:forEach var="cal" items="${list}">
						<c:set var="i" value="0" />
						<c:set var="j" value="7" />
						<c:if test="${i%j == 0 }">
						</c:if>
							<c:choose>
								<c:when
									test="${cal.day<31 && cal.year == 2023 && cal.month == 08}">
									<td>${cal.day}</td>
								</c:when>
							</c:choose>
							<c:if test="${i%j == j-1 }">
							</c:if>
								<c:set var="i" value="${i+1 }" />
					</c:forEach>
				</tr>



				<%-- 

				<tr>
					<td>6</td>
					<td>7</td>
					<td>8</td>
					<td>9</td>
					<td>10</td>
					<td>11</td>
					<td>12</td>
				</tr>
				<tr>
					<td>13</td>
					<td>14</td>
					<td>15</td>
					<td>16</td>
					<td>17</td>
					<td>18</td>
					<td>19</td>
				</tr>
				<tr>
					<td>20</td>
					<td>21</td>
					<td>22</td>
					<td>23</td>
					<td>24</td>
					<td>25</td>
					<td>26</td>
				</tr>
				<tr>
					<td>27</td>
					<td>28</td>
					<td>29</td>
					<td>30</td>
					<td>31</td>
					<td></td>
					<td></td>
					
--%>
				</tr>
			</table>
		</div>
</body>
</html>

<script>
	document.getElementById('h_day').value = new Date().toISOString()
			.substring(0, 10);
	;
</script>