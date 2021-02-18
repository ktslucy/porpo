/**
 * 
 */

let price = 1000;
document.getElementsByClassName('cnt')[0].value = 1;
document.getElementsByClassName('dc-price')[0].innerHTML = price.toLocaleString();

//상품페이지 장바구니 담기 버튼
document.getElementsByClassName('cart')[0].addEventListener("click", function() {
	let itemNum  = document.getElementsByClassName('intoCart')[0].innerHTML;
	let newCnt = document.getElementsByClassName('cnt')[0].value;
	addToCart(itemNum,newCnt);
});

function change(q){
	let cnt=Number(document.getElementsByClassName('cnt')[0].value)+q;
	if(cnt+q <= 1) cnt=1;
	document.getElementsByClassName('cnt')[0].value=cnt;
	document.getElementsByClassName('dc-price')[0].innerHTML=(cnt*price).toLocaleString();
}



