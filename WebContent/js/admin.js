function login(){
	var xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function() {
	    if (this.readyState == 4 && this.status == 200) {	
	    	var content=this.responseText;
	    	var str1 = '<p>';
	    	var loc = content.indexOf(str1);
	    	var len = str1.length;
	    	var check = content.substr(loc+len,1);
	    	if(check==1){
	    		//sessionStorage.setItem('check',check);
	    		window.location.href="adminBoard.do";
	    	}else{
	    		alert("아이디 또는 비밀번호가 틀렸습니다.");
	    		document.getElementById('id').value="";
	    		document.getElementById('passwd').value="";
	    	}
	    }
	};	
	var data="id="+document.getElementById("id").value+"&pw="+document.getElementById("passwd").value;
	
	xhttp.open("post", "adminPro.do", true);
	xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	xhttp.send(data);
}
