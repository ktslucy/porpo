
var httpRequest;
httpRequest = new XMLHttpRequest();
httpRequest.onreadystatechange = getCategory;
httpRequest.open('GET', 'menu.do', true);
httpRequest.send();
function getCategory() {
	if (httpRequest.readyState === XMLHttpRequest.DONE
			&& httpRequest.status === 200) {

		var data = this.responseText;
		var arr = JSON.parse(data);
		console.log(data);

		for (let i = 0; i < arr.length; i++) {
			var li = document.createElement('li');
			li.innerHTML = '<a></a><img class="ico_off"/><img class="ico_on"/>';
			document.getElementById('category').append(li);
			document.querySelectorAll("#category li a")[i].setAttribute("href",
					"category.do?category=" + arr[i].menuNum);
			document.querySelectorAll("#category li a")[i].innerHTML = arr[i].menuName;
			document.querySelectorAll("#category li img.ico_off")[i]
					.setAttribute("src", "image/" + arr[i].ico_off);
			document.querySelectorAll("#category li img.ico_on")[i]
					.setAttribute("src", "image/" + arr[i].ico_on);
		}
	}
}

// header.jsp
document.querySelector("#menu, #category").addEventListener("mouseenter", function(evt) {
	document.getElementById("category").style.display="block";
});

document.querySelector("#category, #menu").addEventListener("mouseleave", function(evt) {
	document.getElementById("category").style.display="none";
});

// 오류날떄 노드 구조 살피기
const subCate = document.querySelector("#category");
subCate.addEventListener("mouseover", function(evt) {
	let li = evt.target.parentNode;
	li.classList.add("over");
	li.querySelector("a").style.color = "#5f0080";
	li.querySelector(".ico_off").style.display = "none";
	li.querySelector(".ico_on").style.display = "block";
});

subCate.addEventListener("mouseout", function(evt) {
	let li = evt.target.parentNode;
	li.classList.remove("over");
	li.querySelector("a").style.color = "#333";
	li.querySelector(".ico_off").style.display = "block";
	li.querySelector(".ico_on").style.display = "none";
});
