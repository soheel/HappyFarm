package spring.web.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring.web.dao.ManageDao;
import spring.web.dto.CertificationDTO;
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
	/** 개별상품관리 클릭했을 때
	 * 상품범호 순서대로 (category_subcategory_no가 null이 아닌것만 가져오기) 리스트로
	 * */
	@Override
	public List<ProductDTO> selectAllProduct() {
		return manageDao.selectAllProduct();
	}

	/**
	 * 개별상품관리 등록(등록폼을 div로 띄워줌)
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
	 * 개별상품관리 등록(유기농 인증 번호 )
	 * */
	@Override
	public int productCertiRegisterManage(ProductCertificationDTO productCertificationDTO) {
		return manageDao.productCertiRegisterManage(productCertificationDTO);
	}
	@Override
	public List<CertificationDTO> selectCertification() {
		return manageDao.selectCertification();
	}
	
	/**
	 * 개별상품관리 수정폼에서 정보를 빼기 위해서 필요한 메소드 해당하는 제품의 정보를 select한다.
	 * 
	@Override
	public ProductDTO productInfoMangage(String productno) {
		return manageDao.productInfoMangage(productno);
	}
*/
	/**
	 * 개별상품관리 수정 정폼을 div로 띄워줌
	 * */
	@Override
	public int productModifyManage(ProductDTO productDTO) {
		return manageDao.productModifyManage(productDTO);
	}

	/**
	 * 개별상품관리 삭제  - 수정폼을 div로 띄워줌 (alert)
	 * */
	@Override
	public int productDeleteManage(int no) {
		return manageDao.productDeleteManage(no);
	}
	/**
	 * 세트상품관리 클릭했을 때  package DTO 리스트
	 * */
	@Override
	public List<PackageDTO> packageManage() {
		return manageDao.packageManage();
	}
	
	/**
	 * 세트상품 상세정보
	 * 해당 세트상품이 포함하고 있는 개별상품을 보여주기
	 * (새창)
	 * */
	@Override
	public List<String> packageShowManage(int packagePk) {
		return manageDao.packageShowManage(packagePk);
	}
	
	/**세트 상품 등록*/
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
	 * 상품검색은 상품이름을 입력하면, 검색된 것을 찾아 ajax로 밑에 있는 상품에 추가한다.
	 */
	@Override
	public List<ProductDTO> packageSearchProduct(String productname) {
		return manageDao.packageSearchProduct(productname);
	}
<<<<<<< HEAD
	/**
	 * 세트상품관리 수정폼에서 정보를 빼기 위해서 필요한 메소드 
	 * 해당하는 제품의 정보를 select한다.
	 */
	@Override
	public ProductDTO packageInfoManage(int packagePk) {
		return manageDao.packageInfoMangage(packagePk);
	}
=======

