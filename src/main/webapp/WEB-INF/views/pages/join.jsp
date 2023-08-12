<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Sign Up</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/login.css" type="text/css"></link>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/menu.css" type="text/css"></link>
</head>
<body>
	<nav>
        <ul>
            <li><a href="/web">Home</a></li>
            <li><a href="login">Login</a></li>
        </ul>
    </nav>
	<main class="container">
		<header>회원가입</header>
		<form name=form1 action="join" method="post">
			<table>
				<tr>
					<th>ID</th>
					<td><input type="text" name="userId" autofocus placeholder="공백없이 입력하세요"></td>
				</tr>
				<tr>
					<th>PASSWORD</th>
					<td><input type="text" name="userPasswd" placeholder="공백없이 입력하세요"></td>
				</tr>
				<tr>
					<th>NAME</th>
					<td><input type="text" name="userName" placeholder="공백없이 입력하세요"></td>
				</tr>
				<tr>
					<th>EMAIL</th>
					<td><input type="text" name="userEmail" placeholder="****@****.***"></td>
				</tr>
			</table>
			<dl>
				<dd>
					<input type="submit" name="submit" value="회원가입">
				</dd>
				<dd>
					<input type="reset" name="reset" value="다시 작성">
				</dd>
			</dl>
		</form>
	</main>
</body>
</html>