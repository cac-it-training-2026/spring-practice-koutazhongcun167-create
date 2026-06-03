package jp.co.sss.practice.p02.q02.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Practice0202Controller {
	@RequestMapping("/show/redirect_page")
	public String showRedirectPage() {
		return "Practice02/02/redirect_link";
	}

	@RequestMapping("/absolute")
	public String redirectAbsolutePath() {
		return "redirect:https://www.google.co.jp/";
	}

	@RequestMapping("/relative")
	public String redirectRelativePath() {
		return "redirect:/result";
	}

	@RequestMapping("/result")
	public String redirectResult() {
		return "Practice02/02/redirect_result";
	}

}
