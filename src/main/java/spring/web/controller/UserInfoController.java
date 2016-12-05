package spring.web.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import spring.web.dto.MemberDTO;
import spring.web.service.UserInfoService;

@Controller("userinfo")
@RequestMapping("/user")
public class UserInfoController {
	
	@Autowired
	UserInfoService userService;
	
	/**
	 * �ΰ� ������ ��
	 * */
	@RequestMapping("logo")
	public String logo() {
		
		/**
		 * ������ ��ܿ� �ΰ� ������ ��
		 * �׻� ���� �������� �̵�
		 * */
		
		return "";
	}
	
	
	/**
	 * ȸ������ //insert
	 * */
	@RequestMapping("register")
	@ResponseBody
	public int register(MemberDTO memberDto){
		/**
		 * ȸ������ ��ư�� ������ ��
		 * �μ��� ������  ������ MemberDTO�� �����Ѵ�.
		 * �׸��� �� ������ 
		 * service -> dao�� ���ļ� db���� �̵���
		 * ������ ���� ����(int��)�� ��� �����ش�.
		 * �信�� ����/������ ���ο� ���� alert���� �˷��ش�.
		 * */
		int result = userService.registerMember(memberDto);
		
		return result;
	}
	
	/**
	 * ����ã��(id)
	 * */
	@RequestMapping("searchId")
	@ResponseBody
	public String searchId(MemberDTO memeberDto) {
		/**
		 * �α����� �õ�-> ������ �� ���,����ã�� ������.
		 * form�� �̸��� ����ó�� ���� �׸��� �� ������ 
		 * MemberDto�� �������� �޾Ƽ� service�� ���� �Ѱ���
		 * service���� ������ ���ϰ��� String ���·� �޾Ƽ�
		 * ��� �Ѱ��ش�
		 * */
		String result = userService.searchId(memeberDto);
		return result;
	}
	
	/**
	 * ����ã��(pwd)
	 * ������ ���Ϸ� �����ڵ� ������(ajax)
	 * */
	@RequestMapping("searchPwdSendCode")
	@ResponseBody
	public String searchPwdSendCode(String email) {
		/**
		 * ����ڰ� ��й�ȣ�� ã�� ��,
		 * ���̵� �Է��� �� �ش� ���̵� �����ϴ� �� üũ ��
		 * ������ ��� ���������ڵ带 �̸��Ϸ� �߼�
		 * */
		String result = userService.searchPwdSendCode(email);
		return result;
	}
	
	/**
	 * ����ã��(pwd)
	 * �����ڵ� Ȯ��
	 * �����ڵ� ������ �Ʒ��� ��й�ȣ ����ֱ�(ajax)
	 * */
	@RequestMapping("searchPwdConfirm")
	@ResponseBody
	public String searchPwdConfirm(String code) {
		/**
		 * ����ڰ� ��й�ȣ�� ã�� �� �ֵ��� �̸��Ϸ� �߼۵�
		 * �ڵ带 Ȯ���� �Է��� ���
		 * service�� ���ļ� dao�� �̵��� �� 
		 * �ش� ȸ���� ��й�ȣ�� �����ؼ� 
		 * view�� ������ �̵� -> �ѷ�����.
		 * */
		String result =  userService.searchPwd(code);
		return result;
	}
	
	/**
	 * �α���
	 * ���� ���̵� admin�̸� ������ ������ �ε�
	 * */
	@RequestMapping("login")
	public ModelAndView login(String email, String pwd) {
		/**
		 * �α����ϱ� - ������ ���̵� ��й�ȣ�� �Է��� ��
		 * db�� �����ϸ� �ش� ���̵� �����ؿ�
		 * �������� ���� ��� errorPage�� �̵�
		 * 
		 * ������ ���
		 * -> ���̵� 'admin'�� ��� ,admin-main page�� �̵�
		 *    �Ϲ� ȸ���� ���, user-main page�� �̵�
		 * */
		
		ModelAndView mv = new ModelAndView();
		MemberDTO memberDto = userService.login(email, pwd);
		if(memberDto!=null){
			if(memberDto.getName().equals("admin")){
				/**
				 * ������ ����â���� �̵�
				 *	ModelAndView�� setViewName���� �̵������� ����
				 **/
				mv.setViewName("������ ���� ������");
				return mv;
				
			}else{
				//user���� â���� �̵�
				/**
				 * user-main page : �����ڿ� ���� ���� , �α� ��ǰ 3���� ���� ����, 
				 * �������(������ �� ��ݾ�,�̹��� �� ��ݾ�)
				 * �ش� user�� ���� ������ session�� �����ؼ�
				 * ModelAndView�� ������ �� view�� �̵�
				 */
				Map<String, Object> map = userService.userMainLoading();
				mv.addObject("map", map);
				mv.setViewName("ȸ�� ���� ������");
			}
		}
		return mv;
	}
	
	/**
	 * �α׾ƿ�
	 * */
	@RequestMapping("logout")
	public String logout(HttpSession session) {
		/**
		 * ȸ��/������ -> �α׾ƿ� ������ ��
		 * session�� ������ ����ְ� 
		 * main�������� �̵�
		 * (�������� ��쵵 user�� main�������� �̵�)
		 * */
		session.invalidate();
		
		return "����â���� �̵�";
	}
	
