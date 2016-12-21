package spring.web.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.maven.model.Model;
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
import spring.web.dto.InfomationDTO;
import spring.web.dto.MemberDTO;
import spring.web.dto.MemberRequestDTO;
import spring.web.dto.ProducerDTO;
import spring.web.dto.ProductDTO;
import spring.web.dto.PurchaseDTO;
import spring.web.dto.PurchaseListDTO;
import spring.web.dto.PurchaseStateDTO;
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
	public String loginPage(HttpSession session) {
		if(session.getAttribute("email") != null) {
			return "redirect:mainLoading";
		}
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
	@RequestMapping("searchPwd")
	@ResponseBody
	public String searchPwd(String email) {
		/**
		 * ����ڰ� ��й�ȣ�� ã�� ��,
		 * ���̵� �Է��� �� �ش� ���̵� �����ϴ� �� üũ ��
		 * ������ ��� ���������ڵ带 �̸��Ϸ� �߼�
		 * */
		String result = userService.searchPwd(email);
		System.out.println("��й�ȣ : " + result);
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
	 * @throws Exception 
	 * */
	@RequestMapping("login")
	public String login(HttpServletRequest request, MemberDTO memberDto, HttpSession session) throws Exception {
		System.out.println("UserInfoController�� login �޼ҵ�");
		MemberDTO result = userService.login(memberDto);
		if(result == null) {
			request.setAttribute("errorMsg", "ȸ�� ������ �ٽ� �Է��� �ּ���");
			throw new Exception();
		}
		session.setAttribute("email", result.getEmail());
		return "redirect:loginResult";
	}
	
	/**
	 * �α��� �� ��� ���İ� �޼ҵ�
	 * */
	@RequestMapping("loginResult")
	public String loginResult(HttpSession session) {
		System.out.println("loginResult");
		String email = (String)session.getAttribute("email");
		if(email.equals("admin")) {
			return "redirect:adminPage";
		}else {
			return "redirect:mainLoading";
		}
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
		return "redirect:loginPage";
	}
	
	/**
	 * admin �������� �̵�
	 * */
	@RequestMapping("adminPage")
	public String adminPage() {
		return "admin/admin";
	}
	
	/**
	 * ���ηε�
	 * �α׾ƿ� �� �������� �̵��ϱ� ���� �ʿ�
	 * */
	@RequestMapping("mainLoading")
	public ModelAndView mainLoading() {
		ModelAndView mv = new ModelAndView();
		Map<String, Object> map = userService.userMainLoading();
		List<ProductDTO> list = (List<ProductDTO>)map.get("bestProduct");
		List<ProducerDTO> list2 = (List<ProducerDTO>)map.get("bestProducer");
		int price = (Integer)map.get("previousMonthDonationPrice");
		List<InfomationDTO> infoList = (List<InfomationDTO>)map.get("infoList");
		mv.addObject("bestProduct", list);
		mv.addObject("bestProducer", list2);
		mv.addObject("infoList",infoList);
		mv.addObject("donationPrice", price);
		mv.setViewName("main/index");
		return mv;
	}
	
	 /**
	  * id �ߺ�Ȯ�� (ajax)
	  * */
	@RequestMapping("idCheck")
	public ResponseEntity<Boolean> idCheck(String email) {
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
		System.out.println(email);
		
		Map<String, Object>  map = userService.myPageLoading(email);
		mv.addObject("mileage", map.get("mileage"));
	
		//System.out.println("list.size : "+map.get("list"));
		
		mv.addObject("list", map.get("list"));
	
		mv.setViewName("account/account");
		if(email==null){
			mv.setViewName("login/login");
		}
		
		return mv;
	}
	
	/**
	 * ��ȸ������ 12���� ��ɺ� ó�� - �ֹ����� ��ȸ
	 * */
	@RequestMapping("searchOrderList")
	public ModelAndView searchOrderList(HttpSession session,String value) {
		//System.out.println(value+"wwwwwwwwwwwwwwww");
		String email = (String)session.getAttribute("email");
		List<MemberDTO> list = new ArrayList<MemberDTO>();
		int result=0;
		if(value==null){
			value="3����";
		}
		if(value.equals("��ü")){
			list = userService.myPageOrderListAll(email);
			
		}else if(value.equals("3����")){
			list = userService.myPageOrderList3(email);
			//System.out.println(list.size());
			
		}else if(value.equals("6����")){
			list = userService.myPageOrderList6(email);
			
		}else if(value.equals("1��")){
			list = userService.myPageOrderList12(email);
			
		}
		ModelAndView mv = new ModelAndView();
		mv.addObject("list", list);
		mv.setViewName("account/shopping/order");
		
		return mv;
	}    
	
	/**
	 * ��ȸ������ 12���� ��ɺ� ó�� - ȯ�ҳ��� ��ȸ
	 * */
	@RequestMapping("searchRefundList")
	public ModelAndView searchRefundList(HttpSession session,String value) {
		System.out.println(value);
		String email = (String)session.getAttribute("email");
		List<MemberDTO> list = new ArrayList<MemberDTO>();
		
		
		if(value.equals("��ü")){
			list = userService.myPageRefundListAll(email);
			
		}else if(value.equals("3����")){
			list = userService.myPageRefundList3(email);
			
		}else if(value.equals("6����")){
			list = userService.myPageRefundList6(email);
			
		}else if(value.equals("1��")){
			list = userService.myPageRefundList12(email);
			
		}
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("list", list);
		mv.setViewName("account/shopping/refund");
		
		return mv;
	}    

	/**
	 * ��ȸ������ 12���� ��ɺ� ó�� - ��ҳ��� ��ȸ
	 * */
	@RequestMapping("searchReturnList")
	public ModelAndView searchReturnList(HttpSession session,String value) {
		System.out.println(value);
		String email = (String)session.getAttribute("email");
		List<MemberDTO> list = new ArrayList<MemberDTO>();
		
		
		if(value.equals("��ü")){
			list = userService.myPageCancelListAll(email);
			
		}else if(value.equals("3����")){
			list = userService.myPageCancelList3(email);
			
		}else if(value.equals("6����")){
			list = userService.myPageCancelList6(email);
			
		}else if(value.equals("1��")){
			list = userService.myPageCancelList12(email);
			
		}
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("list", list);
		mv.setViewName("account/shopping/return");
		
		return mv;
	}    
	
	
	
	
	/**
	 * ���������� ���γ��� ������ ��
	 * �ڵ����� �ֹ�/��� ��ȸ Ŭ����
	 * ó������ 3���������� �ֹ������� ��������
	 * */
	@RequestMapping("myPageOrderList")
	public ModelAndView myPageOrderList(HttpSession session) {
		/**
		 * Mypage ���γ����� �����ڸ��� ������ �ֹ�/��� ������ ����
		 * purchase���̺��� ���������κ��� 3�������� �����͵��� ��� �����ͼ�
		 * ���̺��� ���·� view�� �ѷ��ش�.
		 * */
		System.out.println("1111111111111");
		String email = (String)session.getAttribute("email");
		List<MemberDTO> list = userService.myPageOrderList3(email);
		ModelAndView mv = new ModelAndView();
		mv.addObject("list",list);
		mv.setViewName("account/shopping/order");
		return mv;
	}
	
	
	/**
	 * ���������� ���/��ǰ/��ȯ ��ư Ŭ������ ��
	 * ó������ 3���������� �ֹ������� ��������
	 * */
	@RequestMapping("myPageCancelList")
	public ModelAndView myPageCancelList(HttpSession session) {
		/**
		 * MyPage���� ���/��ǰ/ ��ȯ ������ ������ �� 
		 * ���糯¥�������� 3���� ������ ��ϸ� �켱 ������ �´�
		 * 
		 * ������ ������ ������ : 	�ֹ���¥ / �ֹ�����(��ǰ�̸�,��ǰ�ڵ�) / ��ǰ�ݾ�,���� / ������ / ����Ȳ
		 * */
		String email = (String)session.getAttribute("email");
		List<MemberDTO> list = userService.myPageCancelList3(email);
		ModelAndView mv = new ModelAndView();
		mv.addObject("list", list);
		mv.setViewName("account/shopping/return");
		return mv;
	}
	
	/**
	 * ���������� ȯ�� ��ư Ŭ������ ��
	 * ó������ 3���������� �ֹ������� ��������
	 * */
	@RequestMapping("myPageRefundList")
	public ModelAndView myPageRefundList(HttpSession session) {
		/**
		 * MyPage���� ȯ�� ������ ������ �� 
		 * ���糯¥�������� 3���� ������ ��ϸ� �켱 ������ �´�
		 * 
		 * ������ ������ ������ : 	�ֹ���¥/ �ֹ�����(��ǰ�̸�,��ǰ�ڵ�) / ��ǰ�ݾ�,���� / ������ 
		 * */
		String email = (String)session.getAttribute("email");
		List<MemberDTO> list = userService.myPageRefundList3(email);
		ModelAndView mv = new ModelAndView();
		mv.addObject("list", list);
		mv.setViewName("account/shopping/refund");
		return mv;

	}
	
	/**
	 * ȯ��/��ǰ/��ȯ ������ ���� �� ��й�ȣ ��� ��û�ϱ�
	 * */
	@RequestMapping("requestRefund")
	@ResponseBody
	public int requestRefund(Integer no, String state, String desc, String pwd)throws Throwable {
		/*System.out.println("����");
			System.out.println(no);
			System.out.println(desc);
			System.out.println(pwd);
			System.out.println(state);*/
		int lastResult = 0;
		String name=null;
		if(state.equals("refund")){
			name="ȯ��";
		}else if(state.equals("return")){
			name="��ǰ";
		}else if(state.equals("change")){
			name="��ȯ";
		}
		int stateNo = userService.getStateNo(name);
		
		String email = userService.checkPwd(pwd);
		if(email==null){
			throw new Exception("��й�ȣ�� ��ġ���� �ʽ��ϴ�.");
		}
	
		MemberRequestDTO memberRequestDto = new MemberRequestDTO();
		memberRequestDto.setEmail(email);
		memberRequestDto.setStateNo(stateNo);
		memberRequestDto.setDesc(desc);
		memberRequestDto.setPurchaseNo(no);
		
		int result = userService.insertRequest(memberRequestDto);
		System.out.println(result+"aaaaaa");
		if(result==1){
			PurchaseDTO purchaseDto = new PurchaseDTO();
			purchaseDto.setNo(no);
			purchaseDto.setStateNo(stateNo);
			lastResult = userService.updateByRequest(purchaseDto);
		}
		return lastResult;
		//return result;
		}
	
	/**
	 * �ֹ�/��� ��ȸ���� �ֹ���� ��ư Ŭ������ ��
	 * ��ϻ���
	 * */
	@RequestMapping("requestCancelButton")
	@ResponseBody
	public int requestCancelButton(int no){
		System.out.println(no+">>>>>>>>>>>>>>>>>>>>>>>111111111111111111");
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
		System.out.println(list.size());
		ModelAndView mv = new ModelAndView();
		mv.addObject("list", list);
		mv.setViewName("account/myInfoQNA");
		return mv;
	}
	
	@RequestMapping(value="showAnswerByNo", produces = "application/text; charset=utf8")
	@ResponseBody
	public String showAnswerByNo(int no) throws UnsupportedEncodingException{
		
		System.out.println("no :"+no);
		String answer = userService.getAnswerByNo(no);
		System.out.println("answer :"+answer);
		return answer;
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
		List<MemberDTO> list = (List<MemberDTO>)map.get("list");
		ModelAndView mv = new ModelAndView();
		mv.addObject("list",list);
		mv.addObject("donationTotalInfo", map.get("donationTotalInfo"));
		mv.setViewName("account/myInfoDonate");
		
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
		ModelAndView mv = new ModelAndView();
		mv.addObject("memberDto", memberDto);
		mv.setViewName("account/myInfoModify");
		return mv;
	}
	
	/**
	 * �������� ����
	 * */
	@RequestMapping("updateUserInfo")
	public String updateUserInfo(MemberDTO memberDto)throws Throwable{
		int result = userService.updateUserInfo(memberDto);
		if(result==0){
			throw new Exception("������ �� �����ϴ�.");
		}
		
		return "forward:myPageInfoModify";
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
		int extra = 0;
		String email = (String)session.getAttribute("email");
		Map<String, Object> map = userService.myPageMileage(email);
		List<String> recommand = (List<String>)map.get("recommand");
		if(recommand.size()>5){
			extra = recommand.size()-5;
		}
		List<MemberDTO> usedMileage = (List<MemberDTO>)map.get("usedMileage");
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("recommand", recommand);
		mv.addObject("usedMileage", usedMileage);
		mv.addObject("extra", extra);
		mv.setViewName("account/myInfoMileage");
		
		return mv;
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
		
		// �α��� ���°� �ƴ϶�� �α���â���� �̵�������
		if(email == null) {
			mv.setViewName("login/login");
			return mv;
		}
		
		Map<String, Object> map = userService.myCart(email);
		List<ProductDTO> list = (List<ProductDTO>)map.get("productList");
		System.out.println("īƮ�� ��� ��ǰ���� ���� : " + list.size());
		System.out.println("īƮ�� ��� ��ǰ���� �� ���� : " + map.get("totalPrice"));
		mv.addObject("productList", map.get("productList"));
		mv.addObject("totalPrice", map.get("totalPrice"));
		mv.setViewName("cart/cart");
		System.out.println("cart : " + map.get("totalPrice"));
		return mv;
	}
	
	/**
	 * ��ٱ��Ͽ��� ����
	 * */
	@RequestMapping("myCartDelete")
	public String myCartDelete(HttpSession session,String name) {
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
		return "redirect:myCart";
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