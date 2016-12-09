package spring.web.dto;

import java.util.List;

public class CartDTO {
	private int cartNo;
	private String email;
	private int productNo;
	private int num;
	
	private MemberDTO memberDto;
	private List<ProductDTO> productDto;
	
	public CartDTO() {
		// TODO Auto-generated constructor stub
	}

	

	public CartDTO(int cartNo, String email, int productNo, int num) {
		super();
		this.cartNo = cartNo;
		this.email = email;
		this.productNo = productNo;
		this.num = num;
	}



	public int getCartNo() {
		return cartNo;
	}

	public void setCartNo(int cartNo) {
		this.cartNo = cartNo;
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

	public MemberDTO getMemberDto() {
		return memberDto;
	}

	public void setMemberDto(MemberDTO memberDto) {
		this.memberDto = memberDto;
	}

	public List<ProductDTO> getProductDto() {
		return productDto;
	}

	public void setProductDto(List<ProductDTO> productDto) {
		this.productDto = productDto;
	}
	
	
}
