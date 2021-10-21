<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <script type="text/javascript">
    if(${cnt} > 0){
    alert("이용권 결제가 완료되었습니다.");
    }else{
    	alert("이용권 결제에 실패했습니다");
    }
    opener.document.location.href="main.wa";
		self.close();
	</script>