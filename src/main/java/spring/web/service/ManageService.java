package spring.web.service;

import java.util.List;
import java.util.Map;

import spring.web.dto.CommunityCommentDTO;
import spring.web.dto.CommunityDTO;
import spring.web.dto.DonationDTO;
import spring.web.dto.PackageDTO;
import spring.web.dto.ProducerDTO;
import spring.web.dto.ProductDTO;
import spring.web.dto.QnaDTO;

public interface ManageService {

	/**
	 * ������ǰ���� Ŭ������ ��
	 * ��ǰ��ȣ ������� (category_subcategory_no�� null�� �ƴѰ͸� ��������)
	 * ����Ʈ��
	 * */
	public List<ProductDTO> selectAllProduct();
	
	/**
	 * ������ǰ���� ���
	 * ������� div�� �����
	 * */
	public int productRegisterManage(ProductDTO productDTO);
	
	/**
	 * ������ǰ���� ���������� ������ ���� ���ؼ� �ʿ��� �޼ҵ� 
	 * �ش��ϴ� ��ǰ�� ������ select�Ѵ�.
	 
	public ProductDTO productInfoMangage(String productno);
	*/
	
	/**
	 * ������ǰ���� ����
	 * �������� div�� �����
	 * */
	public int productModifyManage(ProductDTO productDTO);

	/**
	 * ������ǰ���� ����
	 * �������� div�� ����� (alert)
	 * */
	public int productDeleteManage(int no);
	
	/**
	 * ��Ʈ��ǰ���� Ŭ������ ��
	 * package DTO ����Ʈ
	 * @return 
	 * */
	public List<PackageDTO> packageManage();
	/**
	 * ��Ʈ��ǰ ������
	 * �ش� ��Ʈ��ǰ�� �����ϰ� �ִ� ������ǰ�� �����ֱ�
	 * (��â)
	 * */
	public List<ProductDTO> packageShowManage(String packagename);
	
	/**��Ű�� �߰�*/
	public int packageRegisterManage(PackageDTO packageDTO);
	
	
	/**
	 * ��ǰ�˻��� ��ǰ�̸��� �Է��ϸ�, �˻��� ���� ã�� ajax�� �ؿ� �ִ� ��ǰ�� �߰��Ѵ�.
	 */
	public List<ProductDTO> packageSearchProduct(String productname);
	
	/** div�� ������ �ҷ��ͼ� ...
	 * //���������� product�� �ش��ϴ� productname�� �ش��ϴ� ��ǰ dto�� ���� ������ �޾� ���� ���� �ʿ��� �޼ҵ�		
		ProductDTO product = manageService.selectByPackageName(productDTO)
	 * ��Ʈ��ǰ���� ���������� ������ ���� ���ؼ� �ʿ��� �޼ҵ� 
	 * �ش��ϴ� ��ǰ�� ������ select�Ѵ�.
	 */
	public ProductDTO packageInfoMangage(String productno);
	
	/**
	 * ��Ʈ��ǰ���� ����
	 * �������� div�� �����
	 * */
	public int packageModifyManage(Map<String, Object> modifyinfo);
	
	/**
	 * ��Ʈ��ǰ���� ����
	 * �������� div�� �����
	 * */
	public int packageDeleteManage(String name);
	
	/**
	 * �����ڰ��� ������ ��
	 * ������ DTO ����Ʈ
	 * */
	public List<ProductDTO> selectAllProducer();
	/**
	 * ������ ���
	 * */
	public int producerRegisterManage(ProducerDTO producerDTO);

	/**
	 * ������ ������ ���� �ش� �����ڿ� ���� ������ �ҷ��ͼ� ���� �����ش�.
	 */
	public ProducerDTO producerInfoMangage(String producerno);
	
	/**
	 * ������ ����
	 * */
	public int producerModifyManage(ProducerDTO producerDTO);
	
	/**
	 * ������ ����
	 * */
	int producerDeleteManage(int no);
	/**
	 * ȸ������
	 * ȸ�� DTO ����Ʈ(��������)
	 * */
	public List<ProductDTO> selectAllMember();
	/**
	 * ȸ������(����)
	 * */
	public int memberDeleteManage(String email);
	
	/**
	 * ���Ӱ��� Ŭ������ ��
	 * (ȸ���������� ��� �ٸ�)
	 * ���� DTO ����Ʈ
	 * @return 
	 * */
	public List<CommunityDTO> communityManage();
	
	/**
	 * ���Ӱ���(���)
	 * */
	public int communityRegisterManage(CommunityDTO communityDTO);
	
	/**
	 * ���Ӱ��� ������ ���� �ش� ���ӿ� ���� ������ �ҷ��ͼ� ���� �����ش�.
	 */
	public CommunityDTO communityInfoMangage(String communityno);
	
	/**
	 * ���Ӱ���(����)
	 * @return 
	 * */
	public int communityModifyManage(CommunityDTO communityDTO);
	
	/**
	 * ���Ӱ���(����)
	 * @return 
	 * */
	public int communityDeleteManage(String communityno);
	/**
	 * Q&A ���� ������ ��
	 * qna DTO ����Ʈ
	 * */
	public List<QnaDTO> qnaManage();
	
	/**
	 * Q&A �亯 ���
	 * @return 
	 * */
	public int qnaRegisterManage(CommunityCommentDTO communitycommentDTO);
	
	/**
	 * �������� ������ ���� �ش� ������ ���� ������ �ҷ��ͼ� ���� �����ش�.
	 
	public QnaDTO qnaInfoMangage(String qnano);*/
	/**
	 * Q&A �亯 ����
	 * */
	public int qnaModifyManage(QnaDTO qnaDTO);
	/**
	 * Q&A ���� ����
	 * */
	public int qnaDeleteManage(String communitycommentno);
	
	/**
	 * ��ξ�ü ����
	 * ��ξ�ü DTO
	 * @return 
	 * */
	public List<DonationDTO> donationOrgManage();
	/**
	 * ��ξ�ü ����(���)
	 * @return 
	 * */
	public int donationOrgRegisterManage(DonationDTO donationDTO);
	
	/**
	 * ��� ������ ���� �ش� ������ ���� ������ �ҷ��ͼ� ���� �����ش�.
	 */
	public DonationDTO donationOrgInfoMangage(String donationOrgno);
	
	
	/**
	 * ��ξ�ü ����(����)
	 * @return 
	 * */
	public int donationOrgModifyManage(DonationDTO donationDTO);
	
	
	/**
	 * ��ξ�ü ����(����)
	 * ��ξ�ü DTO
	 * @return 
	 * */
	public int donationOrgDeleteManage(int no);

	

	

	

	
	

}
