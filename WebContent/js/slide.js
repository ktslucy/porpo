
let slideWrap = document.getElementsByClassName('slider-wrap');
	slideContainer=document.getElementsByClassName('slider-container');
	slides=document.getElementsByClassName('slide'),
	slideCnt = slides.length;
	currentSlide = 0;
	maxSlideHeight = 0;

for (let i = 0; i < slideCnt; i++) {
	if (slides[i].offsetHeight > maxSlideHeight) {
			maxSlideHeight = slides[i].offsetHeight;
		}
	}

slideWrap[0].style.height = maxSlideHeight + 'px';
slideContainer[0].style.height = maxSlideHeight + 'px';
	
for(let i=0; i<slideCnt; i++){
	slides[i].style.left=i*100+'%';
}

let autoSlide=setInterval(function(){ 
	let nextIdx=(currentSlide+1)%slideCnt; 
	console.log(currentSlide);
	moveSlide(nextIdx);
}, 3000);

function moveSlide(slideIdx) {
	slideContainer[0].classList.add('animated');
	slideContainer[0].style.left = slideIdx * -100 + '%';
	currentSlide = slideIdx;
	//btnDisplay();
}

moveSlide(0);
autoSlide;