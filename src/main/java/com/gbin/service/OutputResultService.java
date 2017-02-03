package com.gbin.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.annotation.Resource;
import javax.persistence.GenerationType;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.gbin.base.util.X;
import com.gbin.dao.AttendPeopleMapper;
import com.gbin.dao.BeGangMapper;
import com.gbin.dao.BuyHorsePeopleMapper;
import com.gbin.dao.GameMapper;
import com.gbin.dao.RoundMapper;
import com.gbin.dao.SettingMapper;
import com.gbin.dao.UserMapper;
import com.gbin.model.AttendPeople;
import com.gbin.model.BuyHorsePeople;
import com.gbin.model.CalVo;
import com.gbin.model.Game;
import com.gbin.model.Round;
import com.gbin.model.Setting;
import com.gbin.model.User;
import com.gbin.model.UserStaticVo;

@Service
public class OutputResultService {

	@Resource
	private AttendPeopleMapper attendPeopleMapper;

	@Resource
	private BuyHorsePeopleMapper buyHorsePeopleMapper;

	@Resource
	private BeGangMapper beGangMapper;

	@Resource
	private RoundMapper roundMapper;

	@Resource
	private GameMapper gameMapper;

	@Resource
	private UserMapper userMapper;
	
	@Resource
	private SettingMapper settingMapper;

	private static Logger logger = Logger.getLogger(OutputResultService.class);

	public String addRound(List<AttendPeople> attendPeoples, List<BuyHorsePeople> buyHorsePeoples, String gameId) {
		Date date = new Date();
		Round round = new Round();
		String roundId = X.number.generateShortUUID();
		round.setId(roundId);
		round.setGameId(gameId);
		round.setCreateTime(date);
		round.setUpdateTime(date);
		roundMapper.insert(round);
		for (AttendPeople a : attendPeoples) {
			a.setRoundId(roundId);
			a.setId(X.number.generateShortUUID());
			a.setCreateTime(date);
			a.setUpdateTime(date);
			attendPeopleMapper.insert(a);
		}
		for (BuyHorsePeople a : buyHorsePeoples) {
			a.setRoundId(roundId);
			a.setId(X.number.generateShortUUID());
			a.setCreateTime(date);
			a.setUpdateTime(date);
			buyHorsePeopleMapper.insert(a);
		}
		return roundId;
	}

