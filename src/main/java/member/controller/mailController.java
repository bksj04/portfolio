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
	    	 
            mmd.sendMail(mmb); // dto (메일관련 정보)를 sendMail에 저장함
            model.addAttribute("message", "이메일이 발송되었습니다."); // 이메일이 발송되었다는 메시지를 출력시킨다.
 
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("message", "이메일 발송 실패..."); // 이메일 발송이 실패되었다는 메시지를 출력
        }
        return getPage; // 실패했으므로 다시 write jsp 페이지로 이동함
    }
}
