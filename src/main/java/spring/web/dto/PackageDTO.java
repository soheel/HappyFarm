package spring.web.dto;

import java.util.List;

public class PackageDTO {
	private int no;
	private String name;
	private List<ProductDTO> list;
	
	public PackageDTO() {}

	public PackageDTO(int no, String name, List<ProductDTO> list) {
		super();
		this.no = no;
		this.name = name;
		this.list = list;
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
	
	
}
