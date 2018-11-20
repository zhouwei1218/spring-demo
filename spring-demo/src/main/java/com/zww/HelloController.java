package com.zww;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {
	@RequestMapping("/index")
	public String index(ModelMap map) {
		map.addAttribute("hello", "helloWorld~~~~~~~~~~~~~");
		return "index";
	}
}
