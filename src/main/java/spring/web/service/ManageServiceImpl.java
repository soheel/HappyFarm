package spring.web.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring.web.dao.ManageDao;
import spring.web.dto.CommunityCommentDTO;
import spring.web.dto.CommunityDTO;
import spring.web.dto.DonationDTO;
import spring.web.dto.DonationOrgDTO;
import spring.web.dto.MemberDTO;
import spring.web.dto.PackageDTO;
import spring.web.dto.ProducerDTO;
import spring.web.dto.ProductCertificationDTO;
import spring.web.dto.ProductDTO;
import spring.web.dto.QnaDTO;

@Service
public class ManageServiceImpl implements ManageService {

	@Autowired
	private ManageDao manageDao;
	/** ������ǰ���� Ŭ������ ��
	 * ��ǰ��ȣ ������� (category_subcategory_no�� null�� �ƴѰ͸� ��������) ����Ʈ��
	 * */
	@Override
	public List<ProductDTO> selectAllProduct() {
		return manageDao.selectAllProduct();
	}

	/**
	 * ������ǰ���� ���(������� div�� �����)
	 * */
	@Override
	public int productRegisterManage(ProductDTO productDTO) {
		return manageDao.productRegisterManage(productDTO);
	}
	@Override
	public int productNoFind(String name) {
		return manageDao.productNoFind(name);
	}
	
	/**
	 * ������ǰ���� ���(����� ���� ��ȣ )
	 * */
	@Override
	public int productCertiRegisterManage(ProductCertificationDTO productCertificationDTO) {
		return manageDao.productCertiRegisterManage(productCertificationDTO);
	}
	
	/**
	 * ������ǰ���� ���������� ������ ���� ���ؼ� �ʿ��� �޼ҵ� �ش��ϴ� ��ǰ�� ������ select�Ѵ�.
	 * 
	@Override
	public ProductDTO productInfoMangage(String productno) {
		return manageDao.productInfoMangage(productno);
	}
*/
	/**
	 * ������ǰ���� ���� ������ div�� �����
	 * */
	@Override
	public int productModifyManage(ProductDTO productDTO) {
		return manageDao.productModifyManage(productDTO);
	}

	@Override
	public int productCertiModifyManage(ProductCertificationDTO productCertificationDTO) {
		return manageDao.productCertiModifyManage(productCertificationDTO);
	}
	
	/**
	 * ������ǰ���� ����  - �������� div�� ����� (alert)
	 * */
	@Override
	public int productDeleteManage(int no) {
		return manageDao.productDeleteManage(no);
	}
	/**
	 * ��Ʈ��ǰ���� Ŭ������ ��  package DTO ����Ʈ
	 * */
	@Override
	public List<PackageDTO> packageManage() {
		return manageDao.packageManage();
	}
	
	/**
	 * ��Ʈ��ǰ ������
	 * �ش� ��Ʈ��ǰ�� �����ϰ� �ִ� ������ǰ�� �����ֱ�
	 * (��â)
	 * */
	@Override
	public List<String> packageShowManage(int packagePk) {
		return manageDao.packageShowManage(packagePk);
	}
	
	/**��Ʈ ��ǰ ���*/
	@Override
	public int packageRegisterManage(PackageDTO packageDTO, List<Integer> list) {
		int result = manageDao.packageRegisterManage(packageDTO);
		if(result >= 1) {
			int recentPackageNo = manageDao.getRecentPackageNo();
			System.out.println("recentPackageNo : " + recentPackageNo);
			
			for(int productNo : list) {
				int result2 = manageDao.packageProductRegisterManage(recentPackageNo, productNo);
				
				if(result2 < 1) {
					return 0;
				}
			}
		}
		return 1;
	}
	
	

	/**
	 * ��ǰ�˻��� ��ǰ�̸��� �Է��ϸ�, �˻��� ���� ã�� ajax�� �ؿ� �ִ� ��ǰ�� �߰��Ѵ�.
	 */
	@Override
	public List<ProductDTO> packageSearchProduct(String productname) {
		return manageDao.packageSearchProduct(productname);
	}
	/**
	 * ��Ʈ��ǰ���� ���������� ������ ���� ���ؼ� �ʿ��� �޼ҵ� 
	 * �ش��ϴ� ��ǰ�� ������ select�Ѵ�.
	 */
	@Override
	public ProductDTO packageInfoMangage(int packagePk) {
		return manageDao.packageInfoMangage(packagePk);
	}

	/**
	 * ��Ʈ��ǰ���� ����
	 * �������� div�� �����
	 * */
	@Override
	public int packageModifyManage(Map<String, Object> modifyinfo) {
		return manageDao.packageModifyManage(modifyinfo);
	}
	/**
	 * ��Ʈ��ǰ���� ����
	 * */
	@Override
	public int packageDeleteManage(String name) {
		return manageDao.packageDeleteManage(name);
	}
	/**
	 * �����ڰ��� ������ ��
	 * ������ DTO ����Ʈ
	 * */
	@Override
	public Map<String, Object> selectAllProducer() {
		
		Map<String, Object> map = new HashMap<String, Object>();
		List<ProducerDTO> producerDTOList = manageDao.selectAllProducer();
		List<Integer> producerNoList = new ArrayList<Integer>();
		for(ProducerDTO producer : producerDTOList) {
			producerNoList.add(producer.getNo());
		}
		List<Float> evalList = new ArrayList<Float>();
		for(int i : producerNoList) {
			evalList.add(manageDao.getProducerEval(i));
		}
		
		map.put("producerList", producerDTOList);
		map.put("evalList", evalList);
		return map;
	}

