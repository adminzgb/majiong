package com.gbin.model;

import java.util.List;

public class EndVo {

	private String hu;
	private List<String> ming;
	private List<String> an;
	private List<String> fang;
	private List<String> maName;
	private List<Integer> maTotal;
	private List<Integer> maSuccess;
	private String roundId;
	
	public String getHu() {
		return hu;
	}
	public void setHu(String hu) {
		this.hu = hu;
	}
	public List<String> getMing() {
		return ming;
	}
	public void setMing(List<String> ming) {
		this.ming = ming;
	}
	public List<String> getAn() {
		return an;
	}
	public void setAn(List<String> an) {
		this.an = an;
	}
	public List<String> getFang() {
		return fang;
	}
	public void setFang(List<String> fang) {
		this.fang = fang;
	}
	public String getRoundId() {
		return roundId;
	}
	public void setRoundId(String roundId) {
		this.roundId = roundId;
	}
	public List<String> getMaName() {
		return maName;
	}
	public void setMaName(List<String> maName) {
		this.maName = maName;
	}
	public List<Integer> getMaTotal() {
		return maTotal;
	}
	public void setMaTotal(List<Integer> maTotal) {
		this.maTotal = maTotal;
	}
	public List<Integer> getMaSuccess() {
		return maSuccess;
	}
	public void setMaSuccess(List<Integer> maSuccess) {
		this.maSuccess = maSuccess;
	}
	
	
}
