<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/common.css" />
<link rel="preconnect" href="https://fonts.gstatic.com">
<link
	href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR&display=swap"
	rel="stylesheet">
<style>
div.itemList-wrap p.cateName {
	width: 980px;
	border-bottom: 1px solid #DADADA; 
	margin-left: 22px;
	margin-top: 20px;
	padding-bottom: 4px;
}

div.itemList-wrap p.cateName span {
	font-size: 14px;
	position: absolute;
	top: 41px;
	padding-left: 4px;
}

div.itemList-wrap p.cateName img {
	display: inline-block;
	width: 40px;
	height: 40px;
}

div.itemList-wrap {
	width: 1050px;
	margin: 0 auto;
	overflow: hidden;
}

ul.itemList {
	overflow: hidden;
	padding: 0 0 40px 24px;
}

ul.itemList li.items {
	position: relative;
	float: left;
	padding: 20px 28px 0 0;
	height: 611px;
}

.itemList .pdtInfo span {
	display: block;
}

.itemList li.items .img {
	width: 308px;
	height: 396px;
	display: block;
}

.itemList  .pdtInfo .pdtName {
	font-weight: 700;
	font-size: 20px;
	padding-top: 20px;
}

.itemList .pdtInfo .dc-price {
	font-size: 17px;
	font-weight: 700;
	padding-top: 20px;
}

.itemList .pdtInfo .origin-price {
	font-size: 14px;
	color: #999;
	text-decoration: line-through;
	padding-top: 8px;
}

.itemList .pdtInfo .desc {
	padding-top: 8px;
	font-size: 13px;
	color: #666;
}

.itemList .addToCart {
	right: 45px;
	width: 45px;
	position: absolute;
	top: 350px;
}

.itemList .addToCart .cartBtn {
	width: 45px;
	height: 45px;
	background: url("image/ico_pur8.png") no-repeat 50% 50%;
	background-size: 45px 45px;
	border:0;
	cursor: pointer;
}

</style>
</head>
<body>
	<jsp:include page="header.jsp" />
	<div class="content">
		<div class="itemList-wrap">
			<p class="cateName">
				<img src="image/${menu.getIco_on()}" /><span>${menu.getMenuName()}</span>
			</p>
			<ul class="itemList">
				<c:forEach var="itemList" items="${itemList}">
					<li class="items"><a
						href="itemDetail.do?pdtNumber=${itemList.getItemNumber()}"> <img
							src="image/item/${itemList.getFilename()}" class="img"
							alt="${itemList.getItemName()}" />
					</a>
						<div class="pdtInfo">
							<a href="itemDetail.do?pdtNumber=${itemList.getItemNumber()}"
								class="info"> <span class="pdtName">${itemList.getItemName()}</span>
								<span class="dc-price">${itemList.getDcPrice()}</span> <span
								class="origin-price">${itemList.getOriginPrice()}</span> <span
								class="desc">${itemList.getDesc()}</span>
							</a>
						</div>
						<div class="addToCart">
							<button type="button" class="cartBtn" onclick="cart('${itemList.getItemNumber()}')">
								<span class="cartName screen-out">${itemList.getItemNumber()}</span>
							</button>
						</div></li>
				</c:forEach>
			</ul>
		</div>
	</div>
	<jsp:include page="footer.jsp" />
	<script defer src="js/itemCate.js"></script>
	<script defer src="js/cart.js"></script>
</body>
</html>