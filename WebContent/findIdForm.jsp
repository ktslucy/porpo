<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<head>
<style>
.section_findId {
	width: 340px;
	margin: 0 auto;
	padding: 90px 0;
	letter-spacing: -.6px;
}

h3.tit_findId {
	font-weight: 800;
	font-size: 20px;
	line-height: 20px;
	text-align: center;
	margin-bottom: 32px;
}

label {
	display: block;
	padding: 11px 0 7px;
	font-size: 12px;
	line-height: 18px;
	text-align: left;
	font-weight: 600;
}

input[type=text], input[type=email], input[type=button] {
	width: 100%;
	height: 54px;
	padding: 0 19px;
	border: 1px solid #ccc;
	border-radius: 3px;
	background-color: #fff;
	font-size: 14px;
	line-height: 20px;
	outline: none;
	margin: 4px 0;

}

input[type=button].btn_type1 {
	margin-top: 30px;
	background-color: #5f0080;
	color: #fff;
	cursor: pointer;
}
</style>
</head>

<jsp:include page="header.jsp" />
<div class="content">
	<div class="section_findId">
		<h3 class="tit_findId">아이디 찾기</h3>
		<form>
			<label for="name">이름</label> <input type="text" id="name" name="name"
				placeholder="고객님의 이름을 입력해주세요" required /><br> <label
				for="email">이메일</label> <input type="email" id="email" name="email"
				placeholder="가입 시 등록하신 이메일 주소를 입력해주세요" required /><br> <input
				type="button" onclick="findId();" value="확인" class="btn_type1"><br>

		</form>
	</div>
</div>
<jsp:include page="footer.jsp" />
<script>
	function findId() {
		var xhttp = new XMLHttpRequest();
		xhttp.onreadystatechange = function() {
			if (this.readyState == 4 && this.status == 200) {
				var id = this.responseText;
			
				id=id.replace(/\r\n/g, '');

				if (id == '-1') {
					alert("아이디 또는 비밀번호가 틀렸습니다.");
					document.getElementById('id').value = "";
					document.getElementById('email').value = "";
					return;
				}
				alert('id는' + id + "입니다.");
				window.location.href = "main.do";
			}
		};
		var data = "name=" + document.getElementById("name").value + "&email="
				+ document.getElementById("email").value;

		xhttp.open("post", "findId.do", true);
		xhttp.setRequestHeader("Content-type",
				"application/x-www-form-urlencoded");
		xhttp.send(data);
	}
</script>
<script defer src="js/log.js"></script>
