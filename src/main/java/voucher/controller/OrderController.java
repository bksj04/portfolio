package voucher.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import member.model.MemberBean;
import order.model.OrderBean;
import order.model.OrderDao;
import voucher.model.couponDao;

@Controller
public class OrderController {
	
	private final String command="/order.voucher";
	private final String getPage="paymentComplete";
	
	@Autowired(required=false)
	OrderDao odao;
	
	@Autowired
	couponDao cpdao;
	
	OrderBean ob = new OrderBean();
	
	@RequestMapping(value=command,method = RequestMethod.POST)
	public ModelAndView doAction(@RequestParam("cnum") int cnum,
			@RequestParam("mnum") int mnum,HttpSession session) {
		
		MemberBean loginInfo = (MemberBean) session.getAttribute("loginInfo");
		
		ob.setCnum(cnum);
		ob.setMnum(mnum);
		
		int cnt=odao.setInsertOrder(ob);
		if(cnt > 0) {
			cpdao.couponUse(loginInfo.getId());
		}
		
		ModelAndView mav=new ModelAndView();
		
		mav.addObject("cnt", cnt);
		mav.setViewName(getPage);
			
		return mav;
	}
}
