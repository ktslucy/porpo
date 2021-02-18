<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
.board-wrap {
	width: 1050px;
	margin: 0 auto;
	overflow: hidden;
}

.board-wrap .left {
	float: left;
	width: 200px;
		border: 1px solid #f4f4f4;
}

.board-wrap .left ul li a {
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

.board-wrap .left ul li a:hover {
	background: #fff
		url(https://res.kurly.com/pc/ico/2008/ico_arrow_6x11_on.svg) no-repeat
		174px 52%;
	background-size: 6px 11px;
	font-weight: 700;
	color: #5f0080;
}

.board-wrap .left ul li:nth-child(2) a {
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

table.board {
	width: 820px;
	border-top: 2px solid #522772;
	border-bottom: 2px solid #522772;
	font-size: 13px;
	line-height: 140%;
	float: right;
	margin-bottom: 60px;
}

table.board th {
	padding: 20px 0;
	vertical-align: middle;
	font-size: 12px;
	border-bottom: 1px solid #333;
}

table.board td {
	padding: 20px 0;
	vertical-align: middle;
	text-align: center;
	font-size: 12px;
	border-bottom: 1px solid #f4f4f4;
}

table.board td.tit {
	padding-left: 10px;
    text-align: left;
    color: #999;
}

</style>
</head>
<body>

	<jsp:include page="header.jsp" />
	<div class="content">
		<div class="board-wrap">
			<h2 class="tit">문의내역</h2>
			<div class="left">
				<ul>
					<li><a href="orderDetail.do">주문내역</a></li>
					<li><a href="getBoard.do">문의내역</a></li>
				</ul>
			</div>
			<table class="board">
				<thead>
					<tr>
						<th width="6%">번호</th>
						<th width="12%">카테고리</th>
						<th width="12%">주문번호</th>
						<th>제목</th>
						<th width="12%">작성자</th>
						<th width="12%">작성일</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="boardList" items="${boardList}" begin="0" step="1"
						varStatus="status">
						<tr>
							<td class="brdNo">${status.index}</td>
							<td class="cate">${boardList.getBrdType()}</td>
							<td class="orderNo">${boardList.getOrderNo()}</td>
							<td class="tit">
								<a href="boardDetail.do?ordNo=${boardList.getOrderNo()}">${boardList.getTitle()}
								<c:if test="${boardList.getCmt() eq 'Y'}">[답변완료]
							</c:if></a>
							</td>
							<td>${boardList.getWriter()}</td>
							<td>${boardList.getBrdDate()}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
	<jsp:include page="footer.jsp" />

	<script>
		var cate = document.getElementsByClassName("cate");
		var brdNo = document.getElementsByClassName("brdNo");
		
		for (var i = 0; i < cate.length; i++) {
			
			brdNo[i].innerHTML=Number(brdNo[i].innerHTML)+1;
			
			switch (cate[i].innerHTML) {
			case '01':
				cate[i].innerHTML = '배송지연/불만';
				break;
			
			case '02':
				cate[i].innerHTML = '컬리패스(무료배송)';
				break;
			
			case '03':
				cate[i].innerHTML = '반품문의';
				break;
			
			case '04':
				cate[i].innerHTML = 'A/S문의';
				break;
			} 
		}
	</script>
</body>
</html>