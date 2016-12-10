package spring.web.controller;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import oracle.net.aso.s;
import spring.web.dto.DonationDTO;
import spring.web.dto.DonationOrgDTO;
import spring.web.dto.MemberDTO;
import spring.web.dto.ProducerDTO;
import spring.web.dto.ProductDTO;
import spring.web.dto.PurchaseDTO;
import spring.web.dto.QnaDTO;
import spring.web.service.UserInfoService;

@Controller
@RequestMapping("/userInfoController")
public class UserInfoController {
	
	@Autowired
	private UserInfoService userService;
	
	/**
	 * �α����� Ŭ���ϸ� �α��� â���� �̵�
	 * */
	@RequestMapping("loginPage")
	public String loginPage() {
		return "login/login";
	}
	
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
	 * ȸ������ ������ �̵�
	 * */
	@RequestMapping("registerPage")
	public String registerPage() {
		return "login/register";
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
	 * ����ã�� �������� �̵��ϱ�
	 * */
	@RequestMapping("searchAccountPage")
	public String searchAccountPage() {
		return "login/searchAccount";
	}
	
	/**
	 * ����ã��(id)
	 * */
	@RequestMapping("searchId")
	@ResponseBody
	public String searchId(MemberDTO memberDto) {
		/**
		 * �α����� �õ�-> ������ �� ���,����ã�� ������.
		 * form�� �̸��� ����ó�� ���� �׸��� �� ������ 
		 * MemberDto�� �������� �޾Ƽ� service�� ���� �Ѱ���
		 * service���� ������ ���ϰ��� String ���·� �޾Ƽ�
		 * ��� �Ѱ��ش�
		 * */
		
		System.out.println(memberDto.getEmail());
		System.out.println(memberDto.getPhone());
		String result = userService.searchId(memberDto);
		System.out.println(result);
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
	public ModelAndView login(MemberDTO memberDto, HttpSession session) {
		/**
		 * �α����ϱ� - ������ ���̵� ��й�ȣ�� �Է��� ��
		 * db�� �����ϸ� �ش� ���̵� �����ؿ�
		 * �������� ���� ��� errorPage�� �̵�
		 * 
		 * ������ ���
		 * -> ���̵� 'admin'�� ��� ,admin-main page�� �̵�
		 *    �Ϲ� ȸ���� ���, user-main page�� �̵�
		 * */
		
		System.out.println("UserInfoController�� login �޼ҵ�");
		ModelAndView mv = new ModelAndView();
		MemberDTO result = userService.login(memberDto);
		
		if(result!=null){
			if(memberDto.getEmail().equals("admin")){
				/**
				 * ������ ����â���� �̵�
				 *	ModelAndView�� setViewName���� �̵������� ����
				 **/
				mv.setViewName("������ ���� ������");
				return mv;
				
			}else{
				System.out.println("login �޼ҵ� else");
				//user���� â���� �̵�
				/**
				 * user-main page : �����ڿ� ���� ���� , �α� ��ǰ 3���� ���� ����, 
				 * �������(������ �� ��ݾ�,�̹��� �� ��ݾ�)
				 * �ش� user�� ���� ������ session�� �����ؼ�
				 * ModelAndView�� ������ �� view�� �̵�
				 */
				Map<String, Object> map = userService.userMainLoading();
				mv.setViewName("main/index");
				
				List<ProductDTO> list = (List<ProductDTO>)map.get("bestProduct");
				System.out.println(list.get(0).getName());
				List<ProducerDTO> list2 = (List<ProducerDTO>)map.get("bestProducer");
				System.out.println(list2.get(0).getName());
				int price = (Integer)map.get("previousMonthDonationPrice");
				System.out.println(price);
				
				mv.addObject("bestProduct", list);
				mv.addObject("bestProducer", list2);
				mv.addObject("donationPrice", price);
				
				// session �߰��ϱ�
				session.setAttribute("email", memberDto.getEmail());
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
		
		return "redirect:mainLoading";
	}
	
	/**
	 * ���ηε�
	 * �α׾ƿ� �� �������� �̵��ϱ� ���� �ʿ�
	 * */
	@RequestMapping("mainLoading")
	public ModelAndView mainLoading() {
		ModelAndView mv = new ModelAndView();
		Map<String, Object> map = userService.userMainLoading();
		mv.setViewName("main/index");
		
		List<ProductDTO> list = (List<ProductDTO>)map.get("bestProduct");
		System.out.println("bestProduce list�� size : " + list.size());
		System.out.println(list.get(0).getName());
		List<ProducerDTO> list2 = (List<ProducerDTO>)map.get("bestProducer");
		System.out.println(list2.get(0).getName());
		int price = (Integer)map.get("previousMonthDonationPrice");
		System.out.println(price);
		
		mv.addObject("bestProduct", list);
		mv.addObject("bestProducer", list2);
		mv.addObject("donationPrice", price);
		
		return mv;
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
		
		System.out.println(exist + " : exist");
		
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
	public List<ProductDTO> myPageOrderList(HttpSession session) {
		/**
		 * Mypage ���γ����� �����ڸ��� ������ �ֹ�/��� ������ ����
		 * purchase���̺��� ���������κ��� 3�������� �����͵��� ��� �����ͼ�
		 * ���̺��� ���·� view�� �ѷ��ش�.
		 * */
		String email = (String)session.getAttribute("email");
		List<ProductDTO> list = userService.myPageOrderList3(email);
		return list;
	}
	
	
	/**
	 * ���������� ���/��ǰ/��ȯ ��ư Ŭ������ ��
	 * ó������ 3���������� �ֹ������� ��������
	 * */
	@RequestMapping("myPageCancelList")
	public List<ProductDTO> myPageCancelList(HttpSession session) {
		/**
		 * MyPage���� ���/��ǰ/ ��ȯ ������ ������ �� 
		 * ���糯¥�������� 3���� ������ ��ϸ� �켱 ������ �´�
		 * 
		 * ������ ������ ������ : 	�ֹ���¥ / �ֹ�����(��ǰ�̸�,��ǰ�ڵ�) / ��ǰ�ݾ�,���� / ������ / ����Ȳ
		 * */
		String email = (String)session.getAttribute("email");
		List<ProductDTO> list = userService.myPageCancelList3(email);
		return list;
	}
	
	/**
	 * ���������� ȯ�� ��ư Ŭ������ ��
	 * ó������ 3���������� �ֹ������� ��������
	 * */
	@RequestMapping("myPageRefundList")
	public List<ProductDTO> myPageRefundList(HttpSession session) {
		/**
		 * MyPage���� ȯ�� ������ ������ �� 
		 * ���糯¥�������� 3���� ������ ��ϸ� �켱 ������ �´�
		 * 
		 * ������ ������ ������ : 	�ֹ���¥/ �ֹ�����(��ǰ�̸�,��ǰ�ڵ�) / ��ǰ�ݾ�,���� / ������ 
		 * */
		String email = (String)session.getAttribute("email");
		List<ProductDTO> list = userService.myPageRefundList3(email);
		return list;

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
	 * ȯ��/��ǰ/��ȯ ������ ���� �� ��й�ȣ ��� ��û�ϱ�
	 * */
	@RequestMapping("requestRefund")
	public void requestRefund() {
		
	}
	
	/**
	 * �ֹ�/��� ��ȸ���� �ֹ���� ��ư Ŭ������ ��
	 * ��ϻ���(ajax)
	 * */
	@RequestMapping("requestCancelButton")
	public int requestCancelButton(int no) {
		/**
		 * �ֹ�/��� ��ȸ �� ������ �������߿�
		 * Ư�� �����͸� ����ڰ� ����� ���� ��
		 * �ش絥���� ���� üũ�ڽ� ����
		 * 
		 * ���õ� �����Ϳ��� ��ǰ�ڵ�
		 * ���޹޾Ƽ� service - dao�� ����
		 * �׿� �ش��ϴ� �����͸� ������ int���·� ������ �޾Ƽ�
		 * view�� ���� 
		 * */
		int result = userService.deleteOrderProduct(no);
		return result;
	}
	
	
	/**
	 * ���������� Q&A ��ư Ŭ������ ��
	 * ��ü ���� ���� ����ֱ�
	 * */
	@RequestMapping("myPageQna")
	public ModelAndView myPageQna(HttpSession session) {
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
		
		return null;
	}
	
	/**
	 * Q&A �������� �� ������ Ŭ������ ��
	 * ��â����� �亯���� �����ֱ�
	 * */
	@RequestMapping("showAnswer")
	public String showAnswer(int no) {
		/**
		 * session�� ��� email�� view���� �μ��� qna�۹�ȣ�� ���� �޴´�.
		 * ���̵�� �۹�ȣ�� Dto�� ��Ƽ� service�� ������
		 * 
		 * ������ �亯�� �ö���� ���
		 * ���� Ŭ���ϸ� �亯 form�� �����ش�(ȭ���̵�x)
		 * ������ �ش��ϴ� �亯�� view�� �����ش�.
		 * 
		 * view���� ajax�� �亯�� �޾Ƽ� ó��
		 */
		
		String result = userService.showAnswer(no);
		
		return result;
	}
	
	/**
	 * ���������� ��� ��ư Ŭ������ ��
	 * 3���������� ���� �����ֱ�
	 * */
	@RequestMapping("myPageDonation")
	public ModelAndView myPageDonation(HttpSession session) {
		/**
		 * session���� email(���̵�)�� �����´٤���
		 * ������ ���̵� �ش��ϴ� ��γ����� ��ȸ
		 * ó�� ��ι�ư�� Ŭ���ϸ�
		 * ������ ���糯¥���� 3���������� �����͸� �����ش�.
		 * 
		 * �ش� �����͵��� ������ ���ͼ� List�� ��������
		 * view�� �̵�
		 * */
		String email = (String)session.getAttribute("email");
		Map<String, Object> map= userService.myPageDonation(email);
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("map", map);
		
		return mv;
	}
	
	/**
	 * ���������� ������������ ��ư Ŭ������ ��
	 * �� ���� �����ͼ� ���̵�, �̸�, ����ó ����ֱ�
	 * */
	@RequestMapping("myPageInfoModify")
	public ModelAndView myPageInfoModify(HttpSession session) {
		/**
		 * session���� email ����
		 * email�� �ش��ϴ� ȸ���� ������ ������
		 * MemberDTO Ÿ������ �����켭
		 * view�� �ѱ�
		 * */
		String email = (String)session.getAttribute("email");
		MemberDTO memberDto = userService.myPageInfoModify(email);
		
		return null;
	}
	
	/**
	 * ���������� ���ϸ��� ��ư Ŭ������ ��
	 * ��õ�� ���̵�(5��) + �� ~�� ����ֱ�
	 * ���ϸ��� ��볻���� 3�������� �����ֱ�
	 * */
	@RequestMapping("myPageMileage")
	public ModelAndView myPageMileage(HttpSession session) {
		/**
		 * ������ - ���ϸ��� ��ư�� �����ڸ��� �ٷ�
		 * ��õ�� ���̵�(5��)�� ����ְ� �� �̿��� �ٸ� ��õ���� ~�� ~������ ��Ÿ����
		 * ���� ��õ�� ���̵� �غκп��� ���ϸ��� ��볻���� �ѷ��ִµ�
		 * �����Ϸκ��� 3���������� �����͸� ������ ���´�.
		 * 
		 * �� �� ������� map�� ������ �� �����Ѵ�.
		 * �������� �̵��� �ʿ�����Ƿ� �׳� Controller���� ������ map������ 
		 * */
		String email = (String)session.getAttribute("email");
		Map<String, Object> map = userService.myPageMileage(email);
		
		return null;
	}
	
	/**
	 * ����!!!!!!!!!!!!!!!
	 * 
	 * 
	 * ��ٱ��� ��ư Ŭ������ ��
	 * ����¡, cart ���̺��� ������������
	 * �ѱݾ� ����ֱ�
	 * */
	@RequestMapping("myCart")
	public ModelAndView myCart(HttpSession session) {
		/**
		 * session���� email�� �̾ƿͼ�
		 * �ش� �̸����� ���̵�� ������ ȸ����
		 * ��ٱ��Ͽ� ��� ��ǰ����� �����´�
		 * */
		
		ModelAndView mv = new ModelAndView();
		
		String email = (String)session.getAttribute("email");
		System.out.println(email + " : email");
		
		if(email == null) {
			mv.setViewName("login/login");
			return mv;
		}
		
		Map<String, Object> map = userService.myCart(email);
		List<ProductDTO> list = (List<ProductDTO>)map.get("productList");
		System.out.println(list.size());
		System.out.println(map.get("totalPrice"));
		return null;
	}
	
	/**
	 * ��ٱ��Ͽ��� ����
	 * */
	@RequestMapping("myCartDelete")
	public int myCartDelete(HttpSession session,String name) {
		/**
		 * ��ٱ��Ͽ��� ��ǰ ������ ���� ���
		 * ��ٱ��� ����Ʈ���� �ش� ��ǰ�� ���� ���� ����
		 * 
		 * ���� ��ٱ��Ͼȿ� ��� ��ǰ ��ϵ��� map�� ������ �ؼ�
		 * view�� ������ ���Ա� ������ ���� session�� ������ �� �ʿ䰡 ����
		 * 
		 * �ش� ��ǰ�ڵ尡 �μ��� ������ �� ���� service�� �����־� dao���� �̵�
		 * dao������ �ش� ��ȣ�� ��ġ�ϴ� ��ǰ�� ������ ������ �� int���� ����
		 * 
		 * 1 => ���� ����
		 * 0 => ���� ����
		 * view�� int�� ���ϰ��� �Ѱ��ش�.
		 * 
		 * */
		String email = (String)session.getAttribute("email");
		int result = userService.myCartDelete(email,name);
		return result;
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