package jp.co.sss.practice.p09.q01.controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jakarta.validation.Valid;
import jp.co.sss.practice.p09.q01.form.PersonalInfoForm;

@Controller
public class Practice0901Controller {

	@RequestMapping("/personal_info/input")
	public String goInput(@ModelAttribute PersonalInfoForm personalInfoForm) {
		return "practice09/01/info_input";
	}

	@RequestMapping(path = "/personal_info/check", method = RequestMethod.POST)
	public String goCheck(@Valid @ModelAttribute PersonalInfoForm personalInfoForm, BindingResult result) {
		if (result.hasErrors()) {
			return "practice09/01/info_input";
		} else {
			return "practice09/01/input_ok";
		}
	}

}
