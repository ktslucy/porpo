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
<style>
.board-wrap {
	width: 1050px;
	margin: 0 auto;
	overflow: hidden;
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
	width: 1050px;
	border-top: 2px solid #522772;
	border-bottom: 2px solid #522772;
	font-size: 13px;
	line-height: 140%;
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

	<c:if test="${!empty sessionScope.admin}">
		<div class="board-wrap">
			<h2 class="tit">문의내역(관리자계정)</h2>
			<table class="board">
				<thead>
					<tr>
						<th width="6%">번호</th>
						<th width="12%">카테고리</th>
						<th width="12%">주문번호</th>
						<th>제목</th>
						<th width="12%">문의자</th>
						<th width="12%">문의일</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="boardList" items="${boardList}" begin="0" step="1"
						varStatus="status">
						<tr>
							<td class="brdNo">${status.index}</td>
							<td class="cate">${boardList.getBrdType()}</td>
							<td class="orderNo">${boardList.getOrderNo()}</td>
							<td class="tit"><a
								href="adminBoardDetail.do?ordNo=${boardList.getOrderNo()}">${boardList.getTitle()}
									<c:if test="${boardList.getCmt() eq 'Y'}">[답변완료]
							</c:if>
							</a></td>
							<td>${boardList.getWriter()}</td>
							<td>${boardList.getBrdDate()}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</c:if>
	<script>
		var cate = document.getElementsByClassName("cate");
		var brdNo = document.getElementsByClassName("brdNo");

		for (var i = 0; i < cate.length; i++) {

			brdNo[i].innerHTML = Number(brdNo[i].innerHTML) + 1;

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