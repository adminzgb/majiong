package com.gbin.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gbin.model.Round;

public interface RoundMapper {
    int insert(Round record);

    int insertSelective(Round record);
    
    Round selectByPrimary(String id);
    
    List<Round> findByGameId(@Param(value="gameId") String gameId);
    
}