package jp.co.sss.practice.p04.q01.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.sss.practice.p04.q01.form.BmiForm;

@Controller
public class Practice0401Controller {

	@RequestMapping("/bmi/input")
	public String first() {
		return "practice04/01/bmi_input";
	}

	@RequestMapping("/bmi/result")
	public String second(BmiForm bmiForm, Model model) {
		Double weight = bmiForm.getWeight();
		Double height = bmiForm.getHeight() / 100.0;
		bmiForm.setBmi(weight / ((height) * (height)));
		model.addAttribute("bmiForm", bmiForm);

		return "practice04/01/bmi_result";
	}
}
