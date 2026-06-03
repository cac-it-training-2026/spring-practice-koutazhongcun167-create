package jp.co.sss.practice.p05.q03.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.sss.practice.p05.bean.FruitsSeasonBean;
import jp.co.sss.practice.p05.entity.FruitsSeason;
import jp.co.sss.practice.p05.repository.FruitsSeasonRepository;

@Controller
public class Practice0503Controller {

	@Autowired
	private FruitsSeasonRepository frurepo;

	@RequestMapping("/fruits/list/sort/id")
	public String idAsc(Model model) {
		model.addAttribute("fruits", frurepo.findAllByOrderByFruitIdAsc());
		return "practice05/03/fruits_list";
	}

	@RequestMapping("/fruits/detail/{fruitId}")
	public String goDetail(@PathVariable Integer fruitId, Model model) {
		FruitsSeason fruitsEnti = frurepo.getReferenceById(fruitId);
		FruitsSeasonBean fruitsBean = new FruitsSeasonBean();
		BeanUtils.copyProperties(fruitsEnti, fruitsBean);
		model.addAttribute("fruit", fruitsBean);
		return "practice05/03/fruit_detail";
	}

}
