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
	 * ��Ű�� ��ǰ �󼼺���
	 * */
	Map<String, Object> getPackageDetail();
	
	/**
	 * purchase
	 * productDTO, producerDTO�� map�� �־� ��ȯ
	 * */
	Map<String, Object> showPurchase(int productNo, int producerNo, String email);
	
	/**
	 * ����
	 * */
	int pay(PurchaseDTO purchaseDTO, PurchaseOrderDTO purchaseOrderDTO, PurchaseProductDTO purchaseProductDTO);
	
	/**
	 * ��ٱ��Ͽ��� ���� ������ ��
	 * */
	Map<String, Object> purchaseCart(CartProductDTO cartProductDTO, String email);
	
	/**
	 * ��ٱ��Ͽ��� �����ϱ� ���� �� ����
	 * */
	int payCart(PurchaseDTO purchaseDTO, PurchaseOrderDTO purchaseOrderDTO, PurchaseProductListDTO purchaseProductListDTO);
	
	/**
	 * ī��, �ǽð�, �޴��� ������ purchase_state_no �ٲٱ�
	 * */
	int setPurchaseStateNo(int no);

	
}
