package spring.web.service;

import java.util.List;

import spring.web.dto.ProducerDTO;
import spring.web.dto.ProductDTO;

public interface UserProductService {
	
	public List<ProductDTO> shopMenuLoading();
	
	public List<ProductDTO> showMenuListLoading(String categoryNo);
	
	public ProductDTO showProductDetail(String productNo);
	 
	public ProducerDTO showProducerInfo(String producerNo);
}
