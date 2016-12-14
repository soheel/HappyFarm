package spring.web.dto;

import java.util.List;

public class CartProductDTO {
	private List<CartDTO> list;
	
	public CartProductDTO() {
	}

	public CartProductDTO(List<CartDTO> list) {
		super();
		this.list = list;
	}

	public List<CartDTO> getList() {
		return list;
	}

	public void setList(List<CartDTO> list) {
		this.list = list;
	}
	
	
}
