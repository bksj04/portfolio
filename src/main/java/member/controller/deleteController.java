package member.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import member.model.MemberDao;

@Controller
public class deleteController {

	@Autowired
	MemberDao mdao;
	
	private final String command = "/delete.member";
	private final String gotoPage = "redirect:main.wa";
	
	@RequestMapping(value=command)
	public ModelAndView doActionGet(@RequestParam("num") int num,HttpSession session) {
		ModelAndView mav = new ModelAndView();
		
		mdao.deleteMember(num);
		session.invalidate();
		mav.setViewName(gotoPage);
		return mav;
	}
}
