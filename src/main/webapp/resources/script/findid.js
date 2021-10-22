/**
 * 
 */
$(document).ready(function(){
		$('#form-input').append('<input type="text" class="form-control mt-4" name="name" placeholder="이름">');
		$('#form-input').append('<input type="text" class="form-control mt-4" name="tel" placeholder="전화번호">');
		
	$('input[name="findIdWay"]').click(function(){
		var way = $('input[name="findIdWay"]:checked').val();
	if(way == 'tel'){
		$('#form-input').empty();
		$('#form-input').append('<input type="text" class="form-control mt-4" name="name" placeholder="이름">');
		$('#form-input').append('<input type="text" class="form-control mt-4" name="tel" placeholder="전화번호">');
	}else{
		$('#form-input').empty();
		$('#form-input').append('<input type="text" class="form-control mt-4" name="name" placeholder="이름">');
		$('#form-input').append('<input type="text" class="form-control mt-4" name="email" placeholder="이메일">');
	}
	});
});