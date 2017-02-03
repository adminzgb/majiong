package com.gbin.model;

import java.util.Date;

public class BeGang {
    private String fangGangId;

    private String beFangGangId;

    private String id;
    
    private String roundid;

    private Date createTime;

    private Date updateTime;

    public String getFangGangId() {
        return fangGangId;
    }

    public void setFangGangId(String fangGangId) {
        this.fangGangId = fangGangId == null ? null : fangGangId.trim();
    }

    public String getBeFangGangId() {
        return beFangGangId;
    }

    public void setBeFangGangId(String beFangGangId) {
        this.beFangGangId = beFangGangId == null ? null : beFangGangId.trim();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
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

	public String getRoundid() {
		return roundid;
	}

	public void setRoundid(String roundid) {
		this.roundid = roundid;
	}
    
    
}