package spring.web.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import net.nurigo.java_sdk.api.Message;
import net.nurigo.java_sdk.exceptions.CoolsmsException;
import net.sf.json.JSONObject;
import spring.web.dto.CommunityDTO;
import spring.web.dto.DonationDTO;
import spring.web.dto.DonationOrgDTO;
import spring.web.dto.InfomationDTO;
import spring.web.dto.ProductDTO;
import spring.web.dto.QnaDTO;
import spring.web.service.UserEtcService;

@Controller
@RequestMapping("/userEtcController")
public class UserEtcController {
	
	@Autowired
	UserEtcService userEtcService;
	// 모임
	
	/**
	 * 모임목록 불러오기 
	 * 모임DTO 리스트
	 * select + 페이징
	 * */
	@RequestMapping("communityLoading")
	public ModelAndView communityLoading() {
		
		Map<String, Object> communitylist = new HashMap<String, Object>();
		
		/**
		 * 1. commuity를 누르면, 
		 * 2. 6개의 현재 진행하는 행사와 지난 3개행사를 보여줘서 총 9개를 담아서
		 * 뷰로 보내준다. community_profile사진 / commuinty_name, community_register_date를 보여준다.
		 * 3. 6개의 진행행사 / 3개의 지난 행사를 뽑아주는 dao 두 개의 메소드와 (community_state 상태를 확인 한 후)
		 * 페이지 기능 메소드가 필요. 
		 * 
		 */
		
		ModelAndView mv = new ModelAndView();
		communitylist = userEtcService.communityLoading();
		List<CommunityDTO> list1 =(List<CommunityDTO>)communitylist.get("communityIngList");
		/*System.out.println(list1.get(1).getName());*/
		List<CommunityDTO> list2 = (List<CommunityDTO>)communitylist.get("communityPastList");
		System.out.println(list2.get(0).getName());
		if(communitylist!=null){
			//에러 처리 진행중인 행사가 없다.
		}
		mv.addObject("communityIngList",list1);
		mv.addObject("communityPastList",list2);
		mv.setViewName("community/showCommunity");
		return mv;
	}
	
	/**
	 * 모임 상세보기
	 * 모임DTO, 오른쪽 사이드바에 진행중인 행사 목록 가져오기( communityNo)
	 * */
	@RequestMapping("communityDetail")
	public ModelAndView communityDetail(int no) {
		Map<String, Object> communityInfo=new HashMap<String, Object>();
		/**
		 * 1. 사용자가 선택한 모임 번호를 받는다.
		 * 2. 받은 인수(communityNo)를 dao로 넘겨서 CommunityDTO 정보(대표사진, 이름, 날짜, 설명)를 받아 반환
		 * 
		 * 3. 밑에 있는 댓글의 정보를 받아와야 한다.communityDTO에 communityNO와 일치하는 CommunityComment정보를 찾아 communityNo를 제외한 정보를 다 받아온다.
		 * 
		 * 4. 오른쪽 사이드바는 CommunityDTO에 있는 community_state 정보가 1이면 진행중, 0이면 진행완료로 구분해
		 * community_state가 1인 것들을 뽑아와 List<CommunityDTO>해서 행사목록을 가져온다.
		 * Map으로 받는다.
		 */
		communityInfo = userEtcService.communityDetail(no);
		CommunityDTO community = (CommunityDTO)communityInfo.get("community");
		List<CommunityDTO> commentlist = (List<CommunityDTO>)communityInfo.get("commentlist");
		List<CommunityDTO> communityIngList = (List<CommunityDTO>)communityInfo.get("communityIngList");
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("community",community);
		mv.addObject("commentlist",commentlist);
		mv.addObject("communityIngList", communityIngList);
		mv.setViewName("community/communityDetail");
		
		System.out.println(community.getDesc() + "!!!");
		return mv;
	}
	
	
	// Q&A
	
	/**
	 * Q&A 게시판 클릭했을 때
	 * qna DTO 리스트
	 * */
	@RequestMapping("qnaLoading")
	public ModelAndView qnaLoading() {
		/**
		 * 1. Q&A게시판이 클릭하면, 사용자가 입력할 수 있는 Q&A등록 폼이 위에 뜨고
		 * 2. 밑에는 Q&A목록을 dao로 가져와서 전체를 불러와서 페이징으로 처리한다.
		 * 3. ajax로 질문을 누르면 답변을 불러온다.
		 * 
		 */
		List<QnaDTO> qnaList = userEtcService.qnaLoading();
		ModelAndView mv = new ModelAndView();
		mv.addObject("qnaList", qnaList);
		mv.setViewName("qna/qnaLoading");
		return mv;
	}
	
