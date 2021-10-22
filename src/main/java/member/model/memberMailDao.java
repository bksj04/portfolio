package member.model;

import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class memberMailDao {

	@Autowired
	 JavaMailSender mailSender;
	
	  public void sendMail(memberMailBean mmb) {
	        try {
	            // �̸��� ��ü
	            MimeMessage msg = mailSender.createMimeMessage();
	 
	            // �޴� ����� ���� (������, �޴»���� �̸��� �ּ� ��ü�� �����ؼ� ������ �̸����ּҸ� ����)
	            msg.addRecipient(RecipientType.TO, new InternetAddress(mmb.getReceiveMail()));
	 
	            /*
	             * createMimeMessage() : MimeMessage��ü�� ������Ŵ (�̰��� �̿��ؼ� �޽����� ������ �� ���� �߼�)
	             * addRecipient() : �޽����� �߽��ڸ� ���� InternetAddress() : �̸��� �ּ� getReceiveMail() :
	             * ������ �̸��� �ּ�
	             */
	 
	            // ������ ���(�̸����ּ�+�̸�)
	            // (�߽���, ������ ����� �̸��� �ּҿ� �̸��� ����)
	            // �̸��� �߽���
	            msg.addFrom(new InternetAddress[] { new InternetAddress(mmb.getSenderMail(), mmb.getSenderName()) });
	 
	            // �̸��� ���� (���ڵ��� �ؾ� �ѱ��� ������ ����)
	            msg.setSubject(mmb.getSubject(), "utf-8");
	            // �̸��� ���� (���ڵ��� �ؾ� �ѱ��� ������ ����)
	            msg.setText(mmb.getMessage(), "utf-8");
	 
//	            html�� ���� ���            
//	            MimeMessage message = mailSender.createMimeMessage();
//	            MimeMessageHelper helper 
//	            = new MimeMessageHelper(message, true);
//	            helper.setTo("test@host.com");
//	            helper.setText("<html><body><img src='cid:identifier1234'></body></html>", true);
	 
	            // �̸��� ������
	            mailSender.send(msg);
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
}
