package spring.web.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import spring.web.dto.CommunityDTO;
import spring.web.dto.DonationDTO;
import spring.web.dto.InfomationDTO;
import spring.web.dto.ProducerDTO;
import spring.web.dto.QnaDTO;
import spring.web.service.UserEtcService;

@Controller
@RequestMapping("/user")
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
		/**
		 * 1. commuity�� ������, 
		 * 2. 6���� ���� �����ϴ� ���� ���� 3����縦 �����༭ �� 9���� ��Ƽ�
		 * ��� �����ش�.
		 * 3. 6���� ������� / 3���� ���� ��縦 �̾��ִ� dao �� ���� �޼ҵ�� 
		 * ������ ��� �޼ҵ尡 �ʿ�. 
		 */
		List<CommunityDTO> communitylist = null;
		ModelAndView mv = new ModelAndView();
		communitylist = userEtcService.communityLoading();
		mv.addObject("communitylist",communitylist);
		mv.setViewName("showCommunity");
		return mv;
	}
	
	/**
	 * ���� �󼼺���
	 * ����DTO, ������ ���̵�ٿ� �������� ��� ��� ��������
	 * */
	@RequestMapping("communityDetail")
	public ModelAndView communityDetail(String communityNo) {
		Map<String, Object> communityInfo=null;
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
		CommunityDTO community = userEtcService.communityDetail(communityNo);
		
		//���� �������� ��縦 �����´�.
		List<CommunityDTO> communitylist = userEtcService.communityIngList();
		
		communityInfo.put("community", community);
		communityInfo.put("communitylist", communitylist);
		
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("communityInfo",communityInfo);
		mv.setViewName("showCommunityDetail");
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
		
		mv.setViewName("qnaLoading");
		return mv;
	}
	
	/**
	 * Q&A �۾���
	 * */
	@RequestMapping("qnaWrite")
	public String qnaWrite(HttpServletRequest request, QnaDTO qnaDTO) throws Exception{
		/**
		 * 1.Q&A write������ ������ �޾ƿͼ�
		 * 2.������ insert�� ��
		 * 3.Q&A �ε��ϴ� ȭ������ �̵��Ѵ�.
		 */
		int result = userEtcService.registerQnA(qnaDTO);
		if(result==0){
			request.setAttribute("errorMsg","�������� ���߽��ϴ�.");
			throw new Exception();
		}
		return "userEtc/qnaLoading";
		
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
		List<InfomationDTO> infolist = null;
		ModelAndView mv = new ModelAndView();
		infolist = userEtcService.infoLoading();
		mv.addObject("infolist",infolist);
		mv.setViewName("infoLoading");
		return mv;
	}
	
	/**
	 * info �󼼺���
	 * info DTO ��������
	 * @return 
	 * */
	@RequestMapping("infoDetail")
	public ModelAndView infoDetail(String qnano) {
		/**
		 * 1. ����ڰ� ������ ���� ��ȣ�� �޴´�.
		 * 2. ���� �μ�(communityNo)�� dao�� �Ѱܼ� CommunityDTO ������ �޾� ��ȯ
		 */
		InfomationDTO infomationDTO = userEtcService.infoDetail(qnano);
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("infomationDTO",infomationDTO);
		mv.setViewName("showCommunityDetail");
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
		 */
		List<DonationDTO> donationlist = null;
		ModelAndView mv = new ModelAndView();
		donationlist = userEtcService.donationLoading();
		mv.addObject("donationlist",donationlist);
		mv.setViewName("donationLoading");
		return mv;
	}
	
	// ����
	/**
	 * ������ �󼼺���
	 * ������ DTO, ����
	 * @return 
	 * */
	@RequestMapping("producerDetail")
	public ModelAndView producerDetail() {
		/**
		 * ������ �󼼺��⸦ ������,������ �̸�, ����ó, ������ �̹��� ������ �޾ƿ´�.producerDTO������ �޴´�.
		 * producer�� addr�ּҸ� ���� ������ ��ȯ�Ѵ�.
		 * ��ǥ ��ǰ�� producerDTO ������ �´� productDTO�� �޴´�. 
		 * ������ ���� api�� ���� �����Ѵ�.
		 */
		ProducerDTO producer = userEtcService.producerDetail();
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("producer", producer);
		
		mv.setViewName("producerDetail");
		return mv;
	}
}
