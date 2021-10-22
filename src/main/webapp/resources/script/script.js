/**
 * 
 */
$(document).ready(function(){
var isCheck = false;
var isChange = false;
	
	 $('#idcheck').click(function(){
		 
		 isChange = false;
		 $.ajax({
				url : "idCheck.member",
				type : "POST",
				data : {
					"userId" : $('input[name="id"]').val()
				},
				success : function(data) {
					if (data == 0
							&& $.trim($('input[name="id"]')
									.val()) != '') {
						alert("사용가능한 아이디 입니다.");
						isCheck = true;
					} else {
						alert("사용불가능한 아이디 입니다.");
						isCheck = false;
					}
				},
				error : function() {
					alert("에러");
				}
			});
		});
	$('#pw1').keyup(function(){
			$('#pwCheckFF').text('');
		}); //keyup
	 $('#repw1').keyup(function(){
			if($('#pw1').val()!=$('#repw1').val()){
				$('#pwCheckFF').text('');
		  		$('#pwCheckFF').html("<font color='red'>비밀번호 확인이 불일치 합니다.</font>");
		  		use = "impossiblepw";
		 	}else{
			  	$('#pwCheckFF').text('');
			  	$('#pwCheckFF').html("<font color='#70AD47'>비밀번호 확인이 일치 합니다.</font>");
			  	use = "possible";
		 	}
		}); //keyup
	
	 $('#sub').click(function(){
			if(isCheck == false || isChange == true){
				alert("중복체크는 필수입니다.");
				return false;
			}
			else if(use=="impossible"){
				alert("이미 사용중인 아이디입니다.");
				return false;
			}
			else if(use=="impossiblepw"){
				alert("비밀번호 확인이 필요합니다.");
				return false;
			}
			
		});//click
});//ready

function execPostCode() {
         new daum.Postcode({
             oncomplete: function(data) {
                // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.
 
                // 도로명 주소의 노출 규칙에 따라 주소를 조합한다.
                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                var fullRoadAddr = data.roadAddress; // 도로명 주소 변수
                var extraRoadAddr = ''; // 도로명 조합형 주소 변수
 
                // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                    extraRoadAddr += data.bname;
                }
                // 건물명이 있고, 공동주택일 경우 추가한다.
                if(data.buildingName !== '' && data.apartment === 'Y'){
                   extraRoadAddr += (extraRoadAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                }
                // 도로명, 지번 조합형 주소가 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                if(extraRoadAddr !== ''){
                    extraRoadAddr = ' (' + extraRoadAddr + ')';
                }
                // 도로명, 지번 주소의 유무에 따라 해당 조합형 주소를 추가한다.
                if(fullRoadAddr !== ''){
                    fullRoadAddr += extraRoadAddr;
                }
 
                // 우편번호와 주소 정보를 해당 필드에 넣는다.
                console.log(data.zonecode);
                console.log(fullRoadAddr);
                
                
                $("[name=addr1]").val(data.zonecode);
                $("[name=addr2]").val(fullRoadAddr);
                
                /* document.getElementById('signUpUserPostNo').value = data.zonecode; //5자리 새우편번호 사용
                document.getElementById('signUpUserCompanyAddress').value = fullRoadAddr;
                document.getElementById('signUpUserCompanyAddressDetail').value = data.jibunAddress; */
            }
         }).open();
     }
