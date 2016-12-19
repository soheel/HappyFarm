package spring.web.dao;

import java.util.List;

import javax.servlet.http.HttpSession;

import spring.web.dto.CartDTO;
import spring.web.dto.CertificationDTO;
import spring.web.dto.PackageDTO;
import spring.web.dto.ProducerDTO;
import spring.web.dto.ProductCertificationDTO;
import spring.web.dto.ProductCommentDTO;
import spring.web.dto.ProductDTO;
import spring.web.dto.PurchaseDTO;
import spring.web.dto.PurchaseOrderDTO;
import spring.web.dto.PurchaseProductDTO;

public interface UserProductDAO {
	
	/**
	 * shopMenuLoading()
	 * 인기상품 3개 가져오기
	 * */
	List<Integer> getBestProduct();
	
	/**
	 * showMenuLoading()
	 * 최근구매상품 3개 가져오기
	 * */
	List<Integer> getRecentPurchase(String email);
	
	/**
	 * showMenuListLoading(int categoryNo)
	 * 카테고리에 해당하는 상품 리스트 가져오기
	 * */
	List<ProductDTO> getProductByCategory(int categoryNo);
	
	/**
	 * showProductDetail(int productNo) / order(int productNo, int num)
	 * productNo로 ProductDTO 가져오기
	 * */
	ProductDTO getProductByProductNo(int productNo);

	/**
	 * showProductDetail(int productNo) / order(int productNo, int num)
	 * productNo로 ProducerDTO 가져오기
	 * */
	ProducerDTO getProducerByProductNo(int productNo);

	/**
	 * showProductDetail(int productNo)
	 * productNo로 ProductCommentDTO 리스트 가져오기
	 * */
	List<ProductCommentDTO> getProductCommentByProductNo(int productNo);

	
	/**
	 * showProductDetail(int productNo)
	 * productNo로 CertificationDTO 가져오기
	 * */
	List<CertificationDTO> getCertificationByProductNo(int productNo);
	
	/**
	 * showProducerInfo(int producerNo)
	 * producerNo로 ProducerDTO 가져오기
	 * */
	ProducerDTO getProducerByProducerNo(int producerNo);
	
	/**
	 * 상품 상세보기에서 해당 상품의 카테고리 가져오기
	 * */
	String getCategoryName(int subcategoryNo);
	
	/**
	 * 유기농 인증 정보 불러오기
	 */
	List<ProductCertificationDTO> showCertificationInfo(int no);
	
	/**
	 * addCart(int productNo, int num, HttpSession session)
	 * 상품상세보기에서 장바구니에 추가
	 * */
	int registerProductToCart(CartDTO cartDTO);
	
	/**
	 * addCartDirect(int productNo, HttpSession session)
	 * 상품리스트에서 장바구니에 추가
	 * */
	int registerProductToCartDirect(CartDTO cartDTO);
	
	/**
	 * packageMenuListLoading()
	 * 패키지 상품 리스트 가져오기
	 * */
	List<ProductDTO> getPackageList();
	
	/**
	 * 패키지 상품 상세보기
	 * */
	ProductDTO getPackageDetail();
	
	/**
	 * 패키지 상품 내에 포함되어 있는 상품들 띄워주기
	 * */
	List<ProductDTO> getPackageInnerProductList();
	
	/**
	 * search(String keyword)
	 * 검색하기
	 * */
	List<ProductDTO> search(String keyword);
	
	/**
	 * 내 마일리지 가져오기
	 * */
	int getMileage(String email);
	
	/**
	 * purchase 테이블에 삽입
	 * */
	int registerPurchase(PurchaseDTO purchaseDTO);
	
	/**
	 * purchase_order 테이블에 삽입
	 * */
	int registerPurchaseOrder(PurchaseOrderDTO purchaseOrderDTO);
	
	/**
	 * purchase_product 테이블에 삽입
	 * */
	int registerPurchaseProduct(PurchaseProductDTO purchaseProductDTO);
	
	/**
	 * purchase 테이블에서 가장 최근에 추가한 purchase_no 가져오기
	 * */
	int getRecentPurchaseNo();
	
	/**
	 * 카드, 실시간, 휴대폰 결제시 purchase_state_no 바꾸기
	 * */
	int setPurchaseStateNo(int no);

	
}