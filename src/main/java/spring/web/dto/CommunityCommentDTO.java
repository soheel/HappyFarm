package spring.web.dto;

public class CommunityCommentDTO {
	int no;	//모임 댓글 번호
	String content; //모임 댓글 내용
	String registerdate; // 모임 댓글 날짜
	String email; // 회원 이메일
	
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
