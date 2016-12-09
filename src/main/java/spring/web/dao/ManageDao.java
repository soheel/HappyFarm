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
	/** 개별상품관리 클릭했을 때
	 * 상품범호 순서대로 (category_subcategory_no가 null이 아닌것만 가져오기) 리스트로
	 * */
	List<ProductDTO> selectAllProduct();
	/**
	 * 개별상품관리 등록(등록폼을 div로 띄워줌)
	 * */
	int productRegisterManage(ProductDTO productDTO);
	
	
	/**
	 * 개별상품관리 수정폼에서 정보를 빼기 위해서 필요한 메소드 해당하는 제품의 정보를 select한다.
	 *
	ProductDTO productInfoMangage(String productno);
	 */
	
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
	List<ProductDTO> packageShowManage(String packagename);
	
	/**
	 * 상품검색은 상품이름을 입력하면, 검색된 것을 찾아 ajax로 밑에 있는 상품에 추가한다.
	 */
	ProductDTO packageSearchProduct(String productname);
	
	/** 세트 상품 등록*/
	int packageRegisterManage(Map<String, Object> packageRegister);
	
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
	 * 생산자관리 눌렀을 때
	 * 생산자 DTO 리스트
	 * */
	List<ProductDTO> selectAllProducer();
	
	/**
	 * 생산자 등록
	 * */
	int producerRegisterManage(ProducerDTO producerDTO);
	
	/**
	 * 생산자 수정을 위해 해당 생산자에 대한 정보를 불러와서 폼에 보여준다.
	 */
	ProducerDTO producerInfoMangage(String producerno);
	
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
	List<ProductDTO> selectAllMember();
	
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
	CommunityDTO communityInfoMangage(String communityno);
	
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
	List<DonationDTO> donationOrgManage();
	
	/**
	 * 기부업체 관리(등록)
	 **/
	int donationOrgRegisterManage(DonationDTO donationDTO);
	
	/**
	 * 기부 수정을 위해 해당 질문에 대한 정보를 불러와서 폼에 보여준다.
	 */
	DonationDTO donationOrgInfoMangage(String donationOrgno);
	
	/**
	 * 기부업체 관리(수정)
	 * */
	int donationOrgModifyManage(DonationDTO donationDTO);
	
	/**
	 * 기부업체 관리(삭제)
	 * 기부업체 DTO
	 * */
	int donationOrgDeleteManage(int no);
	
	
	
	
	
}
