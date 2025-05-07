function productCheck() {
   if (document.frm.name.value.length == 0) {
      alert("상품명을 써주세요.");
      frm.name.focus();
      return false;
   }
   if (document.frm.price.value.length == 0) {
      alert("가격을 써주세요");
      frm.price.focus();
      return false;
   }
   if (isNaN(document.frm.price.value)) {
      alert("숫자를 입력해야 합니다");
      frm.price.focus();
      return false;
   }
   return true;
}

function confirmDelete() {
		const confirmed = confirm("정말 삭제하시겠습니까?");
		if (confirmed) {
			document.getElementById("deleteForm").submit(); // 폼 전송
		} else {
			alert("삭제가 취소되었습니다.");
		}
	}