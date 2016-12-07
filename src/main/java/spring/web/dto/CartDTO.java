package spring.web.dto;

import java.util.List;

public class CartDTO {
	private int no;
	private int num;
	private MemberDTO memberDto;
	
	private List<ProductDTO> productDto;
	
	public CartDTO() {
		// TODO Auto-generated constructor stub
	}

	public CartDTO(int no, int num, MemberDTO memberDto, List<ProductDTO> productDto) {
		super();
		this.no = no;
		this.num = num;
		this.memberDto = memberDto;
		this.productDto = productDto;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
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
