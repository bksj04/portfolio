package voucher.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import commodity.model.CommodityBean;
import commodity.model.CommodityDao;
import member.model.MemberBean;
import voucher.model.couponBean;
import voucher.model.couponDao;

@Controller
public class PaymentSetController {
	private final String command="/paymentSet.voucher";
	private final String gotoPage="payment";
	
	@Autowired(required = false)
	CommodityDao cdao;
	
	@Autowired
	couponDao cpdao;
	
	@RequestMapping(value=command,method = RequestMethod.GET)
	public ModelAndView goPage(@RequestParam("cnum") int num,HttpSession session) {
		
		MemberBean loginInfo = (MemberBean) session.getAttribute("loginInfo");
		
		CommodityBean cb=cdao.selectMember(num);
		couponBean cpb = cpdao.couponInfo(loginInfo.getId());
		
		ModelAndView mav=new ModelAndView();
		mav.addObject("cpb", cpb);
		mav.addObject("cb",cb);
		mav.setViewName(gotoPage);
		return mav;
	}
}
