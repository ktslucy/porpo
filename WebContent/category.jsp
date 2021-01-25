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
<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR&display=swap" rel="stylesheet">
<style>
.itemList-wrap{
	width: 1050px;
	margin: 0 auto;
	overflow: hidden;
}

.itemList{
	border: 3px solid pink;
	overflow: hidden;
	padding: 0 15px;
}

.itemList .items {
	position: relative;
	border: 1px solid black;
	float: left;
	width: 336px;
	height: 611px;
	padding: 25px 28px 0 0;
}

.pdtInfo span {
	display: block;
	border: 1px solid red;
}

.items .img {
	width: 308px;
	height: 396px;
	display: block;
	border: 3px solid green;
}

.pdtInfo .pdtName{
	font-weight: 700;
    font-size: 20px;
   	line-height: 29px;
	letter-spacing: 0;
}

.pdtInfo .price{
	font-size: 17px;
    line-height: 24px;
    font-weight: 700;
    color: #5f0080;
    letter-spacing: 0;

}

.pdtInfo .desc{
    font-size: 13px;
    color: #666;
    line-height: 19px;
    letter-spacing: 0;
}

.addToCart{
	position: absolute;
	top: 350px;
	right: 45px;
    width: 45px;
}
.cartBtn{
	width: 45px;
    height: 45px;
    background: url("image/ico_pur8.png") no-repeat 50% 50%;
    background-size: 45px 45px;
    border: 0;
}
</style>
</head>
<body>
<jsp:include page="header.jsp" />
<div class="content">
<div class="itemList-wrap">
	<ul class="itemList">
		<c:forEach var="itemList" items="${itemList}">
			<li class="items"><a href="itemDetail.do?pdtNumber=${itemList.getItemNumber()}"> 
				<img src="image/item/${itemList.getFilename()}" class="img" alt="${itemList.getItemName()}"/>
			</a>
				<div class="pdtInfo">
					<a href="itemDetail.do?pdtNumber=${itemList.getItemNumber()}" class="info">
						<span class="pdtName">${itemList.getItemName()}</span>
						<span class="price">${itemList.getDcPrice()}원</span>
						<span class="desc">${itemList.getDesc()}</span>
					</a>
				</div>
				<div class="addToCart">
					<button type="button" class="cartBtn" onclick="cart(${itemList.getItemNumber()},1)">
						<span class="screen-out">${itemList.getItemNumber()}</span>
					</button>
				</div>
			</li>
		</c:forEach>
	</ul>
</div>
</div>
	<jsp:include page="footer.jsp" />
</body>
</html>