package spring.web.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import spring.web.dto.ProducerDTO;
import spring.web.dto.ProductDTO;

public interface UserProductService {
	
	public List<ProductDTO> shopMenuLoading();
	
	public List<ProductDTO> showMenuListLoading(String categoryNo);
	
	public Map<String, Object> showProductDetail(String productNo);
	 
	public ProducerDTO showProducerInfo(String producerNo);
	
	public int addCart(String productNo, int num, String email);
	
	public List<ProductDTO> packageMenuListLoading();
}
