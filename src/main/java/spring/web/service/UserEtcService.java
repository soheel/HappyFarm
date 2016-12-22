package spring.web.service;

import java.util.List;
import java.util.Map;

import org.springframework.web.servlet.ModelAndView;

import spring.web.dto.CommunityCommentDTO;
import spring.web.dto.CommunityDTO;
import spring.web.dto.DonationDTO;
import spring.web.dto.DonationOrgDTO;
import spring.web.dto.InfomationDTO;
import spring.web.dto.ProducerDTO;
import spring.web.dto.ProductDTO;
import spring.web.dto.QnaDTO;

public interface UserEtcService {
	/**
	 * ���Ӹ�� �ҷ����� 
	 * ����DTO ����Ʈ(select + ����¡)
	 * @param communityDTO 
	 */
	Map<String, Object> communityLoading();	

	/**
	 * ���ӻ� ���� �ҷ����� 
	 */
	Map<String, Object> communityDetail(int no);
	/**
	 * Q&A ���
	 */
	int registerQnA(QnaDTO qnaDto);
	/**
	 * Q&A ������� �߰� + ��� 
	 * @return
	 */
	List<QnaDTO> qnaLoading();

	/**
	 * ��� ���� �ε�
	 * @return
	 */
	List<InfomationDTO> infoLoading();
	/**
	 * ��� �� ���� �ε�
	 */
	InfomationDTO infoDetail(int no);
	
	/**
	 * ���� ���õ� ��ǰ �����ֱ�
	 */
	List<ProductDTO> infoRelatedProduct(String name);

	
	/**
	 * ��� ��� 5�� + ��Ʈ �ε�
	 */
	List<DonationDTO> donationLoading();
	/**
	 * ������ ���� �ҷ�����(�̹��� + ���� + ����)
	 * @return
	 */
	Map<String, Object> producerDetail(int no);

	/**
	 * �������� ��縸 ��Ƽ� �ҷ�����)
	 * @return
	
	List<CommunityDTO> communityIngList();
	
	 * ��� ���� ���θ� ��ۿ� �Է��ϴ� ��, �� ��ۿ� ���� �������� �ҷ��´�
	
	List<CommunityCommentDTO> commmentList(int no);
	 */
	
	/**
	 * ��� ���� �Է�
	 * @param comment
	 * @param communityNo
	 * @return
	 */
	int communityReply(String comment, int communityNo, String email);
	
	/**
	 * ��� ���� ����
	 * @param no
	 * @return
	 */
	int communityReplyDelete(int no);
	
	/**
	 * admin ��� ���� �Է�
	 * @param no
	 * @param comment
	 * @param communityNo
	 * @return
	 */
	int communityReplyInsert(int no, String comment, int communityNo, String email);
	
	/**
	 * ��� ���� ����
	 * @param no
	 * @param comment
	 * @return
	 */
	int communityReplyUpdate(int no, String comment);
	
	/**
	 * ��δ�ü����
	 * */
	DonationOrgDTO donationLoading2();

}
