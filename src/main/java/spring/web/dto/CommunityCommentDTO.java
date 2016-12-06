package spring.web.dto;

public class CommunityCommentDTO {
	int no;	//���� ��� ��ȣ
	String content; //���� ��� ����
	String registerdate; // ���� ��� ��¥
	String email; // ȸ�� �̸���
	
	public CommunityCommentDTO() {
		super();
	}

	public CommunityCommentDTO(int no, String content, String registerdate, String email) {
		super();
		this.no = no;
		this.content = content;
		this.registerdate = registerdate;
		this.email = email;
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


	public String getRegisterdate() {
		return registerdate;
	}


	public void setRegisterdate(String registerdate) {
		this.registerdate = registerdate;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
}