	public Map<String, CalVo> calByRoundId(String roundId) {
		List<AttendPeople> attendPeoples = attendPeopleMapper.findAttendByRoundId(roundId);
		List<BuyHorsePeople> buyHorsePeoples = buyHorsePeopleMapper.findBuyHorsePeopleByRoundId(roundId);
		Map<String, Integer> maResult = new HashMap<String, Integer>();
		Map<String, Integer> attResult = new HashMap<String, Integer>();
		Map<String, Integer> result = new HashMap<String, Integer>();
		Map<String, CalVo> calVos = new HashMap<String, CalVo>();
		int buyHorseSuccess = 0;
		int buyHorseTotal = 0;
		for (BuyHorsePeople a : buyHorsePeoples) {
			maResult.put(a.getName(), 0);
			CalVo calVo = new CalVo();
			calVo.setName(a.getName());
			calVo.setFlag(1);
			calVos.put(a.getName(), calVo);
		}
		for (AttendPeople a : attendPeoples) {
			attResult.put(a.getName(), 0);
			CalVo calVo = new CalVo();
			calVo.setName(a.getName());
			calVo.setFlag(0);
			calVos.put(a.getName(), calVo);
		}
		for (BuyHorsePeople a : buyHorsePeoples) {
			int score = a.getSuccess() * 3 * 3;
			buyHorseSuccess += a.getSuccess();
			buyHorseTotal += a.getTotal();
			score += (a.getTotal() - a.getSuccess()) * (-3);
			logger.info(a.getName() + ":买马,分数" + maResult.get(a.getName()));
			calVos.get(a.getName()).setMa(score);
			maResult.put(a.getName(), score);
		}
		for (AttendPeople a : attendPeoples) {
			int score = attResult.get(a.getName());
			score += a.getAnGang() * 3 * 2;
			int calVoA = calVos.get(a.getName()).getAn();
			calVoA += a.getAnGang() * 3 * 2;
			calVos.get(a.getName()).setAn(calVoA);
			logger.info(a.getName() + ":暗杠,分数" + score);
			for (AttendPeople a1 : attendPeoples) {
				if (!a1.getName().equals(a.getName())) {
					int s = attResult.get(a1.getName());
					s += a.getAnGang() * (-2);
					attResult.put(a1.getName(), s);
					logger.info(a1.getName() + ":暗杠,原来:" + attResult.get(a1.getName()) + ",增加:" + a.getAnGang() * (-2)
							+ ",现在：" + attResult.get(a1.getName()));
					int calVoAn = calVos.get(a1.getName()).getAn();
					calVoAn += a.getAnGang() * (-2);
					calVos.get(a1.getName()).setAn(calVoAn);
				}
			}
			score += a.getMingGang() * 3;
			int calVoM = calVos.get(a.getName()).getMing();
			calVoM += a.getMingGang() * 3;
			calVos.get(a.getName()).setMing(calVoM);
			logger.info(a.getName() + ":明杠,原来:" + attResult.get(a.getName()) + ",增加:" + a.getMingGang() * 3 + ",现在："
					+ score);
			for (AttendPeople a1 : attendPeoples) {
				if (!a1.getName().equals(a.getName())) {
					int s = attResult.get(a1.getName());
					s += a.getMingGang() * (-1);
					logger.info(a1.getName() + ":明杠,原来:" + attResult.get(a1.getName()) + ",增加:" + a.getMingGang() * (-1)
							+ ",现在：" + s);
					attResult.put(a1.getName(), s);
					int calVoMing = calVos.get(a1.getName()).getMing();
					calVoMing += a.getMingGang() * (-1);
					calVos.get(a1.getName()).setMing(calVoMing);
				}
			}
			score += a.getFangGang() * 3;
			int calVoF = calVos.get(a.getName()).getFang();
			calVoF += a.getFangGang() * 3;
			calVos.get(a.getName()).setFang(calVoF);
			logger.info(a.getName() + ":放杠,原来:" + attResult.get(a.getName()) + ",增加:" + a.getFangGang() * 3 + ",现在："
					+ score);
			if (a.getHu() == 1) {
				score += 9;
				int calVoH = calVos.get(a.getName()).getHu();
				calVoH += 9;
				calVos.get(a.getName()).setHu(calVoH);
				logger.info(a.getName() + ":胡,原来:" + attResult.get(a.getName()) + ",增加:" + 9 + ",现在：" + score);
				score += (buyHorseTotal - buyHorseSuccess) * 3;
				int calVoMa = calVos.get(a.getName()).getMa();
				calVoMa += (buyHorseTotal - buyHorseSuccess) * 3;
				calVos.get(a.getName()).setMa(calVoMa);
				logger.info(a.getName() + ":斩马,原来:" + attResult.get(a.getName()) + ",增加:"
						+ (buyHorseTotal - buyHorseSuccess) * 3 + ",现在：" + score);
			} else {
				score += -3;
				int calVoH = calVos.get(a.getName()).getHu();
				calVoH += -3;
				calVos.get(a.getName()).setHu(calVoH);
				logger.info(a.getName() + ":胡,原来:" + attResult.get(a.getName()) + ",增加:" + (-3) + ",现在：" + score);
				score += buyHorseSuccess * (-3);
				int calVoMa = calVos.get(a.getName()).getMa();
				calVoMa += buyHorseSuccess * (-3);
				calVos.get(a.getName()).setMa(calVoMa);
				logger.info(a.getName() + ":斩马,原来:" + attResult.get(a.getName()) + ",增加:" + buyHorseSuccess * (-3)
						+ ",现在：" + score);
			}
			attResult.put(a.getName(), score);
		}
		for (Entry<String, CalVo> calVo: calVos.entrySet()) {
			int score = calVo.getValue().getAn()+calVo.getValue().getFang()+calVo.getValue().getHu()+calVo.getValue().getMa()+calVo.getValue().getMing();
			calVo.getValue().setRoundTotal(score);
			if(calVo.getValue().getFlag() == 0){
				AttendPeople a = attendPeopleMapper.findByRoundAndName(roundId,calVo.getValue().getName());
				a.setTotal(score);
				attendPeopleMapper.updateByPrimaryKeySelective(a);
				List<AttendPeople> attendPeoples2 = findUserGame(calVo.getValue().getName(), roundId);
				int total = 0;
				for (AttendPeople attendPeople : attendPeoples2) {
					total += attendPeople.getTotal();
				}
				int gameTotal = calVos.get(calVo.getValue().getName()).getGameTotal();
				gameTotal += total;
				calVos.get(calVo.getValue().getName()).setGameTotal(gameTotal);
			}else{
				List<BuyHorsePeople> buyHorsePeoples2 = findBuyHorseUserGame(calVo.getValue().getName(), roundId);
				int total = 0;
				for (BuyHorsePeople buyHorsePeople : buyHorsePeoples2) {
					int s = buyHorsePeople.getSuccess() * 3 * 3;
					s += (buyHorsePeople.getTotal() - buyHorsePeople.getSuccess()) * (-3);
					total += s;
				}
				int gameTotal = calVos.get(calVo.getValue().getName()).getGameTotal();
				gameTotal += total;
				calVos.get(calVo.getValue().getName()).setGameTotal(gameTotal);
			}
			
			
		}
		result.putAll(maResult);
		result.putAll(attResult);
		logger.info(result);
		return calVos;
	}

