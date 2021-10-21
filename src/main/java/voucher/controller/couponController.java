package voucher.controller;

import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import member.model.MemberBean;
import voucher.model.couponBean;
import voucher.model.couponDao;

@Controller
public class couponController {

	@Autowired
	couponDao cdao;
	
	private final String command = "/coupon.voucher";
	private final String getPage = "alert";
	
	@RequestMapping(value=command,method = RequestMethod.GET)
	public ModelAndView doActionGet(@RequestParam("cp_number") String cp_number,HttpSession session) throws IOException, ParseException {
		ModelAndView mav = new ModelAndView();
		
		String msg = "";
		
		Date nowdate = new Date(System.currentTimeMillis());
		
		MemberBean loginInfo = (MemberBean)session.getAttribute("loginInfo");
		
		couponBean cb1 = cdao.couponInfo(loginInfo.getId());
		if(cb1 == null) {
		couponBean cb2 = cdao.getOneData(cp_number);
		if(nowdate.before(cb2.getCp_duedate())) {
			if(cb2.getCp_id() == null) {
				cdao.couponRegister(cp_number, loginInfo.getId());
				msg = "쿠폰등록이 완료되었습니다.";
				mav.addObject("msg", msg);
			}else {
				msg = "이미 등록된 쿠폰입니다.";
				mav.addObject("msg", msg);
			}
		}else {
			msg = "사용기간이 만료된 쿠폰입니다.";
			mav.addObject("msg", msg);
		}
		}else {
			msg = "사용하지 않은 쿠폰이 있습니다.";
			mav.addObject("msg", msg);
		}
		String alertType = "coupon";
		mav.addObject("alertType", alertType);
		mav.setViewName(getPage);
		return mav;
	}
}
