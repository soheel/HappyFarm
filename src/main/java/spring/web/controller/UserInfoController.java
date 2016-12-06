package spring.web.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import spring.web.dto.DonationDTO;
import spring.web.dto.MemberDTO;
import spring.web.dto.ProductDTO;
import spring.web.dto.QnaDTO;
import spring.web.service.UserInfoService;

@Controller("userinfo")
@RequestMapping("/user")
public class UserInfoController {
	
	@Autowired
	UserInfoService userService;
	
	/**
	 * ȸ������ �ƴ϶� �����ڳ� ��ȸ���� Controller�� �־���ϴ� �޼ҵ�
	 * �ΰ� ������ ��
	 * */
	@RequestMapping("logo")
	public ModelAndView logo() {
		
		/**
		 * ������ ��ܿ� �ΰ� ������ ��
		 * �׻� ���� �������� �̵�
		 * 
		 * �α������� �� ������������ �ѷ������ϴ� ������
		 * (������ ���� ,�α��ǰ 3��, ��ξ׿� ���� ����)
		 * -> ModelAndView�� ��Ƽ� ����ȭ�� �̵�
		 * */
		ModelAndView mv = new ModelAndView();

		return mv;
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
	 * *//*
	@RequestMapping("showButton")
	public void showButton(String value) {
		
	}*/
	
	
	
	/**
	 * ���������� ���γ��� ������ ��
	 * �ڵ����� �ֹ�/��� ��ȸ Ŭ����
	 * ó������ 3���������� �ֹ������� ��������
	 * */
	@RequestMapping("myPageOrderList")
	public List<ProductDTO> myPageOrderList(HttpSession session) {
		/**
		 * Mypage ���γ����� �����ڸ��� ������ �ֹ�/��� ������ ����
		 * purchase���̺��� ���������κ��� 3�������� �����͵��� ��� �����ͼ�
		 * ���̺��� ���·� view�� �ѷ��ش�.
		 * */
		String email = (String)session.getAttribute("email");
		List<ProductDTO> list = userService.myPageOrderList(email);
		return list;
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
	 * �ֹ�/��� ��ȸ���� ȯ��/��ǰ/��ȯ ��ư Ŭ������ ��
	 * ��â���� �� ����ֱ�
	 * */
	@RequestMapping("requestRefundButton")
	public String requestRefundButton() {
		return "ȯ��/��ǰ/��ȯ form";
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
	public int requestCancelButton(HttpSession session) {
		/**
		 * �ֹ�/��� ��ȸ �� ������ �������߿�
		 * Ư�� �����͸� ����ڰ� ����� ���� ��
		 * �ش絥���� ���� üũ�ڽ� ����
		 * 
		 * ���õ� �����Ϳ��� product_no(primary key)��
		 * ���޹޾Ƽ� service - dao�� ����
		 * �׿� �ش��ϴ� �����͸� ������ int���·� ������ �޾Ƽ�
		 * view�� ���� 
		 * */
		String email = (String)session.getAttribute("email");
		int result = userService.deleteOrderProduct(email);
		return result;
	}
	
	
	/**
	 * ���������� Q&A ��ư Ŭ������ ��
	 * ��ü ���� ���� ����ֱ�
	 * */
	@RequestMapping("myPageQna")
	public List<QnaDTO> myPageQna(HttpSession session) {
		/**
		 * MyPage - Q&A�� ������ ��
		 * ȸ���� �ش��ϴ� �������� ���̺��� ���·�
		 * view�� �ѷ��ش�
		 * 
		 * session��ü�� ����� email�� ������
		 * �ش� email ȸ���� Q&A������ ������ List���� ����
		 * ���Ϲ��� ���� �ٷ� view�� �����ش�.
		 * */
		String email = (String)session.getAttribute("email");
		List<QnaDTO> list = userService.myPageQna(email);
		return list;
	}
	
	/**
	 * Q&A �������� �� ������ Ŭ������ ��
	 * ��â����� �亯���� �����ֱ�
	 * */
	@RequestMapping("showAnswer")
	public String showAnswer(HttpSession session, int no) {
		/**
		 * session�� ��� email�� view���� �μ��� qna�۹�ȣ�� ���� �޴´�.
		 * ���̵�� �۹�ȣ�� Dto�� ��Ƽ� service�� ������
		 * 
		 * ������ �亯�� �ö���� ���
		 * ���� Ŭ���ϸ� �亯 form�� �����ش�(ȭ���̵�x)
		 * ������ �ش��ϴ� �亯�� view�� �����ش�.
		 * 
		 * view���� ajax�� �亯�� �޾Ƽ� ó��
		 * */
		String email = (String)session.getAttribute("email");
		QnaDTO qnaDto = new QnaDTO();
		qnaDto.setEmail(email);
		qnaDto.setQnaParent(no);
		
		String result = userService.showAnswer(qnaDto);
		
		return result;
	}
	
	/**
	 * ���������� ��� ��ư Ŭ������ ��
	 * 3���������� ���� �����ֱ�
	 * */
	@RequestMapping("myPageDonation")
	public List<DonationDTO> myPageDonation(HttpSession session) {
		/**
		 * session���� email(���̵�)�� �����´�
		 * ������ ���̵� �ش��ϴ� ��γ����� ��ȸ
		 * ó�� ��ι�ư�� Ŭ���ϸ�
		 * ������ ���糯¥���� 3���������� �����͸� �����ش�.
		 * 
		 * �ش� �����͵��� ������ ���ͼ� List�� ��������
		 * view�� �̵�
		 * */
		String email = (String)session.getAttribute("email");
		List<DonationDTO> list= userService.myPageDonation(email);
		
		return list;
	}
	
	/**
	 * ���������� ������������ ��ư Ŭ������ ��
	 * �� ���� �����ͼ� ���̵�, �̸�, ����ó ����ֱ�
	 * */
	@RequestMapping("myPageInfoModify")
	public MemberDTO myPageInfoModify(HttpSession session) {
		/**
		 * session���� email ����
		 * email�� �ش��ϴ� ȸ���� ������ ������
		 * MemberDTO Ÿ������ �����켭
		 * view�� �ѱ�
		 * */
		String email = (String)session.getAttribute("email");
		MemberDTO memberDto = userService.myPageInfoModify(email);
		
		return memberDto;
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
	public List<ProductDTO> myCart(HttpSession session) {
		/**
		 * session���� email�� �̾ƿͼ�
		 * �ش� �̸����� ���̵�� ������ ȸ����
		 * ��ٱ��Ͽ� ��� ��ǰ����� �����´�
		 * */
		String email = (String)session.getAttribute("email");
		List<ProductDTO> list = userService.myCart(email);
		
		return list;
	}
	
	/**
	 * ��ٱ��Ͽ��� ����
	 * */
	@RequestMapping("myCartDelete")
	public void myCartDelete(int no) {
		/**
		 * ��ٱ��Ͽ��� ��ǰ ������ ���� ���
		 * ��ٱ��Ͽ� 
		 * 
		 * */
		
	}
	
	/**
	 * ��ٱ��Ͽ� �ֹ���ư Ŭ������ ��
	 * �ֹ� �������� �̵�
	 * */
	@RequestMapping("myCartOrder")
	public ModelAndView myCartOrder(HttpSession session) {
		/**
		 * ��ٱ��� ���������� ���Ź�ư Ŭ����
		 * ȸ���� ��ٱ��Ͽ� ��� ��ǰ���� ������ ������ �ֹ��������� �̵��� �ؾ��ϱ� ������
		 * List<productDto>�� ��Ƽ� ����
		 * ������ ���� ModelAndView�� ������ �� �� 
		 * set view name���� �̵�
		 * */
		String email = (String)session.getAttribute("email");
		List<ProductDTO> list = userService.myCartOrder(email);
		
		ModelAndView mv =  new ModelAndView();
		mv.addObject("list", list);
		mv.setViewName("�ֹ������� �̵�");
		
		return mv;
	}
}