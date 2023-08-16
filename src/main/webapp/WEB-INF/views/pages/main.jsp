<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Main</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/main.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/menu.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/table.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/modal.css">
</head>
<body>
	<nav>
		<ul>
			<li><a href="/web" data-page="main">Home</a></li>
			<!-- 세션 데이터가 있는 경우 -->
			<c:if test="${sessionScope.userId != null}">
				<li><a href="user">Profile</a></li>
			</c:if>
			<!-- 세션 데이터가 없는 경우 -->
			<c:if test="${sessionScope.userId == null}">
				<li><a href="login">Login</a></li>
			</c:if>
		</ul>
	</nav>

	<header>
		<h1>Trip Plan</h1>
		<button id="openModalBtn">Create</button>

		<div id="myModal" class="modal">
			<div class="modal-content">
				<span class="close">&times;</span>
				<h2>Create a New Travel Plan</h2>
				<form action="tripCreate" method="post">
					<label>Title:</label> <input type="text" name="title"><br>
					<button type="submit" formethod="post">생성</button>
				</form>
			</div>
		</div>

	</header>

	<main>
		<section class="search">
			<input type="text" name="search" id="searchInput" placeholder="검색어 입력">
			<button type="button" onclick="search()">검색</button>
			<button type="button" onclick="refreshPage()">초기화</button>
		</section>
		
		<section class="list">
			<br>
			<table align="center">
				<thead>
				<tr>
					<th>Num</th>
					<th>Title</th>
					<th>ID</th>
				</tr>
				</thead>
				<tbody>
				<c:forEach var="trip" items="${trips}" varStatus="status">
					<!-- 공개일 경우 -->
					<c:if test="${trip.state == 'public'}">
						<c:set var="tripTitle" value="${fn:toLowerCase(trip.tripTitle)}" />
						<c:set var="searchInput" value="${fn:toLowerCase(param.search)}" />
						<c:if test="${empty param.search or fn:contains(tripTitle, searchInput)}">
							<tbody>
								<tr>
									<td>${status.index + 1}</td>
									<td><c:url value="/trip?tripId=${trip.tripId}" var="url" /><a href="${url}">${trip.tripTitle}</a></td>
									<td><c:out value="${trip.userId}" /></td>
								</tr>
							</tbody>
						</c:if>
					</c:if>
				</c:forEach>
				</tbody>
			</table>
		</section>
	</main>
	<script src="${pageContext.request.contextPath}/resources/js/search.js"></script>
	<script src="${pageContext.request.contextPath}/resources/js/modal.js"></script>
</body>
</html>