package spring.web.dto;

public class CategorySubcategoryDTO {
	
	private int no;//소분류 이름
	private String name;
	private int categoryNo;
	
	private CategoryDTO categoryDto;
	
	public CategorySubcategoryDTO() {}

	public CategorySubcategoryDTO(int no, String name, int categoryNo) {
		super();
		this.no = no;
		this.name = name;
		this.categoryNo = categoryNo;
	}

	public int getCategoryNo() {
		return categoryNo;
	}
	public void setCategoryNo(int categoryNo) {
		this.categoryNo = categoryNo;
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
	public CategoryDTO getCategoryDto() {
		return categoryDto;
	}
	public void setCategoryDto(CategoryDTO categoryDto) {
		this.categoryDto = categoryDto;
	}
	
	
	

}
