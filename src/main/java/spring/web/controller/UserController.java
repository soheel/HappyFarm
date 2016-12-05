package spring.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("user")
public class UserController {

	@RequestMapping("mapSearch")
	public String mapSearch(String keyword) {
		System.out.println("user/mapSearch 들어옴");
		
		return null;
	}
	
	@RequestMapping("pay")
	@ResponseBody
	public String pay(HttpServletRequest request) {
		System.out.println(request.getParameter("imp_uid"));
		return null;
	}
	
	/*@RequestMapping("test4")
	public void test4(CertificationDTO dto) {
		System.out.println("여기");
		System.out.println(dto.getApple());
		System.out.println(dto.getPeach());
	}
	*/
	@RequestMapping("mail")
	public void mail() {
		System.out.println("메일");
		JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
		 
		// 메일 내용을 작성한다
		SimpleMailMessage msg = new SimpleMailMessage();
		msg.setFrom("apfhd5620@gmail.com");
		msg.setTo("apfhd5620@gmail.com");
		msg.setSubject("제목이 이러저러합니다");
		msg.setText("본문이 어쩌구저쩌구합니다");
		 
		try {
		    mailSender.send(msg);
		} catch (MailException ex) {
		    // 적절히 처리
			ex.printStackTrace();
		}
	}
}
