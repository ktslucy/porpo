<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/common.css" />
<link rel="preconnect" href="https://fonts.gstatic.com">
<link
	href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR&display=swap"
	rel="stylesheet">
<meta charset="UTF-8">
<title>Insert title here</title>

<style>

form{
	width: 880px;
	margin: 0 auto;
}
h2.tit {
	font-weight: 800;
	font-size: 30px;
	text-align: center;
	letter-spacing: -.5px;
	line-height: 2;
	padding: 55px 0 30px;
}

div.boardWrite-wrap {
	width: 1050px;
	margin: 0 auto;
	overflow:hidden;
}

div.boardWrite-wrap span {
	display: block;
}

table.boardWrite {
	width: 880px;
	font-size: 12px;
	table-layout: fixed;
	border-top: 2px solid #333;
	line-height: 180%;
}

table.boardWrite th {
	width: 110px;
	padding: 15px 0 15px 20px;
	background-color: #f7f5f8;
	border-bottom: 1px solid #f4f4f4;
	text-align: left;
	font-weight: 400;
	vertical-align: middle;
}

table.boardWrite td {
	width: auto;
	padding: 15px 0 15px 10px;
	height: 23px;
	border-top: 1px solid #f4f4f4;
	border-bottom: 1px solid #f4f4f4;
	vertical-align: middle;
	line-height: 20px;
}

table.boardWrite input[type=text], table.boardWrite textarea, table.boardWrite select
	{
	height: 30px;
	line-height: 25px;
	border: 1px solid #d9d9d9;
	color: #202020;
	padding-left: 4px;
}

table.boardWrite select {
	margin-bottom: 6px;
}

#qnaNotice {
	padding-bottom: 20px;
	font: 12px;
	color: #4c4c4c;
}

#qnaNotice .tit {
	display: block;
	padding: 4px 0 10px;
	font-size: 12px;
	line-height: 20px;
	font-family: noto sans;
	font-weight: 700;
}

#qnaNotice .list {
	padding-top: 10px;
}

#qnaNotice .list dt {
	padding-bottom: 6px;
	font-weight: 700;
	font-size: 12px;
}

#qnaNotice .list span {
	display: block;
	position: relative;
	padding-left: 9px;
	line-height: 1.5;
}

#qnaNotice .list .info {
	color: #5f0080;
	padding-top: 4px;
}

#inquiryBtn {
	width: 150px;
	display: inline-block;
	line-height: 40px;
	text-align: center;
	background-color: #795b8f;
	border: 1px solid #5f0080;
	color: #fff;
	font-size: 15px;
	float: right;
	font-size: 13px;
	margin-top: 10px;

}
</style>
</head>
<body>

	<jsp:include page="header.jsp" />
	<div class="content">
		<div class="boardWrite-wrap">
			<h2 class="tit">문의하기</h2>

			<form action="setBoard.do" method="post">
				<table id="table_after" class="boardWrite">
					<tbody>
						<tr>
							<th class="input_txt">제목</th>
							<td><select name="select" required class="select"
								id="select">
									<option value="">선택해주세요.</option>
									<option value="01">배송지연/불만</option>
									<option value="02">컬리패스 (무료배송)</option>
									<option value="03">반품문의</option>
									<option value="04">A/S문의</option>
							</select><br> <input type="text" name="subject" style="width: 100%"
								required value=""></td>
						</tr>
						<tr>
							<th class="input_txt">주문번호</th>
							<td><input type="text" name="ordno" style="width: 25%"
								value="${orderNo}" readonly></td>
						</tr>
						<tr>
							<th class="input_txt">이메일</th>
							<td><input type="text" name="email"
								value="${userInfo.getEmail()}" size="26" readonly
								class="read_only"></td>
						</tr>
						<tr>
							<th class="input_txt">문자메시지</th>
							<td><input type="text" name="mobile"
								value="${userInfo.getPhone()}" readonly class="read_only"></td>
						</tr>
						<tr>
							<th class="input_txt">내용</th>
							<td class="edit_area" style="position: relative;">


								<div id="qnaNotice">
									<div class="inner_qnaNotice">
										<div class="notice_qna">
											<strong class="tit qna_public">1:1 문의 작성 전 확인해주세요!</strong>
											<dl class="list qna_public">
												<dd>현재 문의량이 많아 답변이 지연되고 있습니다. 문의 남겨 주시면 2일 이내 순차적으로 답변
													드리겠습니다.</dd>
											</dl>

											<dl class="list qna_public">
												<dt>반품 /환불</dt>
												<dd>
													<span>- 제품 하자 혹은 이상으로 반품 (환불)이 필요한 경우 사진과 함께 구체적인
														내용을 남겨주세요.</span>
												</dd>
											</dl>

											<dl class="list" id="branchByVersion15">
												<dt>주문취소</dt>
												<dd class="old" style="display: none">
													<!-- 구버전 분기처리 -->
													<span>샛별 지역 : 배송일 전날 19시까지 <br>택배 지역 : 배송일 전날
														18시까지 <br> 고객행복센터(1644-1107)/ 1:1문의 게시판/ 카카오톡(마켓컬리)
														으로 취소 요청 바랍니다.
													</span> <span>생산이 시작된 이후에는 취소가 불가능 한 점 고객님의 양해 부탁드립니다.</span> <span>일부
														예약상품은 배송 3~4일 전에만 취소 가능합니다.</span> <span>주문상품의 부분 취소는
														불가능합니다. 전체 주문 취소 후 재구매 해주세요.</span> <span>비회원 주문건의 경우
														1:1문의 게시판 접수가 불가하기에 고객행복센터(1644-1107), 카카오톡(마켓컬리) 로 취소 요청
														부탁드립니다.</span>
												</dd>
												<dd class="new">
													<span> - 배송 단계별로 주문취소 방법이 상이합니다. <br> [입금확인] 단계
														: [마이컬리 &gt; 주문내역 상세페이지] 에서 직접 취소 가능 <br> [입금확인] 이후
														단계 : 고객행복센터로 문의
													</span> <br> <span>- 생산이 시작된 [상품 준비중] 이후에는 취소가 제한되는 점
														고객님의 양해 부탁드립니다.</span> <span>- 비회원은 모바일 App 또는 모바일 웹사이트에서
														[마이컬리 &gt; 비회원 주문 조회 페이지] 에서 취소가 가능합니다.</span> <span>- 일부
														예약상품은 배송 3~4일 전에만 취소 가능합니다.</span> <span>- 주문상품의 부분 취소는
														불가능합니다. 전체 주문 취소 후 재구매 해주세요.</span>
												</dd>
											</dl>

											<dl class="list">
												<dt>배송</dt>
												<dd>
													<span>- 주문 완료 후 배송 방법(샛별 / 택배)은 변경이 불가능합니다.</span> <span>-
														배송일 및 배송시간 지정은 불가능합니다. (예약배송 포함)</span>
													<p class="info">※ 전화번호, 이메일, 주소, 계좌번호 등의 상세 개인정보가 문의
														내용에 저장되지 않도록 주의해 주시기 바랍니다.</p>
												</dd>
											</dl>
										</div>
									</div>
								</div> <textarea name="contents" style="width: 100%; height: 300px;"
									class="editing_area" required></textarea>
							</td>
						</tr>

					</tbody>
				
				</table>
					<input type="submit" id="inquiryBtn" value="문의하기" />
			</form>
		</div>
	</div>

	<jsp:include page="footer.jsp" />

</body>
</html>