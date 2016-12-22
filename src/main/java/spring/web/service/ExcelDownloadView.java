package spring.web.service;

import java.net.URLEncoder;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.web.servlet.view.document.AbstractExcelView;

import spring.web.dto.ExcelDownloadDTO;

public class ExcelDownloadView extends AbstractExcelView {

	@SuppressWarnings("unchecked")
	@Override
	protected void buildExcelDocument(Map<String, Object> model, HSSFWorkbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		System.out.println("---- ExcelDownloadView.buildExcelDocument() ----");
		  
		  String userAgent = request.getHeader("User-Agent");
		  String fileName = "OrderList.xls";
		  
		  if(userAgent.indexOf("MSIE") > -1){
		   fileName = URLEncoder.encode(fileName, "utf-8");
		  }else{
		   fileName = new String(fileName.getBytes("utf-8"), "iso-8859-1");
		  }
		  
		  response.setHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\";");
		  response.setHeader("Content-Transfer-Encoding", "binary");
		    
		  HSSFSheet sheet = createFirstSheet(workbook);
		  createColumnLabel(sheet);
		  
		  List<ExcelDownloadDTO> menuList = (List<ExcelDownloadDTO>)model.get("menuList");
		  for(int i=0; i <= menuList.size()-1; i++){
		   createPageRow(sheet, menuList, i);
		  }
		 }
	
		  private HSSFSheet createFirstSheet(HSSFWorkbook workbook){
		  HSSFSheet sheet = workbook.createSheet();
		  workbook.setSheetName(0, "주문내역");
		  sheet.setColumnWidth(1, 256*30);
		  return sheet;
		 }
		 
		 private void createColumnLabel(HSSFSheet sheet){
		  HSSFRow firstRow = sheet.createRow(0);
		  
		  HSSFCell cell = firstRow.createCell(0);
		  cell.setCellValue("상품No");
		  
		  cell = firstRow.createCell(1);
		  cell.setCellValue("회원아이디");
		  

		  cell = firstRow.createCell(2);
		  cell.setCellValue("구매 가격");
		  

		  cell = firstRow.createCell(3);
		  cell.setCellValue("구매 상태");
		  

		  cell = firstRow.createCell(4);
		  cell.setCellValue("구매 형태");
		  

		  cell = firstRow.createCell(5);
		  cell.setCellValue("구매 날짜");
		  

		  cell = firstRow.createCell(6);
		  cell.setCellValue("주문자 이름");
		  

		  cell = firstRow.createCell(7);
		  cell.setCellValue("주문자 주소");
		  

		  cell = firstRow.createCell(8);
		  cell.setCellValue("주문자 연락처");
		 }
		 
		 private void createPageRow(HSSFSheet sheet, List<ExcelDownloadDTO> menuList, int rowNum){
		  
			 ExcelDownloadDTO dto = (ExcelDownloadDTO)menuList.get(rowNum);
			 HSSFRow row = sheet.createRow(rowNum + 1);
		  
		  HSSFCell cell = row.createCell(0);
		  cell.setCellValue(dto.getNo());
		  
		  cell = row.createCell(1);
		  cell.setCellValue(dto.getEmail());

		  cell = row.createCell(2);
		  cell.setCellValue(dto.getPrice());

		  cell = row.createCell(3);
		  cell.setCellValue(dto.getState());

		  cell = row.createCell(4);
		  cell.setCellValue(dto.getMethod());

		  cell = row.createCell(5);
		  cell.setCellValue(dto.getDate());

		  cell = row.createCell(6);
		  cell.setCellValue(dto.getName());

		  cell = row.createCell(7);
		  cell.setCellValue(dto.getAddr());

		  cell = row.createCell(8);
		  cell.setCellValue(dto.getPhone());
		 }
	}
