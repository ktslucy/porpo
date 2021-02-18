
showCartCnt();

// 장바구니 개수 표시
function showCartCnt() {
	let cartCnt = localStorage.getItem('cartCnt'); // cartList가 없으면
	if (cartCnt == 'null' || cartCnt == null || cartCnt == '0') {
		return;
	}
	document.getElementsByClassName("btn-cartCnt")[0].style.display = 'block';
	document.getElementsByClassName("btn-cartCnt")[0].innerHTML = cartCnt;
}

// 장바구니 추가
function addToCart(itemNum, newCnt) {
	// localStorage.removeItem("cartList");
	let cartList = localStorage.getItem("cartList");
	console.log(cartList);
	let cartCnt = localStorage.getItem("cartCnt");
	
	//아예 localSession에 key 이름조차 없을 때, 또는 장바구니 삭제해서 0이 될 때 null로 만들어버림
	if (cartList == 'null' || cartList == null || cartList == "") {
		let cartListArr = new Array();
		var addCart = {
			'itemNumber' : itemNum,
			'cartCnt' : newCnt+""
		}
		cartListArr.push(addCart);
		var toJSON = JSON.stringify(cartListArr);
		localStorage.setItem("cartList", toJSON);
		localStorage.setItem("cartCnt", 1+""); //문자로 저장
		showCartCnt();
		return;
	}

	let cartListArr = JSON.parse(cartList); // string -> 배열
	let exist = false; // 같은 제품이 이미 장바구니에 존재하는지 확인하기 위한 변수
	//같은 상품 있을 때
	for ( let i in cartListArr) {
		if (cartListArr[i].itemNumber == itemNum) { // 같은 상품이 있다면
			exist = true; // true로 변경
			let originCnt = parseInt(cartListArr[i].cartCnt); // 수량 : 문자->숫자
			cartListArr[i].cartCnt = originCnt + parseInt(newCnt) + ""; // 문자로 저장, 구매수량 추가
		}
	}
	//중복 상품 없을 때
	if (exist === false) { // 장바구니에 중복 상품이 없다면
		let cnt = parseInt(localStorage.getItem("cartCnt"));
		var addCart = { // 객체생성
			'itemNumber' : itemNum,
			'cartCnt' : newCnt+""
		}
		cartListArr.push(addCart); // 배열에 추가
		localStorage.setItem("cartCnt", cnt+1+""); //문자로 저장
		showCartCnt();
	}
	var toJSON = JSON.stringify(cartListArr); // 배열->문자
	localStorage.setItem("cartList", toJSON); // localstorage에 추가
}

document.getElementsByClassName("btn-cart")[0].addEventListener('click',function(){
	
			let cartList = localStorage.getItem('cartList');
			if(cartList==null) {
				cartList="";
			}
			let form = document.createElement("form");
			form.setAttribute("method", "post");
			form.setAttribute("action", "cart.do");

			let hiddenField = document.createElement("input");
			hiddenField.setAttribute("type", "hidden");
			hiddenField.setAttribute("name", "cartList");
			hiddenField.setAttribute("value", cartList);
			form.appendChild(hiddenField);

			document.body.appendChild(form);
			form.submit();
});



