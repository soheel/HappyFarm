package spring.web.dto;

import java.util.List;

public class PackageDTO {
	private int no;
	private String name;
	private int productNo;
	
	private PackageProductDTO packageProductDTO;
	
	private ProductDTO productDTO;
	
	public ProductDTO getProductDTO() {
		return productDTO;
	}

	public void setProductDTO(ProductDTO productDTO) {
		this.productDTO = productDTO;
	}

	private List<ProductDTO> list;
	
	public PackageDTO() {}

	public PackageDTO(int no, String name, int productNo) {
		super();
		this.no = no;
		this.name = name;
		this.productNo = productNo;
	}

	public int getNo() {
		return no;
	}
	
	public void setNo(int no) {
		this.no = no;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<ProductDTO> getList() {
		return list;
	}

	public void setList(List<ProductDTO> list) {
		this.list = list;
	}

	public int getProductNo() {
		return productNo;
	}

	public PackageProductDTO getPackageProductDTO() {
		return packageProductDTO;
	}

	public void setPackageProductDTO(PackageProductDTO packageProductDTO) {
		this.packageProductDTO = packageProductDTO;
	}

	public void setProductNo(int productNo) {
		this.productNo = productNo;
	}
	
	
}
