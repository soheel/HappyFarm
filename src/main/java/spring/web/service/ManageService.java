package spring.web.service;

import java.util.List;

import spring.web.dto.PackageDTO;
import spring.web.dto.ProductDTO;

public interface ManageService {

	public List<ProductDTO> selectAllProududct();
	public int productRegisterManage(ProductDTO productDTO);

	public int productModifyManage(String productno);

	public int productDeleteManage(String productno);
	
	public List<ProductDTO> selectAllPackageProduct(String packagename);
	
	public List<PackageDTO> selectAllPackage();

	/**
	 * 상품검색은 상품이름을 입력하면, 검색된 것을 찾아 ajax로 밑에 있는 상품에 추가한다.
	 */
	public List<ProductDTO> packageSearchProduct(String productname);

}
