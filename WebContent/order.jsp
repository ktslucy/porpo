<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<head>
<link rel="stylesheet" href="css/common.css" />
<link rel="stylesheet" href="css/order.css" />
<link rel="preconnect" href="https://fonts.gstatic.com">
<link
	href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR&display=swap"
	rel="stylesheet">
</head>
<body>
	<jsp:include page="header.jsp" />
	<div class="content">
		<h2 class="tit">주문서</h2>
		<div class="cartList-wrap">
			<div class="left">
				<table class="orderList">
					<thead>
						<tr>
							<!-- <th><input type="checkbox" id="allCheck" name="allCheck"
								checked /></th> -->
							<th colspan="2" style="width: 450px;">상품정보</th>
							<th>수량</th>
							<th>상품 금액</th>
						</tr>
					</thead>
					<tbody class="cart">
						<c:forEach var="cartList" items="${cartList}">
							<tr>
								<%-- <td><input type="hidden" name="item" value="${cartList.getItem().getItemNumber()}" /></td> --%>
								<td class="img" 
									style="width: 90px; height: 110px; text-align: left;"><img
									src="image/item/${cartList.getItem().getFilename()}"
									style="width: 90px; height: 110px;" /></td>
								<td class="item" data-item="${cartList.getItem().getItemNumber()}" style="text-align: left;">${cartList.getItem().getItemName()}</td>
								<td style="width: 160px;"><span class="cnt">${cartList.getCnt()}</span><span class="ea">개</span></td>
								<td class='totalPrice' style="width: 160px">${cartList.getItem().getDcPrice()}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>

				<h3 class="tit_sub">주문자 정보</h3>
				<table class="orderer_info">
					<tr>
						<th>받는 분</th>
						<td class="userName"><input type="text" id="orderer" value="${user.getUserName()}" readonly/></td>
					</tr>
					<tr>
						<th>휴대폰</th>
						<td class="phone"><input type="text" id="phone" value="${user.getPhone()}" readonly/></td>
					</tr>
					<tr>
						<th>이메일</th>
						<td class="email"><input type="text" id="email" value="${user.getEmail()}" readonly/>
						<p class="txt_guide">이메일은 주문과정을 통해 보내드립니다.<br> 정보변경은 마이컬리>개인정보 수정에서 가능합니다.</p></td>
						
							
					</tr>
				</table>

				<h3 class="tit_sub">배송 정보</h3>
				<table class="delivery_info">
					<tr>
						<th>배송지</th>
						<td class="deliveryPlace"><input type="text" id="address" value="${user.getAddress()}" readonly/></td>
					</tr>
					<tr>
						<th>받으실 장소</th>
						<td class="finalPlace"><input type="text" id="finalArrival" value="현관 앞" readonly/></td>
					</tr>
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
							<span class="final"></span>원
						</dd>
					</dl>
				</div>

				<button id="pay">결제하기</button>
			</div>
		</div>
	</div>
	<jsp:include page="footer.jsp" />
	<script defer src="js/order.js"></script>
</body>