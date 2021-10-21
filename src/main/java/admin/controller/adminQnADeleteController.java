package admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import cs.model.CsQnADao;

@Controller
public class adminQnADeleteController {

	@Autowired
	CsQnADao cqdao;
	
	private final String command = "/qnaDelete.admin";
	private final String getPage = "redirect:qnaList.admin";
	
	@RequestMapping(value=command)
	public ModelAndView doActionGet(@RequestParam("num") int num) {
		ModelAndView mav = new ModelAndView();
		
		cqdao.deleteData(num);
		mav.setViewName(getPage);
		return mav;
	}
}
