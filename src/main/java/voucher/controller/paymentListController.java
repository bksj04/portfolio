package voucher.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import category.model.CategoryBean;
import member.model.MemberBean;
import member.model.MemberDao;
import order.model.OrderBean;
import order.model.OrderDao;
import utility.Paging;
 
@Controller 
public class paymentListController {
	
	private final String command="paymentList.voucher";
	private final String getPage="adminPaymentList";
	
	@Autowired(required = false)
	MemberDao mdao;
	
	@Autowired(required = false)
	OrderDao odao;
	
	@RequestMapping(value=command,method = RequestMethod.GET)
	public ModelAndView doAction(
			@RequestParam(value="whatColumn",required = false) String whatColumn,
			@RequestParam(value="keyword",required = false) String keyword,
			@RequestParam(value="pageNumber",required = false) String pageNumber,
			HttpServletRequest request
			) {
		
		Map<String,String> map = new HashMap<String, String>();
		map.put("whatColumn", whatColumn); 
		map.put("keyword", "%"+keyword+"%");
		int totalCount = mdao.getTotalCount(map);
		String url = request.getContextPath() + command ;

		ModelAndView mav = new ModelAndView();
		Paging pageInfo = new Paging(pageNumber,null,totalCount,url,whatColumn,keyword, null );
	
		List<MemberBean> mlists = mdao.getMemberOrderList();
		List<OrderBean> olists = odao.selectAll(pageInfo, map);
		mav.addObject("mlists", mlists);
		mav.addObject("olists", olists);
		mav.addObject("totalCount", totalCount);
		mav.addObject("pageInfo", pageInfo);
		
		mav.setViewName(getPage);
		return mav;
	}
}

