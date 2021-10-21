package admin.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import cs.model.CsQnABean;
import cs.model.CsQnADao;
import member.model.MemberBean;

@Controller
public class adminQnAAnswerController {

	@Autowired
	CsQnADao cqdao;
	
	private final String command = "/qnaAnswer.admin";
	private final String getPage = "adminMain";
	private final String gotoPage = "redirect:qnaList.admin";
	
	@RequestMapping(value= command,method=RequestMethod.GET)
	public ModelAndView doActionGet(@RequestParam("ref") int ref) {
		ModelAndView mav = new ModelAndView();
		
		String pageType = "qnaAnswerForm";
		mav.addObject("pageType", pageType);
		mav.addObject("ref", ref);
		mav.setViewName(getPage);
		return mav;
	}
	@RequestMapping(value= command,method = RequestMethod.POST)
	public ModelAndView doActionPost(CsQnABean cqb,HttpSession session) {
		ModelAndView mav = new ModelAndView();
		
		MemberBean loginInfo = (MemberBean)session.getAttribute("loginInfo");
		
		cqb.setWriter(loginInfo.getId());
		
		int cnt = cqdao.writeAnswer(cqb);
		mav.setViewName(gotoPage);
		return mav;
	}
}
