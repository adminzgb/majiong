package com.gbin.dao;

import com.gbin.model.BeGang;

public interface BeGangMapper {
    int insert(BeGang record);

    int insertSelective(BeGang record);
}