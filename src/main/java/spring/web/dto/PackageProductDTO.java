package spring.web.dto;

public class PackageProductDTO {
	private String packageno;	//패키지안에 있는  제품 번호
	private int no;	//패기지 번호
	private int productno; // 제품 번호
	
	
	public PackageProductDTO() {
		super();
	}


	public PackageProductDTO(String packageno, int no, int productno) {
		super();
		this.packageno = packageno;
		this.no = no;
		this.productno = productno;
	}


	public String getPackageno() {
		return packageno;
	}


	public void setPackageno(String packageno) {
		this.packageno = packageno;
	}


	public int getNo() {
		return no;
	}


	public void setNo(int no) {
		this.no = no;
	}


	public int getProductno() {
		return productno;
	}


	public void setProductno(int productno) {
		this.productno = productno;
	}
	
	
}