	/**
	 * ������ ���
	 * */
	@Override
	public int producerRegisterManage(ProducerDTO producerDTO) {
		return manageDao.producerRegisterManage(producerDTO);
	}

	/**
	 * ������ ������ ���� �ش� �����ڿ� ���� ������ �ҷ��ͼ� ���� �����ش�.
	 */
	@Override
	public ProducerDTO producerInfoMangage(int producerno) {
		return manageDao.producerInfoMangage(producerno);
	}

	/**
	 * ������ ����
	 * */
	@Override
	public int producerModifyManage(ProducerDTO producerDTO) {
		return manageDao.producerModifyManage(producerDTO);
	}
	
	/**
	 * ������ ����
	 * */
	@Override
	public int producerDeleteManage(int no) {
		return manageDao.producerDeleteManage(no);
	}

	/**
	 * ȸ������
	 * ȸ�� DTO ����Ʈ(��������)
	 * */
	@Override
	public List<MemberDTO> selectAllMember() {
		return manageDao.selectAllMember();
	}
	/**
	 * ȸ������(����)
	 * */
	@Override
	public int memberDeleteManage(String email) {
		return manageDao.memberDeleteManage(email);
	}
	/**
	 * ���Ӱ��� Ŭ������ ��
	 * (ȸ���������� ��� �ٸ�)
	 * ���� DTO ����Ʈ
	 * */
	@Override
	public List<CommunityDTO> communityManage() {
		return manageDao.communityManage();
	}

	/**
	 * ���Ӱ���(���)
	 * */
	@Override
	public int communityRegisterManage(CommunityDTO communityDTO) {
		return manageDao.communityRegisterManage(communityDTO);
	}
	/**
	 * ���Ӱ��� ������ ���� �ش� ���ӿ� ���� ������ �ҷ��ͼ� ���� �����ش�.
	 */
	@Override
	public CommunityDTO communityShowMangage(int communityno) {
		return manageDao.communityShowMangage(communityno);
	}
	/**
	 * ���Ӱ���(����)
	 * */
	@Override
	public int communityModifyManage(CommunityDTO communityDTO) {
		return manageDao.communityModifyManage(communityDTO);
	}
	/**
	 * ���Ӱ���(����)
	 * @return 
	 * */
	@Override
	public int communityDeleteManage(String communityno) {
		return manageDao.communityDeleteManage(communityno);
	}
	/**
	 * Q&A ���� ������ ��
	 * qna DTO ����Ʈ
	 * */
	@Override
	public List<QnaDTO> qnaManage() {
		return manageDao.qnaManage();
	}
	/**
	 * Q&A �亯 ���
	 * @return 
	 * */
	@Override
	public int qnaRegisterManage(CommunityCommentDTO communitycommentDTO) {
		return manageDao.qnaRegisterManage(communitycommentDTO);
	}
	/**
	 * �������� ������ ���� �ش� ������ ���� ������ �ҷ��ͼ� ���� �����ش�.
	 
	@Override
	public QnaDTO qnaInfoMangage(QnaDTO qnaDTO) {
		return manageDao.qnaInfoMangage(qnaDTO);
	}*/
	/**
	 * Q&A �亯 ����
	 * */
	@Override
	public int qnaModifyManage(QnaDTO qnaDTO) {
		return manageDao.qnaModifyManage(qnaDTO);
	}
	/**
	 * Q&A ���� ����
	 * */
	@Override
	public int qnaDeleteManage(String communitycommentno) {
		return manageDao.qnaDeleteManage(communitycommentno);
	}
	/**
	 * ��ξ�ü ����
	 * ��ξ�ü DTO
	 * */
	@Override
	public List<DonationOrgDTO> donationOrgManage() {
		return manageDao.donationOrgManage();
	}
	/**
	 * ��ξ�ü ����(���)
	 **/
	@Override
	public int donationOrgRegisterManage(DonationOrgDTO donationOrgDTO) {
		return manageDao.donationOrgRegisterManage(donationOrgDTO);
	}
	/**
	 * ��� ������ ���� �ش� ������ ���� ������ �ҷ��ͼ� ���� �����ش�.
	 */
	@Override
	public DonationOrgDTO donationOrgShowMangage() {
		return manageDao.donationOrgShowMangage();
	}
	/**
	 * ��ξ�ü ����(����)
	 * */
	@Override
	public int donationOrgModifyManage(DonationOrgDTO donationOrgDTO) {
		return manageDao.donationOrgModifyManage(donationOrgDTO);
	}
	/**
	 * ��ξ�ü ����(����)
	 * ��ξ�ü DTO
	 * */
	@Override
	public int donationOrgDeleteManage(int no) {
		return manageDao.donationOrgDeleteManage(no);
	}

	@Override
	public ProductDTO productInfoMangage(int no) {
		return manageDao.productInfoMangage(no);
	}

	@Override
	public List<Integer> getMonthSales() {
		return manageDao.getMonthSales();
	}

	@Override
	public List<HashMap<String, String>> getSalesProduct() {
		return manageDao.getSalesProduct();
	}

	

	@Override
	public ProductDTO packageInfoMangage(String productno) {
		// TODO Auto-generated method stub
		return null;
	}

	

	
}
