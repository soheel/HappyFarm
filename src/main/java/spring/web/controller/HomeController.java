package spring.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	
	/**
	 * 메인 페이지로 이동
	 * @return
	 */
	@RequestMapping("")
	public String home() {
		return "main/index";
	}
}
