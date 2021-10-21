package member.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import member.model.MemberBean;
import member.model.MemberDao;

@Controller
public class SignMemberController {
	
	
	private final String command = "sign.member";
	private final String getPage = "signpage";
	private final String gotoPage = "loginpage";
	
	@Autowired
	MemberDao mdao;
	
	@RequestMapping(value=command, method=RequestMethod.GET)
	public String doActionGET() {
		
		return getPage;
	}
	@RequestMapping(value=command, method=RequestMethod.POST)
	public ModelAndView doActionPOST(@Valid MemberBean mb, BindingResult result,HttpServletResponse response) throws IOException {
		ModelAndView mav = new ModelAndView();
		
		PrintWriter pw = response.getWriter();
		response.setContentType("text/html;charset=UTF-8");
		
		if(result.hasErrors()) {
			System.out.println("유효성검사에 오류가 있습니다.");
			mav.addObject("mb", mb);
			mav.setViewName(getPage);
			return mav;
		}
		int cnt = mdao.insertMember(mb);
		if(cnt >= 1) {
			pw.println("<script>alert('회원가입이 완료되었습니다.');</script>");
			pw.flush();
			mav.setViewName(gotoPage);
		}

		return mav;
}
}