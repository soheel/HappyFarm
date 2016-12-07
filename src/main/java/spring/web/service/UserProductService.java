package spring.web.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import spring.web.dto.CartDTO;
import spring.web.dto.PackageDTO;
import spring.web.dto.ProducerDTO;
import spring.web.dto.ProductDTO;

public interface UserProductService {
	
	public List<ProductDTO> shopMenuLoading();
	
	public List<ProductDTO> showMenuListLoading(int categoryNo);
	
	public Map<String, Object> showProductDetail(int productNo);
	 
	public ProducerDTO showProducerInfo(int producerNo);
	
	public int addCart(CartDTO cart);
	
	public int addCartDirect(CartDTO cart);
	
	public Map<String, Object> order(int productNo, int num);
	
	public List<ProductDTO> packageMenuListLoading();
	
	public Map<String, Object> showPackageDetail();
}
