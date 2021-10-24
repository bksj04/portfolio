package member.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import member.model.MemberDao;
import member.model.MemberJjimBean;
import member.model.MemberJjimDao;
import video.model.videoDao;


@Controller
public class MemberJjimDeleteController {

	private final String command ="deletejjim.member";

	@Autowired
	MemberJjimDao mjdao;
	
	@Autowired(required = false)
	videoDao vdao;

	@RequestMapping(value = command)
	public ModelAndView doAction(MemberJjimBean jjim) {
		ModelAndView mav = new ModelAndView();
		String str = jjim.getVideo_category();
		String firstLtr = str.substring(0, 1);
		String restLtrs = str.substring(1, str.length());

		firstLtr = firstLtr.toUpperCase();
		str = firstLtr + restLtrs;

		mjdao.deleteJjim(jjim);
		vdao.jjimCountDown(jjim.getVideo_num());

		if(str.equals("Main")) {
			mav.setViewName("redirect:detail"+str+".wa"+"?num="+jjim.getVideo_num());
		}else {
			mav.setViewName("redirect:detail"+str+".category"+"?num="+jjim.getVideo_num());
		}
		return mav;
	}
}