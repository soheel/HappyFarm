package spring.web.dto;

import java.util.List;

public class PurchaseDTO {
	
	private int no;
	private int price;
	private String date;
	private String method;
	private int stateNo;
	private int discount;
	private String email;
	
	private MemberDTO memberDto;
	//purchase state dto»ý¼º
	private PurchaseStateDTO purchaseStateDto;
	private List<PurchaseProductDTO> purchaseProductDto;

	public PurchaseDTO() {}

	public PurchaseDTO(int no, int price, String date, String method, int stateNo, int discount, String email) {
		super();
		this.no = no;
		this.price = price;
		this.date = date;
		this.method = method;
		this.stateNo = stateNo;
		this.discount = discount;
		this.email = email;
	}
	
	
	public PurchaseStateDTO getPurchaseStateDto() {
		return purchaseStateDto;
	}

	public void setPurchaseStateDto(PurchaseStateDTO purchaseStateDto) {
		this.purchaseStateDto = purchaseStateDto;
	}

	public List<PurchaseProductDTO> getPurchaseProductDto() {
		return purchaseProductDto;
	}

	public void setPurchaseProductDto(List<PurchaseProductDTO> purchaseProductDto) {
		this.purchaseProductDto = purchaseProductDto;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public int getStateNo() {
		return stateNo;
	}

	public void setStateNo(int stateNo) {
		this.stateNo = stateNo;
	}

	public int getDiscount() {
		return discount;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public MemberDTO getMemberDto() {
		return memberDto;
	}

	public void setMemberDto(MemberDTO memberDto) {
		this.memberDto = memberDto;
	}
	
	

}
