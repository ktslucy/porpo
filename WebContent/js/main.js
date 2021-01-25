


//공통
//0) container의 width
//1) li height 값 -> wrap, conatiner에 height 값 설정
//2) padding = 1050px/4-li.offsetWidth;
//3) li 정렬 = style.ㅣeft = i*(li.offsetWidth+padding)
//4) 왼쪽 버튼 : left =0  오른쪽 버튼 = 1050+padding;
let mdWrap = document.getElementsByClassName('md-pdt-wrap')[0];
let mdContainer = document.getElementsByClassName('md-pdt-container')[0];
let mdPdts = document.getElementsByClassName('md-pdt');
let maxHeight = 0;
let maxWidth = 0;

// li.md-pdt의 maxHeight 구해서 wrap/container에 높이 지정
for(let i=0; i<mdPdts.length; i++){
	if(maxWidth<mdPdts[i].offsetWidth){
		maxWidth=mdPdts[i].offsetWidth;
	}
	if(maxHeight<mdPdts[i].offsetHeight){
		maxHeight=mdPdts[i].offsetHeight;
	}
}

mdContainer.style.height=maxHeight+'px';
mdWrap.style.height=maxHeight+'px';

//li.md-pdt 간격, padding-right: 20px;
let padding=Math.floor(1050/4)-maxWidth;

//li.md-pdt의 width+padding -> li 일렬로 배열
for(let i=0; i<mdPdts.length; i++){
	mdPdts[i].style.left=i*(maxWidth+padding)+'px';
}

//좌우버튼 누르면 li 4개씩 이동
let leftBtn = document.getElementsByClassName('left-btn')[0];
let rightBtn = document.getElementsByClassName('right-btn')[0];

leftBtn.addEventListener("click", function() {
	mdContainer.style.left = 10+'px';
	leftBtn.style.display = 'none';
	rightBtn.style.display = 'block';

});

rightBtn.addEventListener("click", function() {
	mdContainer.style.left = -1050 + padding+'px';
	rightBtn.style.display = 'none';
	leftBtn.style.display = 'block';


});

//MD추천 좌우버튼 위치
let mdHeight = document.getElementsByClassName('recmd_md')[0].offsetHeight;
let btnPos=Math.floor((mdHeight-maxHeight)+maxHeight/2)-60;
leftBtn.style.top=btnPos+'px';
rightBtn.style.top=btnPos+'px';


//얼리버트 타이머
let counter=0;
let timeleft=30; // time + 1초

function timer(){
 	counter+=1;
    document.getElementsByClassName("timer-txt")[0].innerHTML = covertSeconds(timeleft-counter);
}

function covertSeconds(s) {

  var secd=s%60;
  var min=Math.floor((s/60))%60;
  var hour= Math.floor((s/60)/60);
  
  if(hour==0&&min==0&&secd==0){
  	  clearInterval(timeIt);  
	  document.getElementsByClassName("timer")[0].style.display="none";
	  document.getElementsByClassName("soldout")[0].style.display="block"; 
  	  return "";
  } 
	return hour+" : "+min+" : "+secd+" ";
}

var timeIt=setInterval(timer, 1000);

//md추천 탭 누르면 해당 카테고리 상품 8개 가져오기
document.getElementsByClassName("menuLink")[0].classList.add("active","click"); //첫번째 탭 보라색 색
const ul = document.querySelector(".md-cate");

ul.addEventListener("click",function(evt) {	
	let cateNum = evt.target.dataset.no;
	let clsName=evt.target.getAttribute('class');
	if(clsName === 'menuLink active click') return;
	
	let check=ul.getElementsByClassName("menuLink active click");
	for(let i=0; i<check.length; i++){
		check.item(i).classList.remove("active","click");
	}
	evt.target.classList.add("active","click");
	
	mdCate(cateNum);
	
});

ul.addEventListener("mouseover", function(evt) {
	let clsName=evt.target.getAttribute('class');
	if(clsName === 'menuLink active click') return;
	evt.target.classList.add("active");
});

ul.addEventListener("mouseout", function(evt) {
	let clsName=evt.target.getAttribute('class');
	if(clsName === 'menuLink active click') return;
	evt.target.classList.remove("active");
});

function mdCate(cateNum){
	var httpRequest;
	httpRequest = new XMLHttpRequest();
	httpRequest.onreadystatechange = getCategory;
	httpRequest.open('GET', 'mdCate.do?category='+cateNum, true);
	httpRequest.send();
	function getCategory() {
		if (httpRequest.readyState === XMLHttpRequest.DONE
				&& httpRequest.status === 200) {

			var data = this.responseText;
			var arr = JSON.parse(data);
			console.log(arr);
			for (var i in arr) {
				document.getElementsByClassName("link-img")[i].setAttribute('href','itemDetail.do?pdtNumber='+arr[i].itemNumber);
				document.getElementsByClassName("link-img")[i].style.backgroundImage= "url('"+ 'image/item/'+arr[i].filename + "')";
				document.getElementsByClassName("pdtName")[i].setAttribute('href','itemDetail.do?pdtNumber='+arr[i].itemNumber);
				document.getElementsByClassName("pdtName")[i].innerHTML=arr[i].itemName;
				document.getElementsByClassName("price")[i].innerHTML=arr[i].originPrice;
				document.getElementsByClassName("dc-price")[i].innerHTML=arr[i].dcPrice;
			}
		}
	}
}


