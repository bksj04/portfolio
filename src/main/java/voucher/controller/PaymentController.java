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
import order.model.OrderBean;
import order.model.OrderDao;
import voucher.model.couponBean;
import voucher.model.couponDao;

@Controller
public class PaymentController {
	
	private final String command="/payment.voucher";
	private final String getPage="payMain";
	
	@Autowired(required = false)
	CommodityDao cdao;
	
	@Autowired(required = false)
	OrderDao odao;
	
	@Autowired
	couponDao cpdao;
	
	@RequestMapping(value=command,method=RequestMethod.GET)
	public ModelAndView doAction(@RequestParam("num") int num,HttpSession session) {
		
		MemberBean loginInfo = (MemberBean) session.getAttribute("loginInfo");
		
		int cnt = odao.OrderCheck(loginInfo.getNum());
		CommodityBean cb=cdao.selectMember(num);
		couponBean cpb = cpdao.couponInfo(loginInfo.getId());
		
		ModelAndView mav=new ModelAndView();
		
		mav.addObject("cpb", cpb);
		mav.addObject("cnt", cnt);
		mav.addObject("cb",cb);
		
		mav.setViewName(getPage);
		return mav;
	}
}
