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
	// ����
	
	/**
	 * ���Ӹ�� �ҷ����� 
	 * ����DTO ����Ʈ
	 * select + ����¡
	 * */
	@RequestMapping("communityLoading")
	public ModelAndView communityLoading() {
		
		Map<String, Object> communitylist = new HashMap<String, Object>();
		
		/**
		 * 1. commuity�� ������, 
		 * 2. 6���� ���� �����ϴ� ���� ���� 3����縦 �����༭ �� 9���� ��Ƽ�
		 * ��� �����ش�. community_profile���� / commuinty_name, community_register_date�� �����ش�.
		 * 3. 6���� ������� / 3���� ���� ��縦 �̾��ִ� dao �� ���� �޼ҵ�� (community_state ���¸� Ȯ�� �� ��)
		 * ������ ��� �޼ҵ尡 �ʿ�. 
		 * 
		 */
		
		ModelAndView mv = new ModelAndView();
		communitylist = userEtcService.communityLoading();
		List<CommunityDTO> list1 =(List<CommunityDTO>)communitylist.get("communityIngList");
		/*System.out.println(list1.get(1).getName());*/
		List<CommunityDTO> list2 = (List<CommunityDTO>)communitylist.get("communityPastList");
		System.out.println(list2.get(0).getName());
		if(communitylist!=null){
			//���� ó�� �������� ��簡 ����.
		}
		mv.addObject("communityIngList",list1);
		mv.addObject("communityPastList",list2);
		mv.setViewName("community/showCommunity");
		return mv;
	}
	
	/**
	 * ���� �󼼺���
	 * ����DTO, ������ ���̵�ٿ� �������� ��� ��� ��������( communityNo)
	 * */
	@RequestMapping("communityDetail")
	public ModelAndView communityDetail(int no) {
		Map<String, Object> communityInfo=new HashMap<String, Object>();
		/**
		 * 1. ����ڰ� ������ ���� ��ȣ�� �޴´�.
		 * 2. ���� �μ�(communityNo)�� dao�� �Ѱܼ� CommunityDTO ����(��ǥ����, �̸�, ��¥, ����)�� �޾� ��ȯ
		 * 
		 * 3. �ؿ� �ִ� ����� ������ �޾ƿ;� �Ѵ�.communityDTO�� communityNO�� ��ġ�ϴ� CommunityComment������ ã�� communityNo�� ������ ������ �� �޾ƿ´�.
		 * 
		 * 4. ������ ���̵�ٴ� CommunityDTO�� �ִ� community_state ������ 1�̸� ������, 0�̸� ����Ϸ�� ������
		 * community_state�� 1�� �͵��� �̾ƿ� List<CommunityDTO>�ؼ� ������� �����´�.
		 * Map���� �޴´�.
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
	 * Q&A �Խ��� Ŭ������ ��
	 * qna DTO ����Ʈ
	 * */
	@RequestMapping("qnaLoading")
	public ModelAndView qnaLoading() {
		/**
		 * 1. Q&A�Խ����� Ŭ���ϸ�, ����ڰ� �Է��� �� �ִ� Q&A��� ���� ���� �߰�
		 * 2. �ؿ��� Q&A����� dao�� �����ͼ� ��ü�� �ҷ��ͼ� ����¡���� ó���Ѵ�.
		 * 3. ajax�� ������ ������ �亯�� �ҷ��´�.
		 * 
		 */
		List<QnaDTO> qnaList = userEtcService.qnaLoading();
		ModelAndView mv = new ModelAndView();
		mv.addObject("qnaList", qnaList);
		mv.setViewName("qna/qnaLoading");
		return mv;
	}
	
	/**
	 * Q&A �۾���
	 * */
	@RequestMapping("qnaWrite")
	@ResponseBody
	public String qnaWrite(HttpServletRequest request, String desc) throws Exception{
		/**
		 * 1.Q&A write������ ����� ������ ������ �޾ƿͼ�
		 * 2.������ insert�� �� 
		 * 3.Q&A �ε��ϴ� ȭ������ �̵��Ѵ�.
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
	
	
	// ����
	/**
	 * info ������ �� 
	 * info DTO ����Ʈ ��������
	 * */
	@RequestMapping("infoLoading")
	public ModelAndView infoLoading() {
		/**
		 * commuity�� ������,9���� ������ ��Ƽ� ��� �����ش�.
		 * dao �ҵ��  ������ ��� �޼ҵ尡 �ʿ�. 
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
	 * info �󼼺���
	 * info DTO �������� (qnano) 
	 * @return 
	 * */
	@RequestMapping("infoDetail")
	public ModelAndView infoDetail(int no) {
		/**
		 * 1. ����ڰ� ������ ���� ��ȣ�� �޴´�.(hidden���� ������ ���� �޾Ƽ�???)
		 * 2. ���� �μ�(communityNo)�� dao�� �Ѱܼ� CommunityDTO ������ �޾� ��ȯ
		 */
		InfomationDTO infomationDTO = userEtcService.infoDetail(no);
	
		//������ ��ǰ �����ֱ�
		//List<ProductDTO> relatedProduct = userEtcService.infoRelatedProduct(infomationDTO.getName());
		ModelAndView mv = new ModelAndView();
		mv.addObject("info",infomationDTO);
		//mv.addObject("relatedProduct", relatedProduct);
		mv.setViewName("info/infoDetail");
		return mv;
	}

	// ���
	
	/**
	 * donation ������ ��
	 * ��ü�����Ȳ(5��) �������� �ٿ�ε�
	 * ��Ʈ
	 * */
	@RequestMapping("donationLoading")
	public ModelAndView donationLoading() {
		/**
		 * donate�� ������ �� ��ü ��� �������� �ֱٿ��� 5�� ������ ����� �������� �ٿ�ε尡 �ǵ��� �Ѵ�.
		 * �ؿ��� ��Ʈ�� �ִ´�. dao�� �ϳ��� �ް�, ǥ���ϴ� ����� �� ����(ǥ�� ��Ʈ)
		 * �̋� ǥ�� ����¡ �ʿ� ����. 
		 */
		List<DonationDTO> donationlist = null;
		ModelAndView mv = new ModelAndView();
		donationlist = userEtcService.donationLoading();
		mv.addObject("donationlist",donationlist);
		mv.setViewName("donate/donationLoading");
		
		// ��ξ�ü �ε� �ۼ��ؾ���
		DonationOrgDTO donationOrg = userEtcService.donationLoading2();
		mv.addObject("donationOrg", donationOrg);
		
		//System.out.println(donationOrg.getDesc());
		return mv;
	}
	
	
	
	// ����
	/**
	 * ������ �󼼺���
	 * ������ DTO, ����
	 * @return 
	 * */
	@RequestMapping("producerDetail")
	public ModelAndView producerDetail(int no) {
		/**
		 * 1.������ �󼼺��⸦ ������,������ �̸�, ����ó, ������ �̹��� ������ �޾ƿ´�.producerDTO������ �޴´�.
		 * 2.producer�� addr�ּҸ� ���� ������ ��ȯ�Ѵ�.
		 * 3.��ǥ ��ǰ�� producerDTO ������ �´� productDTO�� �޴´�. 
		 * 4.������ ���� api�� ���� �����Ѵ�.
		 */
		Map<String, Object> producer = userEtcService.producerDetail(no);
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("producer", producer);
		
		mv.setViewName("producerDetail");
		return mv;
	}
}
