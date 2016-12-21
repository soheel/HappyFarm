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
	 * 로그인을 클릭하면 로그인 창으로 이동
	 * */
	@RequestMapping("loginPage")
	public String loginPage(HttpSession session) {
		if(session.getAttribute("email") != null) {
			return "redirect:mainLoading";
		}
		return "login/login";
	}
	
	/**
	 * 회원쪽이 아니라 관리자나 비회원쪽 Controller에 있어야하는 메소드
	 * 로고 눌렀을 때
	 * */
	@RequestMapping("logo")
	public ModelAndView logo() {
		
		/**
		 * 페이지 상단에 로고를 눌렀을 때
		 * 항상 메인 페이지로 이동
		 * 
		 * 로그인했을 때 메인페이지에 뿌려져야하는 정보들
		 * (생산자 정보 ,인기상품 3개, 기부액에 대한 정보)
		 * -> ModelAndView에 담아서 메인화면 이동
		 * */
		ModelAndView mv = new ModelAndView();
		return mv;
	}
	
	/**
	 * 회원가입 페이지 이동
	 * */
	@RequestMapping("registerPage")
	public String registerPage() {
		return "login/register";
	}
	
	/**
	 * 회원가입 //insert
	 * */
	@RequestMapping("register")
	@ResponseBody
	public int register(MemberDTO memberDto){
		/**
		 * 회원가입 버튼을 눌렀을 때
		 * 인수로 들어오는  값들을 MemberDTO에 저장한다.
		 * 그리고 그 값들을 
		 * service -> dao를 거쳐서 db까지 이동후
		 * 가지고 나온 리턴(int형)을 뷰로 보내준다.
		 * 뷰에서 성공/실패의 여부에 따라 alert으로 알려준다.
		 * */
		int result = userService.registerMember(memberDto);
		return result;
	}
	
	/**
	 * 계정찾기 페이지로 이동하기
	 * */
	@RequestMapping("searchAccountPage")
	public String searchAccountPage() {
		return "login/searchAccount";
	}
	
	/**
	 * 계정찾기(id)
	 * */
	@RequestMapping("searchId")
	@ResponseBody
	public String searchId(MemberDTO memberDto) {
		/**
		 * 로그인을 시도-> 계정을 모를 경우,계정찾기 누르기.
		 * form의 이름과 연락처를 받음 그리고 이 값들을 
		 * MemberDto의 형식으로 받아서 service로 값을 넘겨줌
		 * service에서 나오는 리턴값을 String 형태로 받아서
		 * 뷰로 넘겨준다
		 * */
		
		System.out.println(memberDto.getEmail());
		System.out.println(memberDto.getPhone());
		String result = userService.searchId(memberDto);
		System.out.println(result);
		return result;
	}
	
	/**
	 * 계정찾기(pwd)
	 * 지정된 메일로 인증코드 보내기(ajax)
	 * */
	@RequestMapping("searchPwd")
	@ResponseBody
	public String searchPwd(String email) {
		/**
		 * 사용자가 비밀번호를 찾을 때,
		 * 아이디를 입력한 후 해당 아이디가 존재하는 지 체크 후
		 * 존재할 경우 본인인증코드를 이메일로 발송
		 * */
		String result = userService.searchPwd(email);
		System.out.println("비밀번호 : " + result);
		return result;
	}
	
	/**
	 * 계정찾기(pwd)
	 * 인증코드 확인
	 * 인증코드 맞으면 아래에 비밀번호 띄워주기(ajax)
	 * */
	@RequestMapping("searchPwdConfirm")
	@ResponseBody
	public String searchPwdConfirm(String code) {
		/**
		 * 사용자가 비밀번호를 찾을 수 있도록 이메일로 발송된
		 * 코드를 확인후 입력한 경우
		 * service를 거쳐서 dao로 이동한 후 
		 * 해당 회원의 비밀번호를 리턴해서 
		 * view로 가지고 이동 -> 뿌려진다.
		 * */
		String result =  userService.searchPwd(code);
		return result;
	}
	
	/**
	 * 로그인
	 * @throws Exception 
	 * */
	@RequestMapping("login")
	public String login(HttpServletRequest request, MemberDTO memberDto, HttpSession session) throws Exception {
		System.out.println("UserInfoController의 login 메소드");
		MemberDTO result = userService.login(memberDto);
		if(result == null) {
			request.setAttribute("errorMsg", "회원 정보를 다시 입력해 주세요");
			throw new Exception();
		}
		session.setAttribute("email", result.getEmail());
		return "redirect:loginResult";
	}
	
	/**
	 * 로그인 후 잠시 거쳐갈 메소드
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
	 * 로그아웃
	 * */
	@RequestMapping("logout")
	public String logout(HttpSession session) {
		/**
		 * 회원/관리자 -> 로그아웃 눌렀을 때
		 * session의 정보를 비워주고 
		 * main페이지로 이동
		 * (관리자일 경우도 user의 main페이지로 이동)
		 * */
		session.invalidate();
		return "redirect:loginPage";
	}
	
	/**
	 * admin 페이지로 이동
	 * */
	@RequestMapping("adminPage")
	public String adminPage() {
		return "admin/admin";
	}
	
	/**
	 * 메인로딩
	 * 로그아웃 후 메인으로 이동하기 위해 필요
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
	  * id 중복확인 (ajax)
	  * */
	@RequestMapping("idCheck")
	public ResponseEntity<Boolean> idCheck(String email) {
		boolean exist = userService.checkId(email);
		ResponseEntity<Boolean> result = new ResponseEntity<Boolean>(exist, HttpStatus.OK);
		return result;
	}
	
	/**
	  * 추천인 id 중복확인 (ajax)
	  * */
	@RequestMapping("recommandIdCheck")
	public ResponseEntity<Boolean> recommandIdCheck(String email) {
		
		boolean exist = userService.checkId(email);
		ResponseEntity<Boolean> result = new ResponseEntity<Boolean>(exist, HttpStatus.OK);
		
		System.out.println(exist + " : exist");
		
		return result;
	}
	
	// 내정보
	
	/**
	 * 내정보 버튼 클릭했을 때, 첫 화면 로딩
	 * 마일리지, 진행중인주문내역 가져오기
	 * */
	@RequestMapping("myPageLoading")
	public ModelAndView myPageLoading(HttpSession session) {
		/**
		 * 로그인을 한 후이기 때문에 session에 회원에 대한 개별 정보가 담겨있음
		 * session을 인수로 받아서 session에서 id를 꺼낸 후,
		 * service로 넘겨준다.
		 * 
		 * -> 개별 회원에 해당하는 마일리지와 주문내역의 상품 주문상태를 확인해서
		 *    현재 진행중인 상품만 리턴함(map에 저장한 후 )
		 *    
		 *    리턴한 정보들을 ModelAndView에 담아서 view로 이동
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
	 * 조회에관한 12가지 기능별 처리 - 주문내역 조회
	 * */
	@RequestMapping("searchOrderList")
	public ModelAndView searchOrderList(HttpSession session,String value) {
		//System.out.println(value+"wwwwwwwwwwwwwwww");
		String email = (String)session.getAttribute("email");
		List<MemberDTO> list = new ArrayList<MemberDTO>();
		int result=0;
		if(value==null){
			value="3개월";
		}
		if(value.equals("전체")){
			list = userService.myPageOrderListAll(email);
			
		}else if(value.equals("3개월")){
			list = userService.myPageOrderList3(email);
			//System.out.println(list.size());
			
		}else if(value.equals("6개월")){
			list = userService.myPageOrderList6(email);
			
		}else if(value.equals("1년")){
			list = userService.myPageOrderList12(email);
			
		}
		ModelAndView mv = new ModelAndView();
		mv.addObject("list", list);
		mv.setViewName("account/shopping/order");
		
		return mv;
	}    
	
	/**
	 * 조회에관한 12가지 기능별 처리 - 환불내역 조회
	 * */
	@RequestMapping("searchRefundList")
	public ModelAndView searchRefundList(HttpSession session,String value) {
		System.out.println(value);
		String email = (String)session.getAttribute("email");
		List<MemberDTO> list = new ArrayList<MemberDTO>();
		
		
		if(value.equals("전체")){
			list = userService.myPageRefundListAll(email);
			
		}else if(value.equals("3개월")){
			list = userService.myPageRefundList3(email);
			
		}else if(value.equals("6개월")){
			list = userService.myPageRefundList6(email);
			
		}else if(value.equals("1년")){
			list = userService.myPageRefundList12(email);
			
		}
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("list", list);
		mv.setViewName("account/shopping/refund");
		
		return mv;
	}    

	/**
	 * 조회에관한 12가지 기능별 처리 - 취소내역 조회
	 * */
	@RequestMapping("searchReturnList")
	public ModelAndView searchReturnList(HttpSession session,String value) {
		System.out.println(value);
		String email = (String)session.getAttribute("email");
		List<MemberDTO> list = new ArrayList<MemberDTO>();
		
		
		if(value.equals("전체")){
			list = userService.myPageCancelListAll(email);
			
		}else if(value.equals("3개월")){
			list = userService.myPageCancelList3(email);
			
		}else if(value.equals("6개월")){
			list = userService.myPageCancelList6(email);
			
		}else if(value.equals("1년")){
			list = userService.myPageCancelList12(email);
			
		}
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("list", list);
		mv.setViewName("account/shopping/return");
		
		return mv;
	}    
	
	
	
	
	/**
	 * 내정보에서 쇼핑내역 눌렀을 때
	 * 자동으로 주문/배송 조회 클릭됨
	 * 처음에는 3개월까지만 주문내역을 가져오기
	 * */
	@RequestMapping("myPageOrderList")
	public ModelAndView myPageOrderList(HttpSession session) {
		/**
		 * Mypage 쇼핑내역을 누르자마자 개인의 주문/배송 내역이 나옴
		 * purchase테이블에서 현시점으로부터 3개월전의 데이터들을 모두 가져와서
		 * 테이블의 형태로 view에 뿌려준다.
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
	 * 내정보에서 취소/반품/교환 버튼 클릭했을 때
	 * 처음에는 3개월까지만 주문내역을 가져오기
	 * */
	@RequestMapping("myPageCancelList")
	public ModelAndView myPageCancelList(HttpSession session) {
		/**
		 * MyPage에서 취소/반품/ 교환 내역을 눌렀을 때 
		 * 현재날짜에서부터 3개월 이전의 기록만 우선 가지고 온다
		 * 
		 * 가지고 나오는 데이터 : 	주문날짜 / 주문정보(상품이름,상품코드) / 상품금액,수량 / 생산자 / 현상황
		 * */
		String email = (String)session.getAttribute("email");
		List<MemberDTO> list = userService.myPageCancelList3(email);
		ModelAndView mv = new ModelAndView();
		mv.addObject("list", list);
		mv.setViewName("account/shopping/return");
		return mv;
	}
	
	/**
	 * 내정보에서 환불 버튼 클릭했을 때
	 * 처음에는 3개월까지만 주문내역을 가져오기
	 * */
	@RequestMapping("myPageRefundList")
	public ModelAndView myPageRefundList(HttpSession session) {
		/**
		 * MyPage에서 환불 내역을 눌렀을 때 
		 * 현재날짜에서부터 3개월 이전의 기록만 우선 가지고 온다
		 * 
		 * 가지고 나오는 데이터 : 	주문날짜/ 주문정보(상품이름,상품코드) / 상품금액,수량 / 생산자 
		 * */
		String email = (String)session.getAttribute("email");
		List<MemberDTO> list = userService.myPageRefundList3(email);
		ModelAndView mv = new ModelAndView();
		mv.addObject("list", list);
		mv.setViewName("account/shopping/refund");
		return mv;

	}
	
	/**
	 * 환불/반품/교환 폼에서 사유 및 비밀번호 적어서 신청하기
	 * */
	@RequestMapping("requestRefund")
	@ResponseBody
	public int requestRefund(Integer no, String state, String desc, String pwd)throws Throwable {
		/*System.out.println("들어옴");
			System.out.println(no);
			System.out.println(desc);
			System.out.println(pwd);
			System.out.println(state);*/
		int lastResult = 0;
		String name=null;
		if(state.equals("refund")){
			name="환불";
		}else if(state.equals("return")){
			name="반품";
		}else if(state.equals("change")){
			name="교환";
		}
		int stateNo = userService.getStateNo(name);
		
		String email = userService.checkPwd(pwd);
		if(email==null){
			throw new Exception("비밀번호가 일치하지 않습니다.");
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
	 * 주문/배송 조회에서 주문취소 버튼 클릭했을 때
	 * 목록삭제
	 * */
	@RequestMapping("requestCancelButton")
	@ResponseBody
	public int requestCancelButton(int no){
		System.out.println(no+">>>>>>>>>>>>>>>>>>>>>>>111111111111111111");
		/**
		 * 주문/배송 조회 시 나오는 데이터중에
		 * 특정 데이터를 사용자가 지우기 원할 때
		 * 해당데이터 앞의 체크박스 선택
		 * 
		 * 선택된 데이터에서 상품코드
		 * 전달받아서 service - dao로 전달
		 * 그에 해당하는 데이터를 지운후 int형태로 리턴을 받아서
		 * view로 전달 
		 * */
		int result = userService.deleteOrderProduct(no);
		return result;
	}
	
	
	/**
	 * 내정보에서 Q&A 버튼 클릭했을 때
	 * 전체 질문 내역 띄워주기
	 * */
	@RequestMapping("myPageQna")
	public ModelAndView myPageQna(HttpSession session) {
		/**
		 * MyPage - Q&A를 눌렀을 때
		 * 회원에 해당하는 질문글을 테이블의 형태로
		 * view에 뿌려준다
		 * 
		 * session객체에 저장된 email을 꺼내서
		 * 해당 email 회원의 Q&A정보를 꺼내서 List형태 리턴
		 * 리턴받은 값을 바로 view로 보내준다.
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
	 * 내정보에서 기부 버튼 클릭했을 때
	 * 3개월까지의 내역 보여주기
	 * */
	@RequestMapping("myPageDonation")
	public ModelAndView myPageDonation(HttpSession session) {
		/**
		 * session에서 email(아이디)를 가져온다ㅈㅂ
		 * 가져온 아이디에 해당하는 기부내역을 조회
		 * 처음 기부버튼을 클릭하면
		 * 무조건 현재날짜에서 3개월이전의 데이터만 보여준다.
		 * 
		 * 해당 데이터들을 가지고 나와서 List에 저장한후
		 * view로 이동
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
	 * 내정보에서 개인정보관리 버튼 클릭했을 때
	 * 내 정보 가져와서 아이디, 이름, 연락처 띄워주기
	 * */
	@RequestMapping("myPageInfoModify")
	public ModelAndView myPageInfoModify(HttpSession session) {
		/**
		 * session에서 email 받음
		 * email에 해당하는 회원의 정보를 꺼내서
		 * MemberDTO 타입으로 리턴헤서
		 * view로 넘김
		 * */
		String email = (String)session.getAttribute("email");
		MemberDTO memberDto = userService.myPageInfoModify(email);
		ModelAndView mv = new ModelAndView();
		mv.addObject("memberDto", memberDto);
		mv.setViewName("account/myInfoModify");
		return mv;
	}
	
	/**
	 * 개인정보 수정
	 * */
	@RequestMapping("updateUserInfo")
	public String updateUserInfo(MemberDTO memberDto)throws Throwable{
		int result = userService.updateUserInfo(memberDto);
		if(result==0){
			throw new Exception("수정할 수 없습니다.");
		}
		
		return "forward:myPageInfoModify";
	}
	
	
	/**
	 * 내정보에서 마일리지 버튼 클릭했을 때
	 * 추천인 아이디(5명) + 외 ~명 띄우주기
	 * 마일리지 사용내역은 3개월까지 보여주기
	 * */
	@RequestMapping("myPageMileage")
	public ModelAndView myPageMileage(HttpSession session) {
		/**
		 * 내정보 - 마일리지 버튼을 누르자마자 바로
		 * 추천인 아이디(5명)을 띄워주고 그 이외의 다른 추천인은 ~외 ~명으로 나타낸다
		 * 또한 추천인 아이디 밑부분에는 마일리지 사용내역을 뿌려주는데
		 * 현재일로부터 3개월이전의 데이터만 가지고 나온다.
		 * 
		 * 이 두 결과값을 map에 저장한 후 리턴한다.
		 * 페이지는 이동할 필요없으므로 그냥 Controller에서 리턴을 map으로함 
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
	 * 수정!!!!!!!!!!!!!!!
	 * 
	 * 
	 * 장바구니 버튼 클릭했을 때
	 * 페이징, cart 테이블에서 정보가져오기
	 * 총금액 띄워주기
	 * */
	@RequestMapping("myCart")
	public ModelAndView myCart(HttpSession session) {
		/**
		 * session에서 email을 뽑아와서
		 * 해당 이메일을 아이디로 가지는 회원의
		 * 장바구니에 담긴 상품목록을 가져온다
		 * */
		
		ModelAndView mv = new ModelAndView();
		String email = (String)session.getAttribute("email");
		System.out.println(email + " : email");
		
		// 로그인 상태가 아니라면 로그인창으로 이동시켜줌
		if(email == null) {
			mv.setViewName("login/login");
			return mv;
		}
		
		Map<String, Object> map = userService.myCart(email);
		List<ProductDTO> list = (List<ProductDTO>)map.get("productList");
		System.out.println("카트에 담긴 상품들의 개수 : " + list.size());
		System.out.println("카트에 담긴 상품들의 총 가격 : " + map.get("totalPrice"));
		mv.addObject("productList", map.get("productList"));
		mv.addObject("totalPrice", map.get("totalPrice"));
		mv.setViewName("cart/cart");
		System.out.println("cart : " + map.get("totalPrice"));
		return mv;
	}
	
	/**
	 * 장바구니에서 삭제
	 * */
	@RequestMapping("myCartDelete")
	public String myCartDelete(HttpSession session,String name) {
		/**
		 * 장바구니에서 상품 삭제를 누를 경우
		 * 장바구니 리스트에서 해당 상품에 대한 정보 삭제
		 * 
		 * 먼저 장바구니안에 담긴 상품 목록들을 map에 저장을 해서
		 * view로 가지고 나왔기 때문에 따로 session에 저장을 할 필요가 없다
		 * 
		 * 해당 상품코드가 인수로 들어오면 그 값을 service로 보내주어 dao까지 이동
		 * dao에서는 해당 번호에 일치하는 상품의 정보를 삭제한 후 int형을 리턴
		 * 
		 * 1 => 삭제 성공
		 * 0 => 삭제 실패
		 * view로 int형 리턴값을 넘겨준다.
		 * 
		 * */
		String email = (String)session.getAttribute("email");
		int result = userService.myCartDelete(email,name);
		return "redirect:myCart";
	}
	
	/**
	 * 장바구니에 주문버튼 클릭했을 때
	 * 주문 페이지로 이동
	 * */
	@RequestMapping("myCartOrder")
	public ModelAndView myCartOrder(HttpSession session) {
		/**
		 * 장바구니 페이지에서 구매버튼 클릭시
		 * 회원의 장바구니에 담긴 상품들의 정보를 가지고 주문페이지로 이동을 해야하기 때문에
		 * List<productDto>로 담아서 리턴
		 * 리턴한 값을 ModelAndView에 저장을 한 후 
		 * set view name으로 이동
		 * */
		String email = (String)session.getAttribute("email");
		List<ProductDTO> list = userService.myCartOrder(email);
		
		ModelAndView mv =  new ModelAndView();
		mv.addObject("list", list);
		mv.setViewName("주문페이지 이동");
		
		return mv;
	}
	
	
}