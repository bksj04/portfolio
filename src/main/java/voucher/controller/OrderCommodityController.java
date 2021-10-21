package voucher.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import order.model.OrderBean;
import order.model.OrderDao;

@Controller
public class OrderCommodityController {
	
	private final String command="/updateOrderCommodity.voucher";
	private final String getPage="redirect:/paymentList.voucher";
	
	@Autowired(required = false)
	OrderDao odao;
	
	@RequestMapping(value=command,method = RequestMethod.POST)
	public ModelAndView doAction(@RequestParam("commodity") int commodity,
			@RequestParam("num") int num,
			@RequestParam("pageNumber")int pageNumber) {
		OrderBean ob=new OrderBean();
		ob.setMnum(num);
		ob.setCnum(commodity);
		
		int cnt=odao.updateData(ob);
		
		ModelAndView mav= new ModelAndView();
		if(cnt>0) {
			mav.setViewName(getPage);
		}else {
			mav.setViewName("redirect:/updateOrder.voucher");
		}
		return mav;
	}
}
