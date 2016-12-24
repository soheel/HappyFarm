package spring.web.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring.web.dao.UserProductDAO;
import spring.web.dto.CartDTO;
import spring.web.dto.CartProductDTO;
import spring.web.dto.CertificationDTO;
import spring.web.dto.PackageDTO;
import spring.web.dto.ProducerDTO;
import spring.web.dto.ProductCertificationDTO;
import spring.web.dto.ProductCommentDTO;
import spring.web.dto.ProductDTO;
import spring.web.dto.PurchaseDTO;
import spring.web.dto.PurchaseOrderDTO;
import spring.web.dto.PurchaseProductDTO;
import spring.web.dto.PurchaseProductListDTO;

@Service
public class UserProductServiceImpl implements UserProductService{
	
	@Autowired
	UserProductDAO userProductDAO;

	@Override
	public List<ProductDTO> shopMenuLoading(String email) {
		List<ProductDTO> list = new ArrayList<ProductDTO>();
		
		// getBestProduct()�� ���� List<Integer> �޾ƿ���
		List<Integer> listBestProduct = userProductDAO.getBestProduct();
		// ������ǰ ���
		// getRecentPurchase()�� ���� List<Integer> �޾ƿ���
		List<Integer> listRecentPurchase = userProductDAO.getRecentPurchase(email);
		
		// getProductByProductNo(int productNo)�� ���� ����Ʈ�� �ִ� productNo���� �������༭
		// ProductDTO���� �����ϴ� ����Ʈ�� ����� ��Ʈ�ѷ��� ��ȯ�ϱ�
		for(Integer i : listBestProduct) {
			System.out.println(i + "!!!");
			list.add(userProductDAO.getProductByProductNo(i));
			System.out.println(i + "~~~");
		}
		for(int i = 2; i <= 4 ; i++) {
			list.add(userProductDAO.getProductByProductNo(i));
		}
		for(Integer i : listRecentPurchase) {
			list.add(userProductDAO.getProductByProductNo(i));
		}
		return list;
	}

	@Override
	public List<ProductDTO> showMenuListLoading(int categoryNo) {
		System.out.println("service�� showMenuListLoading�޼ҵ� ����");
		List<ProductDTO> list = userProductDAO.getProductByCategory(categoryNo);
		System.out.println("service�� showMenuListLoading�޼ҵ� ����");
		System.out.println(list.size());
		return list;
	}

	@Override
	public Map<String, Object> showProductDetail(int productNo) {
		/**
		 * Map�� ProductDTO, ProductCommentDTO, CertificationDTO, ProducerDTO�� ��Ƽ� 
		 * ��Ʈ�ѷ��� ��ȯ
		 * */
		
		Map<String, Object> map = new HashMap<String, Object>();
		// ProductDTO ��������
		ProductDTO productDTO = userProductDAO.getProductByProductNo(productNo);
		map.put("product", productDTO);
		// ProductCommentDTO ��������
		List<ProductCommentDTO> productCommentList = userProductDAO.getProductCommentByProductNo(productNo);
		map.put("productComment", productCommentList);
		// CertificationDTO ��������
		List<CertificationDTO> certificationList = userProductDAO.getCertificationByProductNo(productNo);
		map.put("certification", certificationList);
		// ProducerDTO ��������
		ProducerDTO producerDTO = userProductDAO.getProducerByProductNo(productNo);
		map.put("producer", producerDTO);
		
		// productDTO�� categoryno�� ���� ��ǰ �󼼺��⿡�� �ѷ��� ī�װ��� ��������
		int subcategoryNo = productDTO.getSubCategoryNo();
		String categoryName = userProductDAO.getCategoryName(subcategoryNo);
		map.put("categoryName", categoryName);
		return map;
	}
	
	@Override
	public List<ProductCertificationDTO> showCertificationInfo(int no) {
		return userProductDAO.showCertificationInfo(no);
	}
	

	@Override
	public ProducerDTO showProducerInfo(int producerNo) {
		ProducerDTO producerDTO = userProductDAO.getProducerByProducerNo(producerNo);
		return producerDTO;
	}

	@Override
	public int addCart(CartDTO cart) {
		int result = userProductDAO.registerProductToCart(cart);
		return result;
	}
	
	@Override
	public int addCartDirect(CartDTO cart) {
		int result = userProductDAO.registerProductToCartDirect(cart);
		System.out.println("service int�� : " + result);
		return result;
	}
	
	@Override
	public Map<String, Object> order(int productNo, int num) {
		Map<String, Object> map = new HashMap<String, Object>();
		
		// ProductDTO ��������
		ProductDTO productDTO = userProductDAO.getProductByProductNo(productNo);
		map.put("productDTO", productDTO);
		// ProducerDTO ��������
		ProducerDTO ProducerDTO = userProductDAO.getProducerByProductNo(productNo);
		map.put("ProducerDTO", ProducerDTO);
		
		return map;
	}

