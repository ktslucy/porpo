/**
 * 
 */
let sum=0;
let final=0;
let delivery=3000;
let price = 1000;
let total = document.querySelectorAll('.totalPrice');
let cnt = document.querySelectorAll('.cnt');

function show(){
	for (let i = 0; i < total.length; i++) {
		let cost=Number(cnt[i].innerHTML)*price;
		total[i].innerHTML=cost.toLocaleString(); 
		sum+=cost;
	}
	
	document.getElementsByClassName("freeShipping")[0].style.display='block';
	document.getElementsByClassName("freeShipping")[0].style.clear='both';
	document.getElementsByClassName("freeShipping")[0].style.padding='4px 0 0 0';
	document.getElementsByClassName("freeShipping")[0].style.color='#5f0080';
	document.getElementsByClassName("freeShipping")[0].style.float='right';
	document.getElementsByClassName('sum')[0].innerHTML=sum.toLocaleString();
	if(sum>=10000 || sum==0){ 
		delivery=0; 
		if(sum>=10000){
			document.getElementsByClassName("freeShipping")[0].style.display='none';
		}
	}
	document.getElementsByClassName("delivery")[0].innerHTML='+'+delivery.toLocaleString(); 
	final=sum+delivery;
	document.getElementsByClassName('final')[0].innerHTML=final.toLocaleString();
}

document.getElementById("pay").addEventListener("click", pay);

function pay(){
	
	/*
	 * 1. 주문번호(자동설정) > 결제금액 > 배송완료 보낼 거 2. 상품번호 3. 수량 4. 보내는 분 5. 휴대폰 6. 이메일 7.
	 * 배송지 8. 상세정보(현관 앞) 9. id
	 */
	
	let dt=new Date();
	var date = dt.getFullYear()+'-'+(dt.getMonth()+1)+'-'+dt.getDate();
	console.log(date);
	
	let orderItems= document.getElementsByClassName("item");
	let ItemsCnt = document.getElementsByClassName("cnt");
	
	let orderer = document.getElementById("orderer").value;
	let phone = document.getElementById("phone").value;

	let email = document.getElementById("email").value;
	let address = document.getElementById("address").value;
	let finalArrival = document.getElementById("finalArrival").value;
	
	let orderList=new Array();
	for(let i=0; i<orderItems.length; i++){
		let item =	{
			itemNumber : orderItems[i].dataset.item,
			cartCnt : ItemsCnt[i].innerHTML
		
		}
		orderList.push(item);
	}
	
	let stringify=JSON.stringify(orderList);
	
	let data="orderList="+stringify+"&shippingFee="+delivery+"&orderer="+orderer+"&phone="+phone+"&email="+email+"&address="+address+"&finalArrival="+finalArrival+"&date="+date;
	let xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function() {
	    if (this.readyState == 4 && this.status == 200) {	
	    	let payCheck=this.responseText;
	    	payCheck=payCheck.replace(/\r\n/g, '');
	    	console.log(payCheck);
	    	if(payCheck==='-1'){
	    		alert('결제 실패ㅠㅠ 문의주세요');
	    	}
	    	else if(payCheck==='1'){
	    		let cartList = localStorage.getItem("cartList");
	    		let cartCnt = localStorage.getItem("cartCnt");
	    		let cartListArr = JSON.parse(cartList);
	    		
	    		for ( let i in orderList) {
	    			let idx = -1;
	    			for(let j in cartListArr){
		    			if (cartListArr[j].itemNumber == orderList[i].itemNumber) { 
		    				idx = j; // index
		    			}
	    			}
	    			if(idx!=-1){
	    					cartListArr.splice(idx, 1);
	    					cartCnt=Number(cartCnt)-1;
	    			}
	    		}
	    		cartListArr=JSON.stringify(cartListArr);
	    		localStorage.setItem("cartList",cartListArr);
	    		localStorage.setItem("cartCnt",cartCnt);
	    		alert("결제 성공! 1:1문의 게시글을 남겨보아요");
	    		window.location.href="main.do";
	    	}
	    }
	   }
	
	
	
	xhttp.open("post", "pay.do", true);
	xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	xhttp.send(data);
	
}





let tableHeight=document.getElementsByClassName('left')[0].offsetHeight;
let payHeight=document.getElementsByClassName('right')[0].offsetHeight;
let height=tableHeight-payHeight-100;

window.onscroll = function() {
	scrollFunction(document.body.scrollTop)
};
function scrollFunction(pos) {
	console.log(pos);
		pos+=1;
		if(pos<height){
		document.getElementsByClassName('right')[0].style.top = pos;
	}
}
show();