	 /**
	  * id �ߺ�Ȯ�� (ajax)
	  * */
	@RequestMapping("idCheck")
	public ResponseEntity<Boolean> idCheck(String email) {
		/**
		 * ȸ���� ȸ�������� �� ��, ���̵� �ߺ�Ȯ��
		 * �ش� ���̵� ������ ��� ResponseEntity<boolean> -> true
		 * �ش� ���̵� �������� ���� ��� ResponseEntity<boolean> -> false
		 * */
		boolean exist = userService.checkId(email);
		ResponseEntity<Boolean> result = new ResponseEntity<Boolean>(exist, HttpStatus.OK);
		
		return result;
	}
	
	/**
	  * ��õ�� id �ߺ�Ȯ�� (ajax)
	  * */
	@RequestMapping("recommandIdCheck")
	public ResponseEntity<Boolean> recommandIdCheck(String email) {
		boolean exist = userService.checkId(email);
		ResponseEntity<Boolean> result = new ResponseEntity<Boolean>(exist, HttpStatus.OK);
		
		return result;
	}
	
	// ������
	
	/**
	 * ������ ��ư Ŭ������ ��, ù ȭ�� �ε�
	 * ���ϸ���, ���������ֹ����� ��������
	 * */
	@RequestMapping("myPageLoading")
	public ModelAndView myPageLoading(HttpSession session) {
		/**
		 * �α����� �� ���̱� ������ session�� ȸ���� ���� ���� ������ �������
		 * session�� �μ��� �޾Ƽ� session���� id�� ���� ��,
		 * service�� �Ѱ��ش�.
		 * 
		 * -> ���� ȸ���� �ش��ϴ� ���ϸ����� �ֹ������� ��ǰ �ֹ����¸� Ȯ���ؼ�
		 *    ���� �������� ��ǰ�� ������(map�� ������ �� )
		 *    
		 *    ������ �������� ModelAndView�� ��Ƽ� view�� �̵�
		 * */
		
		ModelAndView mv = new ModelAndView();
		String email = (String)session.getAttribute("email");
		
		Map<String, Integer>map = userService.myPageLoading(email);
		mv.addObject("map", map);
		mv.setViewName("���������� �ε��� �̵��� ������");
		
		return mv;
	}
	
	/**
	 * ��ȸ������ 12���� ��ɺ� ó��
	 * */
	@RequestMapping("showButton")
	public void showButton(String value) {
		
	}
	
	/**
	 * ���������� ���γ��� ������ ��
	 * �ڵ����� �ֹ�/��� ��ȸ Ŭ����
	 * ó������ 3���������� �ֹ������� ��������
	 * */
	@RequestMapping("myPageOrderList")
	public void myPageOrderList() {
		
	}
	
	/**
	 * �ֹ�/��� ��ȸ���� ȯ��/��ǰ/��ȯ ��ư Ŭ������ ��
	 * ��â���� �� ����ֱ�
	 * */
	@RequestMapping("requestRefundButton")
	public void requestRefundButton() {
		
	}
	
	/**
	 * ȯ��/��ǰ/��ȯ ������ ������� ��û�ϱ�
	 * */
	@RequestMapping("requestRefund")
	public void requestRefund() {
		
	}
	
	/**
	 * �ֹ�/��� ��ȸ���� �ֹ���� ��ư Ŭ������ ��
	 * ��ϻ���(ajax)
	 * */
	@RequestMapping("requestCancelButton")
	public void requestCancelButton() {
		
	}
	
	/**
	 * ���������� ���/��ǰ/��ȯ ��ư Ŭ������ ��
	 * ó������ 3���������� �ֹ������� ��������
	 * */
	@RequestMapping("myPageCancelList")
	public void myPageCancelList() {
		
	}
	
	/**
	 * ���������� ȯ�� ��ư Ŭ������ ��
	 * ó������ 3���������� �ֹ������� ��������
	 * */
	@RequestMapping("myPageRefundList")
	public void myPageRefundList() {
		
	}
	
	/**
	 * ���������� Q&A ��ư Ŭ������ ��
	 * ��ü ���� ���� ����ֱ�
	 * */
	@RequestMapping("myPageQna")
	public void myPageQna() {
		
	}
	
	/**
	 * Q&A �������� �� ������ Ŭ������ ��
	 * ��â����� �亯���� �����ֱ�
	 * */
	@RequestMapping("showAnswer")
	public void showAnswer() {
		
	}
	
	/**
	 * ���������� ��� ��ư Ŭ������ ��
	 * 3���������� ���� �����ֱ�
	 * */
	@RequestMapping("myPageDonation")
	public void myPageDonation() {
		
	}
	
	/**
	 * ���������� ������������ ��ư Ŭ������ ��
	 * �� ���� �����ͼ� ���̵�, �̸�, ����ó ����ֱ�
	 * */
	@RequestMapping("myPageInfoModify")
	public void myPageInfoModify() {
		
	}
	
	/**
	 * ���������� ���ϸ��� ��ư Ŭ������ ��
	 * ��õ�� ���̵�(5��) + �� ~�� ����ֱ�
	 * ���ϸ��� ��볻���� 3�������� �����ֱ�
	 * */
	@RequestMapping("myPageMileage")
	public void myPageMileage() {
		
	}
	
	/**
	 * ��ٱ��� ��ư Ŭ������ ��
	 * ����¡, cart ���̺��� ������������
	 * �ѱݾ� ����ֱ�
	 * */
	@RequestMapping("myCart")
	public void myCart() {
		
	}
	
	/**
	 * ��ٱ��Ͽ��� ����
	 * */
	@RequestMapping("myCartDelete")
	public void myCartDelete() {
		
	}
	
	/**
	 * ��ٱ��Ͽ� �ֹ���ư Ŭ������ ��
	 * */
	@RequestMapping("myCartOrder")
	public void myCartOrder() {
		
	}
}