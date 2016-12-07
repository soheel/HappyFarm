package spring.web.dto;

public class PurchaseDTO {
	
	private int no;
	private int price;
	private String date;
	private String method;
	private int stateNo;
	private int discount;
	
	private MemberDTO membeDto;

	public PurchaseDTO() {}
	
	public PurchaseDTO(int no, int price, String date, String method, int stateNo, int discount, MemberDTO membeDto) {
		super();
		this.no = no;
		this.price = price;
		this.date = date;
		this.method = method;
		this.stateNo = stateNo;
		this.discount = discount;
		this.membeDto = membeDto;
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

	public MemberDTO getMembeDto() {
		return membeDto;
	}

	public void setMembeDto(MemberDTO membeDto) {
		this.membeDto = membeDto;
	}
	
	

}
