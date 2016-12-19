package spring.web.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import spring.web.dto.CartDTO;
import spring.web.dto.CartProductDTO;
import spring.web.dto.PackageDTO;
import spring.web.dto.ProducerDTO;
import spring.web.dto.ProductCertificationDTO;
import spring.web.dto.ProductDTO;
import spring.web.dto.PurchaseDTO;
import spring.web.dto.PurchaseOrderDTO;
import spring.web.dto.PurchaseProductDTO;
import spring.web.dto.PurchaseProductListDTO;

public interface UserProductService {
	
	public List<ProductDTO> shopMenuLoading(String email);
	
	public List<ProductDTO> showMenuListLoading(int categoryNo);
	
	public Map<String, Object> showProductDetail(int productNo);
	
	public List<ProductCertificationDTO> showCertificationInfo(int no);
	
	public ProducerDTO showProducerInfo(int producerNo);
	
	public int addCart(CartDTO cart);
	
	public int addCartDirect(CartDTO cart);
	
	public Map<String, Object> order(int productNo, int num);
	
	public List<ProductDTO> packageMenuListLoading();
	
	public List<ProductDTO> search(String keyword);
	
	/**
	 * 패키지 상품 상세보기
	 * */
	Map<String, Object> getPackageDetail();
	
	/**
	 * purchase
	 * productDTO, producerDTO를 map에 넣어 반환
	 * */
	Map<String, Object> showPurchase(int productNo, int producerNo, String email);
	
	/**
	 * 결제
	 * */
	int pay(PurchaseDTO purchaseDTO, PurchaseOrderDTO purchaseOrderDTO, PurchaseProductDTO purchaseProductDTO);
	
	/**
	 * 장바구니에서 구매 눌렀을 때
	 * */
	Map<String, Object> purchaseCart(CartProductDTO cartProductDTO, String email);
	
	/**
	 * 장바구니에서 구매하기 누른 후 결제
	 * */
	int payCart(PurchaseDTO purchaseDTO, PurchaseOrderDTO purchaseOrderDTO, PurchaseProductListDTO purchaseProductListDTO);
	
	/**
	 * 카드, 실시간, 휴대폰 결제시 purchase_state_no 바꾸기
	 * */
	int setPurchaseStateNo(int no);

	
}
