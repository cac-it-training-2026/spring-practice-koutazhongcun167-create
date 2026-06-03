package jp.co.sss.practice.p05.q05.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.co.sss.practice.p05.bean.FruitsSeasonBean;
import jp.co.sss.practice.p05.entity.FruitsSeason;
import jp.co.sss.practice.p05.form.FruitsSeasonForm;
import jp.co.sss.practice.p05.repository.FruitsSeasonRepository;

@Controller
public class Practice0505Controller {
	@Autowired
	private FruitsSeasonRepository fruRepo;

	@RequestMapping("/fruits/add/input")
	public String goinput() {
		return "practice05/05/fruit_input";
	}

	@RequestMapping(path = "/fruits/add/complete", method = RequestMethod.POST)
	public String gocomplete(FruitsSeasonForm fruitForm, Model model) {
		FruitsSeason fruEnti = new FruitsSeason();
		BeanUtils.copyProperties(fruitForm, fruEnti);
		fruEnti = fruRepo.save(fruEnti);
		FruitsSeasonBean fruBean = new FruitsSeasonBean();
		BeanUtils.copyProperties(fruEnti, fruBean);
		model.addAttribute("fruits", fruBean);
		return "practice05/05/fruit_detail";
	}

}
