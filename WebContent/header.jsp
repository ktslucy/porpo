<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<head>
<link
	href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR&display=swap"
	rel="stylesheet">
<link rel="stylesheet" href="css/common.css" />
</head>
<div id="header">
	<div class="navi-wrap">
		<div class=navi-left>
			<img src="image/delivery_190819.gif" />
		</div>
		<c:if test="${empty sessionScope.id}">
			<ul class="navi-bflog">
				<li><a href="joinForm.do">회원가입</a></li>
				<li><a href="login.do">로그인</a></li>
			</ul>
		</c:if>

		<c:if test="${!empty sessionScope.id}">
			<ul class="navi-aflog">
				<li class="sub"><a href="#none">${id} 님</a></li>
				<li class="sub"><a href="orderDetail.do">주문내역</a></li>
				<li><a href="userModifyForm.do">개인정보수정</a>
				<li><a href="logout.do">로그아웃</a></li>
			</ul>
		</c:if>
	</div>
	<div class="logo-wrap">
		<h1 class="logo">
			<a href="main.do"><span class="screen-out">마켓컬리</span> <img
				src="image/logo.png" alt="마켓컬리 로고" /></a>
		</h1>
	</div>

	<div class="gnb-wrap">
		<ul class="gnb">
			<li id="menu"><a href="#none"><span class="ico"></span>전체
					카테고리</a>
				<ul id="category"></ul></li>
			<li><a href="#none">신상품</a></li>
			<li><a href="#none">베스트</a></li>
			<li><a href="#none">알뜰쇼핑</a></li>
			<li><a href="#none">금주혜택</a></li>
		</ul>

		<div class="search">
			<input type="text" class="inp_search" value="브런치부터 커피까지 나만의 홈카페" />
			<input type="image" src="image/search.png" class="btn_search" />
		</div>

		<div class="btn-cart">
			<a href="#none"> <span class='btn-cartCnt'></span></a>
		</div>
	</div>
</div>

<script defer src="js/gnb.js"></script>
<script defer src="js/cart.js"></script>



















