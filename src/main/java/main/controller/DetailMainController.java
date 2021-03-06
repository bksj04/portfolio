package main.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import category.detail.DetailBean;
import category.detail.DetailDao;
import category.model.CategoryBean;
import category.model.CategoryDao;
import main.detail.DetailMainBean;
import main.detail.DetailMainDao;
import main.model.MainBean;
import main.model.MainDao;
import member.model.MemberBean;
import member.model.MemberJjimBean;
import member.model.MemberJjimDao;

@Controller
public class DetailMainController {
	private final String command = "/detailMain.wa";
	private final String getPage = "detailMain";
	
	@Autowired
	DetailMainDao dmdao;
	
	@Autowired
	MemberJjimDao mjdao;
	
	
	@RequestMapping(value=command,method=RequestMethod.GET)
	public ModelAndView doAction(@RequestParam("num") int num,HttpSession session) {
		System.out.println("1:"+1);
		ModelAndView mav=new ModelAndView();
		
		MemberBean loginInfo = (MemberBean) session.getAttribute("loginInfo");
		if(loginInfo == null) {
			session.setAttribute("destination", "redirect:main.wa");
			mav.addObject("msg", "로그인을 해야합니다");
			mav.setViewName("alert");
		}else {
		
			DetailMainBean db = dmdao.getOneData(num);
			List<DetailMainBean> dblists = dmdao.getByGenre(db.getGenre());
			List<MemberJjimBean> mjlists = mjdao.getByData(loginInfo.getId());
			
			mav.addObject("db",db);
			mav.addObject("dblists",dblists);
			mav.addObject("mjlists", mjlists);
		
		mav.setViewName(getPage);
		}
		return mav;
	}
	
	
	
}
