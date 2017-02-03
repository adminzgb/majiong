package com.gbin.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.method.annotation.RequestResponseBodyMethodProcessor;

import com.gbin.base.enums.ReturnCode;
import com.gbin.base.model.JsonMessage;
import com.gbin.model.AttendPeople;
import com.gbin.model.BuyHorsePeople;
import com.gbin.model.CalVo;
import com.gbin.model.DataVo;
import com.gbin.model.EndVo;
import com.gbin.model.Round;
import com.gbin.model.Setting;
import com.gbin.model.User;
import com.gbin.model.UserStaticVo;
import com.gbin.service.OutputResultService;

@Controller
@RequestMapping("/bigdata")
public class OutputController {

	@Resource
	private OutputResultService outputResultService;

	@RequestMapping("/index")
	public String toIndex() {
		return "index";
	}

	@RequestMapping("/game")
	public ModelAndView toGame(String gameId) {
		if (gameId == null || gameId.equals("")) {
			gameId = outputResultService.newGame();
		}
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("gameId", gameId);
		param.put("attendPeoples", outputResultService.getLastRoundAttendPeople(gameId));
		param.put("buyHorsePeoples", outputResultService.getLastRoundBuyHorsePeople(gameId));
		return new ModelAndView("game", param);
	}

	@RequestMapping("/setting")
	public String toSetting() {
		return "setting";
	}

	@RequestMapping("/getSetting")
	@ResponseBody
	public Setting getSetting() {
		return outputResultService.getSetting();
	}

	@RequestMapping("/changeSetting")
	@ResponseBody
	public void changeSetting(Setting setting) {
		outputResultService.changeSetting(setting);
	}

	@RequestMapping("/getUser")
	@ResponseBody
	public List<User> getUser() {
		return outputResultService.getUser();
	}

	@ResponseBody
	@RequestMapping("/addRound")
	public JsonMessage addRound(DataVo dataVo, HttpServletRequest request) {
		JsonMessage jsonMessage = new JsonMessage();
		List<AttendPeople> attendPeoples = new ArrayList<AttendPeople>();
		for (String s : dataVo.getAttendPeoples()) {
			AttendPeople attendPeople = new AttendPeople();
			attendPeople.setName(s);
			attendPeoples.add(attendPeople);
		}
		List<BuyHorsePeople> buyHorsePeoples = new ArrayList<BuyHorsePeople>();
		for (String s : dataVo.getBuyHorsePeoples()) {
			BuyHorsePeople buyHorsePeople = new BuyHorsePeople();
			buyHorsePeople.setName(s);
			buyHorsePeoples.add(buyHorsePeople);
		}
		String roundId = outputResultService.addRound(attendPeoples, buyHorsePeoples, dataVo.getGameId());
		jsonMessage.setCode(ReturnCode.SUCCESS);
		jsonMessage.setMes(roundId);
		return jsonMessage;
	}

	@RequestMapping("/endRound")
	@ResponseBody
	public JsonMessage endRound(EndVo endVo, HttpServletRequest request) {
		String roundId = endVo.getRoundId();
		List<AttendPeople> attendPeoples = outputResultService.getAttendByRoundId(roundId);
		for (String s : endVo.getAn()) {
			for (AttendPeople attendPeople : attendPeoples) {
				if (s.equals(attendPeople.getName())) {
					int an = attendPeople.getAnGang();
					an++;
					attendPeople.setAnGang(an);
				}
			}
		}
		for (String s : endVo.getMing()) {
			for (AttendPeople attendPeople : attendPeoples) {
				if (s.equals(attendPeople.getName())) {
					int ming = attendPeople.getMingGang();
					ming++;
					attendPeople.setMingGang(ming);
				}
			}
		}
		Map<String, String> fang = new HashMap<String, String>();
		Map<String, String> beFang = new HashMap<String, String>();
		for (String s : endVo.getFang()) {
			String left = s.split("->")[0].trim();
			String right = s.split("->")[1].trim();
			fang.put(left, left);
			String[] right2 = right.split(" ");
			for (String st : right2) {
				beFang.put(st, st);
			}
		}
		for (Entry<String, String> map : fang.entrySet()) {
			for (AttendPeople attendPeople : attendPeoples) {
				if (attendPeople.getName().equals(map.getKey())) {
					int fangNum = attendPeople.getFangGang();
					fangNum--;
					attendPeople.setFangGang(fangNum);
				}
			}
		}
		for (Entry<String, String> map : beFang.entrySet()) {
			for (AttendPeople attendPeople : attendPeoples) {
				if (attendPeople.getName().equals(map.getKey())) {
					int fangNum = attendPeople.getFangGang();
					fangNum++;
					attendPeople.setFangGang(fangNum);
				}
			}
		}

		for (AttendPeople attendPeople : attendPeoples) {
			if (attendPeople.getName().equals(endVo.getHu())) {
				attendPeople.setHu(1);
			}
			outputResultService.saveAttend(attendPeople);
		}
		List<BuyHorsePeople> buyHorsePeoples = outputResultService.getBuyHorseByRoundId(roundId);
		for (BuyHorsePeople buyHorsePeople : buyHorsePeoples) {
			for (int i = 0; i < endVo.getMaName().size(); i++) {
				if (endVo.getMaName().get(i).equals(buyHorsePeople.getName())) {
					buyHorsePeople.setSuccess(endVo.getMaSuccess().get(i));
					buyHorsePeople.setTotal(endVo.getMaTotal().get(i));
					outputResultService.saveBuyHose(buyHorsePeople);
				}
			}
		}
		JsonMessage jsonMessage = new JsonMessage();
		jsonMessage.setCode(ReturnCode.SUCCESS);
		jsonMessage.setMes(outputResultService.calByRoundId(roundId).toString());
		return jsonMessage;
	}

	@RequestMapping(value = "/getRound", method = RequestMethod.GET)
	public ModelAndView getRound(String roundId) {
		Map<String, String> param = new HashMap<String, String>();
		param.put("roundId", roundId);
		Round round = outputResultService.findRoundById(roundId);
		param.put("gameId", round.getGameId());
		return new ModelAndView("roundEnd", param);
	}

	@RequestMapping(value = "/getRoundPost", method = RequestMethod.GET)
	@ResponseBody
	public List<CalVo> getRoundPost(String roundId) {
		Map<String, CalVo> result = outputResultService.calByRoundId(roundId);
		List<CalVo> calVos = new ArrayList<CalVo>();
		for (Entry<String, CalVo> entry : result.entrySet()) {
			calVos.add(entry.getValue());
		}
		return calVos;
	}

	@RequestMapping(value = "/getUserStatic", method = RequestMethod.GET)
	@ResponseBody
	public List<UserStaticVo> getUserSta() {
		return outputResultService.userStatic();
	}

	@RequestMapping(value = "/getUsersView", method = RequestMethod.GET)
	public String getUsers() {
		return "users";
	}

}
