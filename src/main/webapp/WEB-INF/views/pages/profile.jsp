<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Main</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/login.css"></link>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/menu.css"></link>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/table.css"></link>
</head>
<body>
	<nav>
		<ul>
			<li><a href="/web">Home</a></li>
		</ul>
	</nav>

	<main>
		<section class="container" style="width: 600px">
			<header>회원 정보</header>
			<form name=form1 action="userUpdate" method="post">
				<table>
					<tr>
						<td id="img" rowspan="4" colspan="2"></td>
						<th>ID</th>
						<td><input type="text" name="userId" readonly value="${user.userId}"></td>
					</tr>
					<tr>
						<th>PASSWORD</th>
						<td><input type="text" name="userPasswd" value=""></td>
					</tr>
					<tr>
						<th>NAME</th>
						<td><input type="text" name="userName" value="${user.userName}"></td>
					</tr>
					<tr>
						<th>EMAIL</th>
						<td><input type="text" name="userEmail" value="${user.userEmail}"></td>
					</tr>
					<tr>
						<td><button type="button" onclick="location.href='userDelete?userId=${user.userId}'">계정 탈퇴</button></td>
						<td><button type="button" onclick="location.href='logout'" id="button">로그아웃</button></td>
						<td colspan="2"><input type="submit" name="submit" value="수정"></td>
					</tr>
				</table>
			</form>
		</section>
		<section class="list" id="list" style="width: 600px">
			<table align="center">
				<thead>
					<tr>
						<th>Number</th>
						<th>Title</th>
						<th>State</th>
						<th>-</th>
					</tr>
				</thead>
				<c:forEach var="trip" items="${trips}" varStatus="status">
					<tbody>
						<tr>
							<td>${status.count}</td>
							<td><c:url value="${trip.tripTitle}" /></td>
							<td><c:out value="${trip.state}" /></td>
							<td><c:url value="/trip/trip_modify?tripId=${trip.tripId}" var="url" /><a href="${url}">수정</a> 
							<c:url value="/trip/trip_delete?tripId=${trip.tripId}" var="url" /><a href="${url}">삭제</a></td>
						</tr>
					</tbody>
				</c:forEach>
			</table>
		</section>
	</main>
</body>
</html>