package jp.co.sss.practice.p04.q02.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpSession;

@Controller
public class Practice0402Controller {

	@RequestMapping("/numguess/start")
	public String gennum(HttpSession session) {
		Integer hitNumber = (int) (Math.floor(Math.random() * 9) + 1);
		System.out.println("当たりの値:" + hitNumber);

		session.setAttribute("hitNumber", hitNumber);
		return "practice04/02/numguess_start";
	}

	@RequestMapping("/numguess/input")
	public String goinp() {
		return "practice04/02/numguess_input";
	}

	@RequestMapping("/numguess/judge")
	public String judgenum(HttpSession session, Integer inputNum) {
		Integer hitNumber = (Integer) session.getAttribute("hitNumber");
		if (inputNum == hitNumber) {
			return "redirect:/numguess/hit";
		}
		return "practice04/02/numguess_judge";

	}

	//Practice4-02 数あてゲーム終了受付処理
	@RequestMapping("/numguess/hit")
	public String end(Model model, HttpSession session) {
		Integer hitNumber = (Integer) session.getAttribute("hitNumber");
		String message = "当たり！正解は" + hitNumber + "です。";

		session.removeAttribute("hitNumber");
		model.addAttribute("message", message);
		return "practice04/02/numguess_end";

	}
}
