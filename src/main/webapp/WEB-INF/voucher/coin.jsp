<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
coin.jsp<br><br>
<script type="text/javascript">
function register(cp_number){
	location.href="coupon.voucher?cp_number="+cp_number;
}
</script>
	<table style="text-align:center">
		<tr>
			<td>
				쿠폰등록 <br>
				<img src="resources/images/coupon.png"  > <br>
				쿠폰번호에 숫자 0,1은 없습니다. <br>
				영문자 O,I와 혼동하지 않도록 유의해주세요. <br>

				<input type="text" name="cp_number" >
				<input type="button" value="등록하기" onclick="register(cp_number.value)">

				 <br><br>
				쿠폰으로 지급되는 상품은 기존 보유 상품과 중복되어 적용되므로 가급적 <br>
				이용중인 상품이 만료 된 뒤에 쿠폰을 사용해 주세요. <br>

				유효기간이 지난 쿠폰은 등록하실 수 없습니다. <br>

				등록하신 쿠폰은 환불되지 않습니다. <br>

				쿠폰은 상업적 용도로 사용하거나 매매하실 수 없습니다. <br>
			</td>
		</tr>
	</table>