package spring.web.dto;


public class ProductCommentDTO {
	private int no;
	private String content;
	private String registerDate;
	private String email;
	private int commentNo;
	
	private MemberDTO memberDto;
	private ProductDTO productDto;
	
	public ProductCommentDTO() {
		// TODO Auto-generated constructor stub
	}

	public ProductCommentDTO(int no, String content, String registerDate, String email, int commentNo) {
		super();
		this.no = no;
		this.content = content;
		this.registerDate = registerDate;
		this.email = email;
		this.commentNo = commentNo;
	}

	public int getCommentNo() {
		return commentNo;
	}

	public void setCommentNo(int commentNo) {
		this.commentNo = commentNo;
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

	public MemberDTO getMemberDto() {
		return memberDto;
	}

	public void setMemberDto(MemberDTO memberDto) {
		this.memberDto = memberDto;
	}

	public ProductDTO getProductDto() {
		return productDto;
	}

	public void setProductDto(ProductDTO productDto) {
		this.productDto = productDto;
	}
	
	
	
}
