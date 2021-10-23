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
public class FindpwController {

	private final String command = "/findpw.member";
	private final String getPage = "findpw";
	private final String gotoPage = "login";

	@Autowired
	MemberDao mdao;
	
	@Autowired
	memberMailDao mmd;
	
	@RequestMapping(value=command, method=RequestMethod.GET)
	public String doActionGET() {
		return getPage;
	}
	
	@RequestMapping(value=command, method=RequestMethod.POST)
	public String doActionPOST(MemberBean bean, HttpServletResponse response,Model model) throws IOException {
		
		MemberBean loginInfo = mdao.getPW(bean.getName(),bean.getId(),bean.getEmail());
		
		PrintWriter pw = response.getWriter();
		response.setContentType("text/html;charset=UTF-8");
		
		if(loginInfo == null) {
			pw.println("<script>alert('��ġ���� �ʴ� ȸ������ �Դϴ�.');</script>");
			pw.flush();
			return getPage;
	}
		else {
		    try {
		    	memberMailBean mmb = new memberMailBean();
		    	mmb.setSenderName("MoviePark");
		    	mmb.setSenderMail("wpfhchd@gmail.com");
		    	mmb.setReceiveMail(bean.getEmail());
		    	mmb.setSubject(loginInfo.getName()+"���� ��й�ȣ ã��");
		    	mmb.setMessage(loginInfo.getName()+"���� ã�� ��й�ȣ��"+loginInfo.getPassword()+"�Դϴ�.");
	            mmd.sendMail(mmb); // dto (���ϰ��� ����)�� sendMail�� ������
	        	pw.println("<script>alert('���Ϸ� �н����带 �߼��߽��ϴ�.');</script>");
				pw.flush();
	        } catch (Exception e) {
	            e.printStackTrace();
	            pw.println("<script>alert('���� �߼ۿ� �����߽��ϴ�.');</script>");
				pw.flush(); // �̸��� �߼��� ���еǾ��ٴ� �޽����� ���
	        }
			return gotoPage;
		}
	}
}
