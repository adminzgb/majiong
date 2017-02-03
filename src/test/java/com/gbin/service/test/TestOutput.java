package com.gbin.service.test;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;
import com.gbin.dao.GameMapper;
import com.gbin.model.AttendPeople;
import com.gbin.model.BuyHorsePeople;
import com.gbin.service.OutputResultService;


@RunWith(SpringJUnit4ClassRunner.class)             //表示继承了SpringJUnit4ClassRunner类
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"})
public class TestOutput {
	
	private static Logger logger = Logger.getLogger(TestOutput.class);

	@Resource
	private OutputResultService outputResultService = null;
	
	@Resource
	private GameMapper gameMapper;

	@Test
	public void test1() {
		String gameId = outputResultService.newGame();
		System.out.println("gameId = "+gameId);
		String roundId = outputResultService.newRound(gameId);
		List<AttendPeople> attendPeoples = new ArrayList<AttendPeople>();
		List<BuyHorsePeople> buyHorsePeoples = new ArrayList<BuyHorsePeople>();
			AttendPeople attendPeople = new AttendPeople();
			attendPeople.setId("1");
			attendPeople.setName("a");
			attendPeople.setAnGang(0);
			attendPeople.setMingGang(0);
			attendPeople.setFangGang(0);
			attendPeople.setRoundId(roundId);
			
			AttendPeople attendPeople1 = new AttendPeople();
			attendPeople1.setId("2");
			attendPeople1.setName("b");
			attendPeople1.setAnGang(0);
			attendPeople1.setMingGang(0);
			attendPeople1.setFangGang(-1);
			attendPeople1.setRoundId(roundId);
		
			AttendPeople attendPeople2 = new AttendPeople();
			attendPeople2.setId("3");
			attendPeople2.setName("c");
			attendPeople2.setAnGang(0);
			attendPeople2.setMingGang(0);
			attendPeople2.setFangGang(1);
			attendPeople2.setHu(1);
			attendPeople2.setRoundId(roundId);
			
			AttendPeople attendPeople3 = new AttendPeople();
			attendPeople3.setId("4");
			attendPeople3.setName("d");
			attendPeople3.setAnGang(0);
			attendPeople3.setMingGang(0);
			attendPeople3.setFangGang(0);
			attendPeople3.setRoundId(roundId);
			
			BuyHorsePeople buyHorsePeople = new BuyHorsePeople();
			buyHorsePeople.setId("5");
			buyHorsePeople.setName("e");
			buyHorsePeople.setRoundId(roundId);
			buyHorsePeople.setSuccess(1);
			buyHorsePeople.setTotal(2);
			
			BuyHorsePeople buyHorsePeople1 = new BuyHorsePeople();
			buyHorsePeople1.setId("6");
			buyHorsePeople1.setName("f");
			buyHorsePeople1.setRoundId(roundId);
			buyHorsePeople1.setSuccess(1);
			buyHorsePeople1.setTotal(2);
			
			attendPeoples.add(attendPeople);
			attendPeoples.add(attendPeople1);
			attendPeoples.add(attendPeople2);
			attendPeoples.add(attendPeople3);
			
			buyHorsePeoples.add(buyHorsePeople);
			buyHorsePeoples.add(buyHorsePeople1);
		
			outputResultService.addRound(attendPeoples, buyHorsePeoples, roundId);
			outputResultService.calByRoundId(roundId);
			System.out.println(outputResultService.calByRoundId(roundId));
			
	}
	
	@Test
	public void test2(){
		outputResultService.calByRoundId("bZ4CPlnUW06hGJ3VSgY");
		System.out.println(outputResultService.calByRoundId("bZ4CPlnUW06hGJ3VSgY"));
	}

	
}
