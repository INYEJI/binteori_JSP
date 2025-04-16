function login(){
	if(document.frm.id.value==""){
		alert("아이디 입력 요망!");
		document.frm.id.focus();
		return false;
	}else if(document.frm.pwd.value==""){
		alert("비빌 번호 입력 요망!");
		document.frm.pwd.focus();
		return false;
	}else {
		return true;
	}		
}