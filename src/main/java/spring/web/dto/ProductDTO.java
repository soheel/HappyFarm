package spring.web.dto;

public class ProductDTO {
	private int no;
	private String name;
	private int price;
	private String profile;
	private String desc;
	private double eval;
	private String unit;
	private int producerNo;
	private int categoryNo;
	
	public ProductDTO() {
		// TODO Auto-generated constructor stub
	}

	public ProductDTO(int no, String name, int price, String profile, String desc, double eval, String unit, int producerNo,
			int categoryNo) {
		super();
		this.no = no;
		this.name = name;
		this.price = price;
		this.profile = profile;
		this.desc = desc;
		this.eval = eval;
		this.unit = unit;
		this.producerNo = producerNo;
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

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getProfile() {
		return profile;
	}

	public void setProfile(String profile) {
		this.profile = profile;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public double getEval() {
		return eval;
	}

	public void setEval(double eval) {
		this.eval = eval;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public int getProducerNo() {
		return producerNo;
	}

	public void setProducerNo(int producerNo) {
		this.producerNo = producerNo;
	}

	public int getCategoryNo() {
		return categoryNo;
	}

	public void setCategoryNo(int categoryNo) {
		this.categoryNo = categoryNo;
	}
	
	
}
