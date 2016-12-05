package spring.web.dto;

public class QnaDTO {
	int no;
	String name;
	String desc;
	String pwd;
	String registerdate;
	String Email;
	int qnaParent;
	
	public QnaDTO() {
		super();
	}

	public QnaDTO(int no, String name, String desc, String pwd, String registerdate, String email, int qnaParent) {
		super();
		this.no = no;
		this.name = name;
		this.desc = desc;
		this.pwd = pwd;
		this.registerdate = registerdate;
		Email = email;
		this.qnaParent = qnaParent;
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

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getRegisterdate() {
		return registerdate;
	}

	public void setRegisterdate(String registerdate) {
		this.registerdate = registerdate;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public int getQnaParent() {
		return qnaParent;
	}

	public void setQnaParent(int qnaParent) {
		this.qnaParent = qnaParent;
	}
	
}
