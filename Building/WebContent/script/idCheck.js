function idCheck() {
	  if (document.frm.managerid.value == "") {
	    alert("아이디를 입력하여 주십시오.");
	    document.frm.managerid.focus();
	    return;
	  }
	 
	  var url = "idCheck.do?id=" + encodeURI(document.frm.managerid.value);
	 
	  window.open(url, "_black_1",
	"toolbar=no, menubar=no, scrollbars=yes, resizable=no, width=450, height=200");
	 
	}

	function idok() {
	  opener.frm.managerid.value=document.frm.managerid.value;
	  opener.frm.reid.value=document.frm.managerid.value;
	  self.close();
	}
