package member.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import member.model.MemberBean;
import member.model.MemberDao;
import member.model.memberMailBean;
import member.model.memberMailDao;

@Controller
public class FindidController {

	private final String command = "/findid.member";
	private final String getPage = "findid";
	
	@Autowired
	MemberDao mdao;

	@Autowired
	memberMailDao mmd;
	
	@RequestMapping(value=command, method=RequestMethod.GET)
	public String doActionGET() {
		return getPage;
	}

	@RequestMapping(value=command, method=RequestMethod.POST)
	public String doActionPOST(MemberBean bean, HttpServletResponse response,Model model ) throws IOException {
		MemberBean loginInfo = mdao.getID(bean.getName(),bean.getEmail());
 
		PrintWriter pw = response.getWriter();
		response.setContentType("text/html;charset=UTF-8");
		if(loginInfo == null) {
			pw.println("<script>alert('없는 회원 입니다.');</script>");
			pw.flush();
			return getPage;
		}
		else {
		    try {
		    	memberMailBean mmb = new memberMailBean();
		    	mmb.setSenderName("MoviePark");
		    	mmb.setSenderMail("wpfhchd@gmail.com");
		    	mmb.setReceiveMail(bean.getEmail());
		    	mmb.setSubject(loginInfo.getName()+"님의 아이디 찾기");
		    	mmb.setMessage(loginInfo.getName()+"님의 찾는 아이디는"+loginInfo.getId()+"입니다.");
	            mmd.sendMail(mmb); // dto (메일관련 정보)를 sendMail에 저장함
	            model.addAttribute("message", "이메일이 발송되었습니다."); // 이메일이 발송되었다는 메시지를 출력시킨다.
	 
	        } catch (Exception e) {
	            e.printStackTrace();
	            model.addAttribute("message", "이메일 발송 실패..."); // 이메일 발송이 실패되었다는 메시지를 출력
	        }
			pw.println("<script>alert('메일을 발송했습니다.');</script>");
			pw.flush();
			return getPage;
		}

	}
}