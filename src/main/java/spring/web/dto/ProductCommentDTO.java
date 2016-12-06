package spring.web.dto;

public class ProductCommentDTO {
	private int no;
	private String content;
	private String registerDate;
	private String email;
	private int productNo;
	
	public ProductCommentDTO() {
		// TODO Auto-generated constructor stub
	}

	public ProductCommentDTO(int no, String content, String registerDate, String email, int productNo) {
		super();
		this.no = no;
		this.content = content;
		this.registerDate = registerDate;
		this.email = email;
		this.productNo = productNo;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getRegisterDate() {
		return registerDate;
	}

	public void setRegisterDate(String registerDate) {
		this.registerDate = registerDate;
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
	
	
}
