package jp.co.sss.practice.p03.q01.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Practice0301Controller {

	@RequestMapping("/input")
	public String reInput() {
		return "practice03/01/input_form";
	}

	@RequestMapping("/send/get_method")
	public String sysPar(String color) {
		System.out.println("##GET メソッドで受け取りました");
		System.out.println("##パラメータの値:" + color);

		return "practice03/01/get_result";
	}

	@RequestMapping("/send/post_method")
	public String sysPar2(String color) {
		System.out.println("POST メソッドで受け取りました");
		System.out.println("パラメータの値:" + color);

		return "practice03/01/post_result";
	}
}
