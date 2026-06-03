package jp.co.sss.practice.p05.q04.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.sss.practice.p05.entity.FruitsSeason;
import jp.co.sss.practice.p05.repository.FruitsSeasonRepository;

@Controller
public class Practice0504Controller {

	@Autowired
	private FruitsSeasonRepository fruRepo;

	@RequestMapping("/fruits/search/input")
	public String selectSeason() {
		return "practice05/04/fruits_select_season";
	}

	@RequestMapping("/fruits/search/result")
	public String golist(Integer season, Model model) {
		List<FruitsSeason> fruEntyList = fruRepo.findBySeasonMonthOrderByFruitIdAsc(season);
		model.addAttribute("fruitsList", fruEntyList);

		String searchSeason = "<" + season + "月>";

		if (season == 13) {
			searchSeason = "<通年>";
		}
		model.addAttribute("searchSeason", searchSeason);
		return "practice05/04/fruits_list";
	}
}
