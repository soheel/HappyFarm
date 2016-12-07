package spring.web.dto;

public class InfomationDTO {
	private int no;
	private String name;
	private String desc;
	private String date;
	
	public InfomationDTO() {}

	public InfomationDTO(int no, String name, String desc, String date) {
		super();
		this.no = no;
		this.name = name;
		this.desc = desc;
		this.date = date;
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

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
	
	
}
