package spring.web.dto;

import java.util.List;

public class PackageDTO {
	private int no;
	private int packageNo;
	private int productNo;
	
	private List<ProductDTO> productlist;
	private ProductDTO productDTO;
	
	public PackageDTO() {}

	public PackageDTO(int no, int packageNo, int productNo, List<ProductDTO> productlist) {
		super();
		this.no = no;
		this.packageNo = packageNo;
		this.productNo = productNo;
		this.productlist = productlist;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
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
