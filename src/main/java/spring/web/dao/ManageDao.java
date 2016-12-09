package spring.web.dao;

import java.util.List;
import java.util.Map;

import spring.web.dto.CommunityCommentDTO;
import spring.web.dto.CommunityDTO;
import spring.web.dto.DonationDTO;
import spring.web.dto.PackageDTO;
import spring.web.dto.ProducerDTO;
import spring.web.dto.ProductDTO;
import spring.web.dto.QnaDTO;

public interface ManageDao {
	/** ������ǰ���� Ŭ������ ��
	 * ��ǰ��ȣ ������� (category_subcategory_no�� null�� �ƴѰ͸� ��������) ����Ʈ��
	 * */
	List<ProductDTO> selectAllProduct();
	/**
	 * ������ǰ���� ���(������� div�� �����)
	 * */
	int productRegisterManage(ProductDTO productDTO);
	
	
	/**
	 * ������ǰ���� ���������� ������ ���� ���ؼ� �ʿ��� �޼ҵ� �ش��ϴ� ��ǰ�� ������ select�Ѵ�.
	 *
	ProductDTO productInfoMangage(String productno);
	 */
	
	/**
	 * ������ǰ���� ���� ������ div�� �����
	 * */
	int productModifyManage(ProductDTO productDTO);
	
	/**
	 * ������ǰ���� ����  - �������� div�� ����� (alert)
	 * */
	int productDeleteManage(int no);
	
	/**
	 * ��Ʈ��ǰ���� Ŭ������ ��  package DTO ����Ʈ
	 * */
	List<PackageDTO> packageManage();
	
	/**
	 * ��Ʈ��ǰ ������
	 * �ش� ��Ʈ��ǰ�� �����ϰ� �ִ� ������ǰ�� �����ֱ�
	 * (��â)
	 * */
	List<ProductDTO> packageShowManage(String packagename);
	
	/**
	 * ��ǰ�˻��� ��ǰ�̸��� �Է��ϸ�, �˻��� ���� ã�� ajax�� �ؿ� �ִ� ��ǰ�� �߰��Ѵ�.
	 */
	ProductDTO packageSearchProduct(String productname);
	
	/** ��Ʈ ��ǰ ���*/
	int packageRegisterManage(Map<String, Object> packageRegister);
	
	/**
	 * ��Ʈ��ǰ���� ���������� ������ ���� ���ؼ� �ʿ��� �޼ҵ� 
	 * �ش��ϴ� ��ǰ�� ������ select�Ѵ�.
	 */
	ProductDTO packageInfoMangage(String productno);
	
	/**
	 * ��Ʈ��ǰ���� ����
	 * �������� div�� �����
	 * */
	int packageModifyManage(Map<String, Object> modifyinfo);
	
	/**
	 * ��Ʈ��ǰ���� ����
	 * �������� div�� �����
	 * */
	int packageDeleteManage(String name);
	
	/**
	 * �����ڰ��� ������ ��
	 * ������ DTO ����Ʈ
	 * */
	List<ProductDTO> selectAllProducer();
	
	/**
	 * ������ ���
	 * */
	int producerRegisterManage(ProducerDTO producerDTO);
	
	/**
	 * ������ ������ ���� �ش� �����ڿ� ���� ������ �ҷ��ͼ� ���� �����ش�.
	 */
	ProducerDTO producerInfoMangage(String producerno);
	
	/**
	 * ������ ����
	 * */
	int producerModifyManage(ProducerDTO producerDTO);
	
	/**
	 * ������ ����
	 * */
	int producerDeleteManage(int no);
	
	
	/**
	 * ȸ������
	 * ȸ�� DTO ����Ʈ(��������)
	 * */
	List<ProductDTO> selectAllMember();
	
	/**
	 * ȸ������(����)
	 * */
	int memberDeleteManage(String email);
	
	/**
	 * ���Ӱ��� Ŭ������ ��
	 * (ȸ���������� ��� �ٸ�)
	 * ���� DTO ����Ʈ
	 * */
	List<CommunityDTO> communityManage();
	
	/**
	 * ���Ӱ���(���)
	 * */
	int communityRegisterManage(CommunityDTO communityDTO);
	
	/**
	 * ���Ӱ��� ������ ���� �ش� ���ӿ� ���� ������ �ҷ��ͼ� ���� �����ش�.
	 */
	CommunityDTO communityInfoMangage(String communityno);
	
	/**
	 * ���Ӱ���(����)
	 * */
	int communityModifyManage(CommunityDTO communityDTO);
	
	/**
	 * ���Ӱ���(����)
	 * */
	int communityDeleteManage(String communityno);
	
	/**
	 * Q&A ���� ������ ��
	 * qna DTO ����Ʈ
	 * */
	List<QnaDTO> qnaManage();
	
	/**
	 * Q&A �亯 ���
	 * @return 
	 * */
	int qnaRegisterManage(CommunityCommentDTO communitycommentDTO);
	
	/**
	 * �������� ������ ���� �ش� ������ ���� ������ �ҷ��ͼ� ���� �����ش�.
	 
	QnaDTO qnaInfoMangage(String qnano);
	*/
	
	/**
	 * Q&A �亯 ����
	 * */
	int qnaModifyManage(QnaDTO qnaDTO);
	
	/**
	 * Q&A ���� ����
	 * */
	int qnaDeleteManage(String communitycommentno);
	
	/**
	 * ��ξ�ü ����
	 * ��ξ�ü DTO
	 * */
	List<DonationDTO> donationOrgManage();
	
	/**
	 * ��ξ�ü ����(���)
	 **/
	int donationOrgRegisterManage(DonationDTO donationDTO);
	
	/**
	 * ��� ������ ���� �ش� ������ ���� ������ �ҷ��ͼ� ���� �����ش�.
	 */
	DonationDTO donationOrgInfoMangage(String donationOrgno);
	
	/**
	 * ��ξ�ü ����(����)
	 * */
	int donationOrgModifyManage(DonationDTO donationDTO);
	
	/**
	 * ��ξ�ü ����(����)
	 * ��ξ�ü DTO
	 * */
	int donationOrgDeleteManage(int no);
	
	
	
	
	
}
