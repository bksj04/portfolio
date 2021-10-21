package member.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import member.model.MemberBean;
import member.model.MemberWatchDao;

@Controller
public class MemberWatchDeleteController {

	private final String command = "deletewatch.member";
	private final String getPage = "redirect:/mypage.member";
	
	@Autowired
	MemberWatchDao mwdao;
	
	@RequestMapping(value=command)
	public String doAction(HttpSession session) {
		
		MemberBean loginInfo  = (MemberBean) session.getAttribute("loginInfo");
		
		mwdao.deleteWatch(loginInfo.getId());
		
		return getPage+"?num="+loginInfo.getNum();
	}
}
