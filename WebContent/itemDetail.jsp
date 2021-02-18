<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/common.css" />
<link rel="stylesheet" type="text/css" href="css/itemDetail.css" />
<link rel="preconnect" href="https://fonts.gstatic.com">
<link
	href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR&display=swap"
	rel="stylesheet">

</head>
<body>
	<jsp:include page="header.jsp" />

	<div class="content">
		<div class="item-wrap">
			<div class="img left"
				style='background-image: url("image/item/${item.getFilename()}")'></div>

			<div class="right">
				<div class="title">
					<p class="name">${item.getItemName()}</p>
					<p class="desc">${item.getDesc()}</p>
				</div>

				<div class="price">
					<span class="dc-price"></span><span class="won"> 원</span>
					<span class="orgin-price">${item.getOriginPrice()}</span>
					<span class="price-desc">구매수량 x 1,000원 = 총 상품금액 </span>
				</div>

				<div class="info">
					<dl class="list">
						<dt class="tit">판매단위</dt>
						<dd class="desc">${item.getUnit()}</dd>
					</dl>
					<dl class="list">
						<dt class="tit">무게</dt>
						<dd class="desc">${item.getWeight()}</dd>
					</dl>
					<dl class="list">
						<dt class="tit">배송구분</dt>
						<dd class="desc">${item.getDelivery()}</dd>
					</dl>
					<dl class="list">
						<dt class="tit">포장</dt>
						<dd class="desc">${item.getPacking()}</dd>
					</dl>
					<dl class="list">
						<dt class="tit">구매수량</dt>
						<dd class="desc">
							<div class="desc-cnt-wrap">
								<button class="minus" onclick="change(-1);"></button>
								<input type="text" class="cnt" value="1"/>
								<button class="plus" onclick="change(1);"></button>
							</div>
						</dd>
					</dl>
				</div>

			<!-- 	<div class="total">
					<strong class="tit">총 상품금액 :</strong> <span class="totalPrice"></span> <span
						class="won">원</span>
				</div> -->
				<button type="button" class="cart">
					<span class="screen-out intoCart">${item.getItemNumber()}</span>장바구니 담기
				</button>

				<!--<div class="groupBtn">
					<button type="button" class="cart">
						<span class="screen-out intoCart">${item.getItemNumber()}</span>장바구니 담기
					</button>
				 	<a href="order.do" class="buying">바로 구매하기</a> 
				</div>-->
			</div>
		</div>
	</div>
	<jsp:include page="footer.jsp" />
	<script defer src="js/itemDetail.js"></script>
	<script defer src="js/cart.js"></script>
</body>