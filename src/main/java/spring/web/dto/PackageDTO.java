package spring.web.dto;

import java.util.List;

public class PackageDTO {
	private String name;
	private List<ProductDTO> list;
	
	public PackageDTO() {
		// TODO Auto-generated constructor stub
	}

	public PackageDTO(String name, List<ProductDTO> list) {
		super();
		this.name = name;
		this.list = list;
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
	
	
}
