package spring.web.dto;

import org.springframework.web.multipart.MultipartFile;

public class BoardDTO {
	private String no;
	private String name;
	private int price;
	private String desc;
	private String pwd;
	private String writeDay;
	private int readNum;
	private String fileName;
	private long fileSize;
	
	private MultipartFile file;
	
	public BoardDTO() {
		
	}
	public BoardDTO(String no, String name, int price, String desc, String pwd, String writeDay, int readNum,
			String fileName, int fileSize) {
		super();
		this.no = no;
		this.name = name;
		this.price = price;
		this.desc = desc;
		this.pwd = pwd;
		this.writeDay = writeDay;
		this.readNum = readNum;
		this.fileName = fileName;
		this.fileSize = fileSize;
	}
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
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
	public String getWriteDay() {
		return writeDay;
	}
	public void setWriteDay(String writeDay) {
		this.writeDay = writeDay;
	}
	public int getReadNum() {
		return readNum;
	}
	public void setReadNum(int readNum) {
		this.readNum = readNum;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public long getFileSize() {
		return fileSize;
	}
	public void setFileSize(long fileSize) {
		this.fileSize = fileSize;
	}
	public MultipartFile getFile() {
		return file;
	}
	public void setFile(MultipartFile file) {
		this.file = file;
	}
	
}