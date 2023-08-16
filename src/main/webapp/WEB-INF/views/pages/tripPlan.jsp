<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Trip Create</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/trip_list.css" type="text/css"></link>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css" type="text/css"></link>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/modal.css">

<script defer src="https://maps.googleapis.com/maps/api/js?key=${apiKey}&callback=initMap"></script>
<script src="${pageContext.request.contextPath}/resources/js/mapAPI.js"></script>

</head>
<body>
	<div class="container" style="width: 1400px">
		<form action="tripUpdate" method="post">
			<table>
				<tr>
					<td><input style="display: none;" type="text" name="tripId" value="${trip.tripId}"></td>
					<td><label>Title:</label><input type="text" name="tripTitle" value="${trip.tripTitle}"></td>
					<td>
						<select name="state">
							<option value="private" ${trip.state=='private'?'selected':''}>비공개</option>
							<option value="public" ${trip.state=='public'?'selected':''}>공개</option>
						</select>
					</td>
					<td><button type="submit" formmethod="post">Save</button></td>
				</tr>
			</table>

		</form>

		<table>
			<tr class="list">
				<td>
					<table align="center">
						<tr>
							<th></th>
							<th>장소</th>
							<th>날짜</th>
							<th>시간</th>
							<th>설명</th>
							<th></th>
						</tr>
						<c:forEach var="place" items="${places}" varStatus="status">
							<tr>
							<form action="trip/${trip.tripId}/placeUpdate/${place.placeId}" method="post">
								<td>${status.count}</td>
								<td><input type="text" name="placeName" value="${place.placeName}"></td>
								<td><input type="date" name="date" value="${place.date}"></td>
								<td><input type="time" name="time" value="${place.time}"></td>
								<td><input type="text" name="description" value="${place.description}"></td>
								<script>arr.push("${place.address}");</script>
								<td>
									<button type="submit">수정</button><br>
									<button onclick="location.href='trip/${trip.tripId}/placeDelete/${place.placeId}'" id="button">삭제</button>
									
								</td>
								</form>
							</tr>
						</c:forEach>
							<td colspan="6">
								<button id="openModalBtn">추가</button>
							</td>
						</tr>
					</table>
				</td>
				<td><div id="map" style="height: 600px;"></div></td>
			</tr>
		</table>
		<div id="myModal" class="modal">
			<div class="modal-content">
				<span class="close">&times;</span>
				<h2>장소 추가</h2>
				<form action="trip/${trip.tripId}/place" method="post">
					<label>Name:</label> <input type="text" name="placeName"><br>
					<label>Address:</label> <input type="text" name="address"><br>
					<button type="submit" formethod="post">추가</button>
				</form>
			</div>
		</div>
	</div>
	<script src="${pageContext.request.contextPath}/resources/js/modal.js"></script>
</body>
</html>

