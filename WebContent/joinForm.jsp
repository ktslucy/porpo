<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<head>

<style>
.section_join * {
	border-top: 0;
	font-size: 14px;
	vertical-align: top;
	text-align: left;
	font-family: noto sans;
}

.section_join {
	width: 640px;
	margin: 0 auto;
	padding: 90px 0;
	letter-spacing: -.6px;
}

h3.tit_join {
	padding-top: 34px;
	font-weight: 900;
	font-size: 30px;
	color: #333;
	line-height: 40px;
	text-align: center;
	letter-spacing: -.5px;
}

.section_join table {
	width: 100%;
	border-top: 2px solid #333;
	border-bottom: 2px solid #333;
	padding: 20px 0;
}

.section_join table th {
	width: 159px;
	padding: 20px 0 0 20px;
	font-weight: 700;
	font-size: 14px;
	color: #333;
	line-height: 20px;
	vertical-align: top;
	text-align: left;
}

.section_join table td {
	padding: 10px 0;
	border-top: 0;
	font-size: 14px;
	vertical-align: top;
	text-align: left;
	width: 480px;
}

.section_join table input[type=tel], .section_join table input[type=text],
	.section_join table input[type=password], .section_join table input[type=email]
	{
	width: 330px;
}

.section_join input[type=text], .section_join input[type=password], .section_join input[type=submit], .section_join input[type=email],
	.section_join input[type=tel] {
	width: 100%;
	height: 44px;
	padding: 0 19px;
	border: 1px solid #ccc;
	border-radius: 3px;
	background-color: #fff;
	font-size: 14px;
	line-height: 20px;
	outline: none;
	margin: 4px 0;
}

input[type=submit].btn_type1 {
	display: block;
	margin-top: 30px;
	background-color: #5f0080;
	color: #fff;
	width: 240px;
	height: 56px;
	font-size: 16px;
	line-height: 54px;
	text-align: center;
	margin: 40px auto;
}

.btn_type2 {
	height: 44px;
	border-radius: 3px;
	font-weight: 700;
	font-size: 14px;
	line-height: 40px;
	text-align: center;
	outline: none;
	display: inline-block;
	width: 120px;
	margin: 4px 0 0 5px;
	vertical-align: top;
	border: 1px solid #5f0080;
	background-color: #fff;
	color: #5f0080;
}

.ico {
	padding: 23px 0 10px;
	font-size: 12px;
	color: #666;
	line-height: 17px;
	text-align: right;
}

.required::after {
	content: "*";
	color: #ee6a7b;
}

.ico::before {
	content: "*";
	color: #ee6a7b;
	padding-right: 2px;
}
</style>
</head>
<jsp:include page="header.jsp" />
<div class="content">
	<div class="section_join">
		<h3 class="tit_join">회원가입</h3>
		<p class="ico">필수입력사항</p>
		<form action="join.do" method="post">
			<table>
				<tr>
					<th class="required">아이디</th>
					<td><input type="text" id="id" name="id"
						placeholder="아이디를 입력해주세요" required /> <a href=""
						class="btn_type2">중복확인</a></td>
				</tr>
				<tr>
					<th class="required">비밀번호</th>
					<td><input type="password" id="passwd" name="passwd"
						placeholder="비밀번호를 입력해주세요" required /></td>
				</tr>
				<tr>
					<th class="required">이름</th>
					<td><input type="text" id="name" name="name"
						placeholder="이름을 입력해주세요" required /></td>
				</tr>
				<tr>
					<th class="required">이메일</th>
					<td><input type="email" id="email" name="email"
						placeholder="예 : marketkurly@kurly.com" required /> <a href=""
						class="btn_type2">중복확인</a></td>
				</tr>
				<tr>
					<th class="required">휴대폰</th>
					<td><input type="tel" id="phone" name="phone"
						placeholder="예 : 010-1234-5678"
						pattern="[0-9]{3}-[0-9]{4}-[0-9]{4}" required /></td>
				</tr>
				<tr>
					<th class="required">주소</th>
					<td><input type="text" id="address" name="address"
						placeholder="주소를 입력해주세요" required /></td>
				</tr>
			</table>
			<div>
				<input type="submit" id="join" value="가입하기" class="btn_type1">
			</div>
		</form>
	</div>
</div>
<jsp:include page="footer.jsp" />

