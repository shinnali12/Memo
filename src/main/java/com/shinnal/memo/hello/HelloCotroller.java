package com.shinnal.memo.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloCotroller {

	@ResponseBody
	@GetMapping("/hello")
	public String hello() {
		return "Hello World!!";
	}
	
}
