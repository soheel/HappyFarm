package spring.web.service;

import java.util.List;

import spring.web.dto.ProductDTO;

public interface ManageService {

	public List<ProductDTO> selectAllProududct();
	public int productRegisterManage(ProductDTO productDTO);

	public int productModifyManage(String productno);

	public int productDeleteManage(ProductDTO productdto);

}
