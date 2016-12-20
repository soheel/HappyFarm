package spring.web.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import spring.web.dto.CommunityCommentDTO;
import spring.web.dto.CommunityDTO;
import spring.web.dto.DonationDTO;
import spring.web.dto.DonationOrgDTO;
import spring.web.dto.MemberDTO;
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
	 * ��ǰ ������ ���� �ش� ��ǰ�� ���� ������ �ҷ��ͼ� ���� �����ش�.
	 */
	public ProductDTO productInfoMangage(int no);

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
	public List<String> packageShowManage(int packagePk);
	
	/**��Ű�� �߰�*/
	public int packageRegisterManage(PackageDTO packageDTO, List<Integer> list);
	
	
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
	public Map<String, Object> selectAllProducer();
	/**
	 * ������ ���
	 * */
	public int producerRegisterManage(ProducerDTO producerDTO);

	/**
	 * ������ ������ ���� �ش� �����ڿ� ���� ������ �ҷ��ͼ� ���� �����ش�.
	 */
	public ProducerDTO producerInfoMangage(int producerno);
	
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
	public List<MemberDTO> selectAllMember();
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
	public CommunityDTO communityShowMangage(int communityno);
	
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
	public List<DonationOrgDTO> donationOrgManage();
	/**
	 * ��ξ�ü ����(���)
	 * @return 
	 * */
	public int donationOrgRegisterManage(DonationOrgDTO donationOrgDTO);
	
	/**
	 * ��� ������ ���� �ش� ������ ���� ������ �ҷ��ͼ� ���� �����ش�.
	 */
	public DonationOrgDTO donationOrgShowMangage();
	
	
	/**
	 * ��ξ�ü ����(����)
	 * @return 
	 * */
	public int donationOrgModifyManage(DonationOrgDTO donationOrgDTO);
	
	
	/**
	 * ��ξ�ü ����(����)
	 * ��ξ�ü DTO
	 * @return 
	 * */
	public int donationOrgDeleteManage(int no);

	/**
	 * ���� ���� ��������
	 * */
	List<Integer> getMonthSales();
	
	/**
	 * �ǸŻ�ǰ ���� ��������
	 * */
	List<HashMap<String, String>> getSalesProduct();
}
