package admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import cs.model.CsQnABean;
import cs.model.CsQnADao;

@Controller
public class adminQnADetailViewController {

	@Autowired
	CsQnADao cqdao;
	
	private final String command = "/qnaDetailView.admin";
	private final String getPage = "adminMain";
	
	@RequestMapping(value= command)
	public ModelAndView doActionGet(@RequestParam("num") int num) {
		ModelAndView mav = new ModelAndView();
		
		CsQnABean cqb = cqdao.getOneData(num);
		
		String pageType = "qnaDetailView";
		
		mav.addObject("pageType", pageType);
		mav.addObject("cqb", cqb);
		mav.setViewName(getPage);
		return mav;
	}
}
