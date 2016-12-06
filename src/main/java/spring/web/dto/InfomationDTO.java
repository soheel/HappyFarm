package spring.web.dto;

public class InfomationDTO {
	private int no;
	private String name;
	private String desc;
	
	public InfomationDTO() {
		// TODO Auto-generated constructor stub
	}

	public InfomationDTO(int no, String name, String desc) {
		super();
		this.no = no;
		this.name = name;
		this.desc = desc;
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
	
	
}
