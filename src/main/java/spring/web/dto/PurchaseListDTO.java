package spring.web.dto;

import java.util.List;

public class PurchaseListDTO{
	
	private List<PurchaseDTO> purchaseList;
	
	public PurchaseListDTO() {}

	public PurchaseListDTO(List<PurchaseDTO> purchaseList) {
		super();
		this.purchaseList = purchaseList;
	}

	public List<PurchaseDTO> getPurchaseList() {
		return purchaseList;
	}

	public void setPurchaseList(List<PurchaseDTO> purchaseList) {
		this.purchaseList = purchaseList;
	}

	
	
	
	
	
	
}