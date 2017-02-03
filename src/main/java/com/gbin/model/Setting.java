package com.gbin.model;

import java.util.Date;

public class Setting {
    private String id;

    private Integer hu;

    private Integer an;

    private Integer ming;

    private Integer fang;
    
    private Date updateTime;
    
    private Date createTime;

    public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public Integer getHu() {
        return hu;
    }

    public void setHu(Integer hu) {
        this.hu = hu;
    }

    public Integer getAn() {
        return an;
    }

    public void setAn(Integer an) {
        this.an = an;
    }

    public Integer getMing() {
        return ming;
    }

    public void setMing(Integer ming) {
        this.ming = ming;
    }

    public Integer getFang() {
        return fang;
    }

    public void setFang(Integer fang) {
        this.fang = fang;
    }
}