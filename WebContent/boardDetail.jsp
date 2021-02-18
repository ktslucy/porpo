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
h2.tit {
	font-weight: 800;
	font-size: 30px;
	text-align: center;
	letter-spacing: -.5px;
	line-height: 2;
	padding: 55px 0 30px;
}

.brdDetail-wrap {
	width: 1050px;
	margin: 0 auto;
	overflow: hidden;
	padding-bottom: 20px;
}

.brdDetail {
	width: 1050px;
	border-top: 2px solid #333;
    border-bottom: 1px solid #f4f4f4;
}

.brdDetail-wrap dl {
	overflow: hidden;
	border-top: 1px solid #f4f4f4;
}

.brdDetail-wrap dl.writer {
	float: left;
	width: 49%;
}

.brdDetail-wrap dl.date {
	width: 49%;
}

.brdDetail-wrap dt {
	width: 130px;
	padding: 13px 0 13px 20px;
	background-color: #f7f5f8;
	border-top: 1px solid #f4f4f4;
}

.brdDetail-wrap dt, .brdDetail-wrap dd {
	float: left;
	padding: 13px 0 13px 20px;
}

.contents, .comment{
	height: 200px;
	padding: 20px 20px;
}

.listBtn{
	width: 150px;
    display: inline-block;
    line-height: 40px;
    text-align: center;
    background-color: #795b8f;
    border: 1px solid #5f0080;
    color: #fff;
    font-size: 15px;
    float: right;
    margin-left: 2px;
    font-size: 13px;
    margin-top: 20px;
}

.comment-container {
	border-bottom: 2px solid #333;
	overflow: hidden;
}
</style>
</head>
<body>

	<jsp:include page="header.jsp" />
	<div class="content">
		<div class="brdDetail-wrap">
			<h2 class="tit">문의내역</h2>
			<div class="brdDetail">
				<dl class="tit">
					<dt>제목</dt>
					<dd>${brd.getTitle()}<c:if test="${brd.getCmt() eq 'Y'}"> [답변완료]
							</c:if></dd>
				</dl>
				<dl class="writer">
					<dt>작성자</dt>
					<dd>${brd.getWriter()}</dd>
				</dl>
				<dl class="date">
					<dt>작성일</dt>
					<dd>${brd.getBrdDate()}</dd>
				</dl>
				<div class="contents">${brd.getContents()}</div>
			</div>
			
			<c:if test="${!empty cmt}">
			<div class="comment-container">
				<dl class="writer">
					<dt>답변자</dt>
					<dd>${cmt.getWriter()}</dd>
				</dl>
				<dl class="date">
					<dt>답변일</dt>
					<dd>${cmt.getBrdDate()}</dd>
				</dl>
				<div style="width: 100%; height: 200px;" class="comment">${cmt.getContents()}</div>
			</div>
		</c:if>
			<a href="getBoard.do" class="listBtn">목록보기</a>
		</div>
		
	</div>
	<jsp:include page="footer.jsp" />

</body>
</html>