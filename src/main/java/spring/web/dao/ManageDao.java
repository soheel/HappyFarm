package spring.web.dao;

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

public interface ManageDao {
	/** 개별상품관리 클릭했을 때
	 * 상품범호 순서대로 (category_subcategory_no가 null이 아닌것만 가져오기) 리스트로
	 * */
	List<ProductDTO> selectAllProduct();
	/**
	 * 개별상품관리 등록(등록폼을 div로 띄워줌)
	 * */
	int productRegisterManage(ProductDTO productDTO);
	
	
	/**
	 * 상품 수정을 위해 해당 상품에 대한 정보를 불러와서 폼에 보여준다.
	 */
	public ProductDTO productInfoMangage(int no);
	
	/**
	 * 개별상품관리 수정 정폼을 div로 띄워줌
	 * */
	int productModifyManage(ProductDTO productDTO);
	
	/**
	 * 개별상품관리 삭제  - 수정폼을 div로 띄워줌 (alert)
	 * */
	int productDeleteManage(int no);
	
	/**
	 * 세트상품관리 클릭했을 때  package DTO 리스트
	 * */
	List<PackageDTO> packageManage();
	
	/**
	 * 세트상품 상세정보
	 * 해당 세트상품이 포함하고 있는 개별상품을 보여주기
	 * (새창)
	 * */
	public List<String> packageShowManage(int packagePk);
	
	/**
	 * 상품검색은 상품이름을 입력하면, 검색된 것을 찾아 ajax로 밑에 있는 상품에 추가한다.
	 */
	List<ProductDTO> packageSearchProduct(String productname);
	
	/**
	 * 세트상품 등록
	 * */
	int packageRegisterManage(PackageDTO packageDTO);
	
	/**
	 * 세트상품관리 수정폼에서 정보를 빼기 위해서 필요한 메소드 
	 * 해당하는 제품의 정보를 select한다.
	 */
	ProductDTO packageInfoMangage(String productno);
	
	/**
	 * 세트상품관리 수정
	 * 수정폼을 div로 띄워줌
	 * */
	int packageModifyManage(Map<String, Object> modifyinfo);
	
	/**
	 * 세트상품관리 삭제
	 * 수정폼을 div로 띄워줌
	 * */
	int packageDeleteManage(String name);
	
	/**
	 * 방금 막 등록한 패키지 상품 번호 가져오기
	 * */
	int getRecentPackageNo();
	
	/**
	 * 패키지 상품 내의 개별 상품 등록
	 * */
	int packageProductRegisterManage(int packageNo, int productNo);
	
	/**
	 * 생산자관리 눌렀을 때
	 * 생산자 DTO 리스트
	 * */
	List<ProducerDTO> selectAllProducer();
	
	/**
	 * 생산자 등록
	 * */
	int producerRegisterManage(ProducerDTO producerDTO);
	
	/**
	 * 생산자 수정을 위해 해당 생산자에 대한 정보를 불러와서 폼에 보여준다.
	 */
	ProducerDTO producerInfoMangage(int producerno);
	
	/**
	 * 생산자 수정
	 * */
	int producerModifyManage(ProducerDTO producerDTO);
	
	/**
	 * 생산자 삭제
	 * */
	int producerDeleteManage(int no);
	
	
	/**
	 * 회원관리
	 * 회원 DTO 리스트(오름차순)
	 * */
	List<MemberDTO> selectAllMember();
	
	/**
	 * 회원관리(삭제)
	 * */
	int memberDeleteManage(String email);
	
	/**
	 * 모임관리 클릭했을 때
	 * (회원측에서의 뷰랑 다름)
	 * 모임 DTO 리스트
	 * */
	List<CommunityDTO> communityManage();
	
	/**
	 * 모임관리(등록)
	 * */
	int communityRegisterManage(CommunityDTO communityDTO);
	
	/**
	 * 모임관리 수정을 위해 해당 모임에 대한 정보를 불러와서 폼에 보여준다.
	 */
	CommunityDTO communityShowMangage(int communityno);
	
	/**
	 * 모임관리(수정)
	 * */
	int communityModifyManage(CommunityDTO communityDTO);
	
	/**
	 * 모임관리(삭제)
	 * */
	int communityDeleteManage(String communityno);
	
	/**
	 * Q&A 관리 눌렀을 때
	 * qna DTO 리스트
	 * */
	List<QnaDTO> qnaManage();
	
	/**
	 * Q&A 답변 등록
	 * @return 
	 * */
	int qnaRegisterManage(CommunityCommentDTO communitycommentDTO);
	
	/**
	 * 질문관리 수정을 위해 해당 질문에 대한 정보를 불러와서 폼에 보여준다.
	 
	QnaDTO qnaInfoMangage(String qnano);
	*/
	
	/**
	 * Q&A 답변 수정
	 * */
	int qnaModifyManage(QnaDTO qnaDTO);
	
	/**
	 * Q&A 질문 삭제
	 * */
	int qnaDeleteManage(String communitycommentno);
	
	/**
	 * 기부업체 관리
	 * 기부업체 DTO
	 * */
	List<DonationOrgDTO> donationOrgManage();
	
	/**
	 * 기부업체 관리(등록)
	 **/
	int donationOrgRegisterManage(DonationOrgDTO donationOrgDTO);
	
	/**
	 * 기부 수정을 위해 해당 질문에 대한 정보를 불러와서 폼에 보여준다.
	 */
	DonationOrgDTO donationOrgShowMangage();
	
	/**
	 * 기부업체 관리(수정)
	 * */
	int donationOrgModifyManage(DonationOrgDTO donationOrgDTO);
	
	/**
	 * 기부업체 관리(삭제)
	 * 기부업체 DTO
	 * */
	int donationOrgDeleteManage(int no);
	
	/**
	 * 생산자별 평점 리스트 가져오기
	 * */
	float getProducerEval(int producerNo);
	
	/**
	 * 월별 매출 가져오기
	 * */
	List<Integer> getMonthSales();
	
	/**
	 * 판매상품 비중 가져오기
	 * */
	List<HashMap<String, String>> getSalesProduct();
}
