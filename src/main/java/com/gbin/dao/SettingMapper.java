package com.gbin.dao;

import java.util.List;

import com.gbin.model.Setting;

public interface SettingMapper {
    int insert(Setting record);

    int insertSelective(Setting record);
    
    List<Setting> findAll();
    
    void updateByPrimaryKeySelective(Setting setting);
    
    void updateByPrimaryKey(Setting setting);
}