package spring.web.dto;

public class CartDTO {
	private int no;
	private int productNo;
	private int num;
	private String email;
	
	public CartDTO() {
		// TODO Auto-generated constructor stub
	}

	public CartDTO(int no, int productNo, int num, String email) {
		super();
		this.no = no;
		this.productNo = productNo;
		this.num = num;
		this.email = email;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
