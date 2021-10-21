package main.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import category.model.CategoryBean;
import category.model.CategoryDao;
import main.model.MainBean;
import main.model.MainDao;
import member.model.MemberJjimBean;
import utility.Paging;

@Controller
public class MainController {

	private final String command = "/main.wa";
	private final String getPage = "main";
	
	@Autowired
	MainDao mdao;
	
	@Autowired(required = false)
	CategoryDao cdao;
	
	@RequestMapping(value=command)
	public ModelAndView doAction() {
		
		ModelAndView mav = new ModelAndView();
	
		List<CategoryBean> vlists = cdao.selectAll();
		List<MainBean> lists = mdao.selectMain();
		mav.addObject("lists",lists);
		mav.addObject("vlists",vlists);
		
		mav.setViewName(getPage);
		return mav;
	}
	
}
