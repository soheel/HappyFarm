package spring.web.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring.web.dao.UserProductDAO;
import spring.web.dto.CartDTO;
import spring.web.dto.CertificationDTO;
import spring.web.dto.PackageDTO;
import spring.web.dto.ProducerDTO;
import spring.web.dto.ProductCommentDTO;
import spring.web.dto.ProductDTO;
import spring.web.dto.PurchaseDTO;
import spring.web.dto.PurchaseOrderDTO;
import spring.web.dto.PurchaseProductDTO;

@Service
public class UserProductServiceImpl implements UserProductService{
	
	@Autowired
	UserProductDAO userProductDAO;

	@Override
	public List<ProductDTO> shopMenuLoading(String email) {
		List<ProductDTO> list = new ArrayList<ProductDTO>();
		
		// getBestProduct()를 통해 List<Integer> 받아오기
		List<Integer> listBestProduct = userProductDAO.getBestProduct();
		// 계절상품 담기
		// getRecentPurchase()를 통해 List<Integer> 받아오기
		List<Integer> listRecentPurchase = userProductDAO.getRecentPurchase(email);
		
		// getProductByProductNo(int productNo)를 통해 리스트에 있는 productNo들을 전달해줘서
		// ProductDTO들을 저장하는 리스트를 만들어 컨트롤러로 반환하기
		for(Integer i : listBestProduct) {
			list.add(userProductDAO.getProductByProductNo(i));
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
		System.out.println("service의 showMenuListLoading메소드 들어옴");
		List<ProductDTO> list = userProductDAO.getProductByCategory(categoryNo);
		System.out.println("service의 showMenuListLoading메소드 나옴");
		System.out.println(list.size());
		return list;
	}

	@Override
	public Map<String, Object> showProductDetail(int productNo) {
		/**
		 * Map에 ProductDTO, ProductCommentDTO, CertificationDTO, ProducerDTO를 담아서 
		 * 컨트롤러로 반환
		 * */
		
		Map<String, Object> map = new HashMap<String, Object>();
		// ProductDTO 가져오기
		ProductDTO productDTO = userProductDAO.getProductByProductNo(productNo);
		map.put("product", productDTO);
		// ProductCommentDTO 가져오기
		List<ProductCommentDTO> productCommentList = userProductDAO.getProductCommentByProductNo(productNo);
		map.put("productComment", productCommentList);
		// CertificationDTO 가져오기
		List<CertificationDTO> certificationList = userProductDAO.getCertificationByProductNo(productNo);
		map.put("certification", certificationList);
		// ProducerDTO 가져오기
		ProducerDTO producerDTO = userProductDAO.getProducerByProductNo(productNo);
		map.put("producer", producerDTO);
		
		// productDTO의 categoryno를 통해 상품 상세보기에서 뿌려줄 카테고리 가져오기
		int subcategoryNo = productDTO.getSubCategoryNo();
		String categoryName = userProductDAO.getCategoryName(subcategoryNo);
		map.put("categoryName", categoryName);
		return map;
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
		System.out.println("service int값 : " + result);
		return result;
	}
	
	@Override
	public Map<String, Object> order(int productNo, int num) {
		Map<String, Object> map = new HashMap<String, Object>();
		
		// ProductDTO 가져오기
		ProductDTO productDTO = userProductDAO.getProductByProductNo(productNo);
		map.put("productDTO", productDTO);
		// ProducerDTO 가져오기
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
	public Map<String, Object> getPackageDetail() {
		Map<String, Object> map = new HashMap<String, Object>();
		// 패키지 상품 상세보기
		ProductDTO productDTO = userProductDAO.getPackageDetail();
		map.put("productDTO", productDTO);
		System.out.println(productDTO.getName());
		System.out.println(productDTO.getProducerNo());
		// 패키지 상품 내에있는 상품 리스트 가져오기
		List<ProductDTO> list = userProductDAO.getPackageInnerProductList();
		map.put("list", list);
		
		return map;
	}

	@Override
	public Map<String, Object> showPurchase(int productNo, int producerNo, String email) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		// productNo를 통해 ProductDTO 얻어오기
		ProductDTO productDTO = userProductDAO.getProductByProductNo(productNo);
		map.put("productDTO", productDTO);
		// producerNo를 통해 ProducerDTO 얻어오기
		ProducerDTO producerDTO = userProductDAO.getProducerByProducerNo(producerNo);
		map.put("producerDTO", producerDTO);
		// 현재 내 마일리지 얻어오기
		int mileage = userProductDAO.getMileage(email);
		map.put("mileage", mileage);
		
		return map;
	}

	@Override
	public int pay(PurchaseDTO purchaseDTO, PurchaseOrderDTO purchaseOrderDTO, PurchaseProductDTO purchaseProductDTO) {
		
		// purchase 테이블에 insert
		int purchaseResult = userProductDAO.registerPurchase(purchaseDTO);
		// purchase 테이블에서 가장 최근 purchaseNo 가져오기
		int recentPurchaseNo = userProductDAO.getRecentPurchaseNo();
		purchaseOrderDTO.setPurchaseNo(recentPurchaseNo);
		purchaseProductDTO.setPurchaseNo(recentPurchaseNo);
		// purchase_order 테이블에 insert
		int purchaseOrderResult = userProductDAO.registerPurchaseOrder(purchaseOrderDTO);
		// purchase_product 테이블에 insert
		int purchaseProductResult = userProductDAO.registerPurchaseProduct(purchaseProductDTO);
		
		return recentPurchaseNo;
	}

	@Override
	public Map<String, Object> purchaseCart(List<Integer> list, String email) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		List<ProductDTO> productDTOList = new ArrayList<ProductDTO>();
		for(int i : list) {
			productDTOList.add(userProductDAO.getProductByProductNo(i));
		}
		map.put("productDTOList", productDTOList);
		int mileage = userProductDAO.getMileage(email);
		map.put("mileage", mileage);
		
		return map;
	}

}
