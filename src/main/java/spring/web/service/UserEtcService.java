package spring.web.service;

import java.util.List;

import org.springframework.web.servlet.ModelAndView;

import spring.web.dto.CommunityCommentDTO;
import spring.web.dto.CommunityDTO;
import spring.web.dto.DonationDTO;
import spring.web.dto.InfomationDTO;
import spring.web.dto.ProducerDTO;
import spring.web.dto.QnaDTO;

public interface UserEtcService {
	/**
	 * ���Ӹ�� �ҷ����� 
	 * ����DTO ����Ʈ(select + ����¡)
	 */
	List<CommunityDTO> communityLoading();	

	/**
	 * ���ӻ� ���� �ҷ����� 
	 */
	CommunityDTO communityDetail(String communityNo);
	/**
	 * Q&A ���
	 */
	int registerQnA(QnaDTO qnaDTO);
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
	InfomationDTO infoDetail(String qnano);
	/**
	 * ��� ��� 5�� + ��Ʈ �ε�
	 */
	List<DonationDTO> donationLoading();
	/**
	 * ������ ���� �ҷ�����(�̹��� + ���� + ����)
	 * @return
	 */
	ProducerDTO producerDetail();

	/**
	 * �������� ��縸 ��Ƽ� �ҷ�����)
	 * @return
	 */
	List<CommunityDTO> communityIngList();
	/**
	 * ��� ���� ���θ� ��ۿ� �Է��ϴ� ��, �� ��ۿ� ���� �������� �ҷ��´�
	 */
	List<CommunityCommentDTO> commmentList(String communityNo);

}
