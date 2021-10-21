package main.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import cs.model.CsQnABean;
import cs.model.CsQnADao;

@Controller
public class messageDetailViewController {

	@Autowired
	CsQnADao cqdao;
	
	private final String command = "messageDetailView.wa";
	private final String getPage = "messageDetailView";

	@RequestMapping(value = command,method = RequestMethod.GET)
	public ModelAndView doActionGet(@RequestParam("num") int num) {
		ModelAndView mav = new ModelAndView();
		
		CsQnABean cqb =cqdao.getOneData(num);
		mav.addObject("cqb", cqb);
		mav.setViewName(getPage);
		return mav;
	}
}