	/**
	 * Q&A 글쓰기
	 * */
	@RequestMapping("qnaWrite")
	@ResponseBody
	public String qnaWrite(HttpServletRequest request, String desc) throws Exception{
		/**
		 * 1.Q&A write폼에서 등록을 누르면 정보를 받아와서
		 * 2.정보를 insert한 후 
		 * 3.Q&A 로딩하는 화면으로 이동한다.
		 */
		System.out.println(desc);
		HttpSession session = request.getSession();
		String email = (String)session.getAttribute("email");
		
		QnaDTO qnaDto = new QnaDTO();
		qnaDto.setDesc(desc);
		qnaDto.setEmail(email);
		
		int result = userEtcService.registerQnA(qnaDto);
		System.out.println("result = "+result);
		if(result==0){
			throw new Exception();
		}
		
		return "forward:qnaLoading";
		
	}
	
	
	// 정보
	/**
	 * info 눌렀을 때 
	 * info DTO 리스트 가져오기
	 * */
	@RequestMapping("infoLoading")
	public ModelAndView infoLoading() {
		/**
		 * commuity를 누르면,9개의 정보를 담아서 뷰로 보내준다.
		 * dao 소드와  페이지 기능 메소드가 필요. 
		 */
		List<InfomationDTO> infoList = null;
		ModelAndView mv = new ModelAndView();
		infoList = userEtcService.infoLoading();
		mv.addObject("infoList",infoList);
		mv.setViewName("info/infoLoading");
		System.out.println(infoList.size() + " !!!");

		return mv;
	}
	
	/**
	 * info 상세보기
	 * info DTO 가져오기 (qnano) 
	 * @return 
	 * */
	@RequestMapping("infoDetail")
	public ModelAndView infoDetail(int no) {
		/**
		 * 1. 사용자가 선택한 모임 번호를 받는다.(hidden으로 정보를 숨겨 받아서???)
		 * 2. 받은 인수(communityNo)를 dao로 넘겨서 CommunityDTO 정보를 받아 반환
		 */
		InfomationDTO infomationDTO = userEtcService.infoDetail(no);
	
		//연관된 상품 보여주기
		//List<ProductDTO> relatedProduct = userEtcService.infoRelatedProduct(infomationDTO.getName());
		ModelAndView mv = new ModelAndView();
		mv.addObject("info",infomationDTO);
		//mv.addObject("relatedProduct", relatedProduct);
		mv.setViewName("info/infoDetail");
		return mv;
	}

	// 기부
	
	/**
	 * donation 눌렀을 때
	 * 전체기부현황(5달) 나머지는 다운로드
	 * 차트
	 * */
	@RequestMapping("donationLoading")
	public ModelAndView donationLoading() {
		/**
		 * donate를 눌렀을 때 전체 기부 내역에서 최근에서 5달 정도만 뺴우고 나머지는 다운로드가 되도록 한다.
		 * 밑에는 차트를 넣는다. dao로 하나로 받고, 표시하는 방법을 두 가지(표와 차트)
		 * 이떄 표는 페이징 필요 없음. 
		 */
		List<DonationDTO> donationlist = null;
		ModelAndView mv = new ModelAndView();
		donationlist = userEtcService.donationLoading();
		mv.addObject("donationlist",donationlist);
		mv.setViewName("donate/donationLoading");
		
		// 기부업체 로딩 작성해야함
		DonationOrgDTO donationOrg = userEtcService.donationLoading2();
		mv.addObject("donationOrg", donationOrg);
		
		//System.out.println(donationOrg.getDesc());
		return mv;
	}
	
	
	
	// 메인
	/**
	 * 생산자 상세보기
	 * 생산자 DTO, 지도
	 * @return 
	 * */
	@RequestMapping("producerDetail")
	public ModelAndView producerDetail(int no) {
		/**
		 * 1.생산자 상세보기를 누르면,생산자 이름, 연락처, 생산자 이미지 정보를 받아온다.producerDTO정보를 받는다.
		 * 2.producer의 addr주소를 통해 지도를 변환한다.
		 * 3.대표 상품은 producerDTO 정보에 맞는 productDTO를 받는다. 
		 * 4.지도는 지도 api를 통해 삽입한다.
		 */
		Map<String, Object> producer = userEtcService.producerDetail(no);
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("producer", producer);
		
		mv.setViewName("producerDetail");
		return mv;
	}
}
