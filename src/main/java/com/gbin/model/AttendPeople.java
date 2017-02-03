package com.gbin.model;

import java.util.Date;

public class AttendPeople {
    private String id;

    private String roundId;

    private String name;

    private Integer anGang=0;

    private Integer mingGang=0;

    private Integer fangGang=0;
    
    private Integer hu = 0;

    private Date createTime;

    private Date updateTime;

    private Integer total = 0;
    
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getRoundId() {
        return roundId;
    }

    public void setRoundId(String roundid) {
        this.roundId = roundid == null ? null : roundid.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getAnGang() {
        return anGang;
    }

    public void setAnGang(Integer anGang) {
        this.anGang = anGang;
    }

    public Integer getMingGang() {
        return mingGang;
    }

    public void setMingGang(Integer mingGang) {
        this.mingGang = mingGang;
    }

    public Integer getFangGang() {
        return fangGang;
    }

    public void setFangGang(Integer fangGang) {
        this.fangGang = fangGang;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

	public Integer getHu() {
		return hu;
	}

	public void setHu(Integer hu) {
		this.hu = hu;
	}

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}
    
    
}