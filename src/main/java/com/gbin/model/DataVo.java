package com.gbin.model;

import java.util.List;

public class DataVo {

	List<String> attendPeoples;
	
	List<String> buyHorsePeoples;
	
	String gameId;

	public List<String> getAttendPeoples() {
		return attendPeoples;
	}

	public void setAttendPeoples(List<String> attendPeoples) {
		this.attendPeoples = attendPeoples;
	}

	public List<String> getBuyHorsePeoples() {
		return buyHorsePeoples;
	}

	public void setBuyHorsePeoples(List<String> buyHorsePeoples) {
		this.buyHorsePeoples = buyHorsePeoples;
	}

	public String getGameId() {
		return gameId;
	}

	public void setGameId(String gameId) {
		this.gameId = gameId;
	}
	
	
}
