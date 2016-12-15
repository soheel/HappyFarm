package spring.web.dto;

import java.util.List;

public class PurchaseProductListDTO {
	private List<PurchaseProductDTO> list;
	
	public PurchaseProductListDTO() {

	}

	public PurchaseProductListDTO(List<PurchaseProductDTO> list) {
		super();
		this.list = list;
	}
	
	public List<PurchaseProductDTO> getList() {
		return list;
	}
	
	public void setList(List<PurchaseProductDTO> list) {
		this.list = list;
	}
	
}
