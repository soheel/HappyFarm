package spring.web.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.maven.model.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import spring.web.dto.ExcelDownloadDTO;
import spring.web.dto.ExcelDownloadListDTO;

@Controller
@RequestMapping("/excel")
public class ExcelController {
	
	@RequestMapping("filedown")
	public ModelAndView fileDownload() {
	System.out.println("----- FileDownloadController.fileDownload() -----");
	ModelAndView modelAndView = new ModelAndView("filedownload");
	return modelAndView;
	}
	 
	 @RequestMapping("exceldown")
	 public String excelDownload(Map<String, Object> model, ExcelDownloadListDTO list) {
	  System.out.println("----- FileDownloadController.excelDownload() -----");
	  System.out.println(list.getList().size() + "~~~");
	  
	  model.put("menuList", list.getList());
	  return "excelDownload";
	 }
}
