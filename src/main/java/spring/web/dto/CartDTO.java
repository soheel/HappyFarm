package spring.web.dto;

public class CartDTO {
	private String email;
	private int productNo;
	private int num;
	
	public CartDTO() {
		// TODO Auto-generated constructor stub
	}

	public CartDTO(String email, int productNo, int num) {
		super();
		this.email = email;
		this.productNo = productNo;
		this.num = num;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getProductNo() {
		return productNo;
	}

	public void setProductNo(int productNo) {
		this.productNo = productNo;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

}
