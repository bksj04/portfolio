package main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import main.model.MainDao;
import video.model.videoBean;
import video.model.videoDao;

@Controller
public class MainController {

	private final String command = "/main.wa";
	private final String getPage = "main";
	
	@Autowired
	MainDao mdao;

	@Autowired
	videoDao vdao;
	
	@RequestMapping(value=command)
	public ModelAndView doAction() {
		
		ModelAndView mav = new ModelAndView();

		List<videoBean> vlists = vdao.getAllData();
		mav.addObject("vlists",vlists);
		List<videoBean> hlists = vdao.getAllDataHot();
		mav.addObject("hlists", hlists);
		List<videoBean> jlists = vdao.getAllDataJjim();
		mav.addObject("jlists", jlists);
		mav.setViewName(getPage);
		return mav;
	}
	
}