	@Override
	public List<ProductDTO> packageMenuListLoading() {
		List<ProductDTO> list = null;
		list = userProductDAO.getPackageList();
		return list;
	}

	@Override
	public List<ProductDTO> search(String keyword) {
		List<ProductDTO> list = null;
		list = userProductDAO.search(keyword);
		return list;
	}

	@Override
	public Map<String, Object> getPackageDetail(int productNo) {
		Map<String, Object> map = new HashMap<String, Object>();
		// ��Ű�� ��ǰ �󼼺���
		ProductDTO productDTO = userProductDAO.getPackageDetail(productNo);
		map.put("productDTO", productDTO);
		System.out.println(productDTO.getName());
		System.out.println(productDTO.getProducerNo());
		// ��Ű�� ��ǰ �����ִ� ��ǰ ����Ʈ ��������
		List<ProductDTO> list = userProductDAO.getPackageInnerProductList(productNo);
		map.put("list", list);
		
		return map;
	}

	@Override
	public Map<String, Object> showPurchase(int productNo, int producerNo, String email) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		// productNo�� ���� ProductDTO ������
		ProductDTO productDTO = userProductDAO.getProductByProductNo(productNo);
		map.put("productDTO", productDTO);
		// producerNo�� ���� ProducerDTO ������
		ProducerDTO producerDTO = userProductDAO.getProducerByProducerNo(producerNo);
		map.put("producerDTO", producerDTO);
		// ���� �� ���ϸ��� ������
		int mileage = userProductDAO.getMileage(email);
		map.put("mileage", mileage);
		
		return map;
	}

	@Override
	public int pay(PurchaseDTO purchaseDTO, PurchaseOrderDTO purchaseOrderDTO, PurchaseProductDTO purchaseProductDTO) {
		
		// purchase ���̺��� insert
		int purchaseResult = userProductDAO.registerPurchase(purchaseDTO);
		// purchase ���̺����� ���� �ֱ� purchaseNo ��������
		int recentPurchaseNo = userProductDAO.getRecentPurchaseNo();
		purchaseOrderDTO.setPurchaseNo(recentPurchaseNo);
		purchaseProductDTO.setPurchaseNo(recentPurchaseNo);
		// purchase_order ���̺��� insert
		int purchaseOrderResult = userProductDAO.registerPurchaseOrder(purchaseOrderDTO);
		// purchase_product ���̺��� insert
		int purchaseProductResult = userProductDAO.registerPurchaseProduct(purchaseProductDTO);
		
		return recentPurchaseNo;
	}

	@Override
	public Map<String, Object> purchaseCart(CartProductDTO cartProductDTO, String email) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		List<ProductDTO> productList = new ArrayList<ProductDTO>();
		List<Integer> numList = new ArrayList<Integer>();
		for(CartDTO cart : cartProductDTO.getList()) {
			if(cart.getNum() == 0) {
				continue;
			}
			ProductDTO productDTO = userProductDAO.getProductByProductNo(cart.getProductNo());
			productList.add(productDTO);
			numList.add(cart.getNum());
		}
		int mileage = userProductDAO.getMileage(email);
		map.put("mileage", mileage);
		map.put("productList", productList);
		map.put("numList", numList);
		
		return map;
	}

	@Override
	public int payCart(PurchaseDTO purchaseDTO, PurchaseOrderDTO purchaseOrderDTO,
			PurchaseProductListDTO purchaseProductListDTO) {

		// purchase ���̺��� insert
		int purchaseResult = userProductDAO.registerPurchase(purchaseDTO);
		// purchase ���̺����� ���� �ֱ� purchaseNo ��������
		int recentPurchaseNo = userProductDAO.getRecentPurchaseNo();
		purchaseOrderDTO.setPurchaseNo(recentPurchaseNo);
		// purchase_order ���̺��� insert
		int purchaseOrderResult = userProductDAO.registerPurchaseOrder(purchaseOrderDTO);
		for(PurchaseProductDTO purchaseProduct : purchaseProductListDTO.getList()) {
			purchaseProduct.setPurchaseNo(recentPurchaseNo);
			userProductDAO.registerPurchaseProduct(purchaseProduct);	
		}
		userProductDAO.removeCartProduct(purchaseDTO);
		return recentPurchaseNo;
	}

	@Override
	public int setPurchaseStateNo(int no) {
		int result = userProductDAO.setPurchaseStateNo(no);
		return result;
	}

	@Override
	public int reduceMileage(int useMileage, String email) {
		return userProductDAO.reduceMileage(useMileage, email);
	}

	@Override
	public int saveMileage(int saveMileage, String email) {
		return userProductDAO.saveMileage(saveMileage, email);
	}

	
}