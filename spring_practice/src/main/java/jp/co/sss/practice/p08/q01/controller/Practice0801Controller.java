package jp.co.sss.practice.p08.q01.controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jakarta.validation.Valid;
import jp.co.sss.practice.p08.q01.form.BodyTempForm;

@Controller
public class Practice0801Controller {
	@RequestMapping("/body_temp/input")
	public String goInput(@ModelAttribute BodyTempForm bodyTempForm) {
		return "practice08/01/bt_input";
	}

	@RequestMapping(path = "/body_temp/check", method = RequestMethod.POST)
	public String gocheak(@Valid @ModelAttribute BodyTempForm bodyTempForm, BindingResult result) {
		if (result.hasErrors()) {
			return "practice08/01/bt_input";
		}
		Double bodyTemp = bodyTempForm.getBodyTemp();
		if (bodyTemp >= 37.5 || bodyTemp <= 35.0) {
			return "practice08/01/bt_ng";
		}
		return "practice08/01/bt_ok";
	}

}
