<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="css/common.css" />
<link rel="preconnect" href="https://fonts.gstatic.com">
<link
	href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR&display=swap"
	rel="stylesheet">
<title>Insert title here</title>
<style>
.ordView-wrap {
	width: 1050px;
	margin: 0 auto;
	overflow: hidden;
}

.ordView-wrap .left {
	float: left;
	width: 200px;
	border: 1px solid #f4f4f4;
}

.ordView-wrap .left ul li a {
	display: block;
	overflow: hidden;
	padding: 15px 0 15px 20px;
	background: #fff
		url(https://res.kurly.com/pc/ico/2008/ico_arrow_6x11.svg) no-repeat
		174px 52%;
	background-size: 6px 11px;
	font-size: 14px;
	color: #666;
	line-height: 20px;
	letter-spacing: -.3px;
}

.ordView-wrap .left ul li a:hover {
	background: #fff
		url(https://res.kurly.com/pc/ico/2008/ico_arrow_6x11_on.svg) no-repeat
		174px 52%;
	background-size: 6px 11px;
	font-weight: 700;
	color: #5f0080;
}

.ordView-wrap .left ul li:nth-child(2) a {
	background: #fafafa
		url(https://res.kurly.com/pc/ico/2008/ico_arrow_6x11_on.svg) no-repeat
		174px 52%;
	background-size: 6px 11px;
	font-weight: 700;
	color: #5f0080;
}

h2.tit {
	font-weight: 800;
	font-size: 30px;
	text-align: center;
	letter-spacing: -.5px;
	line-height: 2;
	padding: 55px 0 30px;
}

.ordView-wrap .right {
	width: 820px;
	margin: 0 auto;
	overflow: hidden;
}

.ordView-wrap .right .table1, .ordView-wrap .right .table2 {
	font-size: 20px;
	color: #333;
	letter-spacing: -.4px;
	padding: 0 0 21px;
	font-weight: 700;
}

.ordView-wrap .right table.list {
	border-top: 2px solid #333;
	margin-bottom: 40px;
	overflow: hidden;
}

.ordView-wrap .right table.list th, .ordView-wrap .right table td {
	padding: 25px 0 24px;
	position: relative;
}

.ordView-wrap .right table.list tr {
	border-bottom: 1px solid #f4f4f4;
}

.ordView-wrap .right .img {
	display: block;
	overflow: hidden;
	width: 60px;
	height: 78px;
	background-color: #f4f4f4;
	background-repeat: no-repeat;
	background-position: 50% 50%;
	background-size: cover;
	float: left;
}

.ordView-wrap .right .info {
	width: 100%;
	padding-left: 20px;
}

.ordView-wrap .right .info .item-tit {
	font-weight: 600;
	font-size: 16px;
	color: #333;
	line-height: 2;
}

.ordView-wrap .right .info .total {
	padding-right: 5px;
	font-weight: 600;
	font-size: 14px;
	color: #333;
	float: left;
}

.ordView-wrap .right .info .total::after {
	content: "";
	display: inline-block;
	width: 2px;
	height: 12px;
	margin: 0 8px 0 8px;
	background-color: #999;
	vertical-align: -1px;
}

.ordView-wrap .right .info .cnt, .ordView-wrap .right .info .ea {
	font-size: 14px;
	color: #333;
}

.ordView-wrap .right .info .shipping {
	position: absolute;
	top: 43%;
	right: 30px;
	font-weight: 600;
	font-size: 16px;
	color: #333;
	line-height: 24px;
	right: 30px;
}

table.deliver-info {
	border-top: 2px solid #333;
	width: 100%;
	margin-bottom: 60px;
}

table.deliver-info tr {
	border-bottom: 1px solid #f4f4f4;
	width: 860px;
}

table.deliver-info th {
	padding-bottom: 24px;
	font-size: 16px;
	color: #666;
	line-height: 24px;
	text-align: left;
	vertical-align: top;
	width: 120px;
	padding-top: 24px;
}

table.deliver-info td {
	font-size: 16px;
	color: #333;
	line-height: 24px;
	vertical-align: top;
	width: auto;
}
</style>
</head>
<body>
	<jsp:include page="header.jsp" />
	<div class="content">
		<div class="ordView-wrap">
			<h2 class="tit">주문내역상세</h2>
			<div class="left">
				<ul>
					<li><a href="orderDetail.do">주문내역</a></li>
					<li><a href="getBoard.do">문의내역</a></li>
				</ul>
			</div>
			<div class="right">
				<div class="table1">주문번호 ${ord.getOrderNo()}</div>
				<table class="list">
					<c:forEach var="list" items="${list}">
						<tr>
							<th class="itemImg"><img class="img"
								src="image/item/${list.getItem().getFilename()}" /></th>
							<td class="info">
								<div class="item-tit">${list.getItem().getItemName()}</div>
								<div class="total">${list.getCnt()}</div>
								<div class="cnt">${list.getCnt()}<span class="ea">개</span>
								</div>
								<div class="shipping">배송완료</div>
							</td>
						</tr>
					</c:forEach>
				</table>


				<div class="table2">배송정보</div>
				<table class="deliver-info">

					<tr>
						<th>주문자</th>
						<td>${ord.getOrderer()}</td>
					</tr>
					<tr>
						<th>휴대폰 번호</th>
						<td>${ord.getPhone()}</td>
					</tr>
					<tr>
						<th>이메일</th>
						<td>${ord.getEmail()}</td>
					</tr>
					<tr>

						<th>주소</th>
						<td>${ord.getAddress()}</td>
					</tr>
					<tr>

						<th>최종 도착지</th>
						<td>${ord.getFinalArrival()}</td>
					</tr>
					<tr>

						<th>배송비</th>
						<td class="deliveryFee">${ord.getShippingFee()}</td>
					</tr>
				</table>
			</div>
		</div>
	</div>
	<jsp:include page="footer.jsp" />
	<script>
		var cnt = document.getElementsByClassName('cnt');
		var total = document.getElementsByClassName('total');
		for (var i = 0; i < cnt.length; i++) {
			var c = (cnt[i].innerHTML).substring(0, 1);
			total[i].innerHTML = (c * 1000).toLocaleString() + '원';
		}

		var deliveryFee = document.getElementsByClassName('deliveryFee')[0].innerHTML;
		if (deliveryFee == 'C') {
			var cost = 3000;
			document.getElementsByClassName('deliveryFee')[0].innerHTML = cost
					.toLocaleString()
					+ '원';
		} else if (deliveryFee == 'F') {
			document.getElementsByClassName('deliveryFee')[0].innerHTML = '무료';
		}
	</script>
</body>
</html>