>>>>>>> origin/master

	/**
	 * 세트상품관리 수정
	 * */
	@Override
	public int packageModifyManage(ProductDTO product, String products) {
		// 1. update product
		int resultUpdate = manageDao.packageModifyManage(product);
		// 2. delete package
		int resultDelete = manageDao.packageModifyDeleteManage(product.getNo());
		// 3. insert package
		String[] str = products.split(",");
		for(String s : str) {
			int i = Integer.parseInt(s);
			int resultInsert = manageDao.packageModifyInsertManage(product.getNo(), i);
			if(resultInsert < 1) {
				return 0;
			}
		}
		return 1;
	}
	/**
	 * 세트상품관리 삭제
	 * */
	@Override
	public int packageDeleteManage(String name) {
		return manageDao.packageDeleteManage(name);
	}
	/**
	 * 생산자관리 눌렀을 때
	 * 생산자 DTO 리스트
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
	 * 생산자 등록
	 * */
	@Override
	public int producerRegisterManage(ProducerDTO producerDTO) {
		return manageDao.producerRegisterManage(producerDTO);
	}

	/**
	 * 생산자 수정을 위해 해당 생산자에 대한 정보를 불러와서 폼에 보여준다.
	 */
	@Override
	public ProducerDTO producerInfoMangage(int producerno) {
		return manageDao.producerInfoMangage(producerno);
	}

	/**
	 * 생산자 수정
	 * */
	@Override
	public int producerModifyManage(ProducerDTO producerDTO) {
		return manageDao.producerModifyManage(producerDTO);
	}
	
	/**
	 * 생산자 삭제
	 * */
	@Override
	public int producerDeleteManage(int no) {
		return manageDao.producerDeleteManage(no);
	}

	/**
	 * 회원관리
	 * 회원 DTO 리스트(오름차순)
	 * */
	@Override
	public List<MemberDTO> selectAllMember() {
		return manageDao.selectAllMember();
	}
	/**
	 * 회원관리(삭제)
	 * */
	@Override
	public int memberDeleteManage(String email) {
		return manageDao.memberDeleteManage(email);
	}
	/**
	 * 모임관리 클릭했을 때
	 * (회원측에서의 뷰랑 다름)
	 * 모임 DTO 리스트
	 * */
	@Override
	public List<CommunityDTO> communityManage() {
		return manageDao.communityManage();
	}

	/**
	 * 모임관리(등록)
	 * */
	@Override
	public int communityRegisterManage(CommunityDTO communityDTO) {
		return manageDao.communityRegisterManage(communityDTO);
	}
	/**
	 * 모임관리 수정을 위해 해당 모임에 대한 정보를 불러와서 폼에 보여준다.
	 */
	@Override
	public CommunityDTO communityShowMangage(int communityno) {
		return manageDao.communityShowMangage(communityno);
	}
	/**
	 * 모임관리(수정)
	 * */
	@Override
	public int communityModifyManage(CommunityDTO communityDTO) {
		return manageDao.communityModifyManage(communityDTO);
	}
	/**
	 * 모임관리(삭제)
	 * @return 
	 * */
	@Override
	public int communityDeleteManage(String communityno) {
		return manageDao.communityDeleteManage(communityno);
	}
	/**
	 * Q&A 관리 눌렀을 때
	 * qna DTO 리스트
	 * */
	@Override
	public List<QnaDTO> qnaManage() {
		return manageDao.qnaManage();
	}
	/**
	 * Q&A 답변 등록
	 * @return 
	 * */
	@Override
	public int qnaRegisterManage(CommunityCommentDTO communitycommentDTO) {
		return manageDao.qnaRegisterManage(communitycommentDTO);
	}
	/**
	 * 질문관리 수정을 위해 해당 질문에 대한 정보를 불러와서 폼에 보여준다.
	 
	@Override
	public QnaDTO qnaInfoMangage(QnaDTO qnaDTO) {
		return manageDao.qnaInfoMangage(qnaDTO);
	}*/
	/**
	 * Q&A 답변 수정
	 * */
	@Override
	public int qnaModifyManage(QnaDTO qnaDTO) {
		return manageDao.qnaModifyManage(qnaDTO);
	}
	/**
	 * Q&A 질문 삭제
	 * */
	@Override
	public int qnaDeleteManage(String communitycommentno) {
		return manageDao.qnaDeleteManage(communitycommentno);
	}
	/**
	 * 기부업체 관리
	 * 기부업체 DTO
	 * */
	@Override
	public List<DonationOrgDTO> donationOrgManage() {
		return manageDao.donationOrgManage();
	}
	/**
	 * 기부업체 관리(등록)
	 **/
	@Override
	public int donationOrgRegisterManage(DonationOrgDTO donationOrgDTO) {
		return manageDao.donationOrgRegisterManage(donationOrgDTO);
	}
	/**
	 * 기부 수정을 위해 해당 질문에 대한 정보를 불러와서 폼에 보여준다.
	 */
	@Override
	public DonationOrgDTO donationOrgShowMangage() {
		return manageDao.donationOrgShowMangage();
	}
	/**
	 * 기부업체 관리(수정)
	 * */
	@Override
	public int donationOrgModifyManage(DonationOrgDTO donationOrgDTO) {
		return manageDao.donationOrgModifyManage(donationOrgDTO);
	}
	/**
	 * 기부업체 관리(삭제)
	 * 기부업체 DTO
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
<<<<<<< HEAD
	public ProductDTO packageInfoMangage(String productno) {
		// TODO Auto-generated method stub
		return null;
	}
=======
	public Map<String, Object> packageModifyShowManage(int no) {
		Map<String, Object> map = new HashMap<String, Object>();
		PackageDTO packageDTO = manageDao.getPackageByPackageNo(no);
		List<Integer> productList = manageDao.getPackageProductNo(no);
		map.put("package", packageDTO);
		map.put("productList", productList);
		return map;
	}
	

	

	
>>>>>>> origin/master
}
