package com.gbin.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gbin.model.AttendPeople;
import com.gbin.model.Game;

public interface AttendPeopleMapper {
    int insert(AttendPeople record);

    int insertSelective(AttendPeople record);
    
    List<AttendPeople> findAttendByRoundId(@Param(value="roundId")String roundId);
    
    int updateByPrimaryKeySelective(AttendPeople record);

    int updateByPrimaryKey(AttendPeople record);
    
    List<AttendPeople> findByGameAndUser(@Param(value="gameId") String gameId, @Param(value="name") String name);
    
    AttendPeople findByRoundAndName(@Param(value="roundId") String roundId, @Param(value="name") String name);
    
    List<AttendPeople> findByUser(@Param(value="name")String name);
    
    AttendPeople selectByName(String name);
    
    List<AttendPeople> findLastRoundByGameId(@Param(value="gameId")String gameId);
}