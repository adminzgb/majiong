package com.gbin.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gbin.model.AttendPeople;
import com.gbin.model.BuyHorsePeople;
import com.gbin.model.Game;

public interface BuyHorsePeopleMapper {
    int insert(BuyHorsePeople record);

    int insertSelective(BuyHorsePeople record);
    
    List<BuyHorsePeople> findBuyHorsePeopleByRoundId(@Param(value="roundId")String roundId);
    
    int updateByPrimaryKeySelective(BuyHorsePeople record);

    int updateByPrimaryKey(BuyHorsePeople record);
    
    List<BuyHorsePeople> findByUser(@Param(value="name")String name);
    
    List<BuyHorsePeople> findByGameAndUser(@Param(value="gameId") String gameId, @Param(value="name") String name);
    
    BuyHorsePeople findByRoundAndName(@Param(value="roundId") String roundId, @Param(value="name") String name);
    
    List<BuyHorsePeople> findLastRoundByGameId(@Param(value="gameId")String gameId);
}