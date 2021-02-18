
let plusBtn = document.getElementsByClassName("plus");
let minusBtn = document.getElementsByClassName("minus");
let chkItem = document.querySelectorAll('input[name=chkItem]');
let inputCnt = document.querySelectorAll('input[name=cnt]');
let checkIco = document.querySelectorAll('.ico');
let allCheck=document.querySelector('input[name=allCheck]');


for (let i = 0; i < checkIco.length; i++) {
	checkIco[i].addEventListener("click", check); 
}

for (let i = 0; i < plusBtn.length; i++) {
	plusBtn[i].addEventListener("click", changeCnt);
}

for (let i = 0; i < minusBtn.length; i++) {
	minusBtn[i].addEventListener("click", changeCnt);
}

document.getElementById("order").addEventListener("click", logCheck);

function logCheck(){
	var xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function() {
	    if (this.readyState == 4 && this.status == 200) {	
	    	let logCheck=this.responseText;
	    	logCheck=logCheck.replace(/\r\n/g, '');
	    	if(logCheck=='-1'){
	    		alert('로그인 후에 구매가 가능합니다.');
	    	}
	    	else if(logCheck=='0'){
	    		order();
	    	}
	    }
	};	
	
	xhttp.open("post", "logCheck.do", true);
	xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	xhttp.send();
	
}

function order(){

	let dataArr=new Array();
	for(let i=0; i<chkItem.length; i++){
		if(chkItem[i].checked == true){
			var data = {
					  itemNumber: chkItem[i].dataset.item,
					  cartCnt: inputCnt[i].value
					};
			dataArr.push(data);
		}
	}
	let dataStr=JSON.stringify(dataArr)
	
	let form = document.createElement("form");
	form.setAttribute("method", "post");
	form.setAttribute("action", "order.do");

	let hiddenField = document.createElement("input");
	hiddenField.setAttribute("type", "hidden");
	hiddenField.setAttribute("name", "cartList");
	hiddenField.setAttribute("value", dataStr);
	form.appendChild(hiddenField);

	document.body.appendChild(form);
	form.submit();
}

function check(evt){
	let clck=evt.target;
	let clckPrev=clck.previousElementSibling;
	
	switch (clckPrev.id) {
	case 'allCheck': 
		if(clckPrev.checked == true){
			clckPrev.checked = false;
		
			for(let i=0; i<chkItem.length; i++){
				chkItem[i].checked = false;
				chkItem[i].nextElementSibling.style.backgroundImage = "url('image/ico_checkbox.svg')";
				allCheck.nextElementSibling.style.backgroundImage = "url('image/ico_checkbox.svg')";
			}
		}else if(clckPrev.checked == false){
			clckPrev.checked = true;
		
			for(let i=0; i<chkItem.length; i++){
				chkItem[i].checked = true;
				chkItem[i].nextElementSibling.style.backgroundImage = "url('image/ico_checkbox_checked.svg')";
				allCheck.nextElementSibling.style.backgroundImage = "url('image/ico_checkbox_checked.svg')";
			}
		}
	case 'chkItem': 
		
		if(clckPrev.checked==true){
			console.log(clckPrev.checked);
			clckPrev.checked=false;
			clckPrev.nextElementSibling.style.backgroundImage = "url('image/ico_checkbox.svg')";
		}else{
			console.log(clckPrev.checked);
			clckPrev.checked=true;
			clckPrev.nextElementSibling.style.backgroundImage = "url('image/ico_checkbox_checked.svg')";
		}
			
		let check=0;
		for(let i=0; i<chkItem.length; i++){
			if(chkItem[i].checked == true){
				check+=1;
			}
		}
		if(check==chkItem.length){
			allCheck.checked=true;
			allCheck.nextElementSibling.style.backgroundImage = "url('image/ico_checkbox_checked.svg')";
		}else{
			allCheck.checked=false;
			allCheck.nextElementSibling.style.backgroundImage = "url('image/ico_checkbox.svg')";
			
		}
	}
	show();
}

function changeCnt(evt) {
	let idx = -1;
	for (let i = 0; i < chkItem.length; i++) {
		if (evt.target.dataset.item === chkItem[i].dataset.item) {
			idx = i;
			break;
		}
	}
	if (idx == -1)
		return;

	switch (event.target.className) {
	case 'plus':
		inputCnt[idx].value=Number(inputCnt[idx].value)+1;
		break;
	case 'minus':
		let cnt=Number(inputCnt[idx].value)-1;
		if(cnt<1) break;
		inputCnt[idx].value=cnt;
		break;
	}
	 show();
}

function show(){
	let sum=0;
	let final=0;
	let delivery=3000;
	let price = 1000;
	let total = document.querySelectorAll('.totalPrice');
	if(allCheck.checked==true){
	}
	
	for (let i = 0; i < chkItem.length; i++) {
		total[i].innerHTML=(Number(inputCnt[i].value)*price).toLocaleString(); 
																				
		if(chkItem[i].checked == true){
			sum+=Number(inputCnt[i].value)*price;
		}
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
	document.getElementsByClassName("delivery")[0].innerHTML='+ '+delivery.toLocaleString(); 
	final=sum+delivery;
	document.getElementsByClassName('final')[0].innerHTML=final.toLocaleString();
}

show();


let tableHeight=document.getElementsByClassName('orderList')[0].offsetHeight;
let payHeight=document.getElementsByClassName('right')[0].offsetHeight;
let height=tableHeight-payHeight;

window.onscroll = function() {scrollFunction(document.body.scrollTop)};
function scrollFunction(pos) {
		pos+=1;
		if(pos<height){
		document.getElementsByClassName('right')[0].style.top = pos;
	}
}

