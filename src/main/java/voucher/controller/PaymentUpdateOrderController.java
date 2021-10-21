package voucher.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import member.model.MemberBean;
import member.model.MemberDao;
import order.model.OrderBean;
import order.model.OrderDao;

@Controller
public class PaymentUpdateOrderController {
	
	private final String command="/updateOrder.voucher";
	private final String getPage="updateOrder";
	@Autowired(required = false)
	OrderDao odao;
	
	@Autowired(required = false)
	MemberDao mdao;
	
	
	@RequestMapping(value=command,method = RequestMethod.GET)
	public ModelAndView doAction(@RequestParam("mnum")int mnum,
			@RequestParam("pageNumber")int pageNumber) {
		
		MemberBean mb=mdao.getByNumData(mnum);
		OrderBean ob=odao.getOneData(mnum);
		
		ModelAndView mav=new ModelAndView();
		mav.addObject("pageNumber",pageNumber);
		mav.addObject("mb",mb);
		mav.addObject("ob", ob);
		mav.setViewName(getPage);
		return mav;
	}
	
	
}
