package play.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import member.model.MemberBean;
import member.model.MemberDao;
import member.model.MemberWatchBean;
import member.model.MemberWatchDao;
import order.model.OrderDao;
import video.model.videoBean;
import video.model.videoDao;

@Controller
public class playController {

	@Autowired
	MemberWatchDao mwdao;
	
	@Autowired
	OrderDao odao;
	
	@Autowired
	videoDao vdao;
	
	private final String command = "/video.play";
	private final String getPage = "playVideo";
	
	@RequestMapping(value=command)
	public ModelAndView doAction(@RequestParam("num") int num,HttpSession session) {
		ModelAndView mav = new ModelAndView();
		
		videoBean vbean = vdao.getByVideoInfo(num);
		MemberBean loginInfo = (MemberBean) session.getAttribute("loginInfo");
		int cnt	= odao.OrderCheck(loginInfo.getNum());
		if(cnt == 0) {
			mav.addObject("msg", "이용권을 구매 후 이용해주세요");
			mav.setViewName("alert");
		}else {
			MemberWatchBean mwbean = new MemberWatchBean();
			mwbean.setVideo_num(num);
			mwbean.setMember_id(loginInfo.getId());
		mwdao.insertWatch(mwbean);
		vdao.watchCountUp(num);
		mav.addObject("vbean", vbean);
		mav.setViewName(getPage);
		}
		return mav;
	}
}
