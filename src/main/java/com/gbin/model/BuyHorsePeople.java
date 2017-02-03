package com.gbin.model;

import java.util.Date;

public class BuyHorsePeople {
    private String roundId;

    private String id;

    private String name;

    private Integer total;
    
    private Integer success;

    private Date createTime;

    private Date updateTime;

    public String getRoundId() {
        return roundId;
    }

    public void setRoundId(String roundid) {
        this.roundId = roundid == null ? null : roundid.trim();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getSuccess() {
        return success;
    }

    public void setSuccess(Integer success) {
        this.success = success;
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

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}
    
    
}