package spring.web.dto;

import java.util.List;

public class PackageDTO {
	private int pk;
	private int packageNo;
	private int productNo;
	
	private List<ProductDTO> productlist;
	private ProductDTO productDTO;
	
	public PackageDTO() {}

	public PackageDTO(int pk, int packageNo, int productNo) {
		super();
		this.pk = pk;
		this.packageNo = packageNo;
		this.productNo = productNo;
	}

	public int getPk() {
		return pk;
	}

	public void setPk(int pk) {
		this.pk = pk;
	}

	public int getPackageNo() {
		return packageNo;
	}

	public void setPackageNo(int packageNo) {
		this.packageNo = packageNo;
	}

	public int getProductNo() {
		return productNo;
	}

	public void setProductNo(int productNo) {
		this.productNo = productNo;
	}

	public List<ProductDTO> getProductlist() {
		return productlist;
	}

	public void setProductlist(List<ProductDTO> productlist) {
		this.productlist = productlist;
	}
	
	public ProductDTO getProductDTO() {
		return productDTO;
	}
	
	public void setProductDTO(ProductDTO productDTO) {
		this.productDTO = productDTO;
	}

}
