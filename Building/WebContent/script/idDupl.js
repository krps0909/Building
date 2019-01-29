function loginCheck() {
	if (document.frm.managerid.value.length ==0) {
		alert("아이디를 써주세요");
		frm.managerid.focus();
		return false;
		}
	if (document.frm.password.value=="") {
			alert("암호는 반드시 입력해야 합니다.");
			frm.password.focus();
			return false;
	}
	return true;
}

function idCheck() {
	    alert("ㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇ");
	  if (document.frm.managerid.value == "") {
	    alert("아이디를 입력하여 주십시오. ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
	    document.frm.managerid.focus();
	    return;
	  }
	  alert("aaaaaaaaaaaaaaaaaaa");
	  var url = "idCheck.do?id=" + encodeURI(document.frm.managerid.value);
	  alert("bbbbbbbbbbbbbbbbbbb");
	  window.open(url, "_black_1",
	"toolbar=no, menubar=no, scrollbars=yes, resizable=no, width=450, height=200");
	  alert("cccccccccccccccccccc");
	}

	function idok() {
	  opener.frm.managerid.value=document.frm.managerid.value;
	  opener.frm.reid.value=document.frm.managerid.value;
	  self.close();
	}
