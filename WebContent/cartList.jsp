<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<head>
<link rel="stylesheet" href="css/common.css" />
<link rel="stylesheet" href="css/cartList.css" />
<link rel="preconnect" href="https://fonts.gstatic.com">
<link
	href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR&display=swap"
	rel="stylesheet">
</head>
<body>
	<jsp:include page="header.jsp" />
	<div class="content">
		<h2 class="tit">장바구니</h2>
		<div class="cartList-wrap">
				<div class="left">
					<table class="orderList">
						<thead>
							<tr>
								<th><input type="checkbox" id="allCheck" name="allCheck"
									checked /><span class="ico"></span></th>
								<th colspan='2'>상품정보</th>
								<th>수량</th>
								<th>상품 금액</th>
							</tr>
						</thead>
						<tbody class="cart">
							<c:forEach var="cartList" items="${cartList}">
								<tr>
									<td><input type="checkbox" id="chkItem" name="chkItem"
										data-item="${cartList.getItem().getItemNumber()}" checked />
										<span class="ico"></span>
									<td class="img"
										style="width: 90px; height: 110px; text-align: left;"><img
										src="image/item/${cartList.getItem().getFilename()}"
										style="width: 90px; height: 110px;" /></td>
									<td style="text-align: left;">${cartList.getItem().getItemName()}</td>
									<td style="width: 160px; padding-left: 24px">
										<div class="btn-container">
											<button class="minus"
												data-item="${cartList.getItem().getItemNumber()}">-</button>
											<input type="text" name="cnt" class="cnt"
											value="${cartList.getCnt()}" readonly />
											<button class="plus"
												data-item="${cartList.getItem().getItemNumber()}">+</button>
										</div>
									</td>
									<td class='totalPrice' style="width: 160px">${cartList.getItem().getDcPrice()}</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
				<div class="right">
					<!-- <h3 class="tit_sub">결제 금액</h3> -->
					<div class="pay-container">
						<dl>
							<dt>상품금액</dt>
							<dd class="sum"></dd>
						</dl>
						<dl>
							<dt>배송비</dt>
							<dd>
								<span class="delivery"></span> 
							</dd>
							<span class="freeShipping">10,000원이상 주문 시, 무료배송</span>

						</dl>
						<dl class="amount">
							<dt>결제예정금액</dt>
							<dd>
								<span class="final"></span> 원
							</dd>
						</dl>
					</div>
					
					<button id="order">주문하기</button>
				</div>
		</div>
	</div>
	<jsp:include page="footer.jsp" />
	<script defer src="js/cartList.js"></script>
</body>