<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="css/common.css" />
<link rel="stylesheet" type="text/css" href="css/main.css" />
<link rel="preconnect" href="https://fonts.gstatic.com">
<link
	href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR&display=swap"
	rel="stylesheet">



<title>Insert title here</title>

</head>
<body>
	<div class="top">
		<div class="top-container">
			<a href="#none">지금 가입하고 인기상품 <b>100원</b>에 받아가세요!
			</a>
		</div>
	</div>

	<jsp:include page="header.jsp" />

	<div class="slider-wrap">
		<ul class="slider-container">
			<li class="slide"><a href="#none"
				style='background-image: url("image/slide_1.jpg")'></a></li>
			<li class="slide"><a href="#none"
				style='background-image: url("image/slide_2.jpg")'></a></li>
			<li class="slide"><a href="#none"
				style='background-image: url("image/slide_3.jpg")'></a></li>
			<li class="slide"><a href="#none"
				style='background-image: url("image/slide_4.jpg")'></a></li>
		</ul>
	</div>

	<div class="content">
		<div class="special">
			<div class="special-container">
				<div class="left">
					<h3 class="tit">
						<span class="name">설 얼리버드 특가</span> <span class="tit_desc">설날까지
							매일 진행되는 24시간 한정 특가</span>
					</h3>
					<p class="sub_hook">망설이면 늦어요!</p>
				</div>
				<div class="right">
					<div class="right-container">
						<a class="event-pdt" href="#none"></a>
						<p class="timer">
							<span class="timer-txt"></span><span class="txt">남음</span>
						</p>
						<div class="soldout">
							<p class="soldout-txt">판매 완료</p>
						</div>
					</div>

					<div class="pdtInfo">
						<div class="pdt">
							<a href="#none" class="name">김정환홍삼 홍삼으로 에너지타임 스틱</a> <a href="#none"
								class="sub_name">에너지를 위한 한포 드림</a>
						</div>
						<div class="timer-price">
							<span class="timer-dc-percent">65%</span>
							<div class="timer-in-price">
								<span class="timer-selling">28,000원</span> <span class="timer-cost">80,000원</span>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>

		<div class="bnr">
			<a href="#none"></a>
		</div>

		<div class="recmd_md">
			<h3>MD의 추천</h3>
			<div class="md-cate-contatiner">
				<ul class="md-cate">
					<c:forEach var="menuList" items="${menuList}">
						<li class="menu"><a data-no="${menuList.getMenuNum()}" href="#none" class="menuLink">${menuList.getMenuName()}</a></li>
					</c:forEach>
				</ul>
			</div>

			<div class="md-pdt-wrap">
				<ul class="md-pdt-container">
					<c:forEach var="mdList" items="${mdList}">
						<li class="md-pdt"><a class="link-img"
							href="itemDetail.do?pdtNumber=${mdList.getItemNumber()}"
							style='background-image: url("image/item/${mdList.getFilename()}")'></a>
							<div class="pdt-info">
								<span class="pdtName"><a href="itemDetail.do?pdtNumber=${mdList.getItemNumber()}">${mdList.getItemName()}</a></span>
								<span class="dc-price">${mdList.getDcPrice()}</span> <span
									class="price">${mdList.getOriginPrice()}</span>
							</div></li>
					</c:forEach>
				</ul>
			</div>
			<a class="left-btn"></a> <a class="right-btn"></a>
		</div>

		<div class="recipe">
			<h3>컬리의 레시피</h3>
			<ul class="recipe-container">
				<li><a href="#none"
					style="background-image: url('image/recipe1.jpg')"></a> <span><a
						href="#none">플랫 브레드 루꼴라 피자</a></span></li>
				<li><a href="#none" style="background-image: url('image/recipe2.jpg')"></a> <span><a href="#">시금치 페스토 파스타</a></span></li>
				<li><a href="#none" style="background-image: url('image/recipe3.jpg')"></a> <span><a href="#">황태 양념구이</a></span></li>
			</ul>
		</div>
		
		
		<div class="insta">
			<h3>인스타그램 고객 후기</h3>
			<ul class="insta-container">
				<li><a href="#none" style="background-image: url('image/insta1.jpg')"></a> 
				<li><a href="#none" style="background-image: url('image/insta2.jpg')"></a> 
				<li><a href="#none" style="background-image: url('image/insta3.jpg')"></a> 
				<li><a href="#none" style="background-image: url('image/insta4.jpg')"></a> 
				<li><a href="#none" style="background-image: url('image/insta5.jpg')"></a> 
				<li><a href="#none" style="background-image: url('image/insta6.jpg')"></a> 
			</ul>
		</div>

	</div>
	<jsp:include page="footer.jsp" />

	<script src="js/slide.js"></script>
	<script defer src="js/main.js"></script>
</body>
</html>