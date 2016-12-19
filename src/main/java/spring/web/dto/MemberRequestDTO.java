package spring.web.dto;

public class MemberRequestDTO {
		
		private int requestNo;
		private int stateNo;
		private String desc;
		private int purchaseNo;
		private String email;
		
		private MemberDTO memberDto;
		private PurchaseDTO purchaseDto;
		private PurchaseStateDTO purchaseStateDto;
		
		public MemberRequestDTO() {}

		
		
		public MemberRequestDTO(int requestNo, int stateNo, String desc, int purchaseNo, String email) {
			super();
			this.requestNo = requestNo;
			this.stateNo = stateNo;
			this.desc = desc;
			this.purchaseNo = purchaseNo;
			this.email = email;
		}



		public int getRequestNo() {
			return requestNo;
		}

		public void setRequestNo(int requestNo) {
			this.requestNo = requestNo;
		}

		public int getStateNo() {
			return stateNo;
		}

		public void setStateNo(int stateNo) {
			this.stateNo = stateNo;
		}

		public String getDesc() {
			return desc;
		}

		public void setDesc(String desc) {
			this.desc = desc;
		}

		public int getPurchaseNo() {
			return purchaseNo;
		}

		public void setPurchaseNo(int purchaseNo) {
			this.purchaseNo = purchaseNo;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public MemberDTO getMemberDto() {
			return memberDto;
		}

		public void setMemberDto(MemberDTO memberDto) {
			this.memberDto = memberDto;
		}

		public PurchaseDTO getPurchaseDto() {
			return purchaseDto;
		}

		public void setPurchaseDto(PurchaseDTO purchaseDto) {
			this.purchaseDto = purchaseDto;
		}

		public PurchaseStateDTO getPurchaseStateDto() {
			return purchaseStateDto;
		}

		public void setPurchaseStateDto(PurchaseStateDTO purchaseStateDto) {
			this.purchaseStateDto = purchaseStateDto;
		}

		
}
