<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div id="header">
	<div class="navi-wrap">
		<div class=navi-left><img src="image/delivery_190819.gif"/></div>
		<ul class="navi-bflog">
			<li><a href="join.do">회원가입</a></li>
			<li><a href="login.do">로그인</a></li>
			<li class="sub"><a href="">고객센터</a>
				<ul class="navi-sub">
					<li><a href="">공지사항</a></li>
					<li><a href="">자주하는 질문</a></li>
					<li><a href="">1:1 문의</a></li>
					<li><a href="">상품제안</a></li>
					<li><a href="">에코포장 피드백</a></li>
				</ul></li>
		</ul>
	</div>
	<div class="logo-wrap">
		<h1 class="logo">
			<a href="main.do"><span class="screen-out">마켓컬리</span><img
				src="image/logo.png" alt="마켓컬리 로고" /></a>
		</h1>
	</div>

	<div class="gnb-wrap">
		<ul class="gnb">
			<li id="menu"><a href="#none"><span class="ico"></span>전체 카테고리</a>
					<ul id="category"></ul>
			</li>
			<li><a href="#none">신상품</a></li>
			<li><a href="#none">베스트</a></li>
			<li><a href="#none">알뜰쇼핑</a></li>
			<li><a href="#none">금주혜택</a></li>
		</ul>

		<div class="search">
			<input type="text" class="inp_search" value="브런치부터 커피까지 나만의 홈카페" />
			<input type="image" src="image/search.png" class="btn_search" />
		</div>
		
		<div class="btn-location"><a href="#none"></a></div>
		<div class="btn-cart"><a href="#none"></a></div>
	</div>


</div>

<script defer src="js/gnb.js"></script>



















