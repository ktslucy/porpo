<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link
	href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR&display=swap"
	rel="stylesheet">
<link rel="stylesheet" href="css/common.css" />
<title>Insert title here</title>
<style>
.section_login * {
	font-family: noto sans;
	color: #333;
}

.section_login {
	width: 340px;
	margin: 0 auto;
	padding: 90px 0;
	letter-spacing: -.6px;
}

h3.tit_login {
	font-weight: 800;
	font-size: 20px;
	line-height: 20px;
	text-align: center;
	margin-bottom: 32px;
}

input[type=text], input[type=password], input[type=button] {
	width: 100%;
	height: 54px;
	padding: 0 19px;
	border: 1px solid #ccc;
	border-radius: 3px;
	background-color: #fff;
	font-size: 14px;
	line-height: 20px;
	outline: none;
	margin: 4px 0;
}

input[type=button].btn_type1 {
	background-color: #5f0080;
	color: #fff;
}

.btn_type2 {
	display: block;
	width: 340px;
	height: 54px;
	border: 1px solid #5f0080;
	border-radius: 3px;
	background-color: #fff;
	font-size: 14px;
	line-height: 55px;
	outline: none;
	text-align: center;
	color: #5f0080;
	margin: 10px auto;
}

.login_search {
	float: right;
	margin: 8px 0 28px 0;
}

.login_search .findId {
	float: left;
}

.login_search .findPw {
	float: right;
}

.bar {
	display: inline-block;
	width: 1px;
	height: 10px;
	background-color: #333;
	float: left;
	margin: 1px 8px;
}
</style>
</head>
<body>
	
	<div class="content">
		<div class="section_login">
			<h3 class="tit_login">관리자 로그인</h3>
			<input type="text" id="id" placeholder="아이디를 입력하세요" /><br> <input
				type="password" id="passwd" placeholder="비밀번호 입력하세요" /><br>
		
			<input type="button" id="loginBtn" value="로그인" class="btn_type1"
				onclick="login();">
		</div>
	</div>




	<script defer src="js/admin.js"></script>

</body>
</html>