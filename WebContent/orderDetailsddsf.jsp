<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/common.css" />
<link rel="preconnect" href="https://fonts.gstatic.com">
<link
	href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR&display=swap"
	rel="stylesheet">
<meta charset="EUC-KR">
<title>Insert title here</title>


<style>
.orderDetailList-wrap {
	margin: 0 auto;
	width: 1050px;
}

.orderDetailList-wrap .left {
	float: left;
	width: 200px;
	border: 1px solid #f4f4f4;
}

.orderDetailList-wrap .left ul li a {
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

.orderDetailList-wrap .left ul li a:hover {
	background: #fff
		url(https://res.kurly.com/pc/ico/2008/ico_arrow_6x11_on.svg) no-repeat
		174px 52%;
	background-size: 6px 11px;
	font-weight: 700;
	color: #5f0080;
}

.orderDetailList-wrap .left ul li:first-child a {
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

ul.orderDetailList {
	width: 820px;
	margin: 0 auto;
	overflow: hidden;
	padding-bottom: 60px;
}

ul.orderDetailList li.orderDetail {
	padding: 0 20px;
	border: 1px solid #dddfe1;
}

ul.orderDetailList div.date {
	padding: 20px 0 8px 4px;
	font-size: 16px;
	line-height: 24px;
	font-weight: 700;
	color: #666;
}

ul.orderDetailList li.orderDetail .tit {
	padding: 20px 0 13px;
	border-bottom: 1px solid #dddfe1;
}

ul.orderDetailList li.orderDetail .tit .all-orderDetail {
	display: block;
	overflow: hidden;
	background: url("image/ico_arrow_10x15.webp") no-repeat 100% 1px;
	font-size: 16px;
	line-height: 24px;
	font-weight: 700;
	color: #000;
	cursor: pointer;
}

.img {
	float: left;
}

ul.orderDetailList li.orderDetail div.orderDetail {
	float: left;
	margin-left: 10px;
}

ul.orderDetailList li.orderDetail div.order-info {
	overflow: hidden;
	padding: 14px 0 20px;
	position: relative;
}

ul.orderDetailList li.orderDetail div.order-info a.inquiry {
	display: block;
	width: 100px;
	height: 34px;
	border: 1px solid #5f0080;
	background-color: #fff;
	font-size: 12px;
	color: #5f0080;
	line-height: 32px;
	text-align: center;
	cursor: pointer;
	position: absolute;
	top: 40px;
	right: 0;
}

a.inquiry {
	position: absolute;
	top: 61px;
	right: 0;
}

div.orderDetail dl {
	padding-top: 3px;
}

div.orderDetail dt {
	display: inline-block;
	padding-right: 15px;
	font-size: 12px;
	color: #000;
	line-height: 20px;
}

div.orderDetail dd {
	display: inline-block;
	font-size: 14px;
	line-height: 20px;
	font-weight: 700;
	color: #000;
}
</style>
</head>
<body>
	<jsp:include page="header.jsp" />
	<div class="content">

		<div class="orderDetailList-wrap">
			<h2 class="tit">주문내역</h2>
			<div class="left">
				<ul>
					<li><a href="">주문내역</a></li>
					<li><a href="getBoard.do">문의내역</a></li>
				</ul>
			</div>
			<ul class="orderDetailList">
				<c:forEach var="i" items="${allOrdList}">
					<c:forEach var="j" items="${i}">
	${j.getItemNo()}
	
				</c:forEach>
				</c:forEach>

<c:forEach var="i" items="${allOrdList}"
					varStatus="status">
					<c:forEach var="j" items="${i}"
					varStatus="status">
					<div class="date">주문번호</div>
				
					<li class="orderDetail">

					 	<div class="tit">
							<a class="all-orderDetail"
								href="orderView.do?ordNo=${orderSummaryList.getOrderNo()}">${orderSummaryList.getItemName()}
								외 ${orderSummaryList.getCnt()}개</a>

						</div>
						<div class="order-info">
							<div class="img">
								<img src="image/item/${orderSummaryList.getFileName()}"
									style="width: 60px">
							</div>
							<div class="orderDetail">
								<dl>
									<dt>주문일자</dt>
									<dd>${orderSummaryList.getDate()}</dd>
								</dl>
								<dl>
									<dt>결제금액</dt>
									<dd class="total">${orderSummaryList.getTotal()}</dd>
								</dl>

								<dl>
									<dt>주문상태</dt>
									<dd>배송완료</dd>
								</dl>
								<a class="inquiry"
									href="inquiry.do?orderNo=${orderSummaryList.getOrderNo()}">1:1문의</a>
								<c:choose>
									<c:when test="${check[status.index] eq '1'}">
										<a class="inquiry"
											href="boardDetail.do?ordNo=${orderSummaryList.getOrderNo()}">문의글
											확인</a>
									</c:when>
									<c:when test="${check[status.index] eq '-1'}">
										<a class="inquiry"
											href="inquiry.do?orderNo=${orderSummaryList.getOrderNo()}">1:1문의</a>
									</c:when>
								</c:choose>

							</div>
						</div>
					</li> >
				</c:forEach>
				</c:forEach

			</ul>
		</div>
	</div>
	<script>
		var total = document.getElementsByClassName('total');
		for (var i = 0; i < total.length; i++) {
			total[i].innerHTML = Number(total[i].innerHTML).toLocaleString()
					+ '원';
		}
	</script>

	<jsp:include page="footer.jsp" />
</body>
</html>