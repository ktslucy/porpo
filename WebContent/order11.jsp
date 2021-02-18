<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<head>
<link rel="stylesheet" href="css/common.css"/>
<style>
.orderList-wrap{
	margin: 0 auto;
	padding-top: 60px;
	width: 1050px;
	overflow: hidden;
}

.left{
	width: 742px;
	float: left;
}

.right{
	float: right;
    width: 284px;
}

.right .sum{
	width: 100%;
	padding: 18px;
	background: #fafafa;
    border: 2px solid #f2f2f2;
    margin-bottom: 18px;
}

.right .sum dl{
	overflow: hidden;
	padding-top: 12px;
}

.right .sum dt{
	float: left;
}

.right .sum dd{
	float: right;
}

.right .sum dt, .right .sum dd{
	font-size: 16px;
	font-weight: 500;
	vertical-align: top;
	letter-spacing: -0.5px;
}

.right .sum dl.amount{
	margin-top: 17px;
	border-top: 1px solid #eee;
}

.right .sum dl.amount span{
	font-size: 24px;
}


h2.tit{
	font-weight: 800;
	font-size: 30px;
	text-align: center;
	letter-spacing: -.5px;
	line-height: 2;
}

.desc{
	font-size: 14px;
    color: #999;
    letter-spacing: -.3px;
    text-align: center;
}

h3.tit_sub{
 	font-size: 20px;
	font-weight: 500;
	padding: 60px 0 15px;
}

table.orderList{
	width: 100%;
	border-top: 1px solid #333;
	border-bottom: 1px solid #999;
}

table.orderList thead{
	border-bottom: 1px solid #999;
}

table.orderList td{
	padding: 20px 0;
    font-weight: 700;
    font-size: 16px;
    line-height: 24px;
    text-indent: -.3px;
    text-align: center;
}

table.orderList th{
	font-size: 14px;
	font-weight: 600;
	padding: 20px 0;
}

table.orderer_info, table.delivery_info{
	width: 100%;
	border-top: 1px solid #333;
	border-bottom: 1px solid #999;
}

table.orderer_info th, table.orderer_info td, table.delivery_info th, table.delivery_info td {
 	padding: 30px 0;
 	vertical-align: top;
 	text-align: left;
    font-size: 14px;
}

table.orderer_info th, table.delivery_info th{
	width: 190px;
    font-weight: 700;
    padding-left: 20px;
}

table.orderer_info th::after{
	content: "*";
}

table.orderer_info .txt_guide{
	line-height: 1.8;
	padding-top: 20px;
}

#pay{
	display: block;
    width: 100%;
    height: 54px;
    border: 1px solid #5f0080;
    border-radius: 3px;
    background: #5f0080;
    font-weight: 700;
    font-size: 16px;
    color: #fff;
    line-height: 52px;
    letter-spacing: -.1px;
    text-align: center;
}
</style>
</head>
<body>
	<div class="orderList-wrap">
	
		<h2 class="tit">주문서</h2>
		<p class="desc">주문하실 상풍명 및 수량을 정확하게 확인해 주세요.</p>

		<h3 class="tit_sub">상품 정보</h3>
		<table class="orderList">
			<thead>
				<tr>
					<th colspan="2" style="width: 450px;">상품 정보</th>
					<th>수량</th>
					<th>상품 금액</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td class="img" style="width: 110px; text-align: left;">
						<img src="" style="width: 90px; height: 110px; background-color: pink;"/>
					</td>
					<td style="text-align: left;">콩나물</td>
					<td>1500원</td>
					<td>10원</td>
				</tr>
			</tbody>
		</table>

		<div class="left">
			<h3 class="tit_sub">주문자 정보</h3>
			<table class="orderer_info">
				<tr>
					<th>보내는 분</th>
					<td>김경은</td>
				</tr>
				<tr>
					<th>휴대폰</th>
					<td>01066342193</td>
				</tr>
				<tr>
					<th>이메일</th>
					<td>ktslucy@gmail.com
						<p class="txt_guide">
							이메일은 주문과정을 통해 보내드립니다.<br>
							정보변경은 마이컬리>개인정보 수정에서 가능합니다.
						</p>
					</td>
					
				</tr>
			</table>
		
	
			<h3 class="tit_sub">배송 정보</h3>
			<table class="delivery_info">
				<tr>
					<th>배송지</th>
					<td>경기도 부천시 소사동</td>
				</tr>
				<tr>
					<th>받으실 장소</th>
					<td>현관 앞</td>
				</tr>
			</table>
		</div>
		<div class="right">
			<h3 class="tit_sub">결제 금액</h3>
			<div class="sum">
				<dl>
					<dt>주문 금액</dt>
					<dd>10,500원</dd>
				</dl>
				<dl>
					<dt>배송비</dt>
					<dd>+ 3,000원</dd>
				</dl>
				<dl class="amount">
					<dt>최종 결제 금액</dt>
					<dd><span>13,500</span> 원</dd>
				</dl>
			</div>
			<button id="pay">결제하기</button>
		</div>
	</div>
		
	<script src="js/jquery-1.11.0.min.js"></script>
	<script>
		var person={
				name: 'lucy',
				age: 32,
				gender: 'male'
		};
		
		var pay=document.querySelector("#pay");
		var x=JSON.stringify(person);
		console.log(person);
		
		var httpRequest;
		httpRequest = new XMLHttpRequest();
		httpRequest.onreadystatechange = getCategory;
		httpRequest.open('post', 'order.do', true);
		httpRequest.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
		httpRequest.send("x="+x);
		function getCategory(){
			if (httpRequest.readyState === XMLHttpRequest.DONE && httpRequest.status === 200) {
			}
		}	
	
		
		function loadCategory(xml){
			var category = "";
			var xmldoc = xml.responseXML;
			var len = xmldoc.getElementsByTagName("category").length;
			for (var i = 0; i < len; i++) {
				category += "<li class='menu' data-index-number="+i+"><a>"
						+ xmldoc.getElementsByTagName("category")[i].childNodes[0].nodeValue
						+ "</a></li>";
			}
			document.getElementById("category").innerHTML = category;
		}
		
	</script>

<%--<c:forEach var="allOrdList" items="${allOrdList}"
					varStatus="status">
				<c:forEach var="allOrdList1" items="${allOrdList1}"
					varStatus="status">
					<div class="date">주문번호 ${allOrdList1.getOrderNo()}xcv</div>
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
				</c:forEach>--%>

</body>

