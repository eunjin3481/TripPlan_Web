<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/login.css" >
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/menu.css" >
</head>
<body>

	<nav>
        <ul>
            <li><a href="/web">Home</a></li>
        </ul>
    </nav>

	<main class="container">
		<header>로그인</header>
		<form name="form1" action="login" method="post">
			<table>
				<tr>
					<th>ID</th>
					<td><input type="text" name="id" autofocus
						placeholder="아이디를 입력하세요"></td>
				</tr>
				<tr>
					<th>PASSWORD</th>
					<td><input type="password" name="passwd"
						placeholder="비밀번호를 입력하세요"></td>
				</tr>
			</table>
			<input type="submit" name="submit" value="로그인">
			<div class="signup-link">
				<c:url value="/join" var="url" />
				<a href="${url}">회원 가입</a>
			</div>
		</form>
	</main>
</body>
</html>
