package video.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import member.model.MemberBean;
import member.model.MemberDao;
import member.model.MemberWatchBean;
import member.model.MemberWatchDao;

@Controller
public class videoPlayController {

	@Autowired
	MemberWatchDao mwdao;
	
	@Autowired
	MemberDao memberDao;
	
	private final String command = "/play.video";
	private final String getPage = "videoPlay";
	
	@RequestMapping(value=command)
	public ModelAndView doAction(MemberWatchBean watch,HttpSession session) {
		ModelAndView mav = new ModelAndView();
		
		MemberBean loginInfo = (MemberBean) session.getAttribute("loginInfo");
		String commodity_name = memberDao.getByCommodity(loginInfo.getNum());
		if(commodity_name == null) {
			
			mav.addObject("msg", "이용권을 구매 후 이용해주세요");
			mav.setViewName("alert");
		}else {
		int cnt = mwdao.insertWatch(watch);
		mav.addObject("watch", watch);
		mav.setViewName(getPage);
		}
		return mav;
	}
}
