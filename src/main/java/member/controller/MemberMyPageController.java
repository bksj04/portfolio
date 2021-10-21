package member.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import category.model.CategoryBean;
import commodity.model.CommodityBean;
import commodity.model.CommodityDao;
import member.model.MemberBean;
import member.model.MemberDao;
import member.model.MemberJjimBean;
import member.model.MemberJjimDao;
import member.model.MemberWatchBean;
import member.model.MemberWatchDao;
import order.model.OrderBean;
import order.model.OrderDao;

@Controller
public class MemberMyPageController {
	private final String command = "/mypage.member";
	private final String getPage = "memberMypage";
	
	@Autowired
	MemberDao memberDao;
	
	@Autowired
	MemberJjimDao mjdao;
	
	@Autowired
	MemberWatchDao mwdao;
	
	@Autowired(required = false)
	OrderDao odao;
	
	@Autowired(required = false)
	CommodityDao cdao;
	
	@RequestMapping(value=command)
	public ModelAndView doAction(HttpSession session) throws IOException {
		ModelAndView mav= new ModelAndView();
		
		MemberBean loginInfo = (MemberBean) session.getAttribute("loginInfo");
		
		if(loginInfo == null) {
			session.setAttribute("destination", "redirect:mypage.member");
			mav.setViewName("alert");
			mav.addObject("msg", "로그인을 해야합니다.");
		}else {
		List<MemberJjimBean> cblists = mjdao.getByMydata(loginInfo.getId());
		List<MemberWatchBean> wblists = mwdao.getByMydata(loginInfo.getId());
		CommodityBean cb = null;
		OrderBean ob =odao.getOneData(loginInfo.getNum());
		if(ob != null) {
			cb=cdao.selectMember(ob.getCnum());
		}
		mav.addObject("cb",cb);
		mav.addObject("cblists", cblists);
		mav.addObject("wblists", wblists);
		mav.setViewName(getPage);
		}
		return mav;
	}
}