	public List<AttendPeople> findUserGame(String name, String roundId) {
		Round round = roundMapper.selectByPrimary(roundId);
		return attendPeopleMapper.findByGameAndUser(round.getGameId(), name);
	}
	
	public List<BuyHorsePeople> findBuyHorseUserGame(String name, String roundId) {
		Round round = roundMapper.selectByPrimary(roundId);
		return buyHorsePeopleMapper.findByGameAndUser(round.getGameId(), name);
	}

	public String newRound(String gameId) {
		Round round = new Round();
		Date date = new Date();
		round.setId(X.number.generateShortUUID());
		round.setUpdateTime(date);
		round.setCreateTime(date);
		round.setGameId(gameId);
		roundMapper.insert(round);
		return round.getId();
	}

	public String newGame() {
		Game game = new Game();
		Date date = new Date();
		game.setId(X.number.generateShortUUID());
		game.setUpdateTime(date);
		game.setCreateTime(date);
		gameMapper.insert(game);
		return game.getId();
	}

	public List<User> getUser() {
		return userMapper.findAll();
	}

	public List<AttendPeople> getAttendByRoundId(String roundId) {
		return attendPeopleMapper.findAttendByRoundId(roundId);
	}

	public List<BuyHorsePeople> getBuyHorseByRoundId(String roundId) {
		return buyHorsePeopleMapper.findBuyHorsePeopleByRoundId(roundId);
	}

	public void saveAttend(AttendPeople attendPeople) {
		attendPeopleMapper.updateByPrimaryKeySelective(attendPeople);
	}

	public void saveBuyHose(BuyHorsePeople buyHorsePeople) {
		buyHorsePeopleMapper.updateByPrimaryKeySelective(buyHorsePeople);
	}
	
	public Setting getSetting(){
		return settingMapper.findAll().get(0);
	}
	
	public void changeSetting(Setting setting){
		settingMapper.updateByPrimaryKeySelective(setting);
	}
	
	public List<UserStaticVo> userStatic(){
		List<UserStaticVo> userStaticVos = new ArrayList<UserStaticVo>();
		List<User> users = userMapper.findAll();
		
		for(User user: users){
			List<AttendPeople> attendPeoples = attendPeopleMapper.findByUser(user.getName());
			List<BuyHorsePeople> buyHorsePeoples = buyHorsePeopleMapper.findByUser(user.getName());
			int attend = attendPeoples.size();
			int attendSuccess = 0;
			int an = 0;
			int ming = 0;
			int fang = 0;
			int maTotal = 0;
			int maSucess = 0;
			for(AttendPeople attendPeople: attendPeoples){
				if(attendPeople.getHu() ==1){
					attendSuccess++;
				}
				an += attendPeople.getAnGang();
				ming += attendPeople.getMingGang();
				fang += attendPeople.getFangGang();
			}
			
			for(BuyHorsePeople buyHorsePeople: buyHorsePeoples){
				maTotal += buyHorsePeople.getTotal();
				maSucess += buyHorsePeople.getSuccess();
			}
			
			UserStaticVo userStaticVo = new UserStaticVo();
			userStaticVo.setAn(an);
			userStaticVo.setMing(ming);
			userStaticVo.setFang(fang);
			userStaticVo.setAttend(attend);
			userStaticVo.setAttendRate(attendSuccess*1.0/attend);
			userStaticVo.setAttendSuccess(attendSuccess);
			userStaticVo.setMaRate(maSucess*1.0/maTotal);
			userStaticVo.setMaTotal(maTotal);
			userStaticVo.setMaSuccess(maSucess);
			userStaticVo.setName(user.getName());
			userStaticVos.add(userStaticVo);
		}
		return userStaticVos;
	}
	
	public Round findRoundById(String roundId){
		return roundMapper.selectByPrimary(roundId);
	}
	
	public List<String> getLastRoundAttendPeople(String gameId){
		List<String> peoples = new ArrayList<String>();
		List<AttendPeople> attendPeoples = attendPeopleMapper.findLastRoundByGameId(gameId);
		for(AttendPeople attendPeople: attendPeoples){
			peoples.add(attendPeople.getName());
		}
		return peoples;
	}
	
	public List<String> getLastRoundBuyHorsePeople(String gameId){
		List<String> peoples = new ArrayList<String>();
		List<BuyHorsePeople> buyHorsePeoples = buyHorsePeopleMapper.findLastRoundByGameId(gameId);
		for(BuyHorsePeople buyHorsePeople: buyHorsePeoples){
			peoples.add(buyHorsePeople.getName());
		}
		return peoples;
	}

}
