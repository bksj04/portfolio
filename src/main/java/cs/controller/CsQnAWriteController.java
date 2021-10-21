package cs.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import cs.model.CsQnABean;
import cs.model.CsQnADao;
import member.model.MemberBean;

@Controller
public class CsQnAWriteController {

	@Autowired
	CsQnADao cqdao;
	
	private final String command = "/QnA.cs";
	private final String getPage = "CsQnAWriteForm";
	private final String gotoPage = "redirect:main.wa";
	
	@RequestMapping(value=command,method=RequestMethod.GET)
	public ModelAndView doActionGet(HttpSession session) {
		ModelAndView mav = new ModelAndView();
		
		MemberBean loginInfo = (MemberBean)session.getAttribute("loginInfo");
		if(loginInfo == null) {
			mav.setViewName("redirect:login.member");
		}else {
		mav.setViewName(getPage);
		}
		return mav;
	}
	@RequestMapping(value=command,method=RequestMethod.POST)
	public ModelAndView doActionPost(CsQnABean cqb,HttpSession session) {
		ModelAndView mav = new ModelAndView();
		
		MemberBean loginInfo = (MemberBean)session.getAttribute("loginInfo");
		cqb.setWriter(loginInfo.getId());
		int cnt = cqdao.writeQuestions(cqb);
		mav.setViewName(gotoPage);
		return mav;
	}
}
