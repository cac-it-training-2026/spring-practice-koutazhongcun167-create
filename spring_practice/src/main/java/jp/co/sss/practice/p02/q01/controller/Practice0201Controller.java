package jp.co.sss.practice.p02.q01.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Practice0201Controller {

	@RequestMapping("/first")
	public String first() {
		System.out.println("first executed");
		return "practice02/01/before_redirect";
	}

	@RequestMapping("/second")
	public String second() {
		return "redirect:/third";
	}

	@RequestMapping("/third")
	public String third() {
		return "Practice02/01/after_redirect";
	}

	@RequestMapping("/test")
	@ResponseBody
	public String test() {
	    return "OK";
	}
}
