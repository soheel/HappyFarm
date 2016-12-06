package spring.web.service;

import java.util.List;

import spring.web.dto.PackageDTO;
import spring.web.dto.ProductDTO;

public class ManageServiceImpl implements ManageService {

	@Override
	public List<ProductDTO> selectAllProududct() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int productRegisterManage(ProductDTO productDTO) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int productModifyManage(String productno) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int productDeleteManage(String productno) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<ProductDTO> selectAllPackageProduct(String packagename) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PackageDTO> selectAllPackage() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ProductDTO> packageSearchProduct(String productname) {
		// TODO Auto-generated method stub
		return null;
	}

}
