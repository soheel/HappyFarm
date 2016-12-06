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
	 * ��ǰ�˻��� ��ǰ�̸��� �Է��ϸ�, �˻��� ���� ã�� ajax�� �ؿ� �ִ� ��ǰ�� �߰��Ѵ�.
	 */
	public List<ProductDTO> packageSearchProduct(String productname);

}
