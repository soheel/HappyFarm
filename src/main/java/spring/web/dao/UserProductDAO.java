package spring.web.dao;

import java.util.List;

import javax.servlet.http.HttpSession;

import spring.web.dto.CartDTO;
import spring.web.dto.CertificationDTO;
import spring.web.dto.PackageDTO;
import spring.web.dto.ProducerDTO;
import spring.web.dto.ProductCommentDTO;
import spring.web.dto.ProductDTO;

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
	List<Integer> getRecentPurchase();
	
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
	 * productNo로 ProductCommentDTO 가져오기
	 * */
	ProductCommentDTO getProductCommentByProductNo(int productNo);

	/**
	 * showProductDetail(int productNo)
	 * productNo로 CertificationDTO 가져오기
	 * */
	CertificationDTO getCertificationByProductNo(int productNo);
	
	/**
	 * showProducerInfo(int producerNo)
	 * producerNo로 ProducerDTO 가져오기
	 * */
	ProducerDTO getProducerByProducerNo(int producerNo);
	
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
	 * search(String keyword)
	 * 검색하기
	 * */
	List<ProductDTO> search(String keyword);
}
