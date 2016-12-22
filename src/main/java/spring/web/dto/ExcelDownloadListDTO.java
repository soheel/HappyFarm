package spring.web.dto;

import java.util.List;

public class ExcelDownloadListDTO {

	private List<ExcelDownloadDTO> list;
	
	public ExcelDownloadListDTO() {
		
	}

	public ExcelDownloadListDTO(List<ExcelDownloadDTO> list) {
		super();
		this.list = list;
	}

	public List<ExcelDownloadDTO> getList() {
		return list;
	}

	public void setList(List<ExcelDownloadDTO> list) {
		this.list = list;
	}
	
	
}
