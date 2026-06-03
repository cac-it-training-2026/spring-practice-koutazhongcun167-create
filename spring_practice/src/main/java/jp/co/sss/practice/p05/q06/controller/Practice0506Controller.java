package jp.co.sss.practice.p05.q06.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.co.sss.practice.p05.bean.FruitsSeasonBean;
import jp.co.sss.practice.p05.entity.FruitsSeason;
import jp.co.sss.practice.p05.form.FruitsSeasonForm;
import jp.co.sss.practice.p05.repository.FruitsSeasonRepository;

@Controller
public class Practice0506Controller {

	@Autowired
	private FruitsSeasonRepository fruRepo;

	@RequestMapping("/fruits/update")
	public String goSelect(Model model) {
		model.addAttribute("fruits", fruRepo.findAllByOrderByFruitIdAsc());
		return "practice05/06/fruit_select";
	}

	@RequestMapping(path = "/fruits/update/input", method = RequestMethod.POST)
	public String goInput(Integer fruitId, Model model) {
		FruitsSeason fruEnti = fruRepo.getReferenceById(fruitId);
		FruitsSeasonBean fruBean = new FruitsSeasonBean();
		BeanUtils.copyProperties(fruEnti, fruBean);
		model.addAttribute("fruits", fruBean);
		return "practice05/06/fruit_input";
	}

	@RequestMapping(path = "/fruits/update/complete/{fruitId}", method = RequestMethod.POST)
	public String goComp(@PathVariable Integer fruitId, FruitsSeasonForm fruitForm, Model model) {
		FruitsSeason fruEnti = new FruitsSeason();
		BeanUtils.copyProperties(fruitForm, fruEnti);
		fruEnti = fruRepo.save(fruEnti);
		FruitsSeasonBean fruBean = new FruitsSeasonBean();
		BeanUtils.copyProperties(fruEnti, fruBean);
		model.addAttribute("fruits", fruBean);
		return "practice05/06/fruit_detail";
	}

}
