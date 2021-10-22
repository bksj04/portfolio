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
			pw.println("<script>alert('���� ȸ�� �Դϴ�.');</script>");
			pw.flush();
			return getPage;
		}
		else {
		    try {
		    	memberMailBean mmb = new memberMailBean();
		    	mmb.setSenderName("MoviePark");
		    	mmb.setSenderMail("wpfhchd@gmail.com");
		    	mmb.setReceiveMail(bean.getEmail());
		    	mmb.setSubject(loginInfo.getName()+"���� ���̵� ã��");
		    	mmb.setMessage(loginInfo.getName()+"���� ã�� ���̵��"+loginInfo.getId()+"�Դϴ�.");
	            mmd.sendMail(mmb); // dto (���ϰ��� ����)�� sendMail�� ������
	            model.addAttribute("message", "�̸����� �߼۵Ǿ����ϴ�."); // �̸����� �߼۵Ǿ��ٴ� �޽����� ��½�Ų��.
	 
	        } catch (Exception e) {
	            e.printStackTrace();
	            model.addAttribute("message", "�̸��� �߼� ����..."); // �̸��� �߼��� ���еǾ��ٴ� �޽����� ���
	        }
			pw.println("<script>alert('������ �߼��߽��ϴ�.');</script>");
			pw.flush();
			return getPage;
		}

	}
}