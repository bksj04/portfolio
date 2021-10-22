package member.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import member.model.memberMailBean;
import member.model.memberMailDao;

@Controller
public class mailController {

	@Autowired
	memberMailDao mmd;
	
	private final String command = "/mail.member";
	private final String getPage = "write";
	
	@RequestMapping(value=command,method = RequestMethod.GET)
	public String doActionGet() {
		
		return getPage;
	}
	@RequestMapping(value=command,method = RequestMethod.POST)
	public String doActionPost(memberMailBean mmb,Model model) {
		
	    try {
	    	 
            mmd.sendMail(mmb); // dto (���ϰ��� ����)�� sendMail�� ������
            model.addAttribute("message", "�̸����� �߼۵Ǿ����ϴ�."); // �̸����� �߼۵Ǿ��ٴ� �޽����� ��½�Ų��.
 
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("message", "�̸��� �߼� ����..."); // �̸��� �߼��� ���еǾ��ٴ� �޽����� ���
        }
        return getPage; // ���������Ƿ� �ٽ� write jsp �������� �̵���
    }
}
