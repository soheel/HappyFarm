package spring.web.dto;

public class CategoryDTO {
	
	private int no;
	private String name;
	
	public CategoryDTO() {
		// TODO Auto-generated constructor stub
	}
	public CategoryDTO(int no, String name) {
		super();
		this.no = no;
		this.name = name;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	

}